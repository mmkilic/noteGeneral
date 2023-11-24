package mmk.number;

import java.math.BigDecimal;

public class RoundOffError {

	public static void main(String[] args) {
		int x = 5;
		int y = 2;
		double z = x / y + 2;
		
		System.out.println(x + "/" + y + "+" + 2 + "= " + z);
		
		double a = 5.4;
		double b = 1.1;
		System.out.println(a + "-" + b + "= " + (a - b));
		
		double c = 5.1;
		double d = 1.1;
		
		System.out.println(c + "-" + d + "= " + (c - d));
		
		BigDecimal e = new BigDecimal("5.1");
		BigDecimal f = new BigDecimal("1.1");
		
		System.out.println(e + "-" + f + "= " + e.subtract(f));
		System.out.println("------------------------------------------------------------");
		
		double g = 5.3;
		double h = 5.5;
		System.out.println(g + "+" + 0.1 + "= " + (g + 0.1));
		System.out.println(h + "-" + 0.1 + "= " + (h - 0.1));
		System.out.println(g+"+0.1 == "+h+"-0.1 ==> " + ((g + 0.1) == (h - 0.1)));
		System.out.println("------------------------------------------------------------");
		
		BigDecimal i = new BigDecimal("5.3");
		BigDecimal j = new BigDecimal("5.5");
		System.out.println(i + "+" + 0.1 + "= " + (i.add(new BigDecimal("0.1"))));
		System.out.println(j + "-" + 0.1 + "= " + (j.subtract(new BigDecimal("0.1"))));
		System.out.println(i+"+0.1 == "+j+"-0.1 ==> " 
							+ (i.add(new BigDecimal("0.1")).doubleValue() == j.subtract(new BigDecimal("0.1")).doubleValue()));
		System.out.println("------------------------------------------------------------");
	}

}
