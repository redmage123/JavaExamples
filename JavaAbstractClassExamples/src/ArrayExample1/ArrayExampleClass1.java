package ArrayExample1;

class TestObj {
	private int foo;
	private int bar;
	public TestObj() {
		this.foo = 10;
		this.bar = 20;
	}
}
public class ArrayExampleClass1 {
	public static void main(String args[]) {
	    int [] ExampleArray1 = {1,2,3,4,5,6,7,8,9,10}; // An array of 10 integers. Already initialized. 
    	int [] ExampleArray2 = new int[10]; // Arrays are objects.
    	TestObj [] ExampleArray3 = new TestObj[10]; // An array of type TestObj
    	TestObj t1 = new TestObj();
    	TestObj t2 = new TestObj();
    	for (int elem : ExampleArray1) {
	    	System.out.println(elem);
	    }
    	
    	// Loading TestObj objects into our array of TestObjs.
    	ExampleArray3[0]= t1;
    	ExampleArray3[1]= t2;
    	
	}
}
	