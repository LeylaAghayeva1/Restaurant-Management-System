package model.inventory;
import java.util.*;
public final class IngredientRegistry {
    private static final Map<Ingredient, IngredientInfo> INFO_MAP = new HashMap<>();
    static {
        INFO_MAP.put(Ingredient.PEPPERONI,
                new IngredientInfo("Pepperoni", "slices", 100, 20.0));

        INFO_MAP.put(Ingredient.GROUND_BEEF,
                new IngredientInfo("Ground Beef", "gr", 1000, 18.0));

        INFO_MAP.put(Ingredient.BREAST,
                new IngredientInfo("Chicken Breast", "fillets", 10, 22.0));

        INFO_MAP.put(Ingredient.FROZEN_NUGGETS,
                new IngredientInfo("Frozen Nuggets", "pcs", 20, 12.0));

        INFO_MAP.put(Ingredient.CHEESE,
                new IngredientInfo("Cheese", "slices", 20, 15.0));

        INFO_MAP.put(Ingredient.LETTUCE,
                new IngredientInfo("Lettuce", "portions", 20, 5.0));

        INFO_MAP.put(Ingredient.TOMATO,
                new IngredientInfo("Tomato", "slices", 20, 7.0));

        INFO_MAP.put(Ingredient.ONION,
                new IngredientInfo("Onion", "portions", 20, 6.0));

        INFO_MAP.put(Ingredient.MUSHROOM,
                new IngredientInfo("Mushroom", "portions", 20, 9.0));

        INFO_MAP.put(Ingredient.PICKLE,
                new IngredientInfo("Pickle", "slices", 60, 4.0));

        INFO_MAP.put(Ingredient.GARLIC,
                new IngredientInfo("Garlic", "cloves", 20, 2.0));

        INFO_MAP.put(Ingredient.KETCHUP,
                new IngredientInfo("Ketchup", "ml", 500, 8.0));

        INFO_MAP.put(Ingredient.MAYO,
                new IngredientInfo("Mayo", "ml", 500, 8.0));

        INFO_MAP.put(Ingredient.PIZZA_SAUCE,
                new IngredientInfo("Pizza Sauce", "ml", 500, 10.0));

        INFO_MAP.put(Ingredient.BARBECUE_SAUCE,
                new IngredientInfo("Barbecue Sauce", "ml", 500, 12.0));

        INFO_MAP.put(Ingredient.POTATO,
                new IngredientInfo("Potato", "portions", 40, 8.0));

        INFO_MAP.put(Ingredient.BUN,
                new IngredientInfo("Bun", "pcs", 50, 9.0));

        INFO_MAP.put(Ingredient.DOUGH,
                new IngredientInfo("Dough", "portions", 50, 14.0));

        INFO_MAP.put(Ingredient.COLA_SYRUP,
                new IngredientInfo("Cola Syrup", "ml", 3000, 25.0));

        INFO_MAP.put(Ingredient.SPRITE_SYRUP,
                new IngredientInfo("Sprite Syrup", "ml", 3000, 25.0));

        INFO_MAP.put(Ingredient.FANTA_SYRUP,
                new IngredientInfo("Fanta Syrup", "ml", 3000, 25.0));

        INFO_MAP.put(Ingredient.WATER,
                new IngredientInfo("Water", "ml", 5000, 4.0));

        INFO_MAP.put(Ingredient.ICE_CUBES,
                new IngredientInfo("Ice Cubes", "pcs", 50, 3.0));

        INFO_MAP.put(Ingredient.PIZZA_BOX,
                new IngredientInfo("Pizza Box", "pcs", 50, 7.0));

        INFO_MAP.put(Ingredient.CUP,
                new IngredientInfo("Cup", "pcs", 100, 6.0));

        INFO_MAP.put(Ingredient.SAUCE_BOWL,
                new IngredientInfo("Sauce Bowl", "pcs", 50, 5.0));

        INFO_MAP.put(Ingredient.PEPPER,
                new IngredientInfo("Pepper", "portions", 20, 4.0));
    }
    private IngredientRegistry() {
    }
    public static IngredientInfo getInfo(Ingredient ingredient) {
        return INFO_MAP.get(ingredient);
    }
    public static Map<Ingredient, IngredientInfo> getAllInfo() {
    return new HashMap<>(INFO_MAP); //return the copy of the map to prevent external modification
    }
}