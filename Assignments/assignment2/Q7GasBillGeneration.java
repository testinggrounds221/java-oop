package assignment2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.*;

class GasBillReceipt {
	ConsumerDetail consumer;
	String date;
	double amount;

	GasBillReceipt(ConsumerDetail consumer, String date, double amount) {
		this.consumer = consumer;
		this.date = date;
		this.amount = amount;
	}
}

class ConsumerDetail {
	int gasId;
	int lotNo;
	String name;
	int category;
	boolean owner;

	ConsumerDetail(int gasId) {
		this.gasId = gasId;
	}

	void getInput() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(String.format("Enter lotNo of ConsumerThread %d: ", gasId));
		lotNo = (int) (in.read());

		System.out.print(String.format("Enter name of ConsumerThread %d: ", gasId));
		name = in.readLine();

		System.out.println(String.format("Enter category of ConsumerThread %d: ", gasId));
		category = (int) (in.read());
	}

	double calculateTotal(int units) {
		if (units < 0)
			return 0;
		if (units < 100)
			return category * (units * 1.20);
		if (units < 300)
			return category * (100 * 1.20 + (units - 100) * 2);
		return category * (100 * 1.20 + 200 * 2 + (units - 300) * 3);
	}
}

class GasDataBase {

	private GasBillReceipt[] recieiptRecords;
	boolean isBusy;

	GasDataBase() {
		isBusy = false;
		recieiptRecords = new GasBillReceipt[10];
	}

	void addRecieiptRecord(GasBillReceipt r, int gasId) {
		recieiptRecords[gasId] = r;
	}

}

class ConsumerThread extends Thread {
	GasDataBase db;
	ConsumerDetail consumer;
	int units;

	static boolean isBusy;

	ConsumerThread(GasDataBase db, ConsumerDetail consumer, int units) {
		this.consumer = consumer;
		this.db = db;
		this.units = units;
	}

	public void run() {
		String now = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
		double amount = consumer.calculateTotal(units);
		synchronized (this) {
			while (isBusy) {
				try {
					System.out.println("ConsumerThread " + consumer.gasId + " Waiting for DB");
					this.wait();
					System.out.println("Notified ConsumerThread " + consumer.gasId + " Waiting for DB");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			isBusy = true;
			try {
				// Thread.sleep((int) (Math.random() % 1000));
				Thread.sleep(100);

			} catch (Exception e) {
			}

			db.addRecieiptRecord(new GasBillReceipt(consumer, now, amount), consumer.gasId);
			System.out.println("Billed and stored ConsumerThread " + consumer.gasId);

			this.notifyAll();
			isBusy = false;

		}
	}
}

public class Q7GasBillGeneration {
	public static void main(String[] args) throws IOException {
		GasDataBase db = new GasDataBase();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		ConsumerThread cThreadArray[] = new ConsumerThread[10];
		for (int i = 0; i < 4; i++) {
			ConsumerDetail c1 = new ConsumerDetail(i);
			c1.getInput();

			System.out.println(String.format("Enter No of Cylinders %d: ", i));
			int units = Integer.parseInt(in.readLine());
			cThreadArray[i] = new ConsumerThread(db, c1, units);
		}
		for (int i = 0; i < 4; i++) {
			cThreadArray[i].start();
		}
		for (int i = 0; i < 4; i++) {
			try {
				cThreadArray[i].join();
			} catch (Exception e) {
			}

		}
	}
}
