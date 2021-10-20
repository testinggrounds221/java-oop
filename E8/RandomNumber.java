import java.util.*;

class MyNumber {
	int value;

	MyNumber(int val) {
		this.value = val;
	}
}

public class RandomNumber {
	static boolean check;
	static int count;

	public static void main(String[] args) {
		Random ran = new Random();
		MyNumber myNum = new MyNumber(1);
		Object lock = new Object();
		count = 1;
		check = false;
		Thread t1 = new Thread() {
			public void run() {
				synchronized (lock) {
					while (count < 10) {
						while (check) {
							try {
								wait();
							} catch (Exception e) {
							}
						}
						myNum.value = ran.nextInt(100);
						System.out.println("Generated Number is " + myNum.value);
						check = true;
						count++;
						lock.notify();
					}

				}

			}
		};

		Thread t2 = new Thread() {

			public void run() {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				synchronized (this) {
					while (count < 10) {
						while (!check) {
							try {
								wait();
							} catch (Exception e) {
							}
						}
						if (myNum.value % 2 == 0) {
							System.out.println("Square is " + myNum.value * myNum.value);
							check = false;
						}
						notify();
					}

				}
			}
		};

		Thread t3 = new Thread() {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}
				synchronized (this) {
					while (count < 10) {
						while (!check) {
							try {
								wait();
							} catch (Exception e) {

							}
						}
						if (myNum.value % 2 != 0) {
							System.out.println("Cube is " + (myNum.value * myNum.value * myNum.value));
							check = false;
						}
						notify();
					}

				}
			}
		};

		try {
			t1.start();
			t2.start();
			t3.start();
			t1.join();
			t2.join();
			t3.join();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
}