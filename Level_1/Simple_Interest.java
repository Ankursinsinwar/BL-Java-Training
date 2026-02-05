package Level_1;

import java.util.Scanner;

public class Simple_Interest {

     public static int  simpleInterest( int Principal, int Rate, int Time){
        int simpleInterest = (Principal * Rate * Time) / 100;
        return simpleInterest;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter Principal: ");
        int Principal = input.nextInt();
        System.out.print("Enter Rate: ");
        int Rate = input.nextInt();
        System.out.print("Enter Time: ");
        int Time = input.nextInt();

        int SimpleInterest = simpleInterest(Principal, Rate, Time);

        System.out.println("The Simple Interest is " + SimpleInterest + " for Principal " + Principal +", Rate of Interest "+ Rate + " and Time " + Time + ".");
        input.close();
    }
}