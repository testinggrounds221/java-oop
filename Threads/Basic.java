class MyTask {
	void executeTask() {
		for (int i = 0; i < 10; i++) {
			System.out.println("@@@ Printing File " + i + " - Printer 2 @@@");
		}
	}
}

class RunnableClass implements Runnable { // OPEN UP TIS BIATCH
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("### Printing File " + i + " - Printer 3 ###");
		}
	}
}

class MyThreadedTask extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("$$$Printing File " + i + " - Printer 4$$$");
		}
	}
}

// class DaemonThread implements Runnable {
// public void run() {
// for (int i = 0; i < 5; i++) {
// System.out.println("This is the Daemon Thread");
// }
// }
// }

public class Basic {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Starting Main Thread");

		System.out.println(Thread.currentThread());

		// MyTask task = new MyTask();
		// task.executeTask();
		// PUT i ub as 10000 OS/JVM => app is unresponsive
		// Sluggish Behaviour => Hang
		// Long Running op inside main method

		Thread runnableThread = new Thread(new RunnableClass(), "My Thread Krish");

		runnableThread.start();
		// runnableThread.join();
		MyThreadedTask thread = new MyThreadedTask();
		thread.start();

		for (int i = 0; i < 10; i++) {
			System.out.println("!!!Printing File " + i + " - Printer 1!!!");
		}

		// Runnable dt = new DaemonThread();

		// Thread t = new Thread(dt);
		// t.setDaemon(true);
		// t.start();

		// thread.join();
		System.out.println("Reaching Last Line og main, But main is in not terminated");
	}
}
