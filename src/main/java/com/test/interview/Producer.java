package com.test.interview;

import java.util.concurrent.BlockingQueue;

public class Producer extends Thread{
	
	private BlockingQueue<Integer> queue = null;
	
	public Producer(BlockingQueue<Integer> q) {
		super("Producer Thread");
		this.queue = q;
	}
	
	@Override
	public void run() {
		for(Integer i = 0; i<10;i++) {
			try {
				queue.put(i);
				System.out.println(getName() + " produced " + i);
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
