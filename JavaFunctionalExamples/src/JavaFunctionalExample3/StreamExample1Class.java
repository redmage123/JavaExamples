package JavaFunctionalExample3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Here is a very simple example of using Java 8 streams. 
public class StreamExample1Class {
	public static void main(String args[]) {
		// Declare the list to be transformed.
		List<Integer> mylist = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4,
				5, 6, 7, 8, 9, 10));

		// Now we start the function pipelining.
		mylist.stream() // Initialize the pipeline
				.filter(s -> s % 2 == 0) // Filter the original list so that we
											// only take the even numbers.
				.map(s -> s * s) // Take each number from the filter (the first
									// function in the pipeline) and square it.
				.forEach(System.out::println); // Now print each number in the
												// list transformed by map
												// Note that we're using the
												// concept of method reference
												// to call the
												// println method.
	}
}
