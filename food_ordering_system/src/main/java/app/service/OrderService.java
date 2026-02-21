package app.service;

import app.annotation.OrderValidation;
import app.exception.InvalidOrderException;
import app.exception.InvalidUserException;
import app.interfaces.OrderServiceI;
import app.model.*;
import app.validation.Validation;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderService implements OrderServiceI {

    private Map<String, List<Order<? extends FoodItem>>> orders = new LinkedHashMap<>();
    // private Stack<Order<? extends FoodItem>> undoStack = new Stack<>();
    private AtomicInteger orderIdCounter = new AtomicInteger(1);

    @Override
    @OrderValidation
    public Order<? extends FoodItem> placeOrder(User user, List<? extends FoodItem> items) {

        if (!Validation.isValidEmail(user.getEmail())) {
            throw new InvalidUserException("Invalid email");
        }

        if (!Validation.isValidPhone(user.getPhone())) {
            throw new InvalidUserException("Invalid phone number");
        }

        if (items == null || items.isEmpty()) {
            throw new InvalidOrderException("Order must contain items");
        }

        Order<? extends FoodItem> order = new Order<>(orderIdCounter.getAndIncrement(), user, items);

        orders
                .computeIfAbsent(user.getEmail(), k -> new ArrayList<>())
                .add(order);

        // undoStack.push(order);

        return order;
    }

    @Override
    public void cancelOrder(User user, int orderId) {
        if (!orders.containsKey(user.getEmail())) {
            throw new InvalidUserException("Order for user " + user.getName() + " not found");
        }
        String email = user.getEmail();
        List<Order<? extends FoodItem>> userOrders = orders.get(email);

        // if (userOrders == null || userOrders.isEmpty()) {
        //     System.out.println("No orders found for user");
        //     return;
        // }

        Order<? extends FoodItem> orderToCancel = null;

        for (Order<? extends FoodItem> o : userOrders) {
            if (o.getOrderId() == orderId) {
                orderToCancel = o;
                break;
            }
        }
        if (orderToCancel == null) {
            // System.out.println("Order ID not found for  user " + user.getName());
            throw new InvalidOrderException("Order not found for user " + user.getName());
            // return;
        }
        userOrders.remove(orderToCancel);

        if (userOrders.isEmpty()) {
            orders.remove(email);
        }

        System.out.println(user.getName() + "'s Order [Order id: " + orderToCancel.getOrderId() + "] cancelled ");
    }

    @Override
    public Map<String, List<Order<? extends FoodItem>>> getAllOrders() {
        return orders;
    }

    @Override
    public void OrderSlip() {

        for (List<Order<? extends FoodItem>> userOrders : orders.values()) {
            printUserOrders(userOrders);
        }
    }

    private void printUserOrders(List<Order<? extends FoodItem>> orders) {

        User user = orders.get(0).getUser();

        System.out.println("\n=================================");
        System.out.printf("|%-32s|\n", " User: " + user.getName());
        System.out.printf("|%-32s|\n", " Email: " + user.getEmail());
        System.out.println("=================================");

        for (Order<? extends FoodItem> o : orders) {

            System.out.println("---------------------------------");
            System.out.printf("|%-26s|\n", " Order ID: " + o.getOrderId());
            System.out.println("---------------------------------");
            
            for (FoodItem i : o.getItems()) {
                System.out.printf("| %-15s | %-6s |\n", i.getName(), i.getPrice());
            }
            
            System.out.printf("| %-15s | %-6s |\n", "---------------", "------");
            System.out.printf("| %-15s | %-6s |\n", "Total", o.getTotalAmount());
        }
        System.out.println("---------------------------------");
    }
}
