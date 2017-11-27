package concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁是指持有锁的线程可以再次持有同一把锁，且释放锁的次数等于加锁次数时才能释放锁
 * 
 * @author qingfeng
 */
public class ReentrantLockTest {

	public static void main(String[] args) {
		final ReentrantLock lock = new ReentrantLock();
		lock.lock();
		lock.lock();
		System.out.println("a");
		lock.unlock();
		lock.unlock();
		lock.unlock();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				lock.lock();
				System.out.println("b");
			}
		}).start();
	}

}
