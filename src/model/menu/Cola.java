package model.menu;
import model.inventory.*;
import java.util.*;
public class Cola extends MenuItem {
    public Cola() {
        this.name = "Cola";
        this.price = 3.00;
    }
    @Override
    public Map<Ingredient, Integer> getRequiredIngredients() {
        Map<Ingredient, Integer> ingredients = new HashMap<>();
        ingredients.put(Ingredient.COLA_SYRUP, 30);
        ingredients.put(Ingredient.ICE_CUBES, 2);
        ingredients.put(Ingredient.CUP, 1);
        return ingredients;
    }
    @Override
    public String getProcessorType() {
        return "DRINK";
    }
}