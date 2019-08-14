package ActiveObject;

/**
 * @author www72
 * Date 2019/8/14 9:20
 * @Description 对应ActiveObject的每一个方法
 */
public abstract class MethodRequest {
	protected final Servant servant;
	protected final FutureResult futureResult;
	
	protected MethodRequest(Servant servant, FutureResult futureResult) {
		this.servant = servant;
		this.futureResult = futureResult;
	}
	
	public abstract void execute();
}
