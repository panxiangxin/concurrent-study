package ActiveObject;

/**
 * @author www72
 * Date 2019/8/14 9:22
 * @Description
 */
 class Servant implements ActiveObject {
	@Override
	public Result makeString(int count, char fillChar) {
		char[] buf = new char[count];
		for (int i = 0; i < count; i++) {
			buf[i] = fillChar;
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new RealResult(new String(buf));
	}
	
	@Override
	public void displayString(String text) {
	try {
		System.out.println("display:" + text);
		Thread.sleep(10);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	}
}
