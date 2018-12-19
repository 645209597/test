package throwable;

public class ThrowableTest {

	public static void main(String[] args) {
		try {
			throw new Throwable();
		} catch (Throwable e) {
			
		}
		
		throw new Error();
		// throw new RuntimeException();
	}

}
