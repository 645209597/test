package concurrent;

public class ThreadGroupTest {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getThreadGroup().getName());
		
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getThreadGroup().getName());
			}
		});
		t.start();
	}

}
