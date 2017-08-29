package designPatterns;

import java.util.Queue;
import java.util.Random;

public class Consumer implements Runnable {
	private final Queue<Integer> sharedQueue;
	private final int capacity;
	private final int size;

	public Consumer(Queue<Integer> sharedQueue, int capacity, int size) {
		super();
		this.sharedQueue = sharedQueue;
		this.capacity = capacity;
		this.size = size;
	}


	@Override
	public void run() {
		while(true) {
		synchronized (sharedQueue) {
			while(sharedQueue.size() == 0){
				try {
					sharedQueue.wait();
					System.out.println("Queue is empty, Consumer Thread is waiting for it to be filled");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		synchronized (sharedQueue) {
				System.out.println("Consumer on go ---");
				System.out.print(sharedQueue.remove());
				sharedQueue.notifyAll();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
