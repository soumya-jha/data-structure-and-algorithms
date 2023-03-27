package com.test.interview;

public class EvenOddThread {

	int i = 1;

	public static void main(String[] args) {
		
		EvenOddThread obj = new EvenOddThread();
		new Thread(() -> obj.printEvenNumbers(), "EvenThread").start();
		new Thread(() -> obj.printOddNumbers(), "OddThread").start();

	}

	private void printOddNumbers() {
		synchronized (this) {
			while (i <= 9) {
				if (i % 2 == 0) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println(Thread.currentThread().getName() +" :: "+ i);
					i++;
					notify();
				}
			}
		}

	}

	private void printEvenNumbers() {

		synchronized (this) {
			while (i <= 10) {
				if (i % 2 == 1) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println(Thread.currentThread().getName() +" :: "+ i);
					i++;
					notify();
				}
			}
		}

	}
}
