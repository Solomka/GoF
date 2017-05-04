package ua.training.gof.factory_method2;

public class VeggiePizzaCreator extends APizzaCreator {

	@Override
	APizza createPizza() {

		APizza pizza = new VeggiePizza();

		pizza.addIngredientsToPizza();
		pizza.bakePizza();

		return pizza;
	}

}
