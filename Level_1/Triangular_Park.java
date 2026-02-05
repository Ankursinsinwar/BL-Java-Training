package Level_1;

import java.util.Scanner;
public class Triangular_Park {
    
    public static double computeRounds(int side1, int side2, int side3) {
        double perimeter = side1 + side2 + side3;
        double distance = 5000; 
        return (distance / perimeter);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter 1st side of the triangular park (in meters): ");
        int side1 = input.nextInt();
        System.out.print("Enter 2nd side of the triangular park (in meters): ");
        int side2 = input.nextInt();
        System.out.print("Enter 3rd side of the triangular park (in meters): ");
        int side3 = input.nextInt();

        double rounds = computeRounds(side1, side2, side3);

        System.out.println("The athlete must complete " + rounds + " rounds to complete a 5 km run.");

        input.close();
    }
}
