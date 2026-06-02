package model.order;
import model.menu.MenuItem;
public class Order {
    private static int nextId = 1;
    private final int id;
    private final MenuItem item;
    private OrderStatus status;
    private final long createdAt;
    private final long maxWaitTimeMillis;
    public Order(MenuItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Menu item cannot be null.");
        }
        this.id = nextId++;
        this.item = item;
        this.status = OrderStatus.PENDING;
        this.createdAt = System.currentTimeMillis();
        this.maxWaitTimeMillis = 15000;
    }
    public Order(int id, MenuItem item, OrderStatus status, long createdAt) {
        if (item == null) {
            throw new IllegalArgumentException("Menu item cannot be null.");
        }
        if (status == null) {
            throw new IllegalArgumentException("Order status cannot be null.");
        }
        if (id <= 0) {
            throw new IllegalArgumentException("Order id must be positive.");
        }
        if (createdAt < 0) {
            throw new IllegalArgumentException("Created time cannot be negative.");
        }
        this.id = id;
        this.item = item;
        this.status = status;
        this.createdAt = createdAt;
        this.maxWaitTimeMillis = 15000;
        if (id >= nextId) {
            nextId = id + 1;
        }
    }
    public int getId() {
        return id;
    }
    public MenuItem getItem() {
        return item;
    }
    public OrderStatus getStatus() {
        return status;
    }
    public void setStatus(OrderStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("Order status cannot be null.");
        }
        this.status = status;
    }
    public long getCreatedAt() {
        return createdAt;
    }
    public long getMaxWaitTimeMillis() {
        return maxWaitTimeMillis;
    }
    public boolean isExpired() {
        long currentTime = System.currentTimeMillis();
        return currentTime - createdAt > maxWaitTimeMillis;
    }
    @Override
    public String toString() {
        return "Order #" + id + " - " + item.getName() + " [" + status + "]";
    }
}