package ActiveObject;

/**
 * @author www72
 * Date 2019/8/14 9:51
 * @Description
 */
 class ActiveObjectProxy implements ActiveObject{
	private final SchedulerThread schedulerThread;
	private final Servant servant;
	
	public ActiveObjectProxy(SchedulerThread schedulerThread, Servant servant) {
		this.schedulerThread = schedulerThread;
		this.servant = servant;
	}
	
	@Override
	public Result makeString(int count, char fillChar) {
		FutureResult futureResult = new FutureResult();
		schedulerThread.invoke(new MakeStringRequest(servant,futureResult,count,fillChar));
		return futureResult;
	}
	
	@Override
	public void displayString(String text) {
	schedulerThread.invoke(new DisplayStringRequest(servant,text));
	}
}
