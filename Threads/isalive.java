public class isalive extends Thread {
	public void run() {
		System.out.println("r1 ");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException ie) {
		}

		System.out.println("r2 ");
	}

	public static void main(String[] args) {
		isalive t1 = new isalive();
		isalive t2 = new isalive();
		t1.start();
		t2.start();
		while (true) {
			System.out.println(t1.isAlive());
			System.out.println(t2.isAlive());
			System.out.println(" ");

		}

	}
}