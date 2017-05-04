package ua.training.gof.factory_method;

public class Client {

	public static void main(String[] args) {
		/*
		 * client doesn't know anything about pizza creating details
		 * 
		 * A Client that requires a ConcreteProduct does not create any object
		 * but instead asks the Creator for it. As a result the Client is not
		 * required to be aware of any ConcreteProduct and how they are created.
		 */

		/*
		 * the factory method pattern helps encapsulate object creation code
		 * from client code. This decouples your client code from the concrete
		 * classes you need to instantiate.
		 */
		APizzaCreator factory = new PizzaCreator();

		// Creates objects without specifying the exact class to create.

		// CheesePizza cheesePizza = new CheesePizza();
		// cheesePizza.addIngredientsToPizza();
		// cheesePizza.bakePizza();

		// abstracts the way objects are created
		APizza pizza = factory.createPizza("cheese");
	}

}
