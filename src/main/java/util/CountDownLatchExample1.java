package util;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author www72
 * Date 2019/8/15 14:10
 * @Description countDownLatch例子1
 */
public class CountDownLatchExample1 {
	private static Random random = new Random(System.currentTimeMillis());
	private static ExecutorService executor = Executors.newFixedThreadPool(2);
	private static CountDownLatch latch = new CountDownLatch(6);
	public static void main(String[] args) throws InterruptedException {
		int[] data = query();
		for (int i = 0; i < data.length; i++) {
			executor.execute(new SimpleRunnable(data, i));
		}
		latch.await();
		System.out.println("all work is finished.");
		executor.shutdown();
	}
	
	private static int[] query() {
		return new int[]{1,2, 3, 4, 5, 6};
	}
	
	public static class SimpleRunnable implements Runnable {
		private  final int[] data;
		private  final int index;
		
		public SimpleRunnable(int[] data, int index) {
			this.data = data;
			this.index = index;
		}
		
		@Override
		public void run() {
			try {
				Thread.sleep(random.nextInt(2000));
				if (data[index] % 2 == 0) {
					data[index] = data[index] * 2;
				}else {
					data[index] = data[index] * 10;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" is finished.");
			latch.countDown();
		}
	}
}
