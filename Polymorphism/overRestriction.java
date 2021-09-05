class A2 {
	protected void msg() {
		System.out.println("Hello java");
	}
}

public class overRestriction extends A2 {
	public void msg() { // if default=>CT error becouse default modifier is more restrictive than
						// protected
		System.out.println("Hello java");
	}// C.T.Error

	public static void main(String args[]) {
		overRestriction obj = new overRestriction();
		obj.msg();
	}
}