package Level_1;

import java.util.Scanner;

public class Multiplication_1To10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] table = new int[10];

        System.out.print("Enter the number: ");
        int number = input.nextInt();
        for (int i = 0; i < table.length; i++) {
            table[i] = number * (i + 1);
        }

        for (int i = 0; i < table.length; i++) {
            System.out.println(number + " * " + (i + 1) + " = " + table[i]);
        }
        input.close();
    }
}