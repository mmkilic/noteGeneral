package mmk.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortWithCollections {

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>();
		
		names.add("Hasan");
		names.add("Ayse");
		names.add("Zeynep");
		names.add("Mehmet");
		
		Collections.sort(names);
		names.sort(Comparator.comparing(String::toString));
		
		for (String s: names) {
			System.out.println(s);
		}
	}

}
