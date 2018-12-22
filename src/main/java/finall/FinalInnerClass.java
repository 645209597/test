package finall;

public class FinalInnerClass {

	int a;
	
	public static void main(String[] args) {

	}

	void f() {
		final int b = 10;
		new I() {
			@Override
			public void f() {
				System.out.println(a);
				System.out.println(b);
			}
		};
		new C() {
			@Override
			public void f() {
				System.out.println(a);
				System.out.println(b);
			}
		};
	}
	
}

interface I {
	void f();
}

class C {
	void f() {}
}