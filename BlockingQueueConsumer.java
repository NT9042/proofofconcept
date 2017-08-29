/**
 * 
 */
package designPatterns;

import java.util.concurrent.BlockingQueue;

/**
 * @author nehatiwari
 *
 */
public class BlockingQueueConsumer implements Runnable{
	
	private final BlockingQueue<Integer> myQueue;

	public BlockingQueueConsumer(BlockingQueue<Integer> myQueue) {
		super();
		this.myQueue = myQueue;
	}

	@Override
	public void run() {
		while(true) {
			try {
				System.out.println("Consuming : " + myQueue.take());
			} catch (InterruptedException e) {
				
			}
			
		}
	}
	
	
}
