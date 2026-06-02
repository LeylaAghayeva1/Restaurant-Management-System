package persistence;
import model.menu.*;
public class MenuFactory {
    public static MenuItem create(String name) {
        if (name == null) return null;
        return switch (name) {
            case "Margherita Pizza" -> new MargheritaPizza();
            case "Pepperoni Pizza" -> new PepperoniPizza();
            case "Barbecue Pizza" -> new BarbecuePizza();
            case "Cheese Pizza" -> new CheesePizza();
            case "Chicken Pizza" -> new ChickenPizza();
            case "Meat Pizza" -> new MeatPizza();
            case "Chicken Burger" -> new ChickenBurger();
            case "Meat Burger" -> new MeatBurger();
            case "Shawarma" -> new Shawarma();
            case "Caesar Roll" -> new CaesarRoll();
            case "Fries" -> new Fries();
            case "Nuggets (4 pieces)" -> new Nuggets_4();
            case "Nuggets (8 pieces)" -> new Nuggets_8();
            case "Lahmacun" -> new Lahmacun();
            case "Cheese Lahmacun" -> new CheeseLahmacun();
            case "Cola" -> new Cola();
            case "Sprite" -> new Sprite();
            case "Fanta" -> new Fanta();
            case "Water" -> new Water();
            case "Ketchup" -> new Ketchup();
            case "Mayo" -> new Mayo();
            default -> throw new IllegalArgumentException("Unknown menu item: " + name);
        };
    }
}