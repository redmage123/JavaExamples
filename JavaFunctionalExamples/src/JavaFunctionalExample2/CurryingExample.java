package JavaFunctionalExample2;

import java.util.function.BiFunction;
import java.util.function.Function;

public class CurryingExample {

	public void currying() {
		// Create a function that adds 2 integers
		BiFunction<Integer, Integer, Integer> adder = (a, b) -> a + b;

		// And a function that takes an integer and returns a function
		Function<Integer, Function<Integer, Integer>> currier = a -> b -> {
			System.out.println("a = " + a + " b = " + b);
			return adder.apply(a, b);
		};

		// Call apply 4 to currier (to get a function back)
		Function<Integer, Integer> curried = currier.apply(4);

		// Results
		System.out.printf("Curry : %d\n", curried.apply(3)); // ( 4 + 3 )
		System.out.printf("Curry : %d\n", curried.apply(10)); // ( 4 + 10 )
	}

	public static void main(String[] args) {
		new CurryingExample().currying();
		// new Currying().composition() ;
	}

}
