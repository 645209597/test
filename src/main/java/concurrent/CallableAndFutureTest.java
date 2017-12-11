package concurrent;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableAndFutureTest {

	public static void main(String[] args) {
		final Thread c = Thread.currentThread();
		
		Callable<Integer> callable = new Callable<Integer>() {
            public Integer call() throws Exception {
            	try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            	
            	System.out.println(c.getState());
            	
            	// throw new RuntimeException("");
                return new Random().nextInt(100);
            }
        };
        FutureTask<Integer> future = new FutureTask<Integer>(callable);
        new Thread(future).start();
        
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
        	System.out.println("execute error");
            e.printStackTrace();
        }
	}

}
