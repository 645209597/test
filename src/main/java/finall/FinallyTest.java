package finall;

public class FinallyTest {

	public static void main(String[] args) {
		try {
			System.exit(1);
		} finally {
			System.out.println("Print from finally");
		}
	}

}
