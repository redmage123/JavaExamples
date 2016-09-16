package JavaFunctionalExample2;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class SquareandSumExample {
    public static Predicate<Integer> isEven = new Predicate<Integer>() {
    	@Override
    	public boolean test(Integer n) {
    		if (n % 2 == 0) {
    			return true;
    		} else {
    			return false;
    		}
    	}
    };
    
    public static Function<Integer, Integer> squareIt = new Function<Integer,Integer>() {
    	@Override
    	public Integer apply(Integer n) {
    		return n * n;
    	}
    };
    
    public static BiFunction<Integer,Integer,Integer> sumIt = new BiFunction<Integer,Integer,Integer>() {
    	@Override
    	public Integer apply (Integer n, Integer m) {
    		return n + m;
    	}
    };
   
    
    
	public static void main(String[] args) {
		int i;
		int sum=0;
		for (i = 1;i<=20;i++) {
			sum = (isEven.test(i) == true ? sumIt.apply(sum,squareIt.apply(i)) : sum);
		}
        System.out.println("Sum = " + sum);
	}

}
