class Loader extends Thread {
	public void run() {
		System.out.println("Hello");
	}
}

class MyClass {
	public static void main(String[] args) {
		Loader obj = new Loader();
		obj.start();
	}
}