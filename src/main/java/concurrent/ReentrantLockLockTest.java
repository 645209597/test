package concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * WAITING状态
 * @author Administrator
 *
 */
public class ReentrantLockLockTest {

	public static void main(String[] args) {
		final ReentrantLock lock = new ReentrantLock();
		
		lock.lock();
		
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				lock.lock();
			}
		});
		t.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(t.getState());
	}

}
