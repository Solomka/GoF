package ua.training.gof.composite;

import java.util.ArrayList;
import java.util.List;
/*
 * Используйте паттерн компоновщик, когда:
а нужно представить иерархию объектов вида часть-целое; 
а хотите, чтобы клиенты единообразно трактовали составные и индивидуаль-
ные объекты.
 */
/*
 * Compose objects into tree structures to represent part-whole hierarchies.
 *  Composite lets clients treat individual objects and compositions of objects uniformly.
 *  
 *  The essence of composite pattern is the ability for a client to perform operations on an object without knowing if there are any nested objects. 
 */
public class CompositeExample {

	public static void main(String[] args) {

		Shape square1 = new Square();
		Shape square2 = new Square();
		Shape triangle1 = new Trinagle();

		Shape square3 = new Square();
		Shape circle1 = new Circle();
		Shape circle2 = new Circle();
		Shape circle3 = new Circle();

		Composite composite1 = new Composite();
		Composite composite2 = new Composite();

		// contains composite1 and composite2
		Composite composite = new Composite();

		composite1.addComponent(square1);
		composite1.addComponent(square2);
		composite1.addComponent(triangle1);

		composite2.addComponent(square3);
		composite2.addComponent(circle1);
		composite2.addComponent(circle2);
		composite2.addComponent(circle3);

		composite.addComponent(composite1);
		composite.addComponent(composite2);
		composite.addComponent(new Trinagle());

		composite.draw();

	}
}

interface Shape {
	void draw();
}

class Square implements Shape {

	@Override
	public void draw() {
		System.out.println("Draw Square");
	}
}

class Trinagle implements Shape {

	@Override
	public void draw() {
		System.out.println("Draw Triangle");
	}
}

class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Draw Circel");
	}
}

// Composite
// може містити в собі список як окремих фігур, так і інших композитів:
// Shape
// Composite implemets Shape => Composite == Shape
class Composite implements Shape {

	private List<Shape> components = new ArrayList<>();

	public void addComponent(Shape component) {
		components.add(component);
	}

	public void removeCOmponent(Shape component) {
		components.remove(component);
	}

	@Override
	public void draw() {
		for (Shape component : components) {
			component.draw();
		}
	}
}
