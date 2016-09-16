package JavaConcurrencyExamples1;

import java.util.ArrayList;
import java.util.List;

class ThreadExample2 extends Thread {
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
public class JavaConcurrencyExample3Class {

		
	public static void main(String[] args) {
		List<ThreadExample2> tList = new ArrayList<>();
		tList.add(new ThreadExample2());
		tList.add(new ThreadExample2());
	    	
		// Note here that we are putting each thread into an ArrayList.  We can iterate over the
		// list to start the threads. 
		for (ThreadExample2 t: tList) {
			t.start();
		}
		
		// Here we wait for all of the threads to die.  t.join can throw an InterruptedException exception
		// so we need to catch it as it's a checked exception. 
		
		try {
			for (ThreadExample2 t : tList) {
				t.join();
			}
		} catch (InterruptedException ex) {
				ex.printStackTrace();
		}

	}
}