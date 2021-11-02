// Java program to demonstrate inter-thread communication
// (wait(), join() and notify()) in Java

import java.util.Scanner;

public class threadexample {
	public static void main(String[] args) throws InterruptedException {
		final PC pc = new PC();

		// Create a thread object that calls pc.produce()
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.produce1();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.produce2();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.produce3();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// Create another thread object that calls
		// pc.consume()
		Thread tc = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// Start both threads
		t1.start();
		t2.start();
		t3.start();

		tc.start();

		// t1 finishes before tc
		t2.join();
		t3.join();
		t1.join();

		tc.join();
	}

	// PC (Produce Consumer) class with produce() and
	// consume() methods.
	public static class PC { // DABBA
		// Prints a string and waits for consume()
		public void produce1() throws InterruptedException {
			// synchronized block ensures only one thread
			// running at a time.
			synchronized (this) {
				System.out.println("producer thread 1 running");

				// releases the lock on shared resource
				wait();

				// and waits till some other method invokes notify().
				System.out.println("Resumed 1");
			}
		}

		public void produce2() throws InterruptedException {
			// synchronized block ensures only one thread
			// running at a time.
			synchronized (this) {
				System.out.println("producer thread 2 running");

				// releases the lock on shared resource
				wait();

				// and waits till some other method invokes notify().
				System.out.println("Resumed 2");
			}
		}

		public void produce3() throws InterruptedException {
			// synchronized block ensures only one thread
			// running at a time.
			synchronized (this) {
				System.out.println("producer thread 3 running");

				// releases the lock on shared resource
				wait();

				// and waits till some other method invokes notify().
				System.out.println("Resumed 3");
			}
		}

		// Sleeps for some time and waits for a key press. After key
		// is pressed, it notifies produce().
		public void consume() throws InterruptedException {
			// this makes the produce thread to run first.
			Thread.sleep(1000);
			Scanner s = new Scanner(System.in);

			// synchronized block ensures only one thread
			// running at a time.
			synchronized (this) {
				System.out.println("Waiting for return key.");
				s.nextLine();
				System.out.println("Return key pressed");

				// notifies the produce thread that it
				// can wake up.
				notifyAll();

				// NOTIFY
				// NOTIFY

				// Sleep
				Thread.sleep(3000);
				s.close();
			}
		}
	}
}
