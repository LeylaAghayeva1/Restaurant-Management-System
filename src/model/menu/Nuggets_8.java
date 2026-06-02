package model.menu;
import model.inventory.*;
import java.util.*;
public class Nuggets_8 extends MenuItem{
    public Nuggets_8(){
        this.name = "Nuggets (8 pieces)";
        this.price = 10;
    }
    @Override
    public Map<Ingredient, Integer> getRequiredIngredients() {
        Map<Ingredient, Integer> ingredients = new HashMap<>();
        ingredients.put(Ingredient.FROZEN_NUGGETS, 8);
        return ingredients;
    }
    @Override
    public String getProcessorType() {
        return "FRYER";
    }
}
