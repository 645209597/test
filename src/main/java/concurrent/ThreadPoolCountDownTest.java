package concurrent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolCountDownTest {

	public static void main(String[] args) throws InterruptedException {

		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, 
				new LinkedBlockingDeque<Runnable>(3),
				new RejectedExecutionHandler() {
					@Override
					public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
						try {
							System.out.println("reject start");
							executor.getQueue().put(r);
							System.out.println("reject end");
						} catch (InterruptedException e) {
							System.out.println("rejectedExecution error!");
						}
					}

				});
        threadPool.allowCoreThreadTimeOut(true);
        
        final DateFormat df = new SimpleDateFormat(" mm:ss");
        
        final CountDownLatch countDownLatch = new CountDownLatch(5);
		for (int i = 1; i <= 5; i++) {
			// Thread.sleep(1000);
			
			final int j = i;
			Callable<Integer> callable = new Callable<Integer>() {
	            public Integer call() throws Exception {
	            	try {
						Thread.sleep(j * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	            	
	            	// System.out.println(c.getState());
	            	
	            	// throw new RuntimeException("");
	            	int r = new Random().nextInt(100);
	            	System.out.println(r + df.format(new Date()));
	            	countDownLatch.countDown();
	                return r;
	            }
	        };
	        threadPool.submit(callable);
		}
        
		System.out.println("++++++++++++");
		
		countDownLatch.await();
	}

}
