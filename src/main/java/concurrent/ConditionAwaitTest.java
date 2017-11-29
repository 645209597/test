package concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * WAITING和TIMED_WAITING状态
 * 
 * @author qingfeng
 */
public class ConditionAwaitTest {

	public static void main(String[] args) {
		final Lock lock = new ReentrantLock();
		final Condition condition = lock.newCondition();
		
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				lock.tryLock();
				try {
					condition.await(); // 未获取到锁时抛java.lang.IllegalMonitorStateException
					// condition.await(2000, TimeUnit.MILLISECONDS); 
				} catch (InterruptedException e) {
					e.printStackTrace();
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
