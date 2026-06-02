package model.menu;
import model.inventory.*;
import java.util.*;
public class Fanta extends MenuItem {
    public Fanta() {
        this.name = "Fanta";
        this.price = 3.00;
    }
    @Override
    public Map<Ingredient, Integer> getRequiredIngredients() {
        Map<Ingredient, Integer> ingredients = new HashMap<>();
        ingredients.put(Ingredient.FANTA_SYRUP, 30);
        ingredients.put(Ingredient.ICE_CUBES, 2);
        ingredients.put(Ingredient.CUP, 1);
        return ingredients;
    }
    @Override
    public String getProcessorType() {
        return "DRINK";
    }
}