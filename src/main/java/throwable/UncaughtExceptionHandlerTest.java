package throwable;

import java.lang.Thread.UncaughtExceptionHandler;

public class UncaughtExceptionHandlerTest
{
    public static void main(String args[])
    {
        Thread thread = new Thread(new Task());
        // thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
        while (true) {
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	System.out.println("sleep");
        }
    }
}
 
class Task implements Runnable
{
    @Override
    public void run()
    {
        System.out.println(3/2);
        System.out.println(3/0);
        System.out.println(3/1);
    }
}

class ExceptionHandler implements UncaughtExceptionHandler
{
    @Override
    public void uncaughtException(Thread t, Throwable e)
    {
        System.out.println("==Exception: "+e.getMessage());
    }
}
