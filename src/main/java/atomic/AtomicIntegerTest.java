package atomic;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author www72
 * Date 2019/8/14 15:30
 * @Description
 */
public class AtomicIntegerTest {
	/**
	 * volatile
	 * 1.内存可见性
	 * 2.有序性
	 * 3.不保证原子性
	 */
//	private static volatile int value = 0;
	private static Set<Integer> set = new HashSet<>();
	private static final AtomicInteger value = new AtomicInteger();
	public static void main(String[] args) throws InterruptedException {
//		Thread t1 = new Thread() {
//			@Override
//			public void run() {
//				int x = 0;
//				while (x < 500) {
//					set.add(value);
//					int tmp = value;
//					System.out.println(Thread.currentThread().getName() + ":" + tmp);
//					value += 1;
//					x++;
//					/**
//					 * 1.get value from memory
//					 * 2.add 1=>x
//					 * 3.assign the value to x
//					 * 4.flush to memory
//					 */
//				}
//			}
//		};
//		Thread t2 = new Thread() {
//			@Override
//			public void run() {
//				int x = 0;
//				while (x < 500) {
//					set.add(value);
//					int tmp = value;
//					System.out.println(Thread.currentThread().getName() + ":" + tmp);
//					value += 1;
//					x++;
//				}
//			}
//		};
//		Thread t3 = new Thread() {
//			@Override
//			public void run() {
//				int x = 0;
//				while (x < 500) {
//					set.add(value);
//					int tmp = value;
//					System.out.println(Thread.currentThread().getName() + ":" + tmp);
//					value += 1;
//					x++;
//				}
//			}
//		};
//		t1.start();
//		t2.start();
//		t3.start();
//		t1.join();
//		t2.join();
//		t3.join();
//
//		System.out.println(set.size());
		
		Thread t1 = new Thread() {
			@Override
			public void run() {
				int x = 0;
				while (x < 500) {
					
					int tmp = value.getAndIncrement();
					set.add(tmp);
					System.out.println(Thread.currentThread().getName() + ":" + tmp);
					x++;
				}
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				int x = 0;
				while (x < 500) {
					int tmp = value.getAndIncrement();
					set.add(tmp);
					System.out.println(Thread.currentThread().getName() + ":" + tmp);
					x++;
				}
			}
		};
		Thread t3 = new Thread() {
			@Override
			public void run() {
				int x = 0;
				while (x < 500) {
					int tmp = value.getAndIncrement();
					set.add(tmp);
					System.out.println(Thread.currentThread().getName() + ":" + tmp);
					x++;
				}
			}
		};
		
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();

		System.out.println(set.size());
	}
}
