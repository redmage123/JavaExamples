package JavaFunctionalExample2;

/*
 * This is the emergency contact info class.  It has a strong relationship to the Person class
 * i.e. each Person should have emergency contact information as part of the person. 
 */
 class EmergencyContactInfo implements Comparable<EmergencyContactInfo> {

	 private String contactName;
	 private String contactTelephone;
	 private String contactAddress;
     private Integer priority;
     private final int LESSTHAN = -1;
     private final int EQUAL = 0;
     private final int GREATERTHAN = 1;
    		
     // Constructor
	 public EmergencyContactInfo(String n, String t, String a, Integer p) {
		 this.contactName = n;
		 this.contactTelephone = t;
		 this.contactAddress = a;
		 this.priority = p;
	 }
	 
	 /* One of the EmergencyContactInfo attributes is the priority.  This is a measure of whom to call
	  * first in the case of an emergency.  Obviously we want the user to be able to quickly determine who 
	  * the first person is that should be called.
	  */
	 public int compareTo(EmergencyContactInfo other) {
		 if (this == other) {
			 return EQUAL;
		 }
		 if (this.priority < other.priority) {
			 return LESSTHAN;
		 } else if (this.priority == other.priority) {
			 return EQUAL;
		 } else {
			 return GREATERTHAN;
		 }
	 }
	 
	 // Standard toString() method. 
	public String toString() {
	     return contactName + " " + contactTelephone + " " + contactAddress + " " + priority;
     }
 }
