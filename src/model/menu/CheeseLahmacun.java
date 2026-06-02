package model.menu;
import model.inventory.*;
import java.util.*;
public class CheeseLahmacun extends MenuItem {
    public CheeseLahmacun() {
        this.name = "Cheese Lahmacun";
        this.price = 4.20;
    }
    @Override
    public Map<Ingredient, Integer> getRequiredIngredients() {
        Map<Ingredient, Integer> ingredients = new HashMap<>();
        ingredients.put(Ingredient.DOUGH, 1);
        ingredients.put(Ingredient.GROUND_BEEF, 80);
        ingredients.put(Ingredient.ONION, 4);
        ingredients.put(Ingredient.TOMATO, 4);
        ingredients.put(Ingredient.PEPPER, 2);
        ingredients.put(Ingredient.CHEESE, 2);
        return ingredients;
    }
    @Override
    public String getProcessorType() {
        return "OVEN";
    }
}