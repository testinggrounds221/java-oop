// Data Members:name,reg_no,sub_marks,sub_grade,total,overall_grade

// Methods:getInput(),printOutput(),gradeCal()totalCal()
// Define the class with its members

// Add suitable
// constructor wherever applicable-
// Create objects for
// accessing the
// members of the class-
// Define the main class for
// implementing the application
import java.util.Scanner;

public class Grade {
	String name;
	String reg_no;
	int[] sub_marks;
	int[] credits;
	char[] sub_grades;
	int total;
	char overall_grade;
	int no_crs;

	Grade(int courses) {
		no_crs = courses;
		name = "";
		reg_no = "";
		sub_marks = new int[no_crs];
		sub_grades = new char[no_crs];
		credits = new int[no_crs];

		total = 0;
		overall_grade = ' ';
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
		}
		for (int i = 0; i < this.no_crs; i++) {
			if ((90 < this.sub_marks[i]) && (this.sub_marks[i] < 100))
				this.sub_grades[i] = 'S';

			if ((80 <= this.sub_marks[i]) && (this.sub_marks[i] < 90))
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

	void gradeCal() {

	}

	void printGrade() {

	}

	public static void main(String[] args) {
		Grade g = new Grade(5);
		g.getInput();
	}
}
