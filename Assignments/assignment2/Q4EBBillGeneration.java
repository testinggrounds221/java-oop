package assignment2;

import java.io.*;

interface ElectricityConsumption {
	int baseAmount = 5;
	int secondLevelAmount = 7;
	int thirdLevelAmount = 11;
	int fourthLevelAmount = 14;

	boolean getInput() throws IOException;

	int calculateBill();

	boolean processPayment() throws IOException;

	void printBill();

}

public class Q4EBBillGeneration implements ElectricityConsumption {
	String month;
	String doorNo;

	int unitsConsumed;
	int amount;
	boolean paid;

	public boolean getInput() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Door Number : ");
		this.doorNo = in.readLine();

		System.out.println("Enter Month for payment : ");
		this.month = in.readLine();

		System.out.println("Enter Units Consumed for " + this.month + " : ");
		this.unitsConsumed = Integer.parseInt(in.readLine());
		return true;
	}

	public int calculateBill() {
		if (0 < this.unitsConsumed && this.unitsConsumed <= 100) {
			this.amount = (this.unitsConsumed * baseAmount);
		} else if (this.unitsConsumed > 100 && this.unitsConsumed <= 200) {
			this.amount = ((100 * baseAmount) + (this.unitsConsumed - 100) * secondLevelAmount);
		} else if (this.unitsConsumed > 200 && this.unitsConsumed <= 300) {
			this.amount = ((100 * 5) + (100 * 7) + (this.unitsConsumed - 200) * fourthLevelAmount);
		} else if (this.unitsConsumed > 300) {
			this.amount = ((100 * 5) + (100 * 7) + (100 * 10) + (this.unitsConsumed - 300) * 15);
		} else {
			this.amount = 0;
		}
		return this.amount;
	}

	public boolean processPayment() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Procceding to Payment. Amount to be Paid : ₹" + this.amount);
		System.out.println("Enter Username : ");
		String usr = in.readLine().toString();
		System.out.println("Enter Password : ");
		String pss = in.readLine().toString();
		this.paid = usr.compareTo(pss) == 0;
		return this.paid;
	}

	public void printBill() {
		System.out.println("Tarriff");
		System.out.println("For Month : \t\t" + this.month);
		System.out.println("Door Number : \t\t" + this.doorNo);
		System.out.println("Units Consumed : \t\t" + this.unitsConsumed);
		System.out.println("Fare : \t\t" + this.amount);
		System.out.print("Payment Status : \t\t");
		if (paid)
			System.out.println("Complete");
		else
			System.out.println("Incomplete");
	}

	public static void main(String[] args) throws IOException {
		boolean stop = false;
		Q4EBBillGeneration ticket = new Q4EBBillGeneration();
		ticket.getInput();
		System.out.println("Your Fare is : ₹" + ticket.calculateBill());
		stop = false;
		while (!stop)
			stop = ticket.processPayment();
		System.out.println("Payment Success");
		ticket.printBill();
	}
}
