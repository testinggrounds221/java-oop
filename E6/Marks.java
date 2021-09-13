import java.util.Scanner;
import java.io.*;

interface GradeCard {
	void printGradeCard();

	int getGradePoint(char c);

	void getGradeInput();

	float calculateGPA();
}

interface Scholar {
	void getStudentInput();

	void printStudentInfo();

	String institution = "TCE";
	String dept = "Information Technology";

}

public class Marks implements Scholar, GradeCard {

	int[] sub_marks;
	int[] credits;
	char[] sub_grades;
	int total;
	char overall_grade;
	int no_crs;
	float gpa;
	String name;
	String reg_no;
	static Scanner in;

	Marks(int courses) {
		no_crs = courses;
		name = "";
		reg_no = "";
		sub_marks = new int[no_crs];
		sub_grades = new char[no_crs];
		credits = new int[no_crs];
		in = new Scanner(System.in);
		total = 0;
		overall_grade = ' ';
	}

	protected void finalize() throws IOException {
		in.close();
	}

	public float calculateGPA() {
		float gpa = 0.0f;
		int sumCTimesGP = 0;
		int sumc = 0;
		for (int i = 0; i < this.no_crs; i++) {
			sumCTimesGP += credits[i] * getGradePoint(sub_grades[i]);
			sumc += credits[i];
		}
		gpa = sumCTimesGP / sumc;
		this.gpa = gpa;
		return gpa;
	}

	public int getGradePoint(char c) {
		int gp = 0;
		switch (c) {
			case 'S':
				gp = 10;
				break;
			case 'A':
				gp = 9;
				break;
			case 'B':
				gp = 8;
				break;
			case 'C':
				gp = 7;
				break;
			case 'D':
				gp = 6;
				break;
			case 'U':
				gp = 0;
				break;
			default:
				System.out.println("No Marks point");
				break;
		}
		return gp;
	}

	public void getGradeInput() {

		// System.out.println("Enter name : ");
		// this.name = sc.nextLine();

		// System.out.println("Enter Reg No : ");
		// this.reg_no = sc.nextLine();

		System.out.println("Enter Marks : ");
		for (int i = 0; i < this.no_crs; i++) {
			System.out.println("Enter Mark : ");
			this.sub_marks[i] = in.nextInt();
			System.out.println("Enter Credit : ");
			this.credits[i] = in.nextInt();

		}
		for (int i = 0; i < this.no_crs; i++) {
			if ((90 < this.sub_marks[i]) && (this.sub_marks[i] <= 100))
				this.sub_grades[i] = 'S';

			if ((80 <= this.sub_marks[i]) && (this.sub_marks[i] <= 90))
				this.sub_grades[i] = 'A';

			if ((70 <= this.sub_marks[i]) && (this.sub_marks[i] < 80))
				this.sub_grades[i] = 'B';

			if ((60 <= this.sub_marks[i]) && (this.sub_marks[i] < 70))
				this.sub_grades[i] = 'C';

			if ((50 <= this.sub_marks[i]) && (this.sub_marks[i] < 60))
				this.sub_grades[i] = 'D';

			if ((0 <= this.sub_marks[i]) && (this.sub_marks[i] < 50))
				this.sub_grades[i] = 'U';

		}
	}

	public void getStudentInput() {
		System.out.print("Enter Student Name : ");
		this.name = in.nextLine();

		System.out.print("Enter Student RegNo : ");
		this.reg_no = in.nextLine();
	}

	public void printGradeCard() {
		System.out.println("Student Grade Card");
		printStudentInfo();
		System.out.println("Grade Point Average : " + this.gpa);
	}

	public void printStudentInfo() {
		System.out.print("Name : " + this.name + "\n");
		System.out.print("Register Number : " + this.reg_no + "\n");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of courses  : ");
		int no_crs = sc.nextInt();
		Marks g = new Marks(no_crs);
		g.getStudentInput();
		g.getGradeInput();
		g.calculateGPA();
		g.printGradeCard();
		sc.close();
	}
}
