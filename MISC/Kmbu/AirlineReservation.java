package MISC.Kmbu;

import java.util.Date;
import java.io.*;

class Airline {
	String name;
	String tr_no;
	static final String[] airPorts = { "Denver International Airport", "Orlando International Airport",
			"Cairo International Airport", "Suvarnabhumi Airport" };
	static final String[] classTypes = { "Category 1", "Category 2", "Category 3", "Category 4" };
}

class PassengerAirline extends Airline {
	int source;
	int destination;
}

public class AirlineReservation extends PassengerAirline {
	Date fromDate;
	int classType;
	int noOfPassengers;
	int fare;
	Boolean saved;
	Boolean paid;
	private BufferedReader in;

	AirlineReservation() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}

	int getFare(int frmStat, int toStat) {
		int distFare = Math.abs(frmStat - toStat) * 1000;
		return distFare;
	}

	int getFare(String frmStat, String toStat) {
		int distFare = Math.abs(getPoint(frmStat) - getPoint(toStat)) * 1000;
		return distFare;
	}

	int getPoint(String airportName) {
		for (int i = 0; i < Airline.airPorts.length; i++) {
			if (Airline.airPorts[i].equals(airportName))
				return i;
		}
		return -1;
	}

	int calcFare() {
		int distFare = getFare(this.source, this.destination);
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
	}

	void printTicket() {
		System.out.println("Tarriff");
		System.out.println("Departure Date : \t\t" + this.fromDate);
		System.out.println("From : \t\t" + airPorts[this.source]);
		System.out.println("To : \t\t" + airPorts[this.destination]);
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
			System.out.println(i + ". " + airPorts[i]);
		}
		this.source = Integer.parseInt(br.readLine());
		if (0 > this.source || this.source > 3) {
			System.out.println("Enter Within Range");
			return this.saved;
		}

		System.out.println("Enter To Station");
		for (int i = 0; i < 4; i++) {
			System.out.println(i + ". " + airPorts[i]);
		}
		this.destination = Integer.parseInt(br.readLine());

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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		AirlineReservation ticket = new AirlineReservation();
		System.out.println("Enter 1 to Book Tickets");
		System.out.println("Enter 2 to Get Fare Details");
		int c = Integer.parseInt(br.readLine());
		if (c == 1) {
			while (!stop)
				stop = ticket.getInput();
			System.out.println("Your Fare is : ₹" + ticket.calcFare());
			stop = false;
			while (!stop)
				stop = ticket.payTicket();
			ticket.printTicket();
		} else if (c == 2) {
			System.out.println("Enter Enquiry First Airport");
			String f = br.readLine();
			System.out.println("Enter Enquiry Second Airport");
			String l = br.readLine();
			if (ticket.getPoint(f) == -1 || ticket.getPoint(l) == -1) {
				System.out.println("Invalid Airport Names");
			} else {
				System.out.println("Distance Fare between " + f + " and " + l + " is " + ticket.getFare(f, l));
			}

		}
	}
}
