import java.util.ArrayList;
import java.util.Iterator;

class MyLoader implements Runnable {
	public void run() {
		while (true) {
			System.out.println("Hello");
		}
	}
}

public class MyThread {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 6; i++) {
			list.add(i);
			System.out.println(i);
		}
		int x = 0;
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			x += it.next();
		}
		System.out.println(x);

	}
}
