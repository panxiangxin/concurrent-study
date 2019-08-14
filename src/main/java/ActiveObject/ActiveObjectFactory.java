package ActiveObject;

/**
 * @author www72
 * Date 2019/8/14 9:57
 * @Description
 */
public final class ActiveObjectFactory {
	
	private ActiveObjectFactory(){
	}
	
	public static ActiveObject createActiveObject(){
		
			Servant servant = new Servant();
			ActivationQueue activationQueue = new ActivationQueue();
			SchedulerThread schedulerThread = new SchedulerThread(activationQueue);
			ActiveObjectProxy proxy = new ActiveObjectProxy(schedulerThread,servant);
			schedulerThread.start();
			return proxy;
	}
}
