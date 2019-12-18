package concurrent;

import java.io.IOException;

public class ThreadReadTest {

	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.in.read();
					System.out.println("read done");
				} catch (IOException e) {
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
		
		t.interrupt();
	}

}
