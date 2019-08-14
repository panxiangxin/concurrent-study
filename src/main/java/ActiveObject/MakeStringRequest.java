package ActiveObject;

/**
 * @author www72
 * Date 2019/8/14 9:33
 * @Description {@link ActiveObject#makeString(int, char)}
 */
public class MakeStringRequest extends MethodRequest {
	
	private final int count;
	private final char fillChar;
	
	protected MakeStringRequest(Servant servant, FutureResult futureResult,int count,char fillChar) {
		super(servant, futureResult);
		this.count = count;
		this.fillChar = fillChar;
	}
	
	@Override
	public void execute() {
		Result result = servant.makeString(count,fillChar);
		futureResult.setResult(result);
	}
}
