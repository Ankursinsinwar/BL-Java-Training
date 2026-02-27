package read_write_opencsv;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV_Using_OpenCSV {
    public static void main(String[] args) {
        try (CSVWriter writer = new CSVWriter(new FileWriter("CSV_Data_Handling\\csv_handling\\src\\media\\employees.csv"))) {
            String[] header = { "ID", "Name", "Department", "Salary" };
            String[] emp1 = { "104", "Alice Williams", "Finance", "62000" };
            String[] emp2 = { "105", "Bob Johnson", "Sales", "58000" };
            writer.writeNext(header);
            writer.writeNext(emp1);
            writer.writeNext(emp2);
            System.out.println("CSV file written successfully using OpenCSV!");
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}