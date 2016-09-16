package FourthExample;

public class AppDriver {
	public static void main(String args[]) {
		Person p = new Person("Barack Obama", 55);
		Person p1 = new Person(p);
		System.out.println("Name = " + p.getName());
		System.out.println("Age = " + p.getAge());
		if (p == p1) {
			System.out.println("The two objects are equal!");
		} else {
			;
			System.out.println("The two objects are not equal!");
		}
		if (p.equals(p1)) {
			System.out.println("The two objects are equal");
		}
	}
}
