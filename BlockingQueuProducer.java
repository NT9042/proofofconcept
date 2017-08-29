/**
 * 
 */
package designPatterns;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

/**
 * @author nehatiwari
 *
 */
public class BlockingQueuProducer implements Runnable {
	private final BlockingQueue<Integer> myQueue;
	
	public BlockingQueuProducer(BlockingQueue<Integer> myQueue) {
		super();
		this.myQueue = myQueue;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for (int i = 0; i < 13; i++) {
			try {
				System.out.println("Produced");
				myQueue.put(i*12);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
