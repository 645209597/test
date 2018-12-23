package inner;

import inner.inner.G;

public class A {

	public static void main(String[] args) {
		A a = new A();
		B b = a.new B();
		C c = new C();
		
		G g = new G();
		// g.new H();
		// new G.I();
	}

	private class B {
		
	}
	
	private static class C {
		
	}
	
	class D {
		
	}
	
	static class E {
		
	}
	
}
