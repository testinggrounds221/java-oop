public class OddEvenThread {
	static int count = 1;
	static boolean odd = true;
	static int max = 10;

	void printEven() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		synchronized (this) {
			while (count < max) {
				while (odd) {
					try {
						wait();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				System.out.println("Even  :" + count++);
				odd = true;
				notifyAll();
			}
		}
	}

	void printOdd() {
		synchronized (this) {
			while (count < max) {
				while (!odd) {
					try {
						wait();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				System.out.println("Odd  :" + count++);
				odd = false;
				notifyAll();
			}
		}
	}

	public static void main(String[] args) {
		OddEvenThread oet = new OddEvenThread();
		Thread oddThread = new Thread(new Runnable() {
			public void run() {
				oet.printOdd();
			}
		});

		Thread evenThread = new Thread(new Runnable() {
			public void run() {
				oet.printEven();
			}
		});
		evenThread.start();
		oddThread.start();

		try {
			evenThread.join();
			oddThread.join();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
