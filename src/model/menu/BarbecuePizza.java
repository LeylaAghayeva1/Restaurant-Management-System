package model.menu;
import model.inventory.*;
import java.util.*;
public class BarbecuePizza extends MenuItem {
    public BarbecuePizza() {
        this.name = "Barbecue Pizza";
        this.price = 13.00;
    }
    @Override
    public Map<Ingredient, Integer> getRequiredIngredients() {
        Map<Ingredient, Integer> ingredients = new HashMap<>();
        ingredients.put(Ingredient.DOUGH, 1);
        ingredients.put(Ingredient.CHEESE, 2);
        ingredients.put(Ingredient.BREAST, 1);
        ingredients.put(Ingredient.ONION, 4);
        ingredients.put(Ingredient.PEPPER, 4);
        ingredients.put(Ingredient.BARBECUE_SAUCE, 40);
        ingredients.put(Ingredient.PIZZA_BOX, 1);
        return ingredients;
    }
    @Override
    public String getProcessorType() {
        return "OVEN";
    }
}