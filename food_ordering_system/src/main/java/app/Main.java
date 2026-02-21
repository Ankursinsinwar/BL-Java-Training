package app;

import java.util.Arrays;

import app.exception.InvalidOrderException;
import app.exception.InvalidUserException;
import app.interfaces.OrderServiceI;
import app.model.FoodItem;
import app.model.User;
import app.service.OrderService;

public class Main {
    public static void main(String[] args) {
        OrderServiceI service = new OrderService();
        try {

            User user1 = new User(
                    "Ankur",
                    "ankur@gmail.com",
                    "9876543210");
            User user2 = new User(
                    "David",
                    "david@gmail.com",
                    "9012345678");

            FoodItem pizza = new FoodItem("Pizza", 110);
            FoodItem burger = new FoodItem("Burger", 65);

            service.placeOrder(user1, Arrays.asList(pizza));
            service.placeOrder(user1, Arrays.asList(burger));
            service.placeOrder(user2, Arrays.asList(pizza, burger));

            service.OrderSlip();

            service.cancelOrder(user2, 3);
            service.cancelOrder(user1, 3);

        } catch (InvalidUserException | InvalidOrderException e) {
            System.err.println(e.getMessage());
        } finally {
            service.OrderSlip();
        }
    }
}