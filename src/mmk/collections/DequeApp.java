package mmk.collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeApp {

	public static void main(String[] args) {
		Deque<String> queue = new ArrayDeque<String>();
		queue.add("item 1");
		queue.add("item 2");
		queue.add("item 3");
		queue.add("item 4");
		
		queue.forEach(System.out::println);
		
		System.out.println(queue.size());
		System.out.println(queue.pop() + " ==> " + queue.size());
		System.out.println(queue.pollLast() + " ==> " + queue.size());
	
	}
}
