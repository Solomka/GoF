package ua.training.gof.factory_method;

public class PizzaCreator extends APizzaCreator {

	@Override
	APizza createPizza(String pizzaType) {
		APizza pizza;

		switch (pizzaType.toLowerCase()) {
		
		case "cheese":
			// dependence ----->
			pizza = new CheesePizza();
			break;
		case "pepperoni":
			pizza = new PepperoniPizza();
			break;
		case "veggie":
			pizza = new VeggiePizza();
			break;
		default:
			throw new IllegalArgumentException("No such pizza.");

		}

		pizza.addIngredientsToPizza();
		pizza.bakePizza();
		
		return pizza;
	}

}
