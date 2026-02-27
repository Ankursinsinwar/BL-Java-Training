package CSV_Data_Handling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CSV_BufferedWriter {
    public static void main(String[] args) {

        String filePath = "CSV_Data_Handling\\media\\employees.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ID,Name,Department,Salary\n");
            writer.write("104,Alice,Finance,62000\n");
            writer.write("105,Bob,Sales,58000\n");
            System.out.println("CSV file written successfully!");

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
