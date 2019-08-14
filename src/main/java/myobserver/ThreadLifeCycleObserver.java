package myobserver;

import java.util.List;

/**
 * @author www72
 * Date 2019/8/13 12:28
 * @Description
 */
public class ThreadLifeCycleObserver implements LifeCycleListener {
	private final static Object LOCK = new Object();
	
	public void concurrentQuery(List<String> ids){
	if(ids == null || ids.isEmpty()) {
		return;
	}
		ids.stream().forEach(id -> new Thread(new ObservableRunnable(this) {
			@Override
			public void run() {
				try {
					notifyChange(new RunnableEvent(RunnableState.RUNNING, Thread.currentThread(), null));
					System.out.println("query for id " + id);
					Thread.sleep(1000L);
					int x = 1/0;
					notifyChange(new RunnableEvent(RunnableState.DONE, Thread.currentThread(), null));
				} catch (Exception e) {
					notifyChange(new RunnableEvent(RunnableState.ERROR, Thread.currentThread(), e));
				}
			}
		}, id).start());
	
	}
	@Override
	public void onEvent(ObservableRunnable.RunnableEvent event) {
			synchronized (LOCK){
				System.out.println("the runnable [ "+event.getThread().getName()+" ]  data change and the state is [ "+event.getState()+" ]");
				if(event.getCause()!=null){
					event.getCause().printStackTrace();
					System.out.println("the runnable [ "+event.getThread().getName()+" ] is failed.");
					
				}
			}
	}
}
