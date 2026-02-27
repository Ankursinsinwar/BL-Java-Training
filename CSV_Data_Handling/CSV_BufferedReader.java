package CSV_Data_Handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSV_BufferedReader {
    public static void main(String[] args) {

        String filePath = "CSV_Data_Handling\\media\\employees.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] columns = line.split(",");

                System.out.printf("%-5s %-10s %-15s %-10s\n", columns[0], columns[1], columns[2], columns[3]);

            }
        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
