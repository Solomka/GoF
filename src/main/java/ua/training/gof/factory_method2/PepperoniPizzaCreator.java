package ua.training.gof.factory_method2;

public class PepperoniPizzaCreator extends APizzaCreator {

	@Override
	APizza createPizza() {
		APizza pizza = new PepperoniPizza();

		pizza.addIngredientsToPizza();
		pizza.bakePizza();

		return pizza;
	}

}
