package Level_1;

import java.util.Scanner;
public class Check_Compare{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int[] numbers = new int[5];
		
		for (int i = 0; i < numbers.length; i++){
			System.out.print("Enter number " + i + ": ");
			numbers[i] = input.nextInt();
		}
		String[] evOdd = {"Even","Odd"};
		for (int j = 0; j < numbers.length; j++){
			if(numbers[j] > 0){
				System.out.println("Number " + j + " (" + numbers[j] + ")" + " is: " + evOdd[(numbers[j]%2)]);
			}
			else if(numbers[j] == 0){
				System.out.println("Number " + j + " (" + numbers[j] + ")" + " is: zero");

			}else{
				System.out.println("Number " + j + " (" + numbers[j] + ")" + " is: " + "Negative");

			}
		}
		input.close();
		
	}
}