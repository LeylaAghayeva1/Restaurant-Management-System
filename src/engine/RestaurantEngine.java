package engine;
import model.appliance.*;
import model.inventory.Ingredient;
import model.inventory.InventoryManager;
import model.log.LogManager;
import model.menu.MenuItem;
import model.order.*;
import javax.swing.SwingWorker;
import java.util.*;
public class RestaurantEngine {
    private final OrderQueueManager orderManager;
    private final InventoryManager inventory;
    private final OrderGenerator generator;
    private final List<IAppliance> appliances;
    private javax.swing.Timer timer;
    public RestaurantEngine() {
        orderManager = new OrderQueueManager();
        inventory = new InventoryManager(1000);
        inventory.initializeDefaultStock();
        generator = new OrderGenerator();
        appliances = new ArrayList<>();
        appliances.add(new Oven());
        appliances.add(new Fryer());
        appliances.add(new Grill());
        appliances.add(new DrinkDispenser());
        appliances.add(new PrepStation());
        appliances.add(new SauceDispenser());
    }
    public void start(Runnable refreshAction) {
        timer = new javax.swing.Timer(3000, e -> {
            generateOrder();
            refreshAction.run();
        });
        timer.start();
    }
    public void stop() {
        if (timer != null) {
            timer.stop();
        }
    }
    public void generateOrder() {
        MenuItem item = generator.getRandomItem();
        Order order = new Order(item);
        orderManager.addOrder(order);
        LogManager.log("[NEW ORDER] " + order);
    }
    public void processNextOrder(Runnable refreshAction) {
        Order order = orderManager.peekNextOrder();
        if (order == null) {
            LogManager.log("[INFO] Queue is empty");
            refreshAction.run();
            return;
        }
        MenuItem item = order.getItem();
        HashMap<Ingredient, Integer> requiredIngredients = new HashMap<>(item.getRequiredIngredients());
        if (!inventory.hasEnough(requiredIngredients)) {
            order.setStatus(OrderStatus.FAILED);
            LogManager.log("[FAILED] Not enough ingredients for " + item.getName());
            refreshAction.run();
            return;
        }
        orderManager.pollNextOrder();
        if (!inventory.consume(requiredIngredients)) {
            order.setStatus(OrderStatus.FAILED);
            LogManager.log("[FAILED] Could not consume ingredients for " + item.getName());
            refreshAction.run();
            return;
        }
        order.setStatus(OrderStatus.COOKING);
        LogManager.log("[COOKING] " + item.getName());
        refreshAction.run();
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                boolean processed = false;
                for (IAppliance appliance : appliances) {
                    if (appliance.canProcess(item)) {
                        appliance.process(item);
                        processed = true;
                        break;
                    }
                }
                if (!processed) {
                    order.setStatus(OrderStatus.FAILED);
                    LogManager.log("[ERROR] No appliance found for " + item.getName());
                    refundIngredients(requiredIngredients);
                    return null;
                }
                inventory.addMoney(item.getPrice());
                order.setStatus(OrderStatus.COMPLETED);
                LogManager.log("[DONE] " + item.getName() + " | Money +" + item.getPrice());
                return null;
            }
            @Override
            protected void done() {
                refreshAction.run();
            }
        }.execute();
    }
    private void refundIngredients(HashMap<Ingredient, Integer> ingredients) {
        for (Ingredient ingredient : ingredients.keySet()) {
            int amount = ingredients.get(ingredient);
            inventory.restock(ingredient, amount, 0);
        }
    }
    public List<Order> getOrders() {
        return orderManager.getQueueSnapshot();
    }
    public InventoryManager getInventory() {
        return inventory;
    }
    public Queue<Order> getQueue() {
        return new LinkedList<>(orderManager.getQueueSnapshot());
    }
    public void restoreQueue(Queue<Order> queue) {
        orderManager.restoreQueue(new ArrayList<>(queue));
    }
}