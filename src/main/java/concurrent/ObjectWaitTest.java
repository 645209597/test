package concurrent;

/**
 * WAITING和TIMED_WAITING状态
 * 
 * @author qingfeng
 */
public class ObjectWaitTest {

	public static void main(String[] args) {
		final Object o = new Object();
		
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (o) {
					try {
						o.wait(); // 未获取监控锁时抛java.lang.IllegalMonitorStateException
						// o.wait(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(t.getState());
	}

}
