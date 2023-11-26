package mmk.patterns.singleton;

public class AppSingletonEager {

	public static void main(String[] args) {
		
		Eager e1 = Eager.getInstance();
		Eager e2 = Eager.getInstance();
		System.out.println(e1 == e2);
		
		AppSingletonEager a1 = new AppSingletonEager();
		AppSingletonEager a2 = new AppSingletonEager();
		System.out.println(a1 == a2);
	}
}
class Eager{
	private static final Eager INSTANCE_EAGER = new Eager();
	
	private Eager() {	}
	
	public static Eager getInstance() {
		return INSTANCE_EAGER;
	}
}