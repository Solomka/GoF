package ua.training.gof.factory_method;

public abstract class APizza {
	abstract void addIngredientsToPizza();

	public void bakePizza() {
		System.out.println("Pizza baked at 400 for 20 minutes.");
	}

}
