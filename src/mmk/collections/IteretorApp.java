package mmk.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteretorApp {

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("ali");
		names.add("veli");
		names.add("ahmet");
		names.add("mehmet");
		names.add("osman");
		System.out.println(names.size());
		
		Iterator<String> item = names.iterator();
		
		while(item.hasNext()) {
			System.out.println(item.next());
		}
		
		while(item.hasNext()) {
			String currentElement = item.next();
			if(currentElement.equals("ali")) {
				item.remove();
				break;
			}
		}
		System.out.println(names.size());
	}

}
