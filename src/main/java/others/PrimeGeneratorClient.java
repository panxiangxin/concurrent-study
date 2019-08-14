package others;


import java.util.Optional;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author www72
 * Date 2019/8/14 14:03
 * @Description 一个仅运行一秒钟的素数生成器
 */
public class PrimeGeneratorClient {
	public static void main(String[] args) {
		others.PrimeGenerator generator = new others.PrimeGenerator();
		new Thread(generator).start();
		try{
			SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			generator.cancel();
		}
		
		Optional.of(generator.get()).ifPresent(System.out::println);
	}
}
