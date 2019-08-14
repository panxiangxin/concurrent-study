package ActiveObject;

/**
 * @author www72
 * Date 2019/8/14 10:02
 * @Description
 */
public class DisplayClient extends Thread{
	private final ActiveObject activeObject;
	
	public DisplayClient(String name, ActiveObject activeObject) {
		super(name);
		this.activeObject = activeObject;
	}
	
	@Override
	public void run() {
		for (int i = 0; true; i++) {
			String text = Thread.currentThread().getName() +"=>"+ i;
			activeObject.displayString(text);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
