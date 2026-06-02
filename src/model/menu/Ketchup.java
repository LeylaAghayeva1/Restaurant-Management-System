package model.menu;
import model.inventory.*;
import java.util.*;
public class Ketchup extends MenuItem{
    public Ketchup(){
        this.name = "Ketchup";
        this.price = 1;
    }
    @Override
    public Map<Ingredient, Integer> getRequiredIngredients() {
        Map<Ingredient, Integer> ingredients = new HashMap<>();
        ingredients.put(Ingredient.KETCHUP, 30);
        ingredients.put(Ingredient.SAUCE_BOWL, 1);
        return ingredients;
    }
    @Override
    public String getProcessorType() {
        return "SAUCE";
    }
}
