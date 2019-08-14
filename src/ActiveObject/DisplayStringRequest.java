package ActiveObject;

/**
 * @author www72
 * Date 2019/8/14 9:37
 * @Description
 */
public class DisplayStringRequest extends MethodRequest{
	
	private final String text;
	
	protected DisplayStringRequest(Servant servant, String text) {
		super(servant, null);
		this.text = text;
	}
	
	@Override
	public void execute() {
	this.servant.displayString(text);
	}
}
