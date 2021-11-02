import java.util.*;

class AgeNotCorrectException extends Exception {
	String s;

	AgeNotCorrectException(String message) {
		this.s = message;
	}

	public String toString() {
		return (s);
	}
}

public class Basic1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int s = sc.nextInt();
			if (s > 10) {
				throw new AgeNotCorrectException("Age is not correct");
			}
		} catch (InputMismatchException e) {
			System.out.println("NUmber FORMat Exception");
		} catch (ArithmeticException e) {
			System.out.println("Arithmetic Eerror");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("After error");
			sc.close();
		}
		System.out.println("After TRY");
		sc.close();
	}
}
