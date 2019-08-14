package myobserver;

/**
 * @author www72
 * Date 2019/8/13 11:50
 * @Description
 */
public abstract class Observer {
	
	protected Subject subject;
	
	public Observer(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}
	
	public abstract void update();
}
