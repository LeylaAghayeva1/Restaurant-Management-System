package model.menu;
import java.util.*;
import model.inventory.*;
public class Mayo extends MenuItem{
    public Mayo(){
        this.name = "Mayo";
        this.price = 1;
    }
    @Override
    public Map<Ingredient, Integer> getRequiredIngredients() {
        Map<Ingredient, Integer> ingredients = new HashMap<>();
        ingredients.put(Ingredient.MAYO, 30);
        ingredients.put(Ingredient.SAUCE_BOWL, 1);
        return ingredients;
    }
    @Override
    public String getProcessorType() {
        return "SAUCE";
    }
}
