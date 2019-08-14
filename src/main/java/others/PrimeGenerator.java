package others;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author www72
 * Date 2019/8/14 13:57
 * @Description 使用volatile类型得域来保存取消状态
 */
@ThreadSafe
public class PrimeGenerator implements Runnable {
	@GuardedBy("this")
	private final List<BigInteger> primes = new ArrayList<>();
	
	private volatile boolean cancelled;
	
	@Override
	public void run() {
		BigInteger p = BigInteger.ONE;
		while (!cancelled){
			p=p.nextProbablePrime();
			synchronized(this){
				primes.add(p);
			}
		}
	}
	
	public void cancel(){
		cancelled = true;
	}
	public synchronized List<BigInteger> get(){
		return new ArrayList<>(primes);
	}
}
