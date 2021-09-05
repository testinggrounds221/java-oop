public class Counter2 {
	static int count = 0;// will get memory only once and retain its value

	void increment() {
		count++;
	}

	int getCount() {
		return count;
	}

	public static void main(String args[]) {
		// creating objects
		Counter2 c1 = new Counter2();
		c1.increment();
		Counter2 c2 = new Counter2();
		c2.increment();
		Counter2 c3 = new Counter2();
		c3.increment();
		System.out.println(c1.getCount());
	}
}