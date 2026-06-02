package persistence;
import model.inventory.Ingredient;
import model.menu.MenuItem;
import model.order.Order;
import model.order.OrderStatus;
import java.io.*;
import java.util.*;
public class StateManager {
    public static void save(String file,
                            Map<Ingredient, Integer> stock,
                            double money,
                            Queue<Order> queue) {
        if (file == null || file.isBlank()) {
            throw new IllegalArgumentException("File name cannot be empty.");
        }
        if (stock == null) {
            throw new IllegalArgumentException("Stock cannot be null.");
        }
        if (queue == null) {
            throw new IllegalArgumentException("Queue cannot be null.");
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write("MONEY=" + money);
            bw.newLine();
            bw.write("STOCK");
            bw.newLine();
            for (Map.Entry<Ingredient, Integer> entry : stock.entrySet()) {
                Ingredient ingredient = entry.getKey();
                Integer quantity = entry.getValue();
                if (ingredient != null && quantity != null) {
                    bw.write(ingredient.name() + ":" + quantity);
                    bw.newLine();
                }
            }
            bw.write("QUEUE");
            bw.newLine();
            for (Order order : queue) {
                if (order == null || order.getItem() == null) {
                    continue;
                }
                bw.write(order.getItem().getName()
                        + "|" + order.getStatus().name()
                        + "|" + order.getId()
                        + "|" + order.getCreatedAt());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Save error: " + e.getMessage());
        }
    }
    public static LoadedState load(String file) {
        if (file == null || file.isBlank()) {
            throw new IllegalArgumentException("File name cannot be empty.");
        }
        Map<Ingredient, Integer> stock = new HashMap<>();
        Queue<Order> queue = new ArrayDeque<>();
        double money = 0;
        boolean stockMode = false;
        boolean queueMode = false;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                if (line.startsWith("MONEY=")) {
                    money = Double.parseDouble(line.substring("MONEY=".length()));
                    continue;
                }
                if (line.equals("STOCK")) {
                    stockMode = true;
                    queueMode = false;
                    continue;
                }
                if (line.equals("QUEUE")) {
                    queueMode = true;
                    stockMode = false;
                    continue;
                }
                if (stockMode) {
                    loadStockLine(line, stock);
                } else if (queueMode) {
                    Order order = loadOrderLine(line);
                    queue.add(order);
                }
            }
        } catch (Exception e) {
            System.out.println("Load error: " + e.getMessage());
        }
        return new LoadedState(stock, money, queue);
    }
    private static void loadStockLine(String line, Map<Ingredient, Integer> stock) {
        String[] parts = line.split(":");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid stock line: " + line);
        }
        Ingredient ingredient = Ingredient.valueOf(parts[0]);
        int quantity = Integer.parseInt(parts[1]);
        if (quantity < 0) {
            throw new IllegalArgumentException("Stock quantity cannot be negative: " + line);
        }
        stock.put(ingredient, quantity);
    }
    private static Order loadOrderLine(String line) {
        String[] parts = line.split("\\|");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Invalid queue line: " + line);
        }
        String itemName = parts[0];
        OrderStatus status = OrderStatus.valueOf(parts[1]);
        int id = Integer.parseInt(parts[2]);
        long createdAt = Long.parseLong(parts[3]);
        MenuItem item = MenuFactory.create(itemName);
        return new Order(id, item, status, createdAt);
    }
    public static class LoadedState {
        private final Map<Ingredient, Integer> stock;
        private final double money;
        private final Queue<Order> queue;
        public LoadedState(Map<Ingredient, Integer> stock,
                           double money,
                           Queue<Order> queue) {
            this.stock = stock;
            this.money = money;
            this.queue = queue;
        }
        public Map<Ingredient, Integer> getStock() {
            return stock;
        }
        public double getMoney() {
            return money;
        }
        public Queue<Order> getQueue() {
            return queue;
        }
    }
}