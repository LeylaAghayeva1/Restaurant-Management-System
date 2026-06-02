package model.menu;
import model.inventory.*;
import java.util.*;
public class CheesePizza extends MenuItem {
    public CheesePizza() {
        this.name = "Cheese Pizza";
        this.price = 9.00;
    }
    @Override
    public Map<Ingredient, Integer> getRequiredIngredients() {
        Map<Ingredient, Integer> ingredients = new HashMap<>();
        ingredients.put(Ingredient.DOUGH, 1);
        ingredients.put(Ingredient.CHEESE, 4);
        ingredients.put(Ingredient.PIZZA_SAUCE, 40);
        ingredients.put(Ingredient.PIZZA_BOX, 1);
        return ingredients;
    }
    @Override
    public String getProcessorType() {
        return "OVEN";
    }
}