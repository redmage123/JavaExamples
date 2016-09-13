package CheckedExceptionExample1;

import java.io.File;
import java.io.FileReader;

public class CheckedException2 {

	/**
	 * @param args
	 */
	

		public static void main(String args[]){	
			  File file;
			  FileReader fr=null;
			 
			  file=new File("/tmp/blah");
			  fr = new FileReader(file); 
			  fr.close();
	}

}
