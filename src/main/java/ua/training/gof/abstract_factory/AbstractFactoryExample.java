package ua.training.gof.abstract_factory;

public class AbstractFactoryExample {
	
	/*
	 * Используйте паттерн абстрактная фабрика, когда:
		- система не должна зависеть от того, как создаются, компонуются и пред-ставляются входящие в нее объекты;
		- входящие в семейство взаимосвязанные объекты должны использоваться вместе и вам необходимо обеспечить выполнение этого ограничения;
 		- система должна конфигурироваться одним из семейств составляющих ее объектов;
		- вы хотите предоставить библиотеку объектов, раскрывая только их интер-фейсы, но не реализацию.
	 */

	/*
	 * In the abstract factory pattern you provide an interface to create
	 * families of related or dependent objects, but you do not specify the
	 * concrete classes of the objects to create. From the client point of view,
	 * it means that a client can create a family of related objects without
	 * knowing about the object definitions and their concrete class names.
	 * 
	 * help in creating client code that is loosely-coupled with object creation
	 * code
	 */
	
	/*
	 *  While abstract factory emphasizes on creating a family of related objects in one go, 
	 *  builder is about creating an object through a step-by-step construction process and returning the object as the final step.
	 *  In short abstract factory is concerned with what is made, while the builder with how it is made. 
	 *  So as you go further into enterprise application development,
	 *   whenever you need to create complex objects independently of the construction algorithm 
	 *   turn to the classic GoF Builder Pattern!
	 */

	/*
	 * Often you’ll find you only need one instance of the factory. If this is
	 * the case, you should consider implementing the concrete factory as a
	 * Singleton.
	 */
	public static void main(String[] args) {
		AbstractDeviceFactory abstractDeviceFactory = getFactoryByCountryCode("en");

		// EnDevice enDevice = new EnDevice(EnMouse, EnKeyboard, EnTouchpad);

		// clinet's code
		Mouse m = abstractDeviceFactory.getMouse();
		Keyboard k = abstractDeviceFactory.getKeyboard();
		Touchpad t = abstractDeviceFactory.getTouchpad();

		m.click();
		k.print();
		t.track(1, 2);

	}

	private static AbstractDeviceFactory getFactoryByCountryCode(String code) {
		switch (code.toLowerCase()) {
		case "ru":
			return new RusDeviceFactory();
		case "en":
			return new EnDeviceFactory();
		default:
			throw new RuntimeException("Unsupported country device");
		}
	}
}

/* Abstract Products */

// мишка
interface Mouse {
	void click();

	void dbclick();

	void scroll(int direction);
}

// клавіатура
interface Keyboard {
	void print();

	void println();
}

interface Touchpad {
	void track(int deltaX, int deltaY);
}

/* Concrete Products */

/* Rus Products */
class RusMouse implements Mouse {

	@Override
	public void click() {
		System.out.println("Rus mouse click");

	}

	@Override
	public void dbclick() {
		System.out.println("Rus mouse dbclick");

	}

	@Override
	public void scroll(int direction) {
		System.out.println("Rus mouse scroll");

	}
}

class RusKeyboard implements Keyboard {

	@Override
	public void print() {
		System.out.println("Rus keyboard print");

	}

	@Override
	public void println() {
		System.out.println("Rus keyboard println");

	}
}

class RusTouchpad implements Touchpad {

	@Override
	public void track(int deltaX, int deltaY) {
		System.out.println("Rus touchpad track");

	}
}

/* En products */
class EnMouse implements Mouse {

	@Override
	public void click() {
		System.out.println("En mouse click");

	}

	@Override
	public void dbclick() {
		System.out.println("En mouse dbclick");

	}

	@Override
	public void scroll(int direction) {
		System.out.println("En mouse scroll");

	}
}

class EnKeyboard implements Keyboard {

	@Override
	public void print() {
		System.out.println("En keyboard print");

	}

	@Override
	public void println() {
		System.out.println("En keyboard println");

	}
}

class EnTouchpad implements Touchpad {

	@Override
	public void track(int deltaX, int deltaY) {
		System.out.println("En touchpad track");

	}
}

/* Abstract factory */
/*
 * constracts set of Products that have some common feature and constract
 * together One Complex Product:
 * 
 * Device = Mouse + Keyboard + Touchpad
 */
interface AbstractDeviceFactory {
	/*
	 * Watch createWatch(); Weight createWeight();
	 */

	// fabric method
	Mouse getMouse();

	// fabric method
	Keyboard getKeyboard();

	// fabric method
	Touchpad getTouchpad();
}

/* Concrete factories */
class RusDeviceFactory implements AbstractDeviceFactory {

	@Override
	public Mouse getMouse() {
		// TODO Auto-generated method stub
		return new RusMouse();
	}

	@Override
	public Keyboard getKeyboard() {
		// TODO Auto-generated method stub
		return new RusKeyboard();
	}

	@Override
	public Touchpad getTouchpad() {
		// TODO Auto-generated method stub
		return new RusTouchpad();
	}
}

class EnDeviceFactory implements AbstractDeviceFactory {

	@Override
	public Mouse getMouse() {
		// TODO Auto-generated method stub
		return new EnMouse();
	}

	@Override
	public Keyboard getKeyboard() {
		// TODO Auto-generated method stub
		return new EnKeyboard();
	}

	@Override
	public Touchpad getTouchpad() {
		// TODO Auto-generated method stub
		return new EnTouchpad();
	}

}