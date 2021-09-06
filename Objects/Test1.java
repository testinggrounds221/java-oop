class A {
	int a;

	A getA() {
		return this;
	}

	void msg() {
		System.out.println("Hello java" + a);
	}
}

public class Test1 {
	public static void main(String args[]) {
		new A().getA().msg();
	}
}