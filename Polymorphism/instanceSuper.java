class sprCls {
	sprCls() {
		System.out.println("Super");
	}
}

class midGuard extends sprCls {
	midGuard() {
		System.out.println("Mid Guard");
	}
}

public class instanceSuper extends midGuard {
	instanceSuper() {
		System.out.println("Sub");
	}

	public static void main(String[] args) {
		// instanceSuper is = new instanceSuper();
	}
}
