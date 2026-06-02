package model.menu;
import model.inventory.*;
import java.util.*;
public class Water extends MenuItem {
    public Water() {
        this.name = "Water";
        this.price = 2.00;
    }
    @Override
    public Map<Ingredient, Integer> getRequiredIngredients() {
        Map<Ingredient, Integer> ingredients = new HashMap<>();
        ingredients.put(Ingredient.WATER, 300);
        ingredients.put(Ingredient.ICE_CUBES, 2);
        ingredients.put(Ingredient.CUP, 1);
        return ingredients;
    }
    @Override
    public String getProcessorType() {
        return "DRINK";
    }
}