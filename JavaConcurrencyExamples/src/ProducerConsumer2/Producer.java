package ProducerConsumer2;

import java.util.Queue;

import JavaConcurrencyExamples1.Message;

public class Producer implements Runnable {
	private Queue<Message> queue;
	    
    public Producer(Queue<Message> q){
    	this.queue=q;
	}
    @Override
    public void run() {
    //produce messages
        for(int i=0; i<100; i++){
        	Message msg = new Message(""+i);
        	
        	/* Note here we're adding messages to the queue with no regard as to what the consumer is doing
        	 * with this queue.  The linked list is unbounded, but if we were using a fixed size pool, such as an array
        	 * we could easily get array index out of bounds exceptions if we tried putting in a message when the array
        	 * was full since we don't know if the consumer has started taking stuff out of the pool.
        	 */
    	    try {
                Thread.sleep(i);
	            queue.add(msg);
	            System.out.println("Produced "+msg.getMsg());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
   	    }
    //adding exit message 
        Message msg = new Message("exit");
        while (true) {
            queue.add(msg);
         }
    }
}
