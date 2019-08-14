package readAndWrite;

import java.util.Random;

/**
 * @author www72
 * Date 2019/8/14 11:23
 * @Description
 */
public class ReaderWorker extends Thread {
	private final Random random = new Random(System.currentTimeMillis());
	private final SharedData data;
	
	public ReaderWorker(SharedData data) {
		this.data = data;
	}
	
	@Override
	public void run() {
		while (true){
			char[] readBuf = data.read();
			System.out.println(Thread.currentThread().getName()+" reads "+String.valueOf(readBuf));
		}
	}
}
