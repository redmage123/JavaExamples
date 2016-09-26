package CyclicBarrierExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


/* This example shows a simple Cyclic Barrier.  
 * It's similar to the Countdown Latch, but we can re-use this if needed,
 * unlike the Countdown Latch.  
 */

class CyclicBarrierThread extends Thread {
	
	private CyclicBarrier cb;
	private Random rGen;
	int n;
	
	public CyclicBarrierThread(int n,CyclicBarrier c) {
		super("CyclicBarrierThread"  + n);
		this.n= n;
		this.cb = c;
		rGen = new Random();
	}
	
	// Note here that not only do we have to catch an Interrupted exception, but
	// we also need to catch the BrokenBarrier exception.  If the barrier is reset,
	// or any of the threads receives an interrupt, then a BrokenBarrier exception
	// is thrown for all threads using the Cyclic Barrier. 
	
    public void run() {
         	try {
    	     	System.out.println("thread "  + this.n  + " Starting");
    		    Thread.sleep(rGen.nextInt(1000));
    		    System.out.println("Waiting at barrier");
    		    cb.await();
    	    } catch (InterruptedException ex) {
    		     System.out.println(ex.getMessage());
    		    
    	    } catch (BrokenBarrierException ex) {
    	     	System.out.println(ex.getMessage());
    	    }
    	
    	System.out.println("Thread completed");
    }
}

public class CyclicBarrierExampleClass extends Thread {
	
	
	public static void main(String args[]) {
		

		Runnable BarrierAction = new Runnable() {
		    int barrierLoop=1;
			public void run() {
			    System.out.println("At the barrier action "+ this.barrierLoop ++);
			}
		};
		
		// Create and start the threads the first time around. 
	    CyclicBarrier cb= new CyclicBarrier(10,BarrierAction);
	    List<CyclicBarrierThread> cList = new ArrayList<>(10);
	    for (int i = 0;i<10;i++) {
	    	cList.add(new CyclicBarrierThread(i,cb));
	    	cList.get(i).start();
	    }
	    
	    // Clear the arraylist and re-start threads the second time around. 
	    // Notice that we can re-use the cyclic barrier defined at the top of the
	    // main method. 
	    
	    cList.clear();
	    for (int i = 0;i<10;i++) {
	    	cList.add(new CyclicBarrierThread(i,cb));
	    	cList.get(i).start();
	    }
	}
}
