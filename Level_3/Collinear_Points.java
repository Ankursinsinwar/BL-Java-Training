package Level_3;

import java.util.Scanner;

public class Collinear_Points {

    static boolean checkCollinearBySlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        int slopeAB = (y2 - y1) / (x2 - x1);
        int slopeBC = (y3 - y2) / (x3 - x2);
        int slopeAC = (y3 - y1) / (x3 - x1);
        if (slopeAB == slopeBC && slopeAB == slopeAC) return true;
        return false;
    }

    static boolean checkCollinearByArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        double area =  0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        return area == 0.0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter coordinates of three points:");

        System.out.print("x1: ");
        int x1 = input.nextInt();
        System.out.print("y1: ");
        int y1 = input.nextInt();

        System.out.print("x2: ");
        int x2 = input.nextInt();
        System.out.print("y2: ");
        int y2 = input.nextInt();

        System.out.print("x3: ");
        int x3 = input.nextInt();
        System.out.print("y3: ");
        int y3 = input.nextInt();

        boolean slopeMethod = checkCollinearBySlope(x1, y1, x2, y2, x3, y3);
        boolean areaMethod = checkCollinearByArea(x1, y1, x2, y2, x3, y3);

        System.out.println("Collinear by Slope: " + slopeMethod);
        System.out.println("Collinear by Area: " + areaMethod);

        input.close();
    }
}
