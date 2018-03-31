package com.infotech.client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.infotech.buffer.Buffer;
import com.infotech.worker.Consumer;
import com.infotech.worker.Producer;

public class ClientTest {
	public static void main(String[] args) {
        // Starting two threads
		ExecutorService executorService = null;
		try {
			Buffer buffer = new Buffer();
			executorService = Executors.newFixedThreadPool(2);
			executorService.execute(new Producer(buffer));
			executorService.execute(new Consumer(buffer));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(executorService != null) {
				executorService.shutdown();
			}
		}
    }
}
