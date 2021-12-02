package MISC.Kmbu;

import java.io.*;

class AreaCalc {
	int calculateArea(int l, int b) {
		return l * b;
	}

	void printArea(int l, int b) {
		System.out.println("Area of rectangle is " + calculateArea(l, b) + " sq. Units");
	}
}

public class AreaRoom extends AreaCalc {
	void printArea(int l, int b) {
		System.out.println("Area of Room is " + calculateArea(l, b));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		AreaRoom ar = new AreaRoom();
		System.out.println("Enter Length and breadth of Rectangular Room : ");
		int l = Integer.parseInt(in.readLine());
		int b = Integer.parseInt(in.readLine());
		ar.printArea(l, b);
		in.close();
	}
}