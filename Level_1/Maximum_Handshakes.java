package Level_1;

import java.util.Scanner;
public class Maximum_Handshakes {
    
    public static int calculateHandshakes(int students) {
        return students * (students - 1) / 2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = input.nextInt();

        int handshakes = calculateHandshakes(students);
        
        System.out.println("Maximum handshakes among " + students + " students is " + handshakes + '.');

        input.close();
    }
}