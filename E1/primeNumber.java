public class primeNumber {
	public static void main(String[] args) {
		int n = 1000;
		boolean flag = true;
		System.out.println("Prime Numbers upto 1000");
		for (int j = 1; j < n; j++) {
			for (int i = 2; i < j; i++) {
				if (j % i == 0) {
					flag = false;
					break;
				}
			}
			if (flag)
				System.out.print(j + " ");
			flag = true;
		}
	}
}