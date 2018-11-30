package concurrent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolAndFutureTest {

	public static void main(String[] args) throws InterruptedException {

		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, 
				new LinkedBlockingDeque<Runnable>(10),
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
        
        List<Future<Integer>> futureList = new LinkedList<Future<Integer>>();
		Future<Integer> future = null;
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
	                return r;
	            }
	        };
	        future = threadPool.submit(callable);
	        futureList.add(future);
		}
        
		System.out.println("++++++++++++");
		
		for (Future<Integer> futureTmp : futureList) {
			try {
	            System.out.println(futureTmp.get() + df.format(new Date()));
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        } catch (ExecutionException e) {
	        	System.out.println("execute error");
	            e.printStackTrace();
	        }
		}
	}

}
