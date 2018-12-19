package throwable;

public class TryWithResourcesTest {

	public static void main(String[] args) {
		try (Clz clz = new Clz();) {
			
		} catch (Exception e) {
			
		}

	}

}

class Clz implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.println("close");
	}
	
}
