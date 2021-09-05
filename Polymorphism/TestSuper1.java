class AnimalX {
	String color = "white";

	void eat() {
		System.out.println("eating...");
	}
}

class DogX extends AnimalX {
	String color = "black";

	void printColor() {
		System.out.println(color);// prints color of DogX class
		System.out.println(super.color);// prints color of AnimalX class
	}

	void eat() {
		System.out.println("eating bread...");
	}

	void bark() {
		System.out.println("barking...");
	}

	void work() {
		super.eat();
		bark();
	}
}

public class TestSuper1 {
	public static void main(String args[]) {
		DogX d = new DogX();
		d.printColor();
		d.work();
	}
}