package workThread;

/**
 * @author www72
 * Date 2019/8/14 8:44
 * @Description
 */
public class WorkerClient {
	public static void main(String[] args) {
		final Channel channel = new Channel(10);
		channel.startWorker();
		
		new TransportThread(channel,"Jack").start();
		new TransportThread(channel,"Mike").start();
		new TransportThread(channel,"William").start();
		new TransportThread(channel,"Pxx").start();
		
	}
}
