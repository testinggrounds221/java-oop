public class OddEvenPrintMain {

	boolean odd;
	int count = 1;
	int MAX = 20;

	public void printOdd() {
		synchronized (this) {
			while (count < MAX) {
				// System.out.println("Checking odd loop");

				while (!odd) {
					try {
						// System.out.println("Odd waiting : " + count);
						wait();
						// System.out.println("Notified odd :" + count);
					} catch (Exception e) {
						// TODO Auto-generated catch block

					}
				}
				System.out.println("Odd Thread :" + count++);
				odd = false;
				notify();
			}
		}
	}

	public void printEven() {

		try {
			Thread.sleep(1000);
		} catch (Exception e1) {

		}
		synchronized (this) {
			while (count < MAX) {
				// System.out.println("Checking even loop");

				while (odd) {
					try {
						// System.out.println("Even waiting: " + count);
						wait();
						// System.out.println("Notified even:" + count);
					} catch (Exception e) {

					}
				}
				System.out.println("Even thread :" + count++);
				odd = true;
				notify();

			}
		}
	}

	public static void main(String[] args) {

		OddEvenPrintMain oep = new OddEvenPrintMain();
		oep.odd = true;
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				oep.printEven();

			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				oep.printOdd();

			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (Exception e) {

		}

	}
}