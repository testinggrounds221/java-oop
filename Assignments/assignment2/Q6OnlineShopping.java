package assignment2;

class Product {
	private int numberOfItems;

	boolean isStockEmpty() {
		return numberOfItems <= 0;
	}

	void fillUpStock() {
		numberOfItems += 100;
	}

	void purchaseBatch() {
		numberOfItems -= 10;
	}

	void printCurrentItems() {
		System.out.println("Current Stock : " + numberOfItems);
	}

}

class ShopKeeper extends Thread {
	Product p;

	ShopKeeper(Product p) {
		this.p = p;
	}

	public void run() {
		while (true) {
			synchronized (p) {
				if (p.isStockEmpty()) {
					p.fillUpStock();
					System.out.println("[SHOPKEEPER] : Stock is Empty. Refilling");
					p.printCurrentItems();
				}
				p.notifyAll();
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {

			}
		}
	}
}

class OnlineCustomer extends Thread {
	Product p;
	int clNum;

	OnlineCustomer(Product p, int c) {
		this.p = p;
		this.clNum = c;
	}

	public void run() {
		while (true) {
			synchronized (p) {

				if (!p.isStockEmpty()) {
					p.purchaseBatch();
					System.out.println("[CONSUMER " + clNum + "] : Purchased Items");
					p.printCurrentItems();
					p.notify();
				} else {
					try {
						p.wait();
						System.out.println("[CONSUMER " + clNum + "] : Waiting For Shop keeper to Fill up Stock");
					} catch (Exception e) {
					}

				}
			}

			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}

		}

	}
}

public class Q6OnlineShopping {
	public static void main(String[] args) {
		Product p = new Product();

		ShopKeeper sk = new ShopKeeper(p);

		OnlineCustomer cstmr1 = new OnlineCustomer(p, 1);
		OnlineCustomer cstmr2 = new OnlineCustomer(p, 2);

		cstmr1.start();
		cstmr2.start();
		sk.start();
	}
}