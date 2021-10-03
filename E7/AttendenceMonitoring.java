import java.util.Scanner;

class TimeTable {
	String dept;
	String sem;
	Scanner in;

	TimeTable() {

		dept = "";
		in = new Scanner(System.in);
	}

	void getInput() {

		System.out.print("Enter Department : ");
		this.dept = in.nextLine();

		System.out.print("Enter Sem : ");
		this.sem = in.nextLine();
	}
}

class StudentRoll extends TimeTable {
	String name;
	String regNum;
	int noOfWorkingDays;
	int noOfODDays;
	int noOfLeaveDays;

	void getInput() {
		super.getInput();
		System.out.print("Enter name : ");
		this.name = in.nextLine();

		System.out.print("Enter regNum : ");
		this.regNum = in.nextLine();
	}

	void displayStudentInfo() {
		System.out.print("Department : " + this.dept);
		System.out.print("Sem : " + this.sem);
	}
}

public class AttendenceMonitoring extends TimeTable {
	public static void main(String[] args) {

	}
}
