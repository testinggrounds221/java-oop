class A1 {
	A1 get() {
		return this;
	}
}

public class B1 extends A1 {
	@Override
	B1 get() {
		return this;
	}

	void message() {
		System.out.println("welcome to covariant return type");
	}

	public static void main(String args[]) {
		new B1().get().message();
	}
}