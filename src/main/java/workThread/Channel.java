package workThread;

import java.util.Arrays;

/**
 * @author www72
 * Date 2019/8/14 8:18
 * @Description
 */
public class Channel {
	private final static int MAX_REQUEST = 100;
	private final Request[] requestQueue;
	private int head;
	private int tail;
	private int count;
	private final WorkThread[]  workerPool;
	
	public Channel(int workers){
		this.requestQueue = new Request[MAX_REQUEST];
		this.head = 0;
		this.tail = 0;
		this.count = 0;
		this.workerPool = new WorkThread[workers];
		this.init();
	}
	
	private void init() {
		for (int i = 0; i < workerPool.length; i++) {
			workerPool[i] = new WorkThread("Worker-" + i, this);
		}
	}
	public void startWorker(){
		Arrays.asList(workerPool).forEach(WorkThread::start);
	}
	public synchronized void put(Request request){
		while (count >= requestQueue.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			this.requestQueue[tail] = request;
			tail = (tail + 1) % requestQueue.length;
			this.count++;
			this.notifyAll();
		
	}
	
	public synchronized Request take(){
		while(count <= 0){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Request request = requestQueue[head];
		head = (head + 1) % requestQueue.length;
		this.count--;
		this.notifyAll();
		
		return request;
	}
}
