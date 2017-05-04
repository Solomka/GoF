package ua.training.gof.factory_method;

public class VeggiePizza extends APizza {
    @Override
    public void addIngredientsToPizza() {
        System.out.println("Preparing ingredients for veggie pizza.");
    }
}
