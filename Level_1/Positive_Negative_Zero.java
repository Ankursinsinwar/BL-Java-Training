package Level_1;

import java.util.Scanner;
public class Positive_Negative_Zero {

    public static int check_Number(int number) {
        if (number > 0) return 1;
        else if (number == 0) return 0;
        else return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int result = check_Number(number);

        if (result == 1) System.out.println("Number is Positive");
        else if (result == 0) System.out.println("Number is Zero");
        else System.out.println("Number is Negativee");
        

        input.close();
    }
}
