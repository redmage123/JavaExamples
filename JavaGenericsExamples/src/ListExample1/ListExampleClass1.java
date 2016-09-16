package ListExample1;

import java.util.ArrayList;

/*
 Here we have defined a generic stack class MyStack.  This stack will take any parameterized type since it
 extends the Object class.  Additionally, it is required to implement the StackInterface interface. 
 Everything here is generic, so once we've defined this appropriately, we can now create instances of MyStack 
 that will take any type of object.
 */
class MyStack<T extends Object> implements StackInterface<T> {
	private int top;
	private int size;
	private final int INITSIZE = 100;
	private ArrayList<T> elements;

	public MyStack() {
		this(10);
	}

	public MyStack(int s) {
		if (s < 1) {
			s = this.INITSIZE;
		}
		this.size = s;
		top = -1;
		this.elements = new ArrayList<T>(this.size);
	}

	/*
	 * Here we implement push. It's not complete because we haven't done
	 * exception handling yet. So, there is a possibility that this could crash.
	 */
	public boolean push(T item) {

		// The stack is full, so we return a false.
		if (top == this.size - 1) {
			return false;
		}
		// We should catch an exception here, but we haven't gotten to that
		// yet...
		this.elements.add(item);
		this.top++;
		return true;
	}

	/*
	 * Here we implement pop. Note the return value is defined as a generic
	 * type.
	 */
	public T pop() {
		// Get the top element and pop it off of the ArrayList.
		T result = this.elements.get(this.top);

		// Modify the top pointer value appropriately to reflect the new stack
		// size.
		this.top--;

		return result;
	}

	/*
	 * Simple method returning a boolean to test whether or not the stack is
	 * empty. We aren't using it in the app, but it's an example of a method
	 * that may very well be part of a proper stack interface definition.
	 */
	public boolean isEmpty() {
		if (top == -1) {
			return true;
		} else {
			return false;
		}
	}
}

public class ListExampleClass1 {
	public static void main(String args[]) {
		MyStack<String> s = new MyStack<String>();
		MyStack<Integer> i = new MyStack<Integer>();
		s.push("Hello");
		s.push("World");
		System.out.println(s.pop());
		System.out.println(s.pop());
		i.push(new Integer(5));
		i.push(new Integer(6));
		System.out.println(i.pop());
		System.out.println(i.pop());

	}
}
