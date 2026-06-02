package model.order;
import java.util.*;
public class OrderQueueManager {
    private final Queue<Order> orderQueue;
    public OrderQueueManager() {
        this.orderQueue = new LinkedList<>();
    }
    public void addOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        orderQueue.add(order);
    }
    public Order peekNextOrder() {
        return orderQueue.peek();
    }
    public Order pollNextOrder() {
        return orderQueue.poll();
    }
    public boolean isEmpty() {
        return orderQueue.isEmpty();
    }
    public int size() {
        return orderQueue.size();
    }
    public List<Order> getQueueSnapshot() {
        return new ArrayList<>(orderQueue);
    }
    public void restoreQueue(List<Order> orders) {
        orderQueue.clear();
        if (orders == null) {
            return;
        }
        for (Order order : orders) {
            if (order != null) {
                orderQueue.add(order);
            }
        }
    }
}