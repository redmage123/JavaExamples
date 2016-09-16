package FourthExample;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testFourthExample {

	private Person p;
	private Person p1;

	@Before
	public void setUp() throws Exception {
		this.p = new Person("Barack Obama", 55);
		this.p1 = new Person(p);
	}

	@Test
	public void testGetName() {
		String n = p.getName();
		assertTrue(n == "Barack Obama");
		// fail("Not yet implemented");
	}

	@Test
	public void testgetGetAge() {
		int a = p.getAge();
		assertTrue(a == 55);
	}

	@Test
	public void testCopyConstructorName() {
		String n = p1.getName();
		assertTrue(n == "Barack Obama");
		// fail("Not yet implemented");

	}

	@Test
	public void testCopyConstructorAge() {
		int a = p1.getAge();
		assertTrue(a == 55);
		// fail("Not yet implemented");

	}

	@Test
	public void testEqualityOfObjects() {
		assertTrue(p == p1);
	}

	@Test
	public void testEqualityOfObjects2() {
		assertTrue(p.equals(p1));
	}
}
