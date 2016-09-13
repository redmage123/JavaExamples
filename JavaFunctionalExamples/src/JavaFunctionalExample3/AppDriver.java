package JavaFunctionalExample3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AppDriver {
	
	
   
    public static void main(String args[]) {
 
    	List<EmergencyContactInfo> contactList = new ArrayList<>();
    	People people = new People();
    	Person p;
    	Iterator<HashMap<String,Person>> it;
    	Integer ageToFilter;
    	String charToFilter;
    	
    	
    	
    	
    	// Load test data in.  Really, I should do this from a file...
    	contactList.add(new EmergencyContactInfo("Mary Smith","213-555-1212","1234 Main Street, Anytown USA",2));
    	contactList.add(new EmergencyContactInfo("Paul Smith","414-555-1313","1235 Main Street, Anytown USA",1));
    	p = new Person("12345","John Smith","(001) 213-555-1212","1234 Main Street, Anytown USA",18,contactList);
        people.addPersonToMap(p);
    	contactList.clear();
    	
    	contactList.add(new EmergencyContactInfo("Jane Brown","213-555-1212","1234 Main Street, Anytown USA",2));
    	contactList.add(new EmergencyContactInfo("Richard Brown","414-555-1313","1235 Main Street, Anytown USA",1));
        p = new Person("12346","George Brown","(001) 213-555-1212","1234 Main Street, Anytown USA",46,contactList);
        people.addPersonToMap(p);
    	contactList.clear();
    	
    	contactList.add(new EmergencyContactInfo("Joann Green","213-555-1212","1234 Main Street, Anytown USA",2));
    	contactList.add(new EmergencyContactInfo("Robert Green","414-555-1313","1235 Main Street, Anytown USA",1));
    	p = new Person("12347","Jerry Green","(001) 213-555-1212","1234 Main Street, Anytown USA",21,contactList);
        people.addPersonToMap(p);
    	contactList.clear();
    	
        
        
        // We were doing iteration over a hashmap manually to do the filters, but now we're
        // going to do the same thing, but using a stream. 
        // To start with, we've moved the BiPredicate functions fByAge and fByName to the People class
        // rather than having them in the main driver program as it makes sense to put them there.
    	
        System.out.println("Filtering by age");
        ageToFilter = 21;
        people.getPersonMap()  // Gives me back the people object HashMap
            .entrySet() // Then it returns the entry set (The key,value pairs)
            .stream() // Start the stream
            .map(v->v.getValue()) // I only care about the Person object values.
            
            // Filter by age using the filterbyAge bipredicate. A new list is returned
            // containing only those list elements that meet the test. 
            .filter(v ->  People.fByAge.test(v.getAge(),ageToFilter) == true) 
                                                                       
            // Print each element of the filtered list. 
            .forEach(v->System.out.println(v));
    	// Now we're going to iterate over the hashmap, using some of the provided filters. 
   
        
        // Same as the previous code, except we're filtering by name, rather than by age. 
        System.out.println("Filter by name");
        charToFilter = "J";
        people.getPersonMap()
        .entrySet()
        .stream()
        .map(v->v.getValue())
        .filter(v ->  People.fByName.test(v.getName(),charToFilter) == true)
        .forEach(v->System.out.println(v));
    }

	
    
    
    	
    }

