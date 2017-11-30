package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionSignalTest {

	public static void main(String[] args) {
		final Lock lock = new ReentrantLock();
		final Condition condition = lock.newCondition();
		
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				lock.lock();
				try {
					condition.await();
					System.out.println(Thread.currentThread().getId());
					loseTime();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		});
		t.start();
		System.out.println("t=" + t.getId());
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				lock.lock();
				try {
					condition.await();
					System.out.println(Thread.currentThread().getId());
					loseTime();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		});
		t2.start();
		System.out.println("t2=" + t2.getId());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("t=" + t.getState());
		System.out.println("t2=" + t2.getState());
		
		lock.lock();
		condition.signalAll();; // 必须先持有锁否则会抛java.lang.IllegalMonitorStateException
		lock.unlock();
		
		for (int i = 0; i < 6; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("t=" + t.getState());
			System.out.println("t2=" + t2.getState());
		}
	}

	static void loseTime() {
		for (long i = 0; i < 100000; i++) {
			for (long j = 0; j < 100000; j++) {
				double d = 123456789.123456789 * 123456789.123456789;
			}
		}
	}
}
