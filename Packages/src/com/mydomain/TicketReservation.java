package com.mydomain;

import java.util.Date;
import java.io.*;

class Train {
	String name;
	String tr_no;
	int no_compartments;
}

class PassengerTrain extends Train {
	int fromStation;
	int toStation;
	String[] stations = { "Madurai", "Sivakasi", "Tirupur", "Chennai" };
	String[] classTypes = { "Second Class AC", "Sleeper Class", "First Class", "AC Chair Car" };

}

public class TicketReservation extends PassengerTrain {
	Date fromDate;
	int classType;
	int noOfPassengers;
	int fare;
	Boolean saved;
	Boolean paid;
	private BufferedReader in;

	TicketReservation() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}

	protected void finalize() throws IOException {
		in.close();
	}

	int calcFare() {
		int distFare = Math.abs(this.fromStation - this.toStation) * 100;
		int classFare = this.classType * 100;
		this.fare = (classFare + distFare) * noOfPassengers;
		return this.fare;
	}

	boolean payTicket() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Procceding to Payment. Amount to be Paid : ₹" + this.fare);
		System.out.println("Enter Username : ");
		String usr = in.readLine().toString();
		System.out.println("Enter Password : ");
		String pss = in.readLine().toString();
		this.paid = usr.compareTo(pss) == 0;
		return this.paid;
		// return true;
	}

	void printTicket() {
		System.out.println("Tarriff");
		System.out.println("Departure Date : \t\t" + this.fromDate);
		System.out.println("From : \t\t" + stations[this.fromStation]);
		System.out.println("To : \t\t" + stations[this.toStation]);
		System.out.println("Class Type : \t\t" + classTypes[classType]);
		System.out.println("No Of Passengers : \t\t" + noOfPassengers);
		System.out.println("Fare : \t\t" + fare);
		System.out.print("Payment Status : \t\t");
		if (paid)
			System.out.println("Complete");
		else
			System.out.println("Incomplete");

	}

	boolean getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		this.saved = false;
		System.out.println("Enter Date of Departure : (DD/MM/YY)");
		String departDate = br.readLine();
		System.out.println(departDate);
		System.out.println("Enter From Station");
		for (int i = 0; i < 4; i++) {
			System.out.println(i + ". " + stations[i]);
		}
		this.fromStation = Integer.parseInt(br.readLine());
		if (0 > this.fromStation || this.fromStation > 3) {
			System.out.println("Enter Within Range");
			return this.saved;
		}
		System.out.println("Enter To Station");
		for (int i = 0; i < 4; i++) {
			System.out.println(i + ". " + stations[i]);
		}
		this.toStation = Integer.parseInt(br.readLine());

		System.out.println("Enter Class Type : ");
		for (int i = 0; i < 4; i++) {
			System.out.println(i + ". " + classTypes[i]);
		}
		this.classType = Integer.parseInt(br.readLine());
		System.out.println("Enter Number of Passengers : ");
		this.noOfPassengers = Integer.parseInt(br.readLine());
		this.saved = true;
		return this.saved;
	}

	public static void main(String[] args) throws IOException {
		boolean stop = false;
		TicketReservation ticket = new TicketReservation();
		while (!stop)
			stop = ticket.getInput();
		System.out.println("Your Fare is : ₹" + ticket.calcFare());
		stop = false;
		while (!stop)
			stop = ticket.payTicket();
		ticket.printTicket();
	}
}

// import java.util.Date;
// import java.text.DateFormat;
// import java.text.SimpleDateFormat;

// private String getDateTime() {
// DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
// Date date = new Date();
// return dateFormat.format(date);
// }