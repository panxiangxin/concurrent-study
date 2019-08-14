package ActiveObject;

/**
 * @author www72
 * Date 2019/8/14 10:08
 * @Description
 */
public class ActiveObjectTest {
	public static void main(String[] args) {
		ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
		new MakerClientThread("Alice",activeObject).start();
		new MakerClientThread("Bobby",activeObject).start();
		new DisplayClient("Mike",activeObject).start();
	}
}
