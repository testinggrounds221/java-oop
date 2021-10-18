interface Phone {
	abstract void displayInfo();
}

class Samsung implements Phone {
	public void displayInfo() {
		System.out.println("Samsung Phone");
	}
}

class iPhone implements Phone {
	public void displayInfo() {
		System.out.println("iPhone Phone");
	}
}

public class Phones {

	static void displayPhoneInfo(Phone p) {
		p.displayInfo();
	}

	// static void displaySamsungPhone() {
	// System.out.println("Samsung Phone");
	// }

	// static void displayiPhone() {
	// System.out.println("iPhone Phone");
	// }

	public static void main(String[] args) {
		Phone s = new Samsung();
		Phone i = new iPhone();
		displayPhoneInfo(s);
		displayPhoneInfo(i);
		// s.displayInfo();
		// i.displayInfo();

	}

}
