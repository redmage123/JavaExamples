package ProducerConsumer1;
import java.util.LinkedList;
import java.util.Queue;

import JavaConcurrencyExamples1.Message;


/* This is a naive version of a threaded producer consumer that does no locking
 * or monitoring of code or data.
 */
public class ProducerConsumerService {

    public static void main(String[] args) {
        //Creating BlockingQueue of size 10
        Queue<Message> queue = new LinkedList<Message>();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        //starting producer to produce messages in queue
        new Thread(producer).start();
        //starting consumer to consume messages from queue
        new Thread(consumer).start();
        System.out.println("Producer and Consumer has been started");
    }

}