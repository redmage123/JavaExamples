package JavaFunctionalExample3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiPredicate;

class People {
    private HashMap<String,Person> personHash;
   
    public   static BiPredicate<String,String> fByName = (s1,s2) -> s1.startsWith(s2);
    public   static BiPredicate<Integer,Integer> fByAge = (i,j) -> i>=j;
   
    public People() {
    	personHash = new HashMap<String,Person>();
    }
    
    public void addPersonToMap(Person p) {
    	if (p instanceof Person) {		
    		personHash.put(p.getId(),new Person(p));
    	} else {
    		return;
    	}
    }
    
    public Map<String,Person> getPersonMap() {
    	return personHash;
    }
    public Iterator getPeopleIterator() {
    	Iterator it = personHash.entrySet().iterator();
    	return it;
    }
}
