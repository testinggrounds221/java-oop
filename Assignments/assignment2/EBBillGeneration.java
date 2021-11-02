package assignment2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.*;

class Receipt {
	ConsumerProfile consumer;
	String date;
	double amount;

	Receipt(ConsumerProfile consumer, String date, double amount) {
		this.consumer = consumer;
		this.date = date;
		this.amount = amount;
	}
}

class ConsumerProfile {
	int id;
	int doorNo;
	String name;
	int category;
	boolean owner;

	ConsumerProfile(int id) {
		this.id = id;
	}

	void getInput() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(String.format("Enter doorNo of Consumer %d: ", id));
		doorNo = (int) (in.read());

		System.out.print(String.format("Enter name of Consumer %d: ", id));
		name = in.readLine();

		System.out.println(String.format("Enter category of Consumer %d: ", id));
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

class DataBase {

	private Receipt[] recieiptRecords;
	boolean isBusy;

	DataBase() {
		isBusy = false;
		recieiptRecords = new Receipt[10];
	}

	void addRecieiptRecord(Receipt r, int id) {
		recieiptRecords[id] = r;
	}

}

class Consumer extends Thread {
	DataBase db;
	ConsumerProfile consumer;
	int units;

	static boolean isBusy;

	Consumer(DataBase db, ConsumerProfile consumer, int units) {
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
					System.out.println("Consumer " + consumer.id + " Waiting for DB");
					this.wait();
					System.out.println("Notified Consumer " + consumer.id + " Waiting for DB");
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

			db.addRecieiptRecord(new Receipt(consumer, now, amount), consumer.id);
			System.out.println("Billed and stored Consumer " + consumer.id);

			this.notifyAll();
			isBusy = false;

		}
	}
}

public class EBBillGeneration {
	public static void main(String[] args) throws IOException {
		DataBase db = new DataBase();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		Consumer cThreadArray[] = new Consumer[10];
		for (int i = 0; i < 4; i++) {
			ConsumerProfile c1 = new ConsumerProfile(i);
			c1.getInput();

			System.out.println(String.format("Enter Units Consumed %d: ", i));
			int units = Integer.parseInt(in.readLine());
			cThreadArray[i] = new Consumer(db, c1, units);
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
