package JavaInnerClassPackage2;

import java.util.List;

public class AppDriver {
    public static void main(String args[]) {
    	List<EmergencyContactInfo> contactList;
    	Person p = new Person("John Smith","(001) 213-555-1212","1234 Main Street, Anytown USA",21);
    	Person.manageContactInfo g = p.new manageContactInfo();
    	contactList = g.getListSortedByPriority();
    	for (EmergencyContactInfo eci : contactList) {
    		System.out.println(eci);
    	}
    }
}
