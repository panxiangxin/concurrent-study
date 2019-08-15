package util;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author www72
 * Date 2019/8/15 14:10
 * @Description countDownLatch例子1
 */
public class CountDownLatchExample2 {
	
	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch(1);
		
		new Thread(()->{
			System.out.println("do some init work.");
			try {
				Thread.sleep(1000);
				latch.await();
				System.out.println("data is ok, do other work....");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		
		new Thread(()->{
			System.out.println("prepare for work data...");
			try {
				Thread.sleep(2000);
				System.out.println("prepare work is done.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				latch.countDown();
			}
		}).start();
	}
	
	
}
