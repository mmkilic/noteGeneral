package mmk.number;

import java.text.DecimalFormat;

public class NumberFormating {

	private static DecimalFormat DF = new DecimalFormat("#.##");
	
	public static void main(String[] args) {
		
		double a = 105.4 + 2.2;
		
		System.out.println(a);
		System.out.println(DF.format(a));
		
	}

}
