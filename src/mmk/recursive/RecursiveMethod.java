package mmk.recursive;

public class RecursiveMethod {

	public static void main(String[] args) {
		
		System.out.println("Result: " + recursive(5));
	}
	
	static int recursive(int number) {
		System.out.println(number);
		
		if(number <= 1)
			return 1;
		
		return number + recursive(--number);
	}
}
