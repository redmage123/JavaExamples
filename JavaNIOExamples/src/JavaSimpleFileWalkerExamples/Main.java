package JavaSimpleFileWalkerExamples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		Path fileDir = Paths.get("/tmp/foo");
		MySimpleFileVisitor visitor = new MySimpleFileVisitor();
		try {
			Files.walkFileTree(fileDir,visitor);	
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
	}

}
