package ua.training.gof.factory_method2;

public class CheesePizzaCreator extends APizzaCreator{

	@Override
	APizza createPizza() {
		
		APizza pizza = new CheesePizza();
		
		pizza.addIngredientsToPizza();
		pizza.bakePizza();
		
		return pizza;
	}

}
