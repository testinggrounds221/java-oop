abstract class Shape {
	int l;
	int b;

	void printArea() {
	}
}

class Circle extends Shape {
	int r;
	int h;

	Circle(int rad) {
		this.r = rad;
	}

	void printArea() {
		System.out.println("Area of Circle is : " + r * Math.PI * Math.PI);
	}
}

class Rectangle extends Shape {
	int l;
	int h;

	Rectangle(int len, int height) {
		this.l = len;
		this.h = height;
	}

	void printArea() {
		System.out.println("Area of Rectangle is : " + l * h);
	}
}

class Triangle extends Shape {
	int base;
	int height;

	Triangle(int base, int height) {
		this.base = base;
		this.height = height;
	}

	void printArea() {
		System.out.println("Area of Triangle is : " + (0.5 * base * height));
	}
}

public class Area {
	public static void main(String[] args) {
		Rectangle rect = new Rectangle(1, 9);
		rect.printArea();

		Circle cir = new Circle(1);
		cir.printArea();

		Triangle tri = new Triangle(1, 9);
		tri.printArea();

	}
}
