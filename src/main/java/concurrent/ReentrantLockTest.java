package concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		lock.lock();
		lock.lock();
		System.out.println("a");
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				lock.lock();
				System.out.println("b");
			}
			
		}).start();
	}

}
