package JavaSimpleFileWalkerExamples;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class MySimpleFileVisitor extends SimpleFileVisitor<Path> {

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		System.out.println("About to visit " + dir);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if (attrs.isRegularFile()) {
			System.out.println("File " + file + " is a regular file");
		} else if (attrs.isDirectory()) {
			System.out.println("File " + file + " is a subdirectory");
		} else if (attrs.isSymbolicLink()) {
			System.out.println("File " + file + " is a symbolic link");
		} else {
			System.out.println("It's either a pipe(FIFO) or a UNIX domain socket or a device file");
		}
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		System.err.println(exc.getMessage());
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		System.out.println("Just visited " + dir);
		return FileVisitResult.CONTINUE;
	}

}
