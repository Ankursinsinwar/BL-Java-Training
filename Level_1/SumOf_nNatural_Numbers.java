package Level_1;

import java.util.Scanner;
public class SumOf_nNatural_Numbers {

    public static int sumOfNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) sum += i;
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int n = input.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
            input.close();
            return;
        }
        
        int sum = sumOfNaturalNumbers(n);
        System.out.println("Sum of " + n + " natural numbers (using loop) is " + sum);
        
        input.close();    
    }
}