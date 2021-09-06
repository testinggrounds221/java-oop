public class arithmetic {
	int add(int a, int b) {
		System.out.println("Integer");
		return a + b;
	}

	double add(double a, double b) {
		System.out.println("DOuv=ble");
		return a + b;
	}

	float add(float a, float b) {
		System.out.println("Float");
		return a + b;
	}

	public static void main(String[] args) {
		arithmetic a = new arithmetic();
		System.out.println(a.add(4, 5));
		System.out.println(a.add(4.5, 5.4));
		// STATIC BINDING, COMPILE TIME BINDING, OVERLOADING
	}
}
