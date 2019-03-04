package concurrent;

/**
 * Java 虚拟机在最后的非守护线程退出时关闭
 * 
 * @author qingfeng
 */
public class ThreadDaemonTest {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().isDaemon());
		
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("run");
				}
			}
		});
		// t.setDaemon(true);
		t.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
