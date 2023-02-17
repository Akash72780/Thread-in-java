package producer_consumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {

	public static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

	public static void main(String[] args) throws InterruptedException {

		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();

	}

	public static void producer() throws InterruptedException {

		for (int i = 0; i < 100; i++) {
			queue.put(i);
		}
	}

	public static void consumer() throws InterruptedException {
		Random random = new Random();

		while (true) {
			Thread.sleep(100);
			if (random.nextInt(10) == 5) {
				Integer value = queue.take();
				System.out.println("value taken: " + value + "; queue size is " + queue.size());
			}
		}
	}
}
