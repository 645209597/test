package concurrent;

/**
 * 监视器锁是可重入的
 * 
 * @author qingfeng
 */
public class SynchronizedTest {

	public static void main(String[] args) {
		Object o = new Object();
		synchronized(o) {
			synchronized(o) {
				System.out.println("a");
			}
		}
	}

}
