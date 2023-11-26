package mmk.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortWithCollections {

	public static void main(String[] args) {
		javaCollectionsSorting();
		System.out.println("-------------------------");
		
		manualSorting();
		System.out.println("-------------------------");
	}
	
	private static void javaCollectionsSorting() {
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
	
	private static void manualSorting() {
		ArrayList<Integer> sortedNums = new ArrayList<>();
		sortedNums.add(8);
		sortedNums.add(2);
		sortedNums.add(5);
		sortedNums.add(1);
		sortedNums.add(3);
		sortedNums.add(7);
		sortedNums.add(6);
		sortedNums.add(9);
		sortedNums.add(4);
		
		ArrayList<Integer> firstNums = new ArrayList<>();
		firstNums.addAll(sortedNums);
		boolean sorted = false;
		
		while (!sorted) {
			sorted = true;
			for(int i = 0; i<sortedNums.size()-1 ; ++i) {
				if(sortedNums.get(i) > sortedNums.get(i+1)) {
					int temp = sortedNums.get(i);
					sortedNums.set(i, sortedNums.get(i+1));
					sortedNums.set(i+1, temp);
					sorted = false;
				}
			}
		}
		
		for (int i = 0; i<sortedNums.size() ; ++i) {
			System.out.println(firstNums.get(i) + "-" + sortedNums.get(i));
		}
	}

}
