import java.util.*;

class MyNumber {
	int value;

	MyNumber(int val) {
		this.value = val;
	}
}

public class RandomNumber {

	static int count;
	static int current;

	public static void main(String[] args) {
		current = 1;
		Random ran = new Random();
		MyNumber myNum = new MyNumber(1);
		count = 1;

		Thread t1 = new Thread() {
			public void run() {
				synchronized (this) {
					while (count < 10) {
						while (current != 1) {
							try {
								wait();
							} catch (Exception e) {
							}
						}
						myNum.value = ran.nextInt(100);
						System.out.println("Generated Number is " + myNum.value);
						count++;
						current = 2;
						notify();
					}

				}

			}
		};

		Thread t2 = new Thread() {

			public void run() {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}
				synchronized (this) {
					while (count < 10) {
						while (current != 2) {
							try {
								wait();
							} catch (Exception e) {
							}
						}
						if (myNum.value % 2 == 0) {
							System.out.println("Square is " + myNum.value * myNum.value);

						}
						current = 3;
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
						while (current != 3) {
							try {
								wait();
							} catch (Exception e) {

							}
						}
						if (myNum.value % 2 != 0) {
							System.out.println("Cube is " + (myNum.value * myNum.value * myNum.value));

						}
						current = 1;
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