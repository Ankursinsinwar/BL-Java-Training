package Level_1;

import java.util.Scanner;
public class Spring_Season {
    
    public static boolean isSpringSeason(int month, int day) {
        if ((month == 3 && day >= 20) || (month == 4) || (month == 5) || (month == 6 && day <= 20)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter month: ");
        int month = input.nextInt();
        System.out.print("Enter day: ");
        int day = input.nextInt();

        boolean result = isSpringSeason(month, day);

        if (result) System.out.println("It's a Spring Season");
        else System.out.println("Not a Spring Season");
        
        input.close();
    }
}