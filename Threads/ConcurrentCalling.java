public class ConcurrentCalling extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("The Thread name is " + Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {
		ConcurrentCalling t1 = new ConcurrentCalling();
		t1.setName("Main Thread");
		t1.start();
		Thread t2 = currentThread();
		t2.setName("Current Thread");
		for (int i = 0; i < 5; i++) {
			System.out.println("The Thread name is " + Thread.currentThread().getName());
		}
	}
}