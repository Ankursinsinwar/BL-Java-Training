package Level_2;

import java.util.Scanner;

public class Leap_Year_Checker {

    public static boolean isLeapYear(int year) {
        if (year < 1582)
            return false;
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the year (>= 1582): ");
        int year = input.nextInt();

        if (year < 1582) {
            System.out.println("Year must be 1582 or later.");
            input.close();
            return;
        }

        System.out.println(year + (isLeapYear(year) ? " is a Leap Year." : " is not a Leap Year."));

        input.close();
    }
}