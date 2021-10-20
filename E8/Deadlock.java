class Resource1 {
	void useResourse(int pId) {
		System.out.println("Resource 1 being used by Process " + pId);
	}
}

class Resource2 {
	void useResourse(int pId) {
		System.out.println("Resource 2 being used by Process " + pId);
	}
}

class ProcessType1 extends Thread {
	Resource1 r1;
	Resource2 r2;

	ProcessType1(Resource1 r1, Resource2 r2) {
		this.r1 = r1;
		this.r2 = r2;
	}

	public void run() {
		synchronized (r1) {
			r1.useResourse(1);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
			synchronized (r2) {
				r2.useResourse(1);
			}
		}
	}
}

class ProcessType2 extends Thread {
	Resource1 r1;
	Resource2 r2;

	ProcessType2(Resource1 r1, Resource2 r2) {
		this.r1 = r1;
		this.r2 = r2;
	}

	public void run() {
		synchronized (r2) {
			r2.useResourse(2);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
			synchronized (r1) {
				r1.useResourse(2);
			}
		}
	}
}

public class Deadlock {
	public static void main(String[] args) {
		Resource1 r1 = new Resource1();
		Resource2 r2 = new Resource2();

		ProcessType1 p1 = new ProcessType1(r1, r2);
		ProcessType2 p2 = new ProcessType2(r1, r2);

		p1.start();
		p2.start();

	}
}