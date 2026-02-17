package RouteTrackerSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print(" ------------------------- \nAdd Driver (y/n): ");
        String addDriver = input.nextLine();
        if (addDriver.toLowerCase().equals("n")) {   
            input.close();
            return;   
        }
        System.out.print("Enter Driver id: ");
        String driverid = input.nextLine();
        System.out.print("Enter Driver name: ");
        String drivername = input.nextLine();
        // System.out.println("Enter the minimum checkout digit ");
        System.out.print("Enter No. of Checkpoints: ");
        int chpoints = input.nextInt();
        Driver driver = new Driver(driverid, drivername);
        for (int i = 0; i < chpoints; i++) {
            System.out.print("Chose Checkpoint Type [1. Delivery, 2. Fule, 3. Rest ]: ");
            int checkpointType = input.nextInt();
            String checkpointId = "C".concat(Integer.toString(i));
            System.out.print("Enter Checkpoint Location: ");
            input.nextLine();
            String checkpointLocation = input.nextLine();
            System.out.print("Enter Checkpoint distance: ");
            float checkpointDistance = input.nextFloat();
            System.out.print("Enter Checkpoint expected time: ");
            int checkpointExpectedTime = input.nextInt();
            System.out.print("Enter Checkpoint actual time: ");
            int checkpointActualTime = input.nextInt();
            if (checkpointType == 1) {
                driver.routeHistory.addCheckpoint( new DeliveryCheckpoint(checkpointId, checkpointLocation, checkpointDistance, checkpointExpectedTime, checkpointActualTime));   
            }
            else if (checkpointType == 2) {
                driver.routeHistory.addCheckpoint( new FuelCheckpoint(checkpointId, checkpointLocation, checkpointDistance, checkpointExpectedTime, checkpointActualTime));   
            }
            else if (checkpointType == 3) {
                driver.routeHistory.addCheckpoint( new RestCheckpoint(checkpointId, checkpointLocation, checkpointDistance, checkpointExpectedTime, checkpointActualTime));   
            }else{
                System.out.println("Enter valid checkpoint type! ");
                i--;
                continue;
            }
            
        }
        
        // driver.routeHistory.addCheckpoint( new DeliveryCheckpoint("C1", "Warehouse A", 10, 20, 25));
        
        // driver.routeHistory.addCheckpoint(  new FuelCheckpoint("C2", "Pump 12", 15, 30, 30));
        
        // driver.routeHistory.addCheckpoint( new RestCheckpoint("C3", "Motel X", 20, 40, 75));
        
        // driver.routeHistory.addCheckpoint( new DeliveryCheckpoint("C4", "Client Hub", 25, 50, 60));
        
        driver.printSummary();
        main(args);
        input.close();
    }
}
