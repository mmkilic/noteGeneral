package mmk.patterns.singleton;

public class AppSingletonLazy {

	public static void main(String[] args) {
		
		Lazy l1 = Lazy.getInstance();
		Lazy l2 = Lazy.getInstance();
		System.out.println(l1 == l2);
		
		AppSingletonLazy a1 = new AppSingletonLazy();
		AppSingletonLazy a2 = new AppSingletonLazy();
		System.out.println(a1 == a2);
	}
}

class Lazy{
	private static Lazy instance_lazy;
	
	private Lazy() {	}
	
	public static Lazy getInstance() {
		if(instance_lazy == null)
			instance_lazy = new Lazy();
		
		return instance_lazy;
	}
}