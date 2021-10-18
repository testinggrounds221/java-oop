class SynchronizedPrinter {
	synchronized void printDocs(int numCopies, String fileName) {
		for (int i = 0; i < numCopies; i++) {
			System.out.println("Printed Copy " + i + " Of " + fileName);
		}
	}
}

class MySyncPrintingThread implements Runnable {
	SynchronizedPrinter pRef;
	int nCop;
	String fName;

	MySyncPrintingThread(SynchronizedPrinter pObj, int numCopies, String fileName) {
		pRef = pObj;
		this.nCop = numCopies;
		this.fName = fileName;

	}

	public void run() {
		pRef.printDocs(nCop, fName);
	}
}

public class SyncApp {
	public static void main(String[] args) throws InterruptedException {
		SynchronizedPrinter p = new SynchronizedPrinter();
		Thread mpt1 = new Thread(new MySyncPrintingThread(p, 5, "SweResume.pdf"));
		Thread mpt2 = new Thread(new MySyncPrintingThread(p, 5, "DhanmanResume.pdf"));
		Thread mpt3 = new Thread(new MySyncPrintingThread(p, 5, "SinimanResume.pdf"));

		mpt1.start();
		mpt2.start();
		mpt3.start();

	}
}
