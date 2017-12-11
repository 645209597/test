package concurrent;

/**
 * WAITING和TIMED_WAITING状态
 * 
 * @author qingfeng
 */
public class ThreadJoinTest {

	public static void main(String[] args) {
		final Thread c = Thread.currentThread();
		
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println(c.getState());
				// throw new RuntimeException("");
			}
		});
		t.start();
		
		try {
			t.join();
			// t.join(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
        	System.out.println("execute error");
            e.printStackTrace();
        }
	}

}
