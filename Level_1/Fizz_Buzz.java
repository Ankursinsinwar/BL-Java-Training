package Level_1;

import java.util.Scanner;
public class Fizz_Buzz {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a positive integer: ");
		int number = input.nextInt();
		if (number <= 0) {
			System.out.println("Please enter a positive integer.");
			input.close();
			return;
		}

		String[] FizzBuzz= new String[number];

		for (int i = 0; i < number; i++) {
			if (i % 3 == 0 && i % 5 == 0 && i != 0) {
				FizzBuzz[i] = "FizzBuzz";
			} else if (i % 3 == 0 && i != 0) {
				FizzBuzz[i] = "Fizz";
			} else if (i % 5 == 0 && i != 0) {
				FizzBuzz[i] = "Buzz";
			} else {
				FizzBuzz[i] = String.valueOf(i);
			}
		}

		for (int i = 0; i < number; i++) {
			System.out.println("Position " + i + " = " + FizzBuzz[i]);
		}

		input.close();
	}
}