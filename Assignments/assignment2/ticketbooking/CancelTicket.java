package assignment2.ticketbooking;

class CancelTicket implements Runnable {
	TicketReservation tkct;

	CancelTicket(TicketReservation t) {
		this.tkct = t;
	}

	public void run() {
		synchronized (tkct) {
			System.out.println("Waiting to cancel Ticket..");
			if (!tkct.paid) {
				try {
					tkct.wait();
				} catch (InterruptedException e) {
				}
			}
			tkct.paid = false;
			tkct.notify();

			System.out.println("Cancelled Ticket");
		}
	}
}
