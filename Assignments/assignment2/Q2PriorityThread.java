package assignment2;

class BankDataBase {
	long numTranscations;
	long numBalanceCheck;
}

class Transact extends Thread {
	public boolean isRunning;
	BankDataBase bDB;

	Transact(BankDataBase bDB) {
		isRunning = true;
		this.bDB = bDB;
	}

	public void stopRunning() {
		isRunning = false;
	}

	public void run() {
		while (isRunning) {
			bDB.numTranscations++;
		}
		return;
	}
}

class CheckBalance extends Thread {
	public boolean isRunning;
	BankDataBase bDB;

	CheckBalance(BankDataBase bDB) {
		isRunning = true;
		this.bDB = bDB;
	}

	public void stopRunning() {
		isRunning = false;
	}

	public void run() {
		while (isRunning) {
			bDB.numBalanceCheck++;
		}
		return;

	}
}

public class Q2PriorityThread {
	public static void main(String[] args) throws Exception {
		BankDataBase db = new BankDataBase();

		Transact transactThread = new Transact(db);
		transactThread.setPriority(Thread.MAX_PRIORITY);

		CheckBalance checkBalanceThread = new CheckBalance(db);
		checkBalanceThread.setPriority(Thread.MIN_PRIORITY);

		transactThread.start();
		checkBalanceThread.start();
		Thread.sleep(1);
		transactThread.stopRunning();
		checkBalanceThread.stopRunning();

		System.out.println("Number of High priority Transactions : " + db.numTranscations);
		System.out.println("Number of Low priority Balance Checks : " + db.numBalanceCheck);

	}
}