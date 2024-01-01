package mmk.collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCollections {
	
	public static void main(String[] args) {
		List<String> names = Arrays.asList(new String[] {"Mehmet", "Merve", "Meltem", "Meryem"});
		
		String joinedStr1 = String.join(",", names);
		System.out.println(joinedStr1);
		
		String joinedStr2 = names.stream().collect(Collectors.joining(","));
		System.out.println(joinedStr2);
	}
}
