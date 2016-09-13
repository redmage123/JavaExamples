package CheckedExceptionExample1;

import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CheckedExceptionClass1 {

	   public static void main(String args[]){	
		  File file;
		  FileReader fr=null;
		 
		  file=new File("/tmp/blah");
		  
		 
	
		  try {
	          fr = new FileReader(file); 
              System.out.println("We got here!");
		  } catch (FileNotFoundException ex) {
			  System.out.println("Sorry, no such file!");
			  System.exit(1);
		  }
		  try {
              fr.close();
		  }
          catch (IOException ex) {
        	  System.out.println("Caught an IO Exception!");
          }
	   }	   
	}
	
