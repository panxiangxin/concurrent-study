package ActiveObject;

/**
 * @author www72
 * Date 2019/8/14 10:05
 * @Description
 */
public class MakerClientThread extends Thread {
	private final ActiveObject activeObject;
	private final char fillChar;
	
	public MakerClientThread(String name, ActiveObject activeObject) {
		super(name);
		this.activeObject = activeObject;
		this.fillChar = getName().charAt(0);
	}
	
	@Override
	public void run() {
		for (int i = 0; true; i++) {
			Result result = activeObject.makeString(i+1,fillChar);
			try {
				Thread.sleep(20);
				String value = (String) result.getResultValue();
				System.out.println(Thread.currentThread().getName()+" value: "+value);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
