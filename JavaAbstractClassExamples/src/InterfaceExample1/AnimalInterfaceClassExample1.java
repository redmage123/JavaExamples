package InterfaceExample1;

// We're not using a base class here.  We're implementing the speak methods through the Animals interface

class Dog implements Animals {

	int age;
	String name;

	public Dog(String n, int a) {
		this.age = a;
		this.name = name;
	}

	public String speak() {
		return ("Woof!");
	}
}

class Cat implements Animals {

	int age;
	String name;

	public Cat(String n, int a) {
		this.age = a;
		this.name = name;
	}

	public String speak() {
		return ("Meow!");
	}
}

public class AnimalInterfaceClassExample1 {
	public static void main(String args[]) {
		Dog d = new Dog("Rex", 2);
		Cat c = new Cat("Fluffy", 4);

		System.out.println(d.speak());
		System.out.println(c.speak());
	}
}