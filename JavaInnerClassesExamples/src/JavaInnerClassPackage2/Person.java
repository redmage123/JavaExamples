package JavaInnerClassPackage2;
import java.util.*;

public class Person {
     private List<EmergencyContactInfo> emergencyContactList = new ArrayList<> ();
     private String name;
     private String address;
     private String telephone;
     private Integer age;
     
   
     
     /*
      * Why are we creating an inner class called manageContactInfo?  Well, the emergency contact information
      * is part of the Person object, but from a design standpoint, do we really want to put this into the
      * outer class?  It violates good design since a class should really only do one thing.  A person class
      * should really only deal with person methods directly.  However, it's not really desirable to break this 
      * out into a separate class as there is a strong relationship between the Person an the EmergencyContactInfo
      * objects. So we use inner classes as a compromise. 
      */
     public class manageContactInfo {
    	 
    	 private String contactName;
    	 private String contactTelephone;
    	 private String contactAddress;
    	 private Integer priority;
    	 
    
    	 
    	 public manageContactInfo() {
    		 /*
    		  * Here we're simulating the work of getting some contact info.  Normally, this would come in
    		  * through some sort of user input, but we're just hardcoding it for this example.
    		  */
    		 
    		 emergencyContactList.add(new EmergencyContactInfo("Jacob Smith","(213) 555-1213","1235 Main Street, Anytown USA",3));
    		 emergencyContactList.add(new EmergencyContactInfo("Jim Smith","(213) 555-1214","1236 Main Street, Anytown USA",1));
        	 emergencyContactList.add(new EmergencyContactInfo("Mary Smith","(213) 555-1215","1237 Main Street, Anytown USA",2));
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
     public Person(String n, String addr, String t, Integer a) {
    	 this.name = n;
    	 this.address = addr;
    	 this.telephone = t;
    	 this.age = a;
     }
}
