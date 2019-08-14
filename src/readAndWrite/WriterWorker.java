package readAndWrite;

import java.util.Random;

/**
 * @author www72
 * Date 2019/8/14 11:16
 * @Description
 */
public class WriterWorker extends Thread{
	private final Random random = new Random(System.currentTimeMillis());
	private final SharedData data;
	private final String filler;
	private int index = 0;
	
	public WriterWorker(SharedData data,String filler) {
		this.data = data;
		this.filler = filler;
	}
	
	@Override
	public void run() {
		try {
			while (true){
			char c = nextChar();
			data.write(c);
			Thread.sleep(random.nextInt(1_000));
		}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	private char nextChar(){
		char c = filler.charAt(index);
		index++;
		if(index>=filler.length()){
			index = 0;
		}
		return c;
	}
}
