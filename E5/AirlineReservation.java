import java.util.Date;
import java.io.*;

// getFare -> cities, points //Overloading
class Airline {
	String name;
	String tr_no;
}

class PassengerAirline extends Airline {
	int fromStation;
	int toStation;
	String[] airPorts = { "Madurai", "Washington DC", "Chicago", "Duabi" };
	String[] classTypes = { "Economy Class", "Premium Economy", "Business Class", "First Class" };

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

	protected void finalize() throws IOException {
		in.close();
	}

	int getDistFare(int frmStat, int toStat) {
		int distFare = Math.abs(frmStat - toStat) * 1000;
		return distFare;
	}

	int getDistFare(String frmStat, String toStat) {
		int distFare = Math.abs(getPoint(frmStat) - getPoint(toStat)) * 1000;
		return distFare;
	}

	int getPoint(String airportName) {
		for (int i = 0; i < this.airPorts.length; i++) {
			if (this.airPorts[i].equals(airportName))
				return i;
		}
		return -1;
	}

	int calcFare() {
		int distFare = getDistFare(this.fromStation, this.toStation);
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
		System.out.println("From : \t\t" + airPorts[this.fromStation]);
		System.out.println("To : \t\t" + airPorts[this.toStation]);
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
		this.fromStation = Integer.parseInt(br.readLine());
		if (0 > this.fromStation || this.fromStation > 3) {
			System.out.println("Enter Within Range");
			return this.saved;
		}

		System.out.println("Enter To Station");
		for (int i = 0; i < 4; i++) {
			System.out.println(i + ". " + airPorts[i]);
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
				System.out.println("Distance Fare between " + f + " and " + l + " is " + ticket.getDistFare(f, l));
			}

		}

		// if (ticket.payTicket()) {
		// System.out.println("Payment Success");
		// ticket.printTicket();
		// System.exit(0);
		// } else {
		// System.out.println("Payment Failure");
		// ticket.payTicket();
		// }

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