package mmk.collections;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapCollect {
	
	private enum Points{
		BRONZE(10),
		SILVER(20),
		GOLD(50),
		PLATINUM(100);
		
		private int value;
		private Points(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
	}
	
	public static void main(String[] args) {
		Map<String, Integer> output = Arrays.asList(Points.values())
				.stream()
                .map(r -> new AbstractMap.SimpleEntry<String, Integer>(r.name(), r.getValue()))
                .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue
            ));
		
		output.forEach((k,v) -> System.out.println(k + " - " + v));
	}
}
