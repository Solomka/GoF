package ua.training.gof.template_method;

/*
 * to void code dublication
 */
public class TemplateMethodExample {

	public static void main(String[] args) {
		C a = new A();
		a.templteMethod();

		C b = new B();
		b.templteMethod();

	}
}

abstract class C {
	void templteMethod() {
		System.out.println("1");
		differ();
		System.out.println("3");
		differ2();
	}

	abstract void differ();

	abstract void differ2();
}

class A extends C {

	@Override
	void differ() {
		System.out.println("2");

	}

	@Override
	void differ2() {
		System.out.println("5");
	}

}

class B extends C {

	@Override
	void differ() {
		System.out.println("4");
	}

	@Override
	void differ2() {

	}
}
