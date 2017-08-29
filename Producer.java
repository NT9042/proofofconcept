/**
 * 
 */
package designPatterns;

import java.util.Queue;
import java.util.Random;

/**
 * @author nehatiwari
 *
 */
public class Producer implements Runnable {
	private final Queue<Integer> sharedQueue;
	private final int capacity;
	private final int size;
	
	public Producer(Queue<Integer> sharedQueue, int capacity, int size) {
		super();
		this.sharedQueue = sharedQueue;
		this.capacity = capacity;
		this.size = size;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		Object obj;
		int times = 0;
		synchronized (sharedQueue) {
			while(sharedQueue.size() == capacity){
				try {
					times ++;
					sharedQueue.wait();
					System.out.println("Queue is already full, Producer can't put more elements");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		while(times < 1) {
			synchronized (sharedQueue) { 
				System.out.println("Adding element to Queue" + sharedQueue.offer(new Random().nextInt()));
				sharedQueue.notifyAll();
				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
		
	}

}
