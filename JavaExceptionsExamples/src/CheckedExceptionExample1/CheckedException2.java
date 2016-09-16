package CheckedExceptionExample1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CheckedException2 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {
		File file;
		FileReader fr = null;

		file = new File("/tmp/blah");
		fr = new FileReader(file);
		fr.close();
	}

}
