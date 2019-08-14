package workThread;

/**
 * @author www72
 * Date 2019/8/14 8:22
 * @Description
 */
public class Request {
	private final String name;
	private final int num;
	
	public Request(String name, int num) {
		this.name = name;
		this.num = num;
	}
	
	public void execute(){
		System.out.println(Thread.currentThread().getName()+" execute "+ this);
	}
	@Override
	public String toString() {
		return "Request{" +
					   "name='" + name + '\'' +
					   ", num=" + num +
					   '}';
	}
}
