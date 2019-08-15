package atomic;

/**
 * @author www72
 * Date 2019/8/14 16:36
 * @Description
 */
public class AtomicIntegerDetailTest {
	private static final CompareAndSetLock lock = new CompareAndSetLock();
	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new Thread(){
				@Override
				public void run() {
					doSomething2();
				}
			}.start();
		}
	}
	
	public static void doSomething(){
	synchronized (AtomicIntegerDetailTest.class){
		System.out.println(Thread.currentThread().getName()+"get the lock.");
		try {
			Thread.sleep(10_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	}
	public static void doSomething2(){
		try{
			lock.tryLock();
			System.out.println(Thread.currentThread().getName()+"get the lock.");
			Thread.sleep(10_000);
		} catch (GetLockException | InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unLock();
		}
	}
}
