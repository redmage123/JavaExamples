package CalculatorExample1;

 // Here we are using the concepts of generics to be able to pass in any given 
// type  (as long as it inherits from the Number superclass).  This will also return 
// a double, however, we could also return a type <T> which, again, is defined at 
// compile time. 
class MyCalc<T extends Number> {
	public double add(T a, T b) {
		return a.doubleValue() + b.doubleValue();
	}

	public double sub(T a, T b) {
		return a.doubleValue() - b.doubleValue();
	}

	public double mul(T a, T b) {
		return a.doubleValue() * b.doubleValue();
	}

	public double div(T a, T b) {
		if (b.doubleValue() == 0) {
			return -1;
		} else {
			return a.doubleValue() / b.doubleValue();
		}
	}
}

public class CalcExample2 {
	public static void main(String args[]) {
	    	MyCalc c = new MyCalc();
	    	
	    	// Here we can freely pass in any derived class of number without
	    	// having to write a new method for each parameter signature.
	    	
	     	Double result = c.add(new Integer(1),new Double(1.0));
		    System.out.println("result = " + result);
		    
	}
}
