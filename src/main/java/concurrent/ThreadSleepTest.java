package concurrent;

/**
 * TIMED_WAITING状态
 * @author Administrator
 *
 */
public class ThreadSleepTest {

	public static void main(String[] args) {
		final Thread c = Thread.currentThread();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println(c.getState());
			}
		}).start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
