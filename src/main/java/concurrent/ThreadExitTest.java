package concurrent;

public class ThreadExitTest {

	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {}
			}
		});
		t.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Runtime.getRuntime().exit(-1);
	}
	
}
