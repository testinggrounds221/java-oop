class MyTask {
	void executeTask() {
		for (int i = 0; i < 10; i++) {
			System.out.println("@@@ Printing File " + i + " - Printer 2 @@@");
		}
	}
}

class MyThreadedTaskRunnable implements Runnable { // OPEN UP TIS BIATCH
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("### Printing File " + i + " - Printer 3 ###");
		}
	}
}

class MyTHreadedTask extends Thread {
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

		Runnable thrdTskObj = new MyThreadedTaskRunnable();

		Thread runnableThread = new Thread(thrdTskObj);
		runnableThread.start();
		runnableThread.join();
		MyTHreadedTask thread = new MyTHreadedTask();
		thread.start();

		// for (int i = 0; i < 10; i++) {
		// System.out.println("!!!Printing File " + i + " - Printer 1!!!");
		// }

		// Runnable dt = new DaemonThread();

		// Thread t = new Thread(dt);
		// t.setDaemon(true);
		// t.start();

		// thread.join();
		System.out.println("Reaching Last Line og main, But main is in not terminated");
	}
}
