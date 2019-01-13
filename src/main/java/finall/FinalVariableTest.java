package finall;

public class FinalVariableTest {

	final int a;
	final Integer b = 0;
	final String c;
	
	public FinalVariableTest(int a, String c) {
		this.a = a;
		this.c = c;
	}
	
	public static void main(String[] args) {
		
		final int d;
		// System.out.println(d);
		d = 10;
		// d++;
	}
	
	static void f(final int i) {
		// i++;
	}

	void ff() {
		// c = "";
	}
	
}
