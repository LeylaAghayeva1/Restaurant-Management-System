package model.menu;
import model.inventory.*;
import java.util.*;
public class MeatPizza extends MenuItem {
    public MeatPizza() {
        this.name = "Meat Pizza";
        this.price = 14;
    }
    @Override
    public Map<Ingredient, Integer> getRequiredIngredients() {
        Map<Ingredient, Integer> ingredients = new HashMap<>();
        ingredients.put(Ingredient.DOUGH, 1);
        ingredients.put(Ingredient.PIZZA_SAUCE, 40);
        ingredients.put(Ingredient.GROUND_BEEF, 100);
        ingredients.put(Ingredient.CHEESE, 2);
        ingredients.put(Ingredient.PIZZA_BOX, 1);
        ingredients.put(Ingredient.MUSHROOM, 5);
        ingredients.put(Ingredient.PEPPER, 5);
        ingredients.put(Ingredient.ONION, 5);
        return ingredients;
    }
    @Override
    public String getProcessorType() {
        return "OVEN";
    }
}
