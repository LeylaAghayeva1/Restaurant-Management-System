package model.menu;
import model.inventory.*;
import java.util.*;
public class Nuggets_4 extends MenuItem{
    public Nuggets_4(){
        this.name = "Nuggets (4 pieces)";
        this.price = 5;
    }
    @Override
    public Map<Ingredient, Integer> getRequiredIngredients() {
        Map<Ingredient, Integer> ingredients = new HashMap<>();
        ingredients.put(Ingredient.FROZEN_NUGGETS, 4);
        return ingredients;
    }
    @Override
    public String getProcessorType() {
        return "FRYER";
    }
}
