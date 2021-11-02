package assignment2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

class TimeTable {
	String dept;
	String sem;
	Scanner in;

	static boolean containsDigit(String s) {
		for (char c : s.toCharArray()) {
			if (!Character.isDigit(c))
				return false;
		}
		return true;
	}

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
		if (containsDigit(name)) {
			throw new InputMismatchException();
		}
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

public class Q5HierarchicalInheritance extends TimeTable {
	ArrayList<Entry> arrli;

	void getInput() {
		super.getInput();
	}

	Q5HierarchicalInheritance() {
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
		try {
			arrli.add(new Entry(roll, time));
		} catch (Exception e) {
			System.out.println("Cannot Add More Entries");
		}
	}

	void displayAllEntries() {
		System.out.println("Attendence Register");
		try {
			for (Entry entry : arrli) {
				System.out.println("Roll Number : " + entry.roll);
				System.out.println("Time Entered : " + entry.time);
				System.out.println();
			}
		} catch (NullPointerException e) {
			System.out.print("No such Member");
			System.exit(-1);
		}

	}

	public static void main(String[] args) {
		Q5HierarchicalInheritance am = new Q5HierarchicalInheritance();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Roll Number :");
		String roll = in.nextLine();

		System.out.println("Enter time  :");
		String time = in.nextLine();
		in.close();
		try {
			if (!containsDigit(time)) {
				throw new InputMismatchException();
			}
			am.addEntry(roll, time);
			System.out.println("Added Entry");
		} catch (InputMismatchException ime) {
			System.out.println("No Characters allowed in Time.");
			System.exit(-1);
		}

	}
}
