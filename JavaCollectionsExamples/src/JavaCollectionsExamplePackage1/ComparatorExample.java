package JavaCollectionsExamplePackage1;

import java.util.*;

// This is a very simple example of using both the Comparator
// and the Comparable interfaces in out custom class.

class Dog implements Comparator<Dog>, Comparable<Dog> {
	private String name;
	private int age;

	Dog() {
	}

	Dog(String n, int a) {
		name = n;
		age = a;
	}

	public String getDogName() {
		return (name);
	}

	public int getDogAge() {
		return (age);
	}

	public int compare(Dog d, Dog d1) {
		return d.age - d1.age;
	}

	public int compareTo(Dog d) {
		return (this.name).compareTo(d.name);
	}

}

public class ComparatorExample {
	public static void main(String argv[]) {
		List<Dog> dogList = new ArrayList<Dog>();

		dogList.add(new Dog("Rex", 2));
		dogList.add(new Dog("Fido", 6));
		dogList.add(new Dog("Shep", 4));
		dogList.add(new Dog("King", 11));
		dogList.add(new Dog("Max", 12));

		System.out.println("Dogs are: ");
		for (Dog d : dogList) {
			System.out.print(d.getDogName() + " ");

		}
		System.out.println();
		if (dogList.get(0).compareTo(dogList.get(1)) < 0) {
			System.out.println(dogList.get(0).getDogName() + " is less than "
					+ dogList.get(1).getDogName());
		} else if (dogList.get(0).compareTo(dogList.get(1)) == 0) {
			System.out.println(dogList.get(0).getDogName() + " is equal to "
					+ dogList.get(1).getDogName());
		} else {
			System.out.println(dogList.get(0).getDogName()
					+ " is greater than " + dogList.get(1).getDogName());
		}

		if (dogList.get(0).compare(dogList.get(0), dogList.get(1)) < 0) {
			System.out.println(dogList.get(0).getDogName() + " is less than "
					+ dogList.get(1).getDogName());
		} else if (dogList.get(0).compare(dogList.get(0), dogList.get(1)) == 0) {
			System.out.println(dogList.get(0).getDogName() + " is equal to "
					+ dogList.get(1).getDogName());
		} else {
			System.out.println(dogList.get(0).getDogName()
					+ " is greater than " + dogList.get(1).getDogName());
		}

		Collections.sort(dogList);
		for (Dog d : dogList) {
			System.out.print(d.getDogName() + ", ");
		}
		Collections.sort(dogList, new Dog());
		System.out.println(" ");
		for (Dog d : dogList) {
			System.out.print(d.getDogName() + "  : " + d.getDogAge() + ", ");
		}
	}
}
