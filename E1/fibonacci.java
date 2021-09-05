public class fibonacci {
	public static void main(String[] args) {
		int v1 = 1, v2 = 1, v3 = 0, n = 20;
		System.out.println("Fibonacci Series upto 20 Elements");
		System.out.println((v1 + " " + v2).getClass().getSimpleName());
		System.out.print(v1 + " " + v2);
		for (int i = 0; i < n; i++) {
			v3 = v1 + v2;
			System.out.print(" " + v3);
			v1 = v2;
			v2 = v3;
		}
	}
}