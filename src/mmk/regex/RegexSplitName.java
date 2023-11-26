package mmk.regex;

import java.util.Arrays;

public class RegexSplitName {

	public static void main(String[] args) {
		
		String str = "MehmetKilic";
		String[] ss = str.split("(?=[A-Z])|\\s");
		Arrays.asList(ss).forEach(System.out::println);
		
	}
}
