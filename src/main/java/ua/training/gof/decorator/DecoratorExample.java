package ua.training.gof.decorator;

/*
 * Используйте паттерн декоратор:
а для динамического, прозрачного для клиентов добавления обязанностей объектам;
а для реализации обязанностей, которые могут быть сняты с объекта; 
а когда расширение путем порождения подклассов по каким-то причинам не-
удобно или невозможно.
 Иногда приходится реализовывать много незави-симых расширений, 
 так что порождение подклассов для поддержки всех возможных комбинаций приведет к комбинаторному росту их числа. 
 В дру-гих случаях определение класса может быть скрыто или почему-либо еще недоступно, 
 так что породить от него подкласс нельзя.
 */
/*
 * “Attach additional responsibilities to an object dynamically.
 *  Decorators provide a flexible alternative to sub-classing for extending functionality.”
 */
public class DecoratorExample {
	public static void main(String[] args) {
		// PrinterInterface printer = new Printer("Hello!");
		// PrinterInterface printer = new QuotesDecorator(new
		// Printer("Hello!"));
		// PrinterInterface printer = new LeftBracketDecorator(new
		// Printer("Hello!"));

		PrinterInterface printer = new QuotesDecorator(
				new LeftBracketDecorator(new RightBracketDecorator(new Printer("Hello!"))));

		// "XXX"
		// "[XXX"
		// "[XXX]"
		// "[Hello!]"

		printer.print();
	}
}

interface PrinterInterface {
	void print();
}

class Printer implements PrinterInterface {

	String value;

	public Printer(String value) {
		super();
		this.value = value;
	}

	@Override
	public void print() {
		System.out.print(value);
	}
}

/* Decorator */

abstract class Decorator implements PrinterInterface {
	PrinterInterface component;

	public Decorator(PrinterInterface component) {
		this.component = component;
	}

	public void print() {
		component.print();
	}

}

class QuotesDecorator extends Decorator {

	public QuotesDecorator(PrinterInterface component) {
		super(component);
	}

	@Override
	public void print() {
		System.out.print("\"");
		super.print();
		System.out.print("\"");
	}
}

class LeftBracketDecorator extends Decorator {

	public LeftBracketDecorator(PrinterInterface component) {
		super(component);
	}

	@Override
	public void print() {
		System.out.print("[");
		super.print();
	}
}

class RightBracketDecorator extends Decorator {

	public RightBracketDecorator(PrinterInterface component) {
		super(component);
	}

	@Override
	public void print() {
		super.print();
		System.out.print("]");

	}
}
