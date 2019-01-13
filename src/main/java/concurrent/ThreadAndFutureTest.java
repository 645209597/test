package concurrent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadAndFutureTest {

	public static void main(String[] args) throws InterruptedException {
		// final Thread c = Thread.currentThread();
		
		final DateFormat df = new SimpleDateFormat(" mm:ss");
		
		List<FutureTask<Integer>> futureList = new LinkedList<FutureTask<Integer>>();
		FutureTask<Integer> future = null;
		for (int i = 1; i <= 5; i++) {
			Thread.sleep(1000);
			
			final int j = i;
			Callable<Integer> callable = new Callable<Integer>() {
				@Override
	            public Integer call() throws Exception {
	            	try {
						Thread.sleep(j * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	            	
	            	// System.out.println(c.getState());
	            	
	            	throw new RuntimeException("");
//	            	int r = new Random().nextInt(100);
//	            	System.out.println(r + df.format(new Date()));
//	                return r;
	            }
	        };
	        future = new FutureTask<Integer>(callable);
	        futureList.add(future);
	        new Thread(future).start();
		}
        
		System.out.println("++++++++++++");
		
		for (FutureTask<Integer> futureTmp : futureList) {
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
