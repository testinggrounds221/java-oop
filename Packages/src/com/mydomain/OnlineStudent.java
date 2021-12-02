package Packages.src.com.mydomain;

class Member {
	String name;
	String contactNo;
	String institution;
	String gender;
	String email;

	Member(String n, String c, String i, String g, String e) {
		this.name = n;
		this.contactNo = c;
		this.institution = i;
		this.gender = g;
		this.email = e;
	}

	void printDetails() {
		System.out.println("Details of User : ");
		System.out.println("Name : " + name);
		System.out.println("Contact No : " + contactNo);
		System.out.println("Institution : " + institution);

	}
}

class OnlineTutror extends Member {
	String dept;
	int publishedCourseIds[];
	float rating;

	OnlineTutror(String n, String c, String i, String g, String e, String d, float r) {
		super(n, c, i, g, e);
		dept = d;
		rating = r;
	}

	void printDetails() {
		System.out.println("Details of Mentor : ");
		super.printDetails();
		System.out.println("Tutor Rating : " + rating);

	}
}

public class OnlineStudent extends Member {
	int enrollledCourseIds[];
	int favCourseIds[];
	String paymentMethod;
	String occupation;

	OnlineStudent(String n, String c, String i, String g, String e, String p, String o) {
		super(n, c, i, g, e);
		paymentMethod = p;
		occupation = o;
	}

	void printDetails() {
		System.out.println("Details of Student : ");
		super.printDetails();
		System.out.println("Payment Method : " + paymentMethod);
		System.out.println("Occupation : " + occupation);
	}

	public static void main(String[] args) {
		Member mem = new Member("Sample Member", "909090909090", "TCE", "male", "myMail@gmail");
		Member tchr = new OnlineTutror("Mr.Teacher", "9512341234", "VIT", "female", "myMail@vit", "IT", 9.8f);
		Member stud = new OnlineStudent("Sample Member", "8867896789", "SRM", "male", "myMail@srm", "Credit card",
				"Software Engineer");
		mem.printDetails();
		System.out.println();
		tchr.printDetails();
		System.out.println();
		stud.printDetails();
	}
}
// String n, String c, String i, String g, String e