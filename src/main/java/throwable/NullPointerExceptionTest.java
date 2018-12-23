package throwable;

public class NullPointerExceptionTest {

	public static void main(String[] args) {
		try {
			throw new NullPointerException("NPE occur");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		try {
			throw new NullPointerException();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
