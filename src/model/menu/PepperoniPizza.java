package model.menu;
import model.inventory.*;
import java.util.*;
public class PepperoniPizza extends MenuItem {
    public PepperoniPizza() {
        this.name = "Pepperoni Pizza";
        this.price = 12.00;
    }
    @Override
    public Map<Ingredient, Integer> getRequiredIngredients() {
        Map<Ingredient, Integer> ingredients = new HashMap<>();
        ingredients.put(Ingredient.DOUGH, 1);
        ingredients.put(Ingredient.CHEESE, 2);
        ingredients.put(Ingredient.PEPPERONI, 10);
        ingredients.put(Ingredient.PIZZA_SAUCE, 40);
        ingredients.put(Ingredient.PIZZA_BOX, 1);
        return ingredients;
    }
    @Override
    public String getProcessorType() {
        return "OVEN";
    }
}