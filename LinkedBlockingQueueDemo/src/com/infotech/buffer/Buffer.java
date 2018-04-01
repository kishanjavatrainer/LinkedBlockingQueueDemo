package com.infotech.buffer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

//Shared class used by threads
public class Buffer {
	// LinkedBlockingQueue
	private BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<Integer>(1);

	public void get() {
		// retrieve from LinkedBlockingQueue
		try {
			System.out.println("Consumer received - " + blockingQueue.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void put(int data) {
		try {
			// putting in LinkedBlockingQueue
			blockingQueue.put(data);
			System.out.println("Producer produced - " + data);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
