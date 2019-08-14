package workThread;

import java.util.Random;

/**
 * @author www72
 * Date 2019/8/14 8:35
 * @Description
 */
public class TransportThread extends Thread {
	private final Channel channel;
	private final static Random random = new Random(System.currentTimeMillis());
	
	public TransportThread(Channel channel,String name){
		super(name);
		this.channel = channel;
	}
	
	@Override
	public void run() {
		for (int i = 0; true; i++) {
			Request request = new Request(getName(),i);
			this.channel.put(request);
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
