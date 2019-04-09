package interfacee;

public class InterfaceTest implements A, B {

	public static void main(String[] args) {
		A a = new InterfaceTest();
		B b = new InterfaceTest();
		a.f();
		b.f();
	}

	@Override
	public void f() {
		System.out.println("f()");
	}

}

interface A {
	void f();
}

interface B {
	void f();
}