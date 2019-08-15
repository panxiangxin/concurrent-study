package atmoicTest;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author www72
 * Date 2019/8/14 16:08
 * @Description
 */
public class AtomicIntegerDetailsTest {
	@Test
	public void testCreate(){
		/**
		 * create
		 */
		AtomicInteger i = new AtomicInteger();
		System.out.println(i.get());
		i=new AtomicInteger(10);
		System.out.println(i);
		i.set(12);
		System.out.println(i);
		i.lazySet(18);
		System.out.println(i);
		
	}
	@Test
	public void testGetAndSet(){
		
		AtomicInteger getAndSet = new AtomicInteger(10);
		int result = getAndSet.getAndAdd(10);
		System.out.println(result);
		System.out.println(getAndSet.get());
		AtomicInteger getAndSet2 = new AtomicInteger();
		new Thread(){
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					int v = getAndSet2.addAndGet(1);
					System.out.println(v);
				}
			}
		}.start();
		new Thread(){
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					int v = getAndSet2.addAndGet(1);
					System.out.println(v);
				}
			}
		}.start();
	}
}
