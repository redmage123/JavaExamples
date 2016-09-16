package JavaConcurrencyExamples1;


// Here is a very basic example of threading in Java.  We declare a ThreadExample class
// which inherits from Thread, which is part of the core Java library set. 
// Since Thread implements the Runnable interface, we need to override the
// run() method.  This is the task that will run in the thread.  
// Note that each thread has a default name, we can getit using the reflection
// API to extract that name. 
class ThreadExample extends Thread {
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println("Thread " + threadName + " says, foo!");
	}
}

public class JavaConcurrencyExample1Class {
    public static void main(String args[]) {
    	
    	// Here in the main method, we instantiate two new ThreadExample objects
    	// and call the start() method to have the thread tasks run. 
    	ThreadExample mt = new ThreadExample();
    	ThreadExample mt1 = new ThreadExample();
    	mt.start();
    	mt1.start();
    }
}
