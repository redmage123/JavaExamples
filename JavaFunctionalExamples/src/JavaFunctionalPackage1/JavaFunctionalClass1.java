package JavaFunctionalPackage1;

import java.util.function.Function;
import java.util.function.Predicate;

class SquareIt implements Function<Integer, Integer> {
	@Override
	public Integer apply(Integer t) {
		return t * t;
	}
}

class TestIt implements Predicate<Integer> {
	@Override
	public boolean test(Integer t) {
		if (t < 10) {
			return true;
		} else {
			return false;
		}
	}
}

public class JavaFunctionalClass1 {
	public static int doIt(int n, Function<Integer, Integer> f) {
		return f.apply(n);
	}

	public static boolean testIt(int n, Predicate<Integer> f) {
		return f.test(n);
	}

	public static void main(String args[]) {
		System.out.println(doIt(3, new SquareIt()));
		System.out.println(testIt(3, new TestIt()));
	}
}