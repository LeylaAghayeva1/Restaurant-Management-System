package engine;
import model.menu.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class OrderGenerator {
    private final List<MenuItem> menuItems;
    private final Random random;
    public OrderGenerator() {
        menuItems = new ArrayList<>();
        random = new Random();
        menuItems.add(new CheesePizza());
        menuItems.add(new PepperoniPizza());
        menuItems.add(new BarbecuePizza());
        menuItems.add(new ChickenPizza());
        menuItems.add(new MeatPizza());
        menuItems.add(new MargheritaPizza());
        menuItems.add(new ChickenBurger());
        menuItems.add(new MeatBurger());
        menuItems.add(new Shawarma());
        menuItems.add(new CaesarRoll());
        menuItems.add(new Fries());
        menuItems.add(new Nuggets_4());
        menuItems.add(new Nuggets_8());        
        menuItems.add(new Lahmacun());
        menuItems.add(new CheeseLahmacun());
        menuItems.add(new Cola());
        menuItems.add(new Sprite());
        menuItems.add(new Fanta());
        menuItems.add(new Water());
        menuItems.add(new Ketchup());
        menuItems.add(new Mayo());
    }
    public MenuItem getRandomItem() {
        int index = random.nextInt(menuItems.size());
        return menuItems.get(index);
    }
}