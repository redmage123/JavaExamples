package FirstExample;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestFirstExample {

	private Person p;

	@Before
	public void setUp() throws Exception {
		this.p = new Person("Barack Obama", 55);
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
}
