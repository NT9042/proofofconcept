package drivers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

import designPatterns.BlockingQueuProducer;
import designPatterns.BlockingQueueConsumer;
import designPatterns.Consumer;
import designPatterns.Officer;
import designPatterns.Producer;
import designPatterns.Worker;

public class ProducerConsumerProblem {

	public static void main(String[] args) {
		implementUsingCountDownLatch();		
	}

	public static void implementUsingBlockingQueue() {
		BlockingQueue<Integer> myQueue = new ArrayBlockingQueue<>(20);
		BlockingQueuProducer producer = new BlockingQueuProducer(myQueue);
		Thread producerThread = new Thread(producer);
		
		designPatterns.BlockingQueueConsumer consumer = new BlockingQueueConsumer(myQueue);
		Thread consumerThread = new Thread(consumer);
		
		producerThread.start();
		consumerThread.start();
	}
	
	public static void implementUsingWaitAndNoitify() {
		final Queue<Integer> sharedQueue = new ArrayBlockingQueue<Integer>(10);
		Producer producer = new Producer(sharedQueue, 20, 0);
		Consumer consumer = new Consumer(sharedQueue, 20, 0);
		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(consumer);
		t1.start();
		t2.start();
	}
	
	/**
	 * CountDowaLatch is a high-level synchronization utility 
	 * which is used to prevent a particular thread to start processing 
	 * until all threads are ready. This is achieved by a countdown.
	 *  The thread, which needs to wait for starts with a counter, 
	 *  each thread them make the count down by 1 when they become ready,
	 *   once the last thread call countDown() method, then the latch is broken
	 *    and the thread waiting with counter starts running. 
	 *    CountDownLatch is a useful synchronizer and used heavily in multi-threaded testing.
	 *     You can use this class to simulate truly concurrent behavior 
	 *     i.e. trying to access something at the same time once every thread is ready
	 *     . Worth noting is that CountDownLatch starts with a fixed number of counts
	 *      which cannot be changed later, though this restriction is re-mediated in Java 7
	 *       by introducing a similar but flexible concurrency utility called Phaser.

	 */
	public static void implementUsingCountDownLatch() {
		final CountDownLatch latch = new CountDownLatch(3);
		final Queue<Integer> sharedQueue = new ArrayBlockingQueue<Integer>(10);
		Worker worker1 = new Worker(latch, 1000, "PARTY1", sharedQueue);
		/*Worker worker2 = new Worker(latch, 2000, "PARTY2", sharedQueue);
		Worker worker3 = new Worker(latch, 3000, "PARTY3", sharedQueue);*/
		Officer officer1 = new Officer(latch, "Officer ", sharedQueue);
	/*	Officer officer2 = new Officer(latch, "Officer ", sharedQueue);*/
		worker1.start();
		ConcurrentHashMap<String, String> chm;
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		officer1.start();
		
		
		System.out.println(Thread.currentThread().getName() + " is working");
	}
	
	/**
	 * Its similar to CountDownLatch but instead of calling countDown() 
	 * each thread calls await() and when last thread calls await() which signals 
	 * that it has reached the barrier, all thread started processing again, 
	 * also known as a barrier is broken.
	 * Read more: http://www.java67.com/2015/06/how-to-use-cyclicbarrier-in-java.html#ixzz4g1IvGYkC
	 */
	public static void implementUsingCyclicBarrier() {
		final CyclicBarrier barrier = new CyclicBarrier(3);
		List l = new ArrayList<>();
		Collections.synchronizedList(l);
	}

	
	
}
