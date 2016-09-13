package JavaFunctionalExample2;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;


public class Person {
     private List<EmergencyContactInfo> emergencyContactList;
     private String name;
     private String address;
     private String telephone;
     private Integer age;
     private String pID;
     private Person.manageContactInfo mCI;
     
   
     
     /*
      * Why are we creating an inner class called manageContactInfo?  Well, the emergency contact information
      * is part of the Person object, but from a design standpoint, do we really want to put this into the
      * outer class?  It violates good design since a class should really only do one thing.  A person class
      * should really only deal with person methods directly.  However, it's not really desirable to break this 
      * out into a separate class as there is a strong relationship between the Person an the EmergencyContactInfo
      * objects. So we use inner classes as a compromise. 
      */
     public class manageContactInfo {
    	 
    	 /*
		  * Here we're supplying the Emergency Contact List from the driver application. 
		  */
    	 public manageContactInfo(List<EmergencyContactInfo> l) {
    		 
    		 emergencyContactList = l;
    	 }
    	 
    	 /*
    	  * Here we return the list after we've sorted it using the compareTo() function defined
    	  * in the EmergencyContactInfo class. 
    	  */
    	 public List<EmergencyContactInfo> getListSortedByPriority() {
    	     Collections.sort(emergencyContactList);
    	     return emergencyContactList;
    	 }
     }
     
    // The person constructor
     public Person(String pId,String n, String addr, String t, Integer a,List<EmergencyContactInfo> l) {
    	 this.name = n;
    	 this.address = addr;
    	 this.telephone = t;
    	 this.age = a;
    	 this.pID = pId;
    	 this.mCI = new Person.manageContactInfo(l);
     }
     
     // The copy constructor
     public Person(Person other) {
    	 this.name = other.name;
    	 this.address = other.address;
    	 this.telephone = other.telephone;
    	 this.age = other.age;
    	 this.pID = other.pID;
    	 this.mCI = other.mCI;
     }
     
     // Standard getter functions here. 
     public String getId() {
    	 return this.pID;
     }
     public Integer getAge() {
    	 return this.age;
     }
     public String getName() {
    	 return this.name;
     }
     
     public String toString() {
    	 return this.pID + " " + this.name + " " +  this.address + " " +  this.telephone + " " +  this.age; 
     }
    
     // We'll be putting Persons into a HashMap, so we'll need to override the default equals and hashCode
     // methods, otherwise we'll get undefined results from comparing Person objects in the hashmap.
     
     @Override
     public boolean equals(Object other) {
    	 Person o;
    	 if (other == null) {
    		 return false;
    	 }
    	 if (this ==  other) {
    		 return true;
    	 }
    	 if (other instanceof Person) {
    	     o = (Person) other;
    	 } else {
    		 return false;
    	 }
    		 return this.pID == o.pID && this.name == o.name && this.address == o.address && this.telephone == o.telephone && this.age == o.age;
     }
     @Override 
     public int hashCode() {
    	 int prime = 29;
    	 int hash = 1;
    	 return prime * Integer.parseInt(this.pID) * this.name.hashCode() * this.address.hashCode() * this.telephone.hashCode() * this.age;
     }
     
     // Give me back an emergency contact list, sorted in order of the first person to contact.
     public List<EmergencyContactInfo> returnSortedEmergencyContactList() {
    	 return mCI.getListSortedByPriority();
     }
}
