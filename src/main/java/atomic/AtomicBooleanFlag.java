package atomic;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author www72
 * Date 2019/8/14 17:08
 * @Description
 */
public class AtomicBooleanFlag {
	private final static AtomicBoolean flag = new AtomicBoolean(true);
	
	public static void main(String[] args) throws InterruptedException {
		new Thread(){
			@Override
			public void run() {
				while (flag.get()){
					try {
						Thread.sleep(1000);
						// System.out.println("i am working.");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("i am finished.");
			}
		}.start();
		
		Thread.sleep(5000);
		flag.set(false);
	}
}
