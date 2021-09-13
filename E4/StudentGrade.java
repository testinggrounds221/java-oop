import java.util.Scanner;

class Ward {
	String name;
	String reg_no;
	String gender;
}

public class StudentGrade extends Ward {

	int[] sub_marks;
	int[] credits;
	char[] sub_grades;
	int total;
	char overall_grade;
	int no_crs;

	StudentGrade(int courses) {
		no_crs = courses;
		name = "";
		reg_no = "";
		sub_marks = new int[no_crs];
		sub_grades = new char[no_crs];
		credits = new int[no_crs];

		total = 0;
		overall_grade = ' ';
	}

	float calculateGPA() {
		float gpa = 0.0f;
		int sumCTimesGP = 0;
		int sumc = 0;
		for (int i = 0; i < this.no_crs; i++) {
			sumCTimesGP += credits[i] * getGradePoint(sub_grades[i]);
			sumc += credits[i];
		}
		gpa = sumCTimesGP / sumc;
		return gpa;
	}

	int getGradePoint(char c) {
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
				System.out.println("No StudentGrade point");
				break;
		}
		return gp;
	}

	void getInput() {
		Scanner sc = new Scanner(System.in);
		// System.out.println("Enter name : ");
		// this.name = sc.nextLine();

		// System.out.println("Enter Reg No : ");
		// this.reg_no = sc.nextLine();

		System.out.println("Enter Marks : ");
		for (int i = 0; i < this.no_crs; i++) {
			System.out.println("Enter Mark : ");
			this.sub_marks[i] = sc.nextInt();
			System.out.println("Enter Credit : ");
			this.credits[i] = sc.nextInt();

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
		sc.close();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Num Subjects : ");
		int no_crs = sc.nextInt();
		StudentGrade g = new StudentGrade(no_crs);

		g.getInput();
		System.out.println("GPA is " + g.calculateGPA());
		sc.close();
	}
}
