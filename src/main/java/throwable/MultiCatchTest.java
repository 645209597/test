package throwable;

import java.util.ConcurrentModificationException;
import java.util.concurrent.RejectedExecutionException;

public class MultiCatchTest {

	public static void main(String[] args) {
		try {
			
		} catch (RejectedExecutionException | ConcurrentModificationException e) { // 各个异常不能有交集
			
		}
	}

}
