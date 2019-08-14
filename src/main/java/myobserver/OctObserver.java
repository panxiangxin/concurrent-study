package myobserver;

/**
 * @author www72
 * Date 2019/8/13 11:54
 * @Description
 */
public class OctObserver extends Observer {
	
	public OctObserver(Subject subject) {
		super(subject);
	}
	
	@Override
	public void update() {
		System.out.println("Oct String: " + Integer.toBinaryString(subject.getState()));
	}
}
