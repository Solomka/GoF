package ua.training.gof.factory_method2;

public class Client {

	public static void main(String[] args) {
		/*
		 * client doesn't know anything about pizza creating details
		 * 
		 * A Client that requires a ConcreteProduct does not create any object
		 * but instead asks the Creator for it. As a result the Client is not
		 * required to be aware of any ConcreteProduct and how they are created.
		 */
		APizzaCreator factory = choosePizzaCreator("pepperoni");

		// Creates objects without specifying the exact class to create.
		APizza pizza = factory.createPizza();
	}

	private static APizzaCreator choosePizzaCreator(String pizzaType) {
		APizzaCreator creator;

		switch (pizzaType.toLowerCase()) {

		case "cheese":
			// dependence ----->
			creator = new CheesePizzaCreator();
			break;
		case "pepperoni":
			creator = new PepperoniPizzaCreator();
			break;
		case "veggie":
			creator = new VeggiePizzaCreator();
			break;
		default:
			throw new IllegalArgumentException("No such pizza.");

		}

		return creator;
	}
}
