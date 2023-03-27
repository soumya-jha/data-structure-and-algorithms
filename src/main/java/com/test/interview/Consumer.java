package com.test.interview;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread{

private BlockingQueue<Integer> queue = null;
	
	public Consumer(BlockingQueue<Integer> q) {
		super("Consumer Thread");
		this.queue = q;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Integer i = queue.take();
				System.out.println(getName() + " consumed " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
