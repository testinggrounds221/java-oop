import java.util.*;

public class MultiThread {
	public static void main(String[] args) {
		Random rand = new Random();
		for (int i = 0; i < 6; i++) {
			int num = rand.nextInt(100);
			System.out.println("Random Integer : " + num);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			if (num % 2 == 0) {
				new Thread(new Runnable() {
					public void run() {
						System.out.println("Square of " + num + " is " + num * num);
					}
				}).start();

			} else {
				new Thread(new Runnable() {
					public void run() {
						System.out.println("Cube of " + num + " is " + num * num * num);
					}
				}).start();
			}
		}
	}
}
