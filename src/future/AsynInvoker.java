package future;

/**
 * @author www72
 * Date 2019/8/13 15:37
 * @Description future 未来的凭据
 *  			futureTask 将你的调用逻辑进行分离
 *  			futureService 桥接future和futureTask
 */
public class AsynInvoker {
	public static void main(String[] args) throws InterruptedException {
		FutureService futureService = new FutureService();
		Future<String> future = futureService.submit(()->{
			try {
				Thread.sleep(10000);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
			return "FINISH";
		},System.out::println);
		System.out.println("==========");
		System.out.println("do others");
		System.out.println("++++++++++");
		System.out.println(future.done());
		
		//System.out.println(future.get());
	}
}
