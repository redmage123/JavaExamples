package FirstExample;

// Here is an example of a simple class called 'Person'.  It has two attributes and four methods. 
// Note that the attributes are declared private so that they can only be accessed by the methods,
// not by anything outside the class.

class Person {
	private String name;
	private int age;

	public Person(String n, int a) {
		this.name = n;
		this.age = a;
	}

	int getAge() {
		return this.age;
	}

	String getName() {
		return this.name;
	}

	void setAge(int a) {
		this.age = a;
	}

	void setName(String n) {
		this.name = n;
	}
}
