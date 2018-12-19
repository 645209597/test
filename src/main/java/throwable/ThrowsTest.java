package throwable;

import java.util.ConcurrentModificationException;
import java.util.concurrent.RejectedExecutionException;

public class ThrowsTest {

	public static void main(String[] args) {
		f();
	}

	static void f() throws RejectedExecutionException, ConcurrentModificationException {
		
	}
}
