package mmk.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class HashMapApp {

	public static void main(String[] args) {
		Map<String, Integer> mapList = new HashMap<>();
		mapList.put("Mehmet", 35);
		mapList.put("Gülden", 40);
		mapList.put("Şebnem", 51);
		mapList.put("Ayşe", 40);
		mapList.put("Elif", 30);
		mapList.put("Merve", 37);
		
		for (Entry<String, Integer> entry : mapList.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
		
		System.out.println("-----------------------------------");
		
		mapList.forEach((k,v) -> System.out.println(k + " - " + v));
		
		mapList.keySet().stream()
			.filter(k -> mapList.get(k) == 40)
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
	}
}
