public class AlternateNumbers {
	boolean odd;
	int count = 1;
	int MAX = 20;

	public void printOdd() {
		synchronized (this) {
			while (count < MAX) {
				while (!odd) {
					try {
						wait();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				System.out.println(count++);
				odd = false;
				notify();
			}

		}
	}

	public void printEven() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

		}
		synchronized (this) {
			while (count < MAX) {
				while (odd) {
					try {
						wait();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				System.out.println(count++);
				odd = true;
				notify();
			}

		}

	}

	public static void main(String[] args) {
		AlternateNumbers an = new AlternateNumbers();
		// an.odd = true;

		Thread evenThread = new Thread(new Runnable() {
			public void run() {
				an.printEven();
			}
		});
		Thread oddThread = new Thread(new Runnable() {
			public void run() {
				an.printOdd();
			}
		});
		evenThread.start();
		oddThread.start();

		try {
			evenThread.join();
			oddThread.join();

		} catch (Exception e) {
			System.out.print("Exception");
			System.out.print("Exception");
		}

	}

}
