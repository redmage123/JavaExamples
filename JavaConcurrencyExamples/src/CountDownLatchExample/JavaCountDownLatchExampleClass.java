package CountDownLatchExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/* This is a simple example of a CountDownLatch
 * We first define a class CountDownLatchClass
 * that will run some task and then decrement
 * the countdown latch passed to it by the constructor.
 */

class CountDownLatchClass extends Thread {
	CountDownLatch cl;
	Random rGen;
	int n;
	
	public CountDownLatchClass(int n, CountDownLatch c) {
       super("Thread " + n);
       this.n= n;
       this.cl = c;
       rGen = new Random();
	}
	
	/* This is a sample task defined by the run method.
	 * Here we just sleep for a random amount of time, which
	 * is the representation of some task that will be completed.
	 * Once the task is complete, the count down latch is decremented. 
	 */
	@Override
	public void run() {
		System.out.println("In the run method");
		try {
			System.err.println("Thread " + n + " starting task");
			Thread.sleep(rGen.nextInt(1000));
			System.out.println("At the latch");
			cl.countDown();	// Count down the latch. 
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}	
	}
}
public class JavaCountDownLatchExampleClass {

	/* Here in the main method, we define a new CountDownLatch
	 * for ten threads.  Each thread will be defined in an ArrayList
	 * which we will call sequentially to kick off each thread.
	 */
	
	public static void main(String args[]) {
		CountDownLatch cl;
		int MAXTHREADS=10;
		int i = 0;
		List<CountDownLatchClass> threadList = new ArrayList<>(MAXTHREADS);
		cl = new CountDownLatch(MAXTHREADS);
		
		// Initialize and start the threads.
		for (i = 0; i< MAXTHREADS; i++) { 
			threadList.add(new CountDownLatchClass(i,cl));
			
		}
		
		for (CountDownLatchClass c: threadList) {
			System.out.println("Starting the thread");
			c.start();
		}
		
		System.out.println("Threads started");
		
		// Here we wait until all of the threads have finished
		// executing.  How do we know this?  Each thread will, before
		// it completes decrement the countdown latch.  When the
		// latch reaches zero, the main thread will wake from the await()
		// blocking call. 
		
		try {
			System.err.println("About to wait");
			cl.await();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("Barrier lifted");		
	}
}
