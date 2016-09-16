package JavaOptionalTypesPackage1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JavaSortedStreamsExample {

	public static void main(String args[]) {
	    List<Integer> myList = new ArrayList<>();
	    List<Integer> mySortedList;
	
    	for (int i = 0; i < 10;i++) {
	    	myList.add(i);
	    }
    	mySortedList = myList.stream()
    	.sorted((x,y) -> {
    	                  System.out.println("x = " + x + " y = " + y);
    	                  return y-x;
    	                  })
    	.collect(Collectors.toList());
    	
    	}
    }
