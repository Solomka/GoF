package ua.training.gof.factory_method2;

public class VeggiePizza extends APizza {
    @Override
    public void addIngredientsToPizza() {
        System.out.println("Preparing ingredients for veggie pizza.");
    }
}
