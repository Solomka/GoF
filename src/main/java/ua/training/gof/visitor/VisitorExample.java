package ua.training.gof.visitor;

/*
 * “Represent an operation to be performed on the elements of an object structure. 
 * Visitor lets you define a new operation
 *  without changing the classes of the elements on which it operates.”
 */

/*
 * add class functionality without changing code
 */
public class VisitorExample {

	public static void main(String[] args) {

		/*
		Element body = new BodyElement();
		Element engine = new EngineElement();

		Visitor hooligan = new HooliganVisitor();

		body.accept(hooligan);
		engine.accept(hooligan);
*/
		Element car = new CarElement();
		car.accept(new HooliganVisitor());
		System.out.println();
		car.accept(new MechanicVisitor());
	}
}

interface Visitor {

	void visit(EngineElement engineElement);

	void visit(BodyElement bodyElement);

	void visit(CarElement car);

	void visit(WheelElement wheel);
}

// Car element
interface Element {
	void accept(Visitor visitor);
}

class BodyElement implements Element {
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}

class EngineElement implements Element {

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}

class WheelElement implements Element {

	private String name;

	public WheelElement(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);

	}
}

class CarElement implements Element {
	Element[] elements;

	public CarElement() {
		this.elements = new Element[] { new WheelElement("Front left whell"), new WheelElement("Front right wheel"),
				new WheelElement("Back left wheel"), new WheelElement("Back right wheel"), new BodyElement(),
				new EngineElement() };
	}

	@Override
	public void accept(Visitor visitor) {
		for(Element elem: elements){
			elem.accept(visitor);
		}
		visitor.visit(this);
	}
}

class HooliganVisitor implements Visitor {

	@Override
	public void visit(EngineElement engineElement) {
		System.out.println("HooliganVisitor has broken the engine");
	}

	@Override
	public void visit(BodyElement bodyElement) {
		System.out.println("HooliganVisitor has scratched the Body");

	}

	@Override
	public void visit(CarElement car) {
		System.out.println("HooliganVisitor in the CarElement");

	}

	@Override
	public void visit(WheelElement wheel) {
		System.out.println("HooliganVisitor in the WheelElement element:" + wheel.getName());

	}
}

class MechanicVisitor implements Visitor {

	@Override
	public void visit(EngineElement engineElement) {
		System.out.println("MechanicVisitor has repaired the Engine");

	}

	@Override
	public void visit(BodyElement bodyElement) {
		System.out.println("MechanicVisitor has painted the Body");

	}

	@Override
	public void visit(CarElement car) {
		System.out.println("MechanicVisitor in the CarElement");

	}

	@Override
	public void visit(WheelElement wheel) {
		System.out.println("MechanicVisitor in the WheelElement element:" + wheel.getName());

	}

}