package assgn3;

import java.util.Date;
import java.io.*;
import java.util.logging.*;

class BusDetails {
	String name;
	String tr_no;
	static final String[] busStations = { "Canacona Bus Station", "Mapusa Bus Stand",
			"Shiroda Bus Stand", "Margao Bus Terminal" };
	static final String[] classTypes = { "Category 1", "Category 2", "Category 3", "Category 4" };
}

class BusBookingSystem extends BusDetails {
	int source;
	int destination;
}

class Account {
	float balance;
	int accNo;
	Logger logger;

	Account(int initBalance, Logger logger) {
		this.logger = logger;
		balance = initBalance;
		accNo = (int) (Math.random() * 10000);
	}

	void creditAmount(float amount) {
		balance += amount;
		logger.info(String.format("Credited Rupee %f in ACC NO. %d", amount, accNo));

	}

	boolean debitAmount(float amount) {
		if (amount < balance) {
			balance -= amount;
			logger.info(String.format("Debited Rupee %f from ACC NO. %d", amount, accNo));
			return true;
		}
		logger.warning(String.format("Insufficient Balance", amount, accNo));
		return false;
	}
}

public class OnlineBusTicket extends BusBookingSystem {
	Logger logger;
	Account acc;
	Date fromDate;
	int classType;
	int noOfPassengers;
	int fare;
	Boolean saved;
	Boolean paid;
	private BufferedReader in;

	OnlineBusTicket() {
		in = new BufferedReader(new InputStreamReader(System.in));
		LogManager lm = LogManager.getLogManager();

		logger = Logger.getLogger("OnlineBusTicket");
		try {
			FileHandler ch = new FileHandler("busTicketReservation.log");
			ch.setFormatter(new SimpleFormatter());
			logger.addHandler(ch);
		} catch (Exception e) {
			System.out.println("Failed to Initialise Logger");
		}

		logger.setLevel(Level.ALL);
		lm.addLogger(logger);
		acc = new Account(1200, logger);
	}

	int getFare(int frmStat, int toStat) {
		int distFare = Math.abs(frmStat - toStat) * 1000;
		return distFare;
	}

	int getFare(String frmStat, String toStat) {
		int distFare = Math.abs(getPoint(frmStat) - getPoint(toStat)) * 1000;
		return distFare;
	}

	int getPoint(String stationName) {
		for (int i = 0; i < BusDetails.busStations.length; i++) {
			if (BusDetails.busStations[i].equals(stationName))
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

	boolean payTicket(float amount) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Procceding to Payment. Amount to be Paid : ₹" + this.fare);
		System.out.println("Enter Username : ");
		String usr = in.readLine().toString();
		System.out.println("Enter Password : ");
		String pss = in.readLine().toString();
		boolean passMatch = usr.compareTo(pss) == 0;
		if (!passMatch) {
			logger.warning("Username and Password Does not Match");
			return false;
		} else {
			this.paid = acc.debitAmount(amount);
			if (!this.paid) {
				logger.warning("Transaction Error");
				return false;
			}
		}
		return this.paid;
	}

	void printTicket() {
		System.out.println("Tarriff");
		System.out.println("Departure Date : \t\t" + this.fromDate);
		System.out.println("From : \t\t" + busStations[this.source]);
		System.out.println("To : \t\t" + busStations[this.destination]);
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
			System.out.println(i + ". " + busStations[i]);
		}
		this.source = Integer.parseInt(br.readLine());
		if (0 > this.source || this.source > 3) {
			System.out.println("Enter Within Range");
			return this.saved;
		}

		System.out.println("Enter To Station");
		for (int i = 0; i < 4; i++) {
			System.out.println(i + ". " + busStations[i]);
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
		logger.fine("Ticket Details :");
		logger.fine(departDate);
		logger.fine(busStations[source] + " - " + busStations[destination]);
		logger.fine(classTypes[classType]);
		return this.saved;
	}

	public static void main(String[] args) throws IOException {
		boolean stop = false;
		OnlineBusTicket ticket = new OnlineBusTicket();

		while (!stop)
			stop = ticket.getInput();
		float amt = ticket.calcFare();
		System.out.println("Your Fare is : Re." + amt);
		ticket.logger.finest("Calculated Fare : Re." + amt);

		stop = false;
		while (!stop) {
			stop = ticket.payTicket(amt);
			if (!stop) {
				System.out.println("Payment Failure ! Try again");
			}
		}

		ticket.printTicket();
	}
}
