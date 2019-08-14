package future;

/**
 * @author www72
 * Date 2019/8/13 15:28
 * @Description 实现future接口
 */
public class AsynFuture<T> implements Future<T> {
	private volatile boolean done = false;
	private T result;
	public void done(T result){
		synchronized (this){
			if (done){
				return;
			}
			this.result = result;
			done = true;
			this.notifyAll();
		}
	}
	@Override
	public T get() throws InterruptedException {
		synchronized (this){
			while (!done){
				this.wait();
			}
		}
		return result;
	}
	
	@Override
	public boolean done() {
		return done;
	}
}
