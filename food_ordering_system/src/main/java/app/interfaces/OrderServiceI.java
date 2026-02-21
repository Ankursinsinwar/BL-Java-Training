package app.interfaces;

import java.util.List;
import java.util.Map;

import app.model.FoodItem;
import app.model.Order;
import app.model.User;

public interface OrderServiceI {
    
    public Order<? extends FoodItem> placeOrder(User user, List<? extends FoodItem> items);

    public void cancelOrder(User user,int orderId);

    Map<String, List<Order<? extends FoodItem>>> getAllOrders();

    public void OrderSlip();

}
