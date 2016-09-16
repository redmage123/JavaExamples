package JavaConcurrencyExamples1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Threads are really rather painful to deal with as they're rather low-level API's. 
// Java version 5 introduces the Concurrency library.  One of the interfaces provided
// is the Executor Service.  We can now use the Executor service to manage threads 
// rather than calling the Thread class itself.  

class WorkerThread implements Runnable {
    @Override
    public void run() {
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

public class JavaConcurrencyExample4Class {
	public static void main(String[] args) {
		
		// Here we're using the ExecutorService to create a fixed thread pool.  We're going to create
		// a pool of two threads.  Note that the number of tasks can exceed the number of threads in the
		// thread pool, in which case they will wait until one of the threads finished their task at which
		// time the thread is returned to the thread pool so it can be re-used. 
	    ExecutorService executor = Executors.newFixedThreadPool(2);
	   
	    // Now iterate over each thread and assign the worker task defined in the worker's run()
	    // method to the thread and then start the thread. 
	    
	    for (int i=0;i<2;i++) {
	    	 Runnable worker = new WorkerThread();
	    	 executor.execute(worker);
	    }
	    
	    // Here we need to shut down the thread.  This is similar to the thread.join() method. 
	    executor.shutdown();
	    
	    // Wait until all of the threads are terminated. 
	    while (! executor.isTerminated()) {
	    }
	    
	    // Done!
	    System.out.println("All jobs finished!");
	}
}

