package myobserver;

/**
 * @author www72
 * Date 2019/8/13 11:54
 * @Description
 */
public class BinaryObserver extends Observer {
	
	public BinaryObserver(Subject subject) {
		super(subject);
	}
	
	@Override
	public void update() {
		System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
	}
}
