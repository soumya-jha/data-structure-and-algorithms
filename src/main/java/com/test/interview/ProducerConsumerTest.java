package com.test.interview;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
		
		Producer p = new Producer(queue);
		Consumer c = new Consumer(queue);
		
		p.start();
		c.start();

	}

}
