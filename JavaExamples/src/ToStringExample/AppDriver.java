package ToStringExample;

public class AppDriver {
	public static void main(String args[]) {

		Person p = new Person("Barack Obama", 55);
		/*
		 * We used to have to print out each attribute manually. With toString,
		 * we can now simply print out the object.
		 * 
		 * System.out.println("Name = " + p.getName());
		 * System.out.println("Age = " + p.getAge());
		 */
		System.out.println(p);
	}
}
