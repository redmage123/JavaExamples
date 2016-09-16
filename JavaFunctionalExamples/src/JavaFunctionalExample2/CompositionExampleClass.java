package JavaFunctionalExample2;

import java.util.function.Function;

public class CompositionExampleClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Here we declare two functions. Function 1 (times)
		// takes one integer and returns an integer.
		// Function 2 (squared) also takes one integer and
		// returns one integer.
		Function<Integer, Integer> times2 = e -> e * 2;
		Function<Integer, Integer> squared = e -> e * e;

		// Here we use both the compose and the andThen statements

		Integer composed = times2.compose(squared).apply(4);
		Integer AndThen = times2.andThen(squared).apply(4);

		// Note that compose executes the second (i.e. parameterized)
		// function first, and then the first function second.
		// andThen executes the first function and then the second one.
		System.out.println("composed = " + composed);
		System.out.println("andThen = " + AndThen);
	}
}
