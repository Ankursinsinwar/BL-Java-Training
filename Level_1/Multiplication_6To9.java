package Level_1;

import java.util.Scanner;

public class Multiplication_6To9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] table = new int[4];

        System.out.print("Enter the number: ");
        int number = input.nextInt();
        for (int i = 0; i < table.length; i++) {
            table[i] = number * (i + 6);
        }

        for (int i = 0; i < table.length; i++) {
            System.out.println(number + " * " + (i + 6) + " = " + table[i]);
        }
        input.close();
    }
}