package designPatterns;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Worker extends Thread {

	private CountDownLatch latch;
	private int duration;
	private String name;
	private final Queue<Integer> sharedQueue;
	

	public Worker(CountDownLatch latch, int duration, String name,
			Queue<Integer> sharedQueue) {
		super();
		this.latch = latch;
		this.duration = duration;
		this.name = name;
		this.sharedQueue = sharedQueue;
	}


	@Override
	public void run() {
		try {
			Thread.sleep(duration);
			latch.countDown();
			doWork();
			System.out.println(name + " has finished");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	private void doWork() {
		sharedQueue.add(new Random().nextInt());
	}
}
