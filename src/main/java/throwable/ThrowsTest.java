package throwable;

import java.util.ConcurrentModificationException;
import java.util.concurrent.RejectedExecutionException;

public class ThrowsTest {

	public static void main(String[] args) {
		f();
		try {
			f2();
		} catch (Exception e) {
		}
		try {
			f3();
		} catch (Throwable e) {
		}
		
		throw new Error();
		// throw new RuntimeException();
	}

	static void f() throws RuntimeException, Error {
		
	}
	
	static void f2() throws Exception {
		
	}

	static void f3() throws Throwable {
		
	}
	
}
