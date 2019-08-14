package myobserver;

/**
 * @author www72
 * Date 2019/8/13 12:25
 * @Description
 */
public interface LifeCycleListener {
	
	void onEvent(ObservableRunnable.RunnableEvent event);
}
