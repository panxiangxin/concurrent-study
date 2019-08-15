package atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author www72
 * Date 2019/8/14 16:41
 * @Description 利用AtomicInteger中的compareAndSet实现锁
 */
public class CompareAndSetLock {
	private AtomicInteger value = new AtomicInteger(0);
	private Thread lockThread;
	public void tryLock() throws GetLockException {
		boolean success = value.compareAndSet(0, 1);
		if(!success){
			throw new GetLockException("get the lock failed.");
		}
		else {
			lockThread = Thread.currentThread();
		}
	}
	public void unLock(){
		if(value.get() == 0){
			return;
		}
		if(lockThread == Thread.currentThread()){
		value.compareAndSet(1,0);
		}
	}
}
