package JavaFunctionalExample2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.function.BiPredicate;

class People {
	private HashMap<String, Person> personHash;

	public People() {
		personHash = new HashMap<String, Person>();
	}

	public void addPersonToMap(Person p) {
		if (p instanceof Person) {
			personHash.put(p.getId(), new Person(p));
		} else {
			return;
		}
	}

	public HashMap<String, Person> getPersonMap() {
		return personHash;
	}

	public Iterator getPeopleIterator() {
		Iterator it = personHash.entrySet().iterator();
		return it;
	}
}
