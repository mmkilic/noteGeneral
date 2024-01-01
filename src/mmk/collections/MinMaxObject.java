package mmk.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinMaxObject {

	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Mehmet", 35));
		people.add(new Person("Tarik", 37));
		people.add(new Person("Ali", 32));
		people.add(new Person("Tugba", 30));
		
		Person theYongust = Collections.min(people);
		
		System.out.println(theYongust);
		
		List<Cat> cats = new ArrayList<>();
		cats.add(new Cat("tekir", 35));
		cats.add(new Cat("mekir", 37));
		cats.add(new Cat("nekir", 32));
		cats.add(new Cat("fekir", 36));
		cats.add(new Cat("cekir", 32));
		cats.add(new Cat("sekir", 37));
		
		Cat minCat = Collections.min(cats, Comparator.comparing(Cat::getAge));
		//or Cat minCat = Collections.min(cats, Comparator.comparing(c -> c.getAge()));
		System.out.println(minCat);
		
		System.out.println(cats.stream().max(Comparator.comparing(Cat::getAge)).get());
	}

}

class Person implements Comparable<Person>{
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return name + " - " + age;
	}
	@Override
	public int compareTo(Person p) {
		return age - p.age;
	}
}

class Cat{
	private String name;
	private int age;
	
	public Cat(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return name + " - " + age;
	}
}