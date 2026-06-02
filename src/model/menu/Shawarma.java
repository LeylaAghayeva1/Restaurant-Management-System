package model.menu;
import model.inventory.*;
import java.util.*;
public class Shawarma extends MenuItem{
    public Shawarma(){
        this.name = "Shawarma";
        this.price = 7;
    }    
    @Override
    public Map<Ingredient, Integer> getRequiredIngredients() {
        Map<Ingredient, Integer> ingredients = new HashMap<>();
        ingredients.put(Ingredient.DOUGH, 1);
        ingredients.put(Ingredient.BREAST, 1);
        ingredients.put(Ingredient.TOMATO, 2);
        ingredients.put(Ingredient.PICKLE, 3);
        ingredients.put(Ingredient.MAYO, 20);
        ingredients.put(Ingredient.GARLIC, 1);
        ingredients.put(Ingredient.POTATO, 1);
        return ingredients;
    }
    @Override
    public String getProcessorType() {
        return "PREP";
    }
}
