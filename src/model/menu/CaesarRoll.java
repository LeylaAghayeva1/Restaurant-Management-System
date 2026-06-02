package model.menu;
import model.inventory.*;
import java.util.*;
public class CaesarRoll extends MenuItem {
    public CaesarRoll() {
        this.name = "Caesar Roll";
        this.price = 8.50;
    }
    @Override
    public Map<Ingredient, Integer> getRequiredIngredients() {
        Map<Ingredient, Integer> ingredients = new HashMap<>();
        ingredients.put(Ingredient.DOUGH, 1);
        ingredients.put(Ingredient.BREAST, 1);
        ingredients.put(Ingredient.LETTUCE, 2);
        ingredients.put(Ingredient.CHEESE, 1);
        ingredients.put(Ingredient.MAYO, 20);
        ingredients.put(Ingredient.GARLIC, 1);
        return ingredients;
    }
    @Override
    public String getProcessorType() {
        return "PREP";
    }
}