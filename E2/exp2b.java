import java.util.*;
import java.io.*;

//exp 2b
public class exp2b {
	public static void main(String args[]) throws IOException {
		int sum = 0, n = 0;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Integers with gap : ");
		String input = in.readLine();
		StringTokenizer stToken = new StringTokenizer(input, " ");
		while (stToken.hasMoreTokens()) {
			n = Integer.parseInt(stToken.nextToken());
			System.out.println(n);
			sum += n;
		}
		System.out.println("Sum of Input String: " + sum);
		in.close();
	}
}