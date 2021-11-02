package presentation;

class Class1 extends Thread {
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Exception!");
			}
			System.out.println("Welcome");
		}
	}
}

class Class2 extends Thread {
	public void run() {
		while (true) {
			try {
				Thread.sleep(3000, 0);
			} catch (InterruptedException e) {
				System.out.println("Exception!");
			}
			System.out.println("TCE");
		}
	}
}

public class Main {
	public static void main(String[] args) {

		Class1 c1 = new Class1();
		Class2 c2 = new Class2();
		c1.start();
		c2.start();
	}
}
