package ProducerConsumer1;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

import JavaConcurrencyExamples1.Message;

public class Consumer implements Runnable{

private Queue<Message> queue;
    
    public Consumer(Queue<Message>q){
        this.queue=q;
    }

    /* Note here we're consuming messages from the queue with no regard as to what the producer is doing
	 * with this queue.  We can easily get into a situation where we are trying to retrieve data
	 * from an empty list which would throw a runtime exception.  The thread will stop running when
	 * we get this error, however, the producer won't.  
	 */
    @Override
    public void run() {
       
            Message msg;
            //consuming messages until exit message is received
            while(true) {
            	synchronized(queue) {
            	    try {
            	    	while (queue.isEmpty()) {
            	    		queue.wait();
            	    	}
            	    	msg = queue.remove();
                        Thread.sleep(10);
                        System.out.println("Consumed "+msg.getMsg());
                    } catch (InterruptedException ex) {
            	        System.out.println(ex.getStackTrace());
                    }
            	}
            }
    }
}