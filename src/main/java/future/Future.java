package future;

/**
 * @author www72
 * Date 2019/8/13 15:19
 * @Description 返回future 凭据
 */
public interface Future<T> {
	T get() throws InterruptedException;
	boolean done();
}
