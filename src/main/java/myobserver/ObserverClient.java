package myobserver;

/**
 * @author www72
 * Date 2019/8/13 11:59
 * @Description
 */
public class ObserverClient {
	public static void main(String[] args) {
		Subject subject = new Subject();
		new BinaryObserver(subject);
		new OctObserver(subject);
		
		subject.setState(10);
		System.out.println("=========");
		subject.setState(20);
		System.out.println("=========");
		subject.setState(30);
	}
}
