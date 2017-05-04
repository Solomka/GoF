package ua.training.gof.factory_method;

public class CheesePizza extends APizza {

    @Override
    public void addIngredientsToPizza() {
        System.out.println("Preparing ingredients for cheese pizza.");
    }
}
