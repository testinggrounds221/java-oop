
public class Student6 {
	int id;
	String name;

	// constructor to initialize integer and string
	Student6(int i, String n) {
		id = i;
		name = n;
	}

	// constructor to initialize another object
	Student6(Student6 s) {
		id = s.id;
		name = s.name;
	}

	void display() {
		System.out.println(id + " " + name);
		int[] arr = { 1, 2, 3, 4 };
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);

		}
		System.out.print(arr.length);
		System.out.print(arr[0]);

	}

	public static void main(String args[]) {
		Student6 s1 = new Student6(111, "Karan");
		Student6 s2 = new Student6(s1);
		s1.display();
		s2.display();
	}
}