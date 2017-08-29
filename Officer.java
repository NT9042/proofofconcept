package designPatterns;

import java.util.Queue;
import java.util.concurrent.CountDownLatch;

public class Officer extends Thread {
	private CountDownLatch latch;
	private String name;
	private final Queue<Integer> sharedQueue;
	
	public Officer(CountDownLatch latch, String name, Queue<Integer> sharedQueue) {
		super();
		this.latch = latch;
		this.name = name;
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(name + "after waiting for everyone else is finally running");
		assessWork();
	}

	public void assessWork() {
		System.out.print(sharedQueue.remove());
	}
}
