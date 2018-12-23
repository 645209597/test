package protect;

import protect.inner.A;

public class D extends A {

	public static void main(String[] args) {
		A a = new A();
		// a.f();
		
		D d = new D();
		d.ff();
	}

	// void f() {}
	
	void ff() {
		System.out.println(super.a);
		System.out.println(this.a);
		super.f();
		this.f();
	}
	
}
