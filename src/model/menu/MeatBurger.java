package model.menu;
import model.inventory.*;
import java.util.*;
public class MeatBurger extends MenuItem {
    public MeatBurger() {
        this.name = "Meat Burger";
        this.price = 8;
    }
    @Override
    public Map<Ingredient, Integer> getRequiredIngredients() {
        Map<Ingredient, Integer> ingredients = new HashMap<>();
        ingredients.put(Ingredient.BUN, 1);
        ingredients.put(Ingredient.GROUND_BEEF, 120);
        ingredients.put(Ingredient.CHEESE, 1);
        ingredients.put(Ingredient.LETTUCE, 1);
        ingredients.put(Ingredient.TOMATO, 2);
        ingredients.put(Ingredient.PICKLE, 3);
        ingredients.put(Ingredient.KETCHUP, 15);
        return ingredients;
    }
    @Override
    public String getProcessorType() {
        return "GRILL";
    }
}
