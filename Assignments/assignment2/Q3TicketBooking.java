package assignment2;

class Ticket {
	boolean booked;

	Ticket() {
		booked = false;
	}
}

class BookTicket implements Runnable {
	Ticket tkct;

	BookTicket(Ticket t) {
		this.tkct = t;
	}

	public void run() {
		synchronized (tkct) {
			System.out.println("Booking ticket ! Please Wait");
			try {
				Thread.sleep(1500);
			} catch (Exception e) {
			}
			System.out.println("Ticket Booked");
			tkct.booked = true;
			tkct.notify();
		}
	}

}

class CancelTicket implements Runnable {
	Ticket tkct;

	CancelTicket(Ticket t) {
		this.tkct = t;
	}

	public void run() {
		synchronized (tkct) {
			System.out.println("Waiting to cancel Ticket..");
			if (!tkct.booked) {
				try {
					tkct.wait();
				} catch (InterruptedException e) {
				}
			}
			tkct.booked = false;
			tkct.notify();

			System.out.println("Cancelled Ticket");
		}
	}
}

/**
 * TicketBooking
 */
public class Q3TicketBooking {
	public static void main(String[] args) {
		Ticket t = new Ticket();
		Thread bThread = new Thread(new BookTicket(t));
		Thread cThread = new Thread(new CancelTicket(t));

		cThread.start();
		bThread.start();

		try {

			bThread.join();
			cThread.join();
		} catch (Exception e) {

		}
	}
}
