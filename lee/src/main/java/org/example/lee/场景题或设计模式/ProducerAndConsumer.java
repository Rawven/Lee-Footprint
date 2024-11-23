package org.example.lee.场景题或设计模式;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ProducerAndConsumer {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Event> queue = new ArrayBlockingQueue<>(50);
		Producer producer1 = new Producer(queue);
		Producer producer2 = new Producer(queue);
		Producer producer3 = new Producer(queue);
		Consumer consumer1 = new Consumer(queue);
		Consumer consumer2 = new Consumer(queue);
		Consumer consumer3 = new Consumer(queue);
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Thread.sleep(30);
		executorService.execute(producer1);
		Thread.sleep(30);
		executorService.execute(producer2);
		Thread.sleep(30);
		executorService.execute(producer3);
		executorService.execute(consumer1);
		executorService.execute(consumer2);
		executorService.execute(consumer3);
	}

	@Slf4j
	static class Producer implements Runnable {
		private static Random random = new Random();
		private BlockingQueue<Event> blockingQueue;

		public Producer(BlockingQueue queue) {
			this.blockingQueue = queue;
		}

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(3000);
					log.info(Thread.currentThread().getName() + "产生事件!");
					blockingQueue.put(new Event(LocalDateTime.now().toString()));
				} catch (InterruptedException e) {
					log.error("线程睡眠异常");
				}
			}
		}
	}

	@Slf4j
	static class Consumer implements Runnable {
		private BlockingQueue<Event> blockingQueue;

		public Consumer(BlockingQueue queue) {
			this.blockingQueue = queue;
		}

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(5000);
					if (!blockingQueue.isEmpty()) {
						Event poll = blockingQueue.take();
						log.info(Thread.currentThread().getName() + "消费事件" + poll.name);
					}
				} catch (InterruptedException e) {
					log.error("线程睡眠异常");
				}
			}
		}
	}

	@Data
	@AllArgsConstructor
	static class Event {
		String name;
	}
}
