package concurrent;

public class ShutdownHookTest {

	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("hook");
				// while (true) {}
			}
		}));
		
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Runtime.getRuntime().halt(-1);
				System.out.println("halt");
			}
		});
		// t.start();
		
		// Runtime.getRuntime().exit(-1);
		// Runtime.getRuntime().halt(-1);
		// while (true) {}
	}

}
