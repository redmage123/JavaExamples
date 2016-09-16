package CalculatorExample1;


// This is a naive implementation of a calculator class without generics. 
// Note here that we're only able to take integers. 
// What if we want to pass in a double or a pair of doubles?

class Calc {
	public int add(int a, int b) {
		return a+b;
	}
	public int sub(int a, int b) {
		return a-b;
	}
	public int mul(int a,int b) {
		return a*b;
	}
	public int div (int a, int b) {
		if (b == 0) {
			return -1;
		} else {
			return a/b;
		}
	}
}
public class CalcExample1 {

	public static void main(String args[]) {
    	Calc c = new Calc();
     	int result = c.add(1,1);
	    System.out.println("result = " + result);
	    
	    // result = c.add(1.0,1.0);  This won't compile.  There is no add method 
	    // that takes a double and another double.
	}
}
