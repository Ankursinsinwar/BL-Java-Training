package Level_1;

import java.util.Scanner;

public class Odd_Even_Array {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter a natural number: ");
		int number = input.nextInt();

		if (number <= 0) {
			System.out.println("Error: Not a natural number.");
			input.close();
			return;
        	}
		int size = number / 2 + 1;
		int[] even = new int[size];
		int[] odd = new int[size];
		int evenIdx = 0;
		int oddIdx = 0;

		for (int i = 1; i <= number; i++) {
			if (i % 2 == 0) {
				even[evenIdx++] = i;
			} else {
				odd[oddIdx++] = i;
			}
		}

		for (int i = 0; i < oddIdx; i++){
			System.out.println("Odd numbers: " + odd[i] + " ");
		}

		for (int i = 0; i < evenIdx; i++){
			System.out.println("Even numbers: " + even[i] + " ");
		}
		input.close();
	}
}
