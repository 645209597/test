package concurrent;

/**
 * WAITING状态变为BLOCKED状态
 * @author Administrator
 *
 */
public class ObjectNotifyTest {

	public static void main(String[] args) {
		final Object o = new Object();
		
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (o) {
					try {
						o.wait();
						System.out.println(Thread.currentThread().getId());
						while (true) {}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t.start();
		System.out.println("t=" + t.getId());
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (o) {
					try {
						o.wait();
						System.out.println(Thread.currentThread().getId());
						while (true) {}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
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
		
		System.out.println(t.getState());
		System.out.println(t2.getState());
		
		synchronized (o) {
			o.notifyAll();
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(t.getState());
		System.out.println(t2.getState());
	}

}
