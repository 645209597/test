package concurrent;

/**
 * BLOCKED状态
 * @author Administrator
 *
 */
public class SynchronizedBlockedTest {

	public static void main(String[] args) {
		Object o = new Object();
		
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				synchronized (o) { }
			}
		});
		t.start();
		
		synchronized(o) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(t.getState());
		}
	}

}
