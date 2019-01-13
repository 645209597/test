package throwable;

public class ErrorTest {

	public static void main(String[] args) throws Exception {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					System.out.println("running");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}}).start();
//		throw new OutOfMemoryError("");
		byte[] i = new byte[2 * 1024 * 1024];
	}

}
