package JavaConcurrencyExamples1;


// Here we demonstrate that the developer has no control over when threads are executed.
// Thread process execution control is left up to the underlying operating system.  

class ThreadExample1 extends Thread {
	@Override
	public void run() {
		// The task will print the first statement,sleep for one second, and then print the second statement.
		// Note that the Thread.sleep() method throws a checked exception called InterruptedException. 
		// the Thread.sleep() method is a blocking method, i.e. the thread blocks on the sleep.
		// Also note that blocking methods depend on external events. 
		
		// The real takeaway here is that running this program multiple times will likely give different output, depending
		// on when the threads are running. 
		try {  
			String threadName = Thread.currentThread().getName();
			System.out.println("Thread " + threadName + " says, foo!");
		    Thread.sleep(1);
		    System.out.println("Thread " + threadName + " says, bar!");
		} catch (InterruptedException ex) {
			 ex.printStackTrace();
		 }
	}
}
public class JavaConcurrencyExample2Class {

	public static void main(String[] args) {
		
		ThreadExample1 mt = new ThreadExample1();
    	ThreadExample1 mt1 = new ThreadExample1();
    	mt.start();
    	mt1.start();

	}
}
