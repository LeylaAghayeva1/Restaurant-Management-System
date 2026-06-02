package model.menu;
import java.util.*;
import model.inventory.*;
public class Lahmacun extends MenuItem{
    public Lahmacun(){
        this.name = "Lahmacun";
        this.price = 15;
    }
    @Override
    public Map<Ingredient, Integer> getRequiredIngredients() {
        Map<Ingredient, Integer> ingredients = new HashMap<>();
        ingredients.put(Ingredient.DOUGH, 1);
        ingredients.put(Ingredient.GROUND_BEEF, 80);
        ingredients.put(Ingredient.ONION, 4);
        ingredients.put(Ingredient.TOMATO, 4);
        ingredients.put(Ingredient.PEPPER, 2);
        return ingredients;
    }
    @Override
    public String getProcessorType() {
        return "OVEN";
    }
}
