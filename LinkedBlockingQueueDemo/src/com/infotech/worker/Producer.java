package com.infotech.worker;

import java.util.Random;

import com.infotech.buffer.Buffer;

public class Producer implements Runnable {
	private Buffer buffer;

	public Producer(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		while (true) {
			Random random = new Random();
			int data = random.nextInt(1000);
			buffer.put(data);
		}
	}
}