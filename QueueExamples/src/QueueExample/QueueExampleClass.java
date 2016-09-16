package QueueExample;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueExampleClass {

	
	public static void main(String[] args) {
		BlockingQueue<Integer> myq; 
		myq = new LinkedBlockingQueue<Integer>();
		
		try {
			for (int i = 10;i>=1;i--) {
				System.out.println("i = " + i);
				  myq.put(i);
			}
		} catch (InterruptedException ex) {
			System.err.println(ex.getMessage());
		}
		
		System.out.println("Size of queue is: " + myq.size());
		for (int i : myq) {
			System.out.println(i);
		}
	}
}
