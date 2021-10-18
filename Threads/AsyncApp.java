class Printer {
	void printDocs(int numCopies, String fileName) {
		for (int i = 0; i < numCopies; i++) {
			System.out.println("Printed Copy " + i + " Of " + fileName);
		}
	}
}

class MyPrintingThread implements Runnable {
	Printer pRef;
	int nCop;
	String fName;

	MyPrintingThread(Printer pObj, int numCopies, String fileName) {
		pRef = pObj;
		this.nCop = numCopies;
		this.fName = fileName;

	}

	public void run() {
		synchronized (pRef) {
			pRef.printDocs(nCop, fName);
		}

	}
}

public class AsyncApp {
	public static void main(String[] args) throws InterruptedException {
		Printer p = new Printer();
		Thread mpt1 = new Thread(new MyPrintingThread(p, 5, "SweResume.pdf"));
		Thread mpt2 = new Thread(new MyPrintingThread(p, 5, "DhanmanResume.pdf"));
		Thread mpt3 = new Thread(new MyPrintingThread(p, 5, "SinimanResume.pdf"));

		// Asynchronous Running => Multiple threads running on the same object
		mpt1.start();
		mpt2.start();
		mpt3.start();
		// synchronized (p) {
		// mpt1.start();
		// mpt2.start();
		// mpt3.start();
		// }
		// mpt1.start();
		// mpt1.join();
		// mpt2.start();
		// mpt2.join();
		// mpt3.start();
		// mpt3.join();
	}
}
