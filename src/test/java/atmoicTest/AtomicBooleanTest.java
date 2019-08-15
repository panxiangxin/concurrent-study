package atmoicTest;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author www72
 * Date 2019/8/14 16:56
 * @Description
 */
public class AtomicBooleanTest {
	@Test
	public void testCreate(){
		AtomicBoolean bool = new AtomicBoolean();
		System.out.println(bool.get());
	}
	
}
