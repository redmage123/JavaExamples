package ProducerConsumer3;
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
        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        //starting producer to produce messages in queue
        new Thread(producer1).start();
        new Thread(producer2).start();
        //starting consumer to consume messages from queue
        new Thread(consumer1).start();
        new Thread(consumer1).start();
        System.out.println("Producer and Consumer has been started");
    }

}