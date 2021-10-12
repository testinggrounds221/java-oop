import java.util.Scanner;
import java.util.ArrayList;

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
	int noOfHoursAttended;
	int noOfODDays;
	int noOfLeaveDays;

	void getInput() {
		super.getInput();
		System.out.print("Enter name : ");
		this.name = in.nextLine();

		System.out.print("Enter regNum : ");
		this.regNum = in.nextLine();
	}

	void markAttendence(String roll, String time) {
		this.noOfHoursAttended++;
	}

	void displayStudentInfo() {
		System.out.print("Department : " + this.dept);
		System.out.print("Sem : " + this.sem);
	}
}

public class AttendenceMonitoring extends TimeTable {
	ArrayList<Entry> arrli;

	void getInput() {
		super.getInput();
	}

	AttendenceMonitoring() {
		arrli = new ArrayList<Entry>(10);
	}

	class Entry {
		String roll;
		String time;

		Entry(String roll, String time) {
			this.roll = roll;
			this.time = time;
		}
	}

	void addEntry(String roll, String time) {
		arrli.add(new Entry(roll, time));
	}

	void displayAllEntries() {
		System.out.println("Attendence Register");

		for (Entry entry : arrli) {
			System.out.println("Roll Number : " + entry.roll);
			System.out.println("Time Entered : " + entry.time);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		AttendenceMonitoring am = new AttendenceMonitoring();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Roll Number :");
		String roll = in.nextLine();
		System.out.println("Enter time  :");
		String time = in.nextLine();

		am.addEntry(roll, time);
		in.close();
	}
}
