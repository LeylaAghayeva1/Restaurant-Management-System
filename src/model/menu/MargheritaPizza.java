package model.menu;
import model.inventory.*;
import java.util.*;
public class MargheritaPizza extends MenuItem {
    public MargheritaPizza() {
        this.name = "Margherita Pizza";
        this.price = 10;
    }
    @Override
    public Map<Ingredient, Integer> getRequiredIngredients() {
        Map<Ingredient, Integer> ingredients = new HashMap<>();
        ingredients.put(Ingredient.DOUGH, 1);
        ingredients.put(Ingredient.PIZZA_SAUCE, 40);
        ingredients.put(Ingredient.TOMATO, 8);
        ingredients.put(Ingredient.CHEESE, 3);
        ingredients.put(Ingredient.PIZZA_BOX, 1);
        return ingredients;
    }
    @Override
    public String getProcessorType() {
        return "OVEN";
    }
}
