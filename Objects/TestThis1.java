// ERROR CODE:
// class Student {
// 	int rollno;
// 	String name;
// 	float fee;

// 	Student(int rollno, String name, float fee) {
// 		rollno = rollno;
// 		name = name;
// 		fee = fee;
// 	}

// 	void display() {
// 		System.out.println(rollno + " " + name + " " + fee);
// 	}
// }

class StudentX {
	int rollno;
	String name;
	float fee;

	StudentX(int rollno, String name, float fee) {
		this.rollno = rollno;
		this.name = name;
		this.fee = fee;
	}

	void display() {
		System.out.println(rollno + " " + name + " " + fee);
	}
}

public class TestThis1 {
	public static void main(String args[]) {
		StudentX s1 = new StudentX(111, "ankit", 5000f);
		StudentX s2 = new StudentX(112, "sumit", 6000f);
		s1.display();
		s2.display();
	}
}
