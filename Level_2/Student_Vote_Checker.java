package Level_2;

import java.util.Scanner;
public class Student_Vote_Checker {

    public boolean canStudentVote(int age) {
        if (age < 0) {
            return false;
        }
        return age >= 18;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Student_Vote_Checker checker = new Student_Vote_Checker();
        int[] ages = new int[10];

        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter the ages of student " + (i+1) + ": ");
            ages[i] = input.nextInt();
            if (ages[i] < 0) {
                System.out.println("Enter positive value only");
                i--;
                continue;
            }
        }

         System.out.printf("%-8s | %-5s | %-15s\n", "Student","Age", "Eligibiliity");
        System.out.println("-------------------------------");
        for (int i = 0; i < ages.length; i++) {
            boolean canVote = checker.canStudentVote(ages[i]);
            System.out.printf("%-8s | %-5s | %-15s\n", (i + 1), ages[i], (canVote ? "Can vote" : "Cannot vote"));
        }
        input.close();
    }
}