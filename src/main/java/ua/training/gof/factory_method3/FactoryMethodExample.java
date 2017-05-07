  package ua.training.gof.factory_method3;

import java.util.Date;

public class FactoryMethodExample {
	
	/*
	 * Используйте паттерн фабричный метод, когда:
	 	- классу заранее неизвестно, объекты каких классов ему нужно создавать; 
 		- класс спроектирован так, чтобы объекты, которые он создает, специфицировались подклассами;
 		- класс делегирует свои обязанности одному из нескольких вспомогательных подклассов,
 		 и вы планируете локализовать знание о том, какой класс при-нимает эти обязанности на себя.
	 */

	/*
	 * This pattern favors method invocation instead of making direct
	 * constructor calls to create objects.
	 * 
	 * In the factory method pattern, you provide an interface, which can be a
	 * Java interface or an abstract class to create objects. A factory method
	 * in the interface defers the object creation to one or more concrete
	 * subclasses at run time. The subclasses implement the factory method to
	 * select the class whose objects need to be created.
	 * 
	 * help in creating client code that is loosely-coupled with object creation code
	 */
	public static void main(String[] args) {

		WatchCreator watchCreator = null;

		try {
			watchCreator = getWatchCreatorByWatchType("asd");

			// client's code
			Watch watch = watchCreator.createWatch();
			watch.showTime();

		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
		}
	}

	public static WatchCreator getWatchCreatorByWatchType(String watchType) {
		switch (watchType) {
		case "digital":
			return new DigitalWatchCreator();
		// break;
		case "roman":
			return new RomanWatchCreator();
		// break;
		default:
			throw new RuntimeException("We don't create such type of Watch");
		}
	}

}
/* Products */

/* Abstract product */
interface Watch {
	void showTime();
}

/* Concrete products */

class DigitalWatch implements Watch {

	@Override
	public void showTime() {
		System.out.println(new Date());

	}
}

class RomanWatch implements Watch {

	@Override
	public void showTime() {
		System.out.println("III-X");

	}

}

/* Creator */

/* Abstarct creator */

interface WatchCreator {

	// factory method
	Watch createWatch();
}

/* Concreate creators */

class DigitalWatchCreator implements WatchCreator {

	@Override
	public Watch createWatch() {
		// TODO Auto-generated method stub
		return new DigitalWatch();
	}
}

class RomanWatchCreator implements WatchCreator {

	@Override
	public Watch createWatch() {
		// TODO Auto-generated method stub
		return new RomanWatch();
	}

}
