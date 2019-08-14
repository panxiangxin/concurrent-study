package workThread;

import java.util.Random;

/**
 * @author www72
 * Date 2019/8/14 8:22
 * @Description
 */
public class WorkThread extends Thread{
	private final Channel channel;
	private final Random random = new Random(System.currentTimeMillis());
	public WorkThread(String s, Channel channel) {
		super(s);
		this.channel = channel;
	}
	
	@Override
	public void run() {
		while (true){
			channel.take().execute();
			try {
				Thread.sleep(random.nextInt(1_000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
