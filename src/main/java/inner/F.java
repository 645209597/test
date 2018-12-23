package inner;

import inner.A.D;
import inner.A.E;

public class F {

	public static void main(String[] args) {
		A a = new A();
		// a.new B();
		// new A.C();
		D d = a.new D();
		E e = new A.E();
	}

}
