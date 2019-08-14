package readAndWrite;

/**
 * @author www72
 * Date 2019/8/14 11:26
 * @Description ReadWrite Design Pattern
 */
public class ReadWriteLockClient {
	public static void main(String[] args) {
		final SharedData data = new SharedData(10);
		
		new ReaderWorker(data).start();
		new ReaderWorker(data).start();
		new ReaderWorker(data).start();
		new ReaderWorker(data).start();
		new ReaderWorker(data).start();
		
		new WriterWorker(data,"abcdefghijk").start();
		new WriterWorker(data,"ASDDSFFFRRF").start();
	}
}
