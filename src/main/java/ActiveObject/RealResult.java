package ActiveObject;

/**
 * @author www72
 * Date 2019/8/14 9:25
 * @Description
 */
public class RealResult implements Result {
	private final Object realResult;
	
	public RealResult(Object realResult) {
		this.realResult = realResult;
	}
	
	@Override
	public Object getResultValue() {
	return this.realResult;
	}
}
