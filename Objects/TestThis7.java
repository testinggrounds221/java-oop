class StudentY {
	int rollno;
	String name, course;
	float fee;

	StudentY(int rollno, String name, String course) {
		this.rollno = rollno;
		this.name = name;
		this.course = course;
	}

	StudentY(int rollno, String name, String course, float fee) {
		this(rollno, name, course);// reusing constructor
		// Rule: Call to this() must be the first statement in constructor.
		this.fee = fee;
	}

	void display() {
		System.out.println(rollno + " " + name + " " + course + " " + fee);
	}
}

public class TestThis7 {
	public static void main(String args[]) {
		StudentY s1 = new StudentY(111, "ankit", "java");
		StudentY s2 = new StudentY(112, "sumit", "java", 6000f);
		s1.display();
		s2.display();
	}
}