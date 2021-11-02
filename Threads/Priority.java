class LowPriorityThread implements Runnable {
	public void run() {
		int i = 0;
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {

			}
			System.out.println("Low Pr Executing " + i++);
		}
	}
}

class HighPriorityThread implements Runnable {
	public void run() {
		int i = 0;
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {

			}
			System.out.println("High Pr Executing " + i++);
		}
	}
}

public class Priority {
	public static void main(String[] args) {
		Thread high = new Thread(new HighPriorityThread());
		Thread low = new Thread(new LowPriorityThread());

		high.setPriority(Thread.MAX_PRIORITY);
		low.setPriority(Thread.MIN_PRIORITY);

		low.start();
		high.start();
	}
}
