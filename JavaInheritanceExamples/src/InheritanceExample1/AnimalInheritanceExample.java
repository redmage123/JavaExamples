package InheritanceExample1;

// This is the base Animal class.  
class Animal {
	int age;
	String name;

	public Animal(String n, int a) {
		this.name = n;
		this.age = a;
	}

	public String speak() {
		return ("Speak!");
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}

// A dog is a type of animal.
class Dog extends Animal {
	public Dog(String n, int a) {
		super(n, a);
	}

	// We override the speak method so that dog objects return the right sound.
	@Override
	public String speak() {
		return ("Woof!");
	}
}

// A cat is a type of animal.
class Cat extends Animal {
	public Cat(String n, int a) {
		super(n, a);

	}

	// We override the speak method so that cat objects return the right sound.
	@Override
	public String speak() {
		return ("Meow!");
	}
}

public class AnimalInheritanceExample {
	public static void main(String args[]) {
		Dog d = new Dog("Rex", 2);
		Cat c = new Cat("Fluffy", 4);
		System.out.println(d.speak());
		System.out.println(c.speak());
		if (d instanceof Animal) {
			System.out.println("It's an animal!");
		}
		if (c instanceof Animal) {
			System.out.println("It's an animal!");
		}

	}
}
