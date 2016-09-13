package JavaFunctionalExample2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;

public class AppDriver {
	
   
    public static void main(String args[]) {
 
    	List<EmergencyContactInfo> contactList = new ArrayList<>();
    	People people = new People();
    	Person p;
    	Iterator<HashMap<String,Person>> it;
    	
    	// Here are some examples of using functional interfaces with lambdas to do filtering on the people
    	// HashMap.   BiPredicates, by definition, take two arguments and return a boolean.  In these 
    	// examples, we are filtering by age (i.e. that the list will return any person whose age i is greater
    	// than the age bound j.  
    	// Also we do a filter for any persons name that starts with the second String argument. 
    	
    	//BiPredicate<Integer, Integer> fByAge = (i,j) -> i>=j;
    	
    	// Here we're creating the filter by age function using an anonymous inner class. Later
    	// on, we'll see how to do this with lambdas instead. 
    	BiPredicate<Integer,Integer> fByAge = new BiPredicate<Integer,Integer>() {
    			public boolean test (Integer i, Integer j) { 
        			return i>=j;
    			}
    	};
    	
    	// Here we're creating the filter by name function using an anonymous inner class. Later
    	// on, we'll see how to do this with lambdas instead. 
    	BiPredicate<String,String> fByName = new BiPredicate<String,String>() {
    		public boolean test (String s1, String s2) {
    		    return s1.startsWith(s2);
    		}
    	};
    	// BiPredicate<String, String> fByName = (s1,s2) -> s1.startsWith(s2);
    	
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
    	
    	System.out.println("Printing total hashmap");
    	it = people.getPeopleIterator();
        while (it.hasNext()) {
        	Map.Entry kvPair = (Map.Entry)it.next();
        	p = (Person)kvPair.getValue();
        	System.out.println(p);
        }
        
    	// Now we're going to iterate over the hashmap, using some of the provided filters. 
        it = people.getPeopleIterator();
        while (it.hasNext()) {
        	Integer ageLimit=21;
        	Map.Entry kvPair = (Map.Entry)it.next();
        	p = (Person)kvPair.getValue();
        	// Here we call the static method in the PeopleFilters class.  This method takes
        	// two integers (needed for the BiPredicate and the lambda which describes what we're 
        	// testing. 
        	if (PeopleFilters.filterByAge (p.getAge(),ageLimit,fByAge)) {
        	    System.out.println("key = " + kvPair.getKey() + " value = " + kvPair.getValue());
        	}
        }
        it = people.getPeopleIterator();
        while (it.hasNext()) {
        	String charToSearchFor = new String("G");
        	Map.Entry kvPair = (Map.Entry)it.next();
        	p = (Person)kvPair.getValue();
        	if (PeopleFilters.filterByName (p.getName(),charToSearchFor,fByName)) {
        	    System.out.println("key = " + kvPair.getKey() + " value = " + kvPair.getValue());
        	}
        }
    }
    
    
    	
    }

