class R1 {
	void useResource(int n) {
		System.out.println(String.format("Process %d using R1", n));
	}
}

class R2 {
	void useResource(int n) {
		System.out.println(String.format("Process %d using R2", n));
	}
}

class Process1 extends Thread {
	int num = 0;
	R1 r1;
	R2 r2;

	Process1(R1 r1, R2 r2) {
		this.r1 = r1;
		this.r2 = r2;
	}

	public void run() {
		while (true) {
			synchronized (r1) {
				r1.useResource(1);
				try {
					Thread.sleep(100);
				} catch (Exception e) {
				}
				synchronized (r2) {
					r2.useResource(1);
				}
			}
		}
	}
}

class Process2 implements Runnable {
	int num = 0;
	R1 r1;
	R2 r2;

	Process2(R1 r1, R2 r2) {
		this.r1 = r1;
		this.r2 = r2;
	}

	public void run() {
		while (true) {

			synchronized (r2) {
				r2.useResource(2);
				try {
					Thread.sleep(100);
				} catch (Exception e) {
				}
				synchronized (r1) {
					r1.useResource(2);
				}
			}
		}
	}
}

public class DeadlockP {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			int num = 0;

			public void run() {
				while (true) {
					System.out.println("T1" + num++);
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			int num = 0;

			public void run() {
				while (true) {
					System.out.println("T2" + num++);
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}

			}
		});

		// t1.start();
		// t2.start();

		R1 r1 = new R1();
		R2 r2 = new R2();

		Process1 p1 = new Process1(r1, r2);
		Thread p2 = new Thread(new Process2(r1, r2));

		p1.start();
		p2.start();

		try {
			p1.join();
			p2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
