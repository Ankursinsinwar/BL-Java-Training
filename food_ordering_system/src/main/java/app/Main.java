package app;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

import app.exception.InvalidOrderException;
import app.exception.InvalidUserException;
import app.interfaces.OrderServiceI;
import app.model.FoodItem;
import app.model.User;
import app.service.OrderService;

public class Main {
	
    public static void main(String[] args) {
        OrderServiceI service = new OrderService();
        Scanner input = new Scanner(System.in);
        boolean condition = true;
        ArrayList<User> users = new ArrayList<>();
        try {
        while(condition) {
        	System.out.print("Enter User Name: ");
            String name = input.nextLine();
            System.out.print("Enter User Email: ");
            String email = input.nextLine();
            // System.out.println("Enter the minimum checkout digit ");
            System.out.print("Enter User Phone No.: ");
            String phone = input.nextLine();
            User user = new User(name, email, phone);
            users.add(user);
            System.out.print("Enter no. of orders: ");
            int ordersNo = input.nextInt();
            for (int i = 0; i < ordersNo; i++) {
            	ArrayList<FoodItem> foodlist = new ArrayList<>();
                System.out.print("Enter No. of food items: ");
                int foodNo = input.nextInt();
                for (int j = 0; j < foodNo; j++) {
                    System.out.print("Enter of food name: ");
                    input.nextLine();
                    String foodName = input.nextLine();
                    System.out.print("Enter of food price: ");
                    double foodPrice = input.nextDouble();
                    FoodItem f = new FoodItem(foodName, foodPrice);
                    foodlist.add(f);
                service.placeOrder(user, foodlist);
                }
            }
            System.out.print("Add another User (y/n): ");
            input.nextLine();
            String yn = input.nextLine();
            
            if (!yn.toLowerCase().equals("y")) {
				condition = false;
			}
        }
        
        condition = true;
        while(condition) {
        	
        	System.out.print(" print particular user slip[1]| print full slip[2] for exit[not 1,2]: ");
        	int slip = input.nextInt();
        	if(slip == 1) {
        		System.out.print("Enter User: ");
        		input.nextLine();
        		String username = input.nextLine();
        		User u = users.stream().filter(x -> x.getName().equals(username)).findFirst().orElse(null);
        		if (u == null) {
					System.out.println("User not found! ");
				}else {
					service.OrderSlip(u);					
				}
        }else if (slip == 2) {
        	service.OrderSlip();
		}else
			condition = false;
        }
        }catch (InvalidUserException | InvalidOrderException e) {
          System.err.println(e.getMessage());
        }
        input.close();        	
        
        
        
//        
//        try {
//
//            User user1 = new User(
//                    "Ankur",
//                    "ankur@gmail.com",
//                    "9876543210");
//            User user2 = new User(
//                    "David",
//                    "david@gmail.com",
//                    "9012345678");
//            
//
//            FoodItem pizza = new FoodItem("Pizza", 110);
//            FoodItem burger = new FoodItem("Burger", 65);
//
//            service.placeOrder(user1, Arrays.asList(pizza));
//            service.placeOrder(user1, Arrays.asList(burger));
//            service.placeOrder(user2, Arrays.asList(pizza, burger));
//
//            service.OrderSlip();
//
//            service.cancelOrder(user2, 3);
//            service.cancelOrder(user1, 3);
//
//        } catch (InvalidUserException | InvalidOrderException e) {
//            System.err.println(e.getMessage());
//        } finally {
//            service.OrderSlip();
//        }
    }
}