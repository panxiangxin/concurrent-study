package future;

import myobserver.ThreadLifeCycleObserver;

import java.util.function.Consumer;

/**
 * @author www72
 * Date 2019/8/13 15:22
 * @Description
 */
public class FutureService {
	public <T> Future<T> submit(final FutureTask<T> task){
	AsynFuture<T> asynFuture = new AsynFuture<>();
	new Thread(() ->{
		T result = task.call();
		asynFuture.done(result);
	}).start();
	return asynFuture;
	}
	
	public <T> Future<T> submit(final FutureTask<T> task, final Consumer<T> consumer){
		AsynFuture<T> asynFuture = new AsynFuture<>();
		new Thread(() ->{
			T result = task.call();
			asynFuture.done(result);
			consumer.accept(result);
		}).start();
		return asynFuture;
	}
}
