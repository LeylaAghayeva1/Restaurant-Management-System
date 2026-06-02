package model.menu;
import model.inventory.*;
import java.util.*;
public class Fries extends MenuItem{
    public Fries(){
        this.name = "Fries";
        this.price = 3;
    }
    @Override
    public Map<Ingredient, Integer> getRequiredIngredients() {
        Map<Ingredient, Integer> ingredients = new HashMap<>();
        ingredients.put(Ingredient.POTATO, 2);
        return ingredients;
    }
    @Override
    public String getProcessorType() {
        return "FRYER";
    }
}
