package myobserver;

import java.util.Arrays;

/**
 * @author www72
 * Date 2019/8/13 12:40
 * @Description
 */
public class threadLifeCycleClient {
	public static void main(String[] args) {
		new ThreadLifeCycleObserver().concurrentQuery(Arrays.asList("1","2"));
	}
}
