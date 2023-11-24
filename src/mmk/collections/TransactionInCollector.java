package mmk.collections;

import java.util.Arrays;
import java.util.List;

public class TransactionInCollector {

	public static void main(String[] args) {
		String[] namesArray = new String []{"Mehmet", "Elif", "Merve", "Meryem"};
		
		List<String> nameList = Arrays.asList(namesArray);
		
		String[] namesArray2 = nameList.toArray(new String[0]);
		
		for (String name : namesArray2) {
			System.out.println(name);
		}
		
	}

}
