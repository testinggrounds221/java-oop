package assignment2.ticketbooking;

class BookTicket extends TicketReservation implements Runnable {
	TicketReservation tkct;

	BookTicket(TicketReservation t) {
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
			tkct.paid = true;
			tkct.notify();
		}
	}

	public static void main(String[] args) {

	}
}