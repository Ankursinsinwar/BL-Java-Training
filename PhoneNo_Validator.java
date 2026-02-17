import java.util.Scanner;
import java.util.regex.Pattern;

public class PhoneNo_Validator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Phone No. : ");
        String phone = sc.nextLine();

        String regex = "^[6-9]{1}\\d{9}$";
        Pattern pattern = Pattern.compile(regex);

        if (pattern.matcher(phone).matches()) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }

        sc.close();
    }
}