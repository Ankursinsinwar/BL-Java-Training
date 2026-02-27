package read_write_opencsv;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV_Using_OpenCSV {
    public static void main(String[] args) {
        try (CSVReader reader = new CSVReader(new FileReader("CSV_Data_Handling\\csv_handling\\src\\media\\employees.csv"))) {
            String[] nextLine;
            try {
                while ((nextLine = reader.readNext()) != null) {
                    System.out.println("ID: " + nextLine[0] + ", Name: " + nextLine[1]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
