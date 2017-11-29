package concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁是指持有锁的线程可以再次持有同一把锁，且释放锁的次数等于持有锁的次数时才能完全释放锁
 * 
 * @author qingfeng
 */
public class ReentrantLockReentrantTest {

	public static void main(String[] args) {
		final ReentrantLock lock = new ReentrantLock();
		lock.lock();
		lock.lock();
		System.out.println(lock.getHoldCount());
		lock.unlock();
		lock.unlock();
		// lock.unlock(); // 释放锁的次数多于持有锁的次数会抛java.lang.IllegalMonitorStateException
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				lock.lock();
				System.out.println(lock.getHoldCount());
			}
		}).start();
	}

}
