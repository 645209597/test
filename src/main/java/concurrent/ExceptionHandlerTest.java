package concurrent;

import java.lang.Thread.UncaughtExceptionHandler;

public class ExceptionHandlerTest {

	public static void main(String[] args) {
		System.out.println(Thread.getDefaultUncaughtExceptionHandler());
		System.out.println(Thread.currentThread().getName());
		
		Thread.currentThread().setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(t.getName());
				System.out.println(e.getMessage());
				e.printStackTrace();
				Thread.dumpStack();
			}
		});
		
		throw new RuntimeException("异常");
	}

}
