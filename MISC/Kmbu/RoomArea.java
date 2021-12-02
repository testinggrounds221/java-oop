package MISC.Kmbu;

import java.io.*;

class AreaOverload {
	int calculateArea(int l, int b) {
		return l * b;
	}

	double calculateArea(float r) {
		return Math.PI * r * r;
	}

	double calculateArea(float b, float h) {
		return 0.5 * b * h;
	}

	double calculateArea(int s) {
		return s * s;
	}
}

public class RoomArea {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		AreaOverload ar = new AreaOverload();
		System.out.println("1.Rectangular Room\t2.Circular Room\t3.Triangular Room\t4.Square Room");
		int c = Integer.parseInt(in.readLine());
		switch (c) {
		case 1:
			System.out.println("Enter Length and breadth of Rectangular Room");
			int l = Integer.parseInt(in.readLine());
			int b = Integer.parseInt(in.readLine());
			System.out.println("Area of given Rectangular Room : " + ar.calculateArea(l, b) + " sq. units");
			break;
		case 2:
			System.out.println("Enter Radius of Circular Room");
			float rad = Float.parseFloat(in.readLine());
			System.out.println("Area of given Circular Room : " + ar.calculateArea(rad) + " sq. units");
			break;
		case 3:
			System.out.println("Enter Height and Breadth of Triangular Room");
			float hg = Float.parseFloat(in.readLine());
			float br = Float.parseFloat(in.readLine());
			System.out.println("Area of given Triangular Room : " + ar.calculateArea(hg, br) + " sq. units");
			break;
		case 4:
			System.out.println("Enter of Square Room");
			int side = Integer.parseInt(in.readLine());
			System.out.println("Area of given Square Room : " + ar.calculateArea(side) + " sq. units");
			break;
		}

		in.close();
	}
}