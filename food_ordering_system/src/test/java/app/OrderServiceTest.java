package app;

import app.exception.InvalidOrderException;
import app.exception.InvalidUserException;
import app.interfaces.OrderServiceI;
import app.model.FoodItem;
import app.model.User;
import org.junit.jupiter.api.*;

import app.service.OrderService;
import app.validation.Validation;

import java.util.Arrays;
import java.util.Collections;

@DisplayName("Test Cases for Food Ordering System 🍕 ")
public class OrderServiceTest {

    // Add an order
@DisplayName("Should successfuly add valid user and valid placed order ✅")
@Test
    void PlaceOrderTest() {
        OrderServiceI service = new OrderService();
        User user = new User("Test", "test@gmail.com", "9876543210");

        FoodItem pizza = new FoodItem("Pizza", 200);

        Assertions.assertDoesNotThrow(() -> service.placeOrder(user, Arrays.asList(pizza)));
    }


    @SuppressWarnings("unused")
    @Test
    void mainnTest() {
        Main m = new Main();
        Validation v = new Validation();

        Main.main(null);
    }

    // Invalid email
    @Test
    @DisplayName("Should successfuly validate user Email ✅")
    void invalidEmailTest() {
        OrderServiceI service = new OrderService();
        User user = new User("Test", "wrong-email", "9876543210");

        FoodItem burger = new FoodItem("Burger", 100);

        Assertions.assertThrows(
                InvalidUserException.class,
                () -> service.placeOrder(user, Arrays.asList(burger))
        );
    }

    // Invalid Phone no.
    @Test
        @DisplayName("Should successfuly validate user Phone ✅")
    void invalidPhoneNoTest() {
        OrderServiceI service = new OrderService();
        User user = new User("Test", "test@gmail.com", "2876543210");

        FoodItem burger = new FoodItem("Burger", 100);

        Assertions.assertThrows(
                InvalidUserException.class,
                () -> service.placeOrder(user, Arrays.asList(burger))
        );
    }

    // Empty order list
    @Test
    @DisplayName("Should successfuly validate Orderlist ✅")
    void emptyOrderTest() {
        OrderServiceI service = new OrderService();
        User user = new User("Test", "test@gmail.com", "9876543210");

        Assertions.assertThrows(
                InvalidOrderException.class,
                () -> service.placeOrder(user, Collections.emptyList())
        );
    }

    @Test
    @DisplayName("Should successfuly validate Orderlist ✅")
    void nullOrderTest() {
        OrderServiceI service = new OrderService();
        User user = new User("Test", "test@gmail.com", "9876543210");

        Assertions.assertThrows(
                InvalidOrderException.class,
                () -> service.placeOrder(user, null)
        );
    }

    // Cancle order
    @Test
    @DisplayName("Should successfuly cancle last placed order ✅")
    void cancelLastOrderTest() {
        OrderServiceI service = new OrderService();
        User user = new User("Ankur", "ankur@gmail.com", "9876543210");

        FoodItem pizza = new FoodItem("Pizza", 200);
        
        service.placeOrder(user, Arrays.asList(pizza));
        service.OrderSlip();
        // service.cancelOrder(user,4);
        service.cancelOrder(user,1);
        
        Assertions.assertEquals(0, service.getAllOrders().size());
        
    }
    
    
    @Test
    @DisplayName("Should successfuly cancle placed order ✅")
    void cancelOrderTest() {
        OrderServiceI service = new OrderService();
        User user = new User("Ankur", "ankur@gmail.com", "9876543210");

        FoodItem pizza = new FoodItem("Pizza", 200);
        FoodItem burger = new FoodItem("Burger", 100);

        service.placeOrder(user, Arrays.asList(pizza));
        service.placeOrder(user, Arrays.asList(burger));
        service.OrderSlip();
        service.cancelOrder(user,2);
        // service.cancelOrder(user,1);

        Assertions.assertEquals(1, service.getAllOrders().size());

    }

    @Test
    @DisplayName("Should successfuly Threw Invalid User Exception on canceling order ✅")
    void cancelOrderInvalidUserTest() {
        OrderServiceI service = new OrderService();
        User user = new User("Ankur", "ankur@gmail.com", "9876543210");
        User Invaliduser = new User("Ankur", "ankur2@gmail.com", "9876543210");

        FoodItem pizza = new FoodItem("Pizza", 200);

        service.placeOrder(user, Arrays.asList(pizza));
        service.cancelOrder(user,1);

        Assertions.assertThrows(
                InvalidUserException.class,
                () -> service.cancelOrder(Invaliduser,1)
        );

    }
}
