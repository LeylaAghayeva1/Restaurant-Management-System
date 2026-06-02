package model.menu;
import model.inventory.*;
import java.util.*;
public class ChickenBurger extends MenuItem {
    public ChickenBurger() {
        this.name = "Chicken Burger";
        this.price = 7.50;
    }
    @Override
    public Map<Ingredient, Integer> getRequiredIngredients() {
        Map<Ingredient, Integer> ingredients = new HashMap<>();
        ingredients.put(Ingredient.BUN, 1);
        ingredients.put(Ingredient.BREAST, 1);
        ingredients.put(Ingredient.LETTUCE, 1);
        ingredients.put(Ingredient.TOMATO, 2);
        ingredients.put(Ingredient.MAYO, 15);
        ingredients.put(Ingredient.PICKLE, 3);
        return ingredients;
    }
    @Override
    public String getProcessorType() {
        return "GRILL";
    }
}