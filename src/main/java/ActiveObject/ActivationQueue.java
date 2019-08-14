package ActiveObject;

import java.util.LinkedList;

/**
 * @author www72
 * Date 2019/8/14 9:41
 * @Description
 */
public class ActivationQueue {
	private final static int MAX_METHOD_REQUEST_QUEUE_SIZE = 100;
	private final LinkedList<MethodRequest> methodQueue;
	
	public ActivationQueue() {
		this.methodQueue = new LinkedList<MethodRequest>();
	}
	
	
	public synchronized void put(MethodRequest request){
		while (methodQueue.size()>= MAX_METHOD_REQUEST_QUEUE_SIZE){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.methodQueue.add(request);
		this.notifyAll();
	}
	
	public synchronized MethodRequest take(){
		while (methodQueue.isEmpty()){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		MethodRequest request = this.methodQueue.removeFirst();
		this.notifyAll();
		return request;
	}
}
