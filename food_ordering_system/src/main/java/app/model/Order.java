package app.model;

import java.util.List;

public class Order<T extends FoodItem> {
    private int orderId;
    @SuppressWarnings("unused")
    private User user;
    private List<T> items;

    public Order(int orderId, User user, List<T> items) {
        this.orderId = orderId;
        this.user = user;
        this.items = items;
    }

    public double getTotalAmount() {
        return items.stream().mapToDouble(FoodItem::getPrice).sum();
    }

    public int getOrderId() {
        return orderId;
    }

    public List<T> getItems() {
        return items;
    }

    public User getUser() {
        return user;
    }
}