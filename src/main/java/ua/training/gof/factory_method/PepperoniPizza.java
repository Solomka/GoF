package ua.training.gof.factory_method;

public class PepperoniPizza extends APizza {
	
	@Override
	public void addIngredientsToPizza() {
		System.out.println("Preparing ingredients for pepperoni pizza.");
	}
}