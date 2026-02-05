package Level_2;

import java.util.Scanner;

public class SumOf_nNatural_Numbers_Recursive {

    public static int sum_Recursive(int n) {
        if (n <= 1) return n;
        return n + sum_Recursive(n - 1);
    }

    public static int sum_Formula(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
            input.close();
            return;
        }
        
        int sum_recursive = sum_Recursive(number);
        int sum_formula = sum_Formula(number);
        System.out.println("Sum using recursion: " + sum_recursive);
        System.out.println("Sum using formula: " + sum_formula);
        System.out.println("Both results are " + (sum_recursive == sum_formula ? "equal." : "not equal."));
        input.close();
    }
}