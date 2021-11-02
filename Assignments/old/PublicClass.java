package old;

class privateDemo {
	final int var = 92;

	private class privateClass {
		void Display() {
			System.out.println("private Class Method");
		}
	}

	class AnotherClass extends privateClass {
		void anotherDisplay() {
			Display();
		}
	}

}

final class FinalClassDemo {
	void Display() {
		System.out.println("private Class Method");
	}
}
