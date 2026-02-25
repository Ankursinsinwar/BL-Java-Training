package IO_Stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderWriter {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("IO_Stream\\media\\file1.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("IO_Stream\\media\\file2.txt"))) {
            
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
            System.out.println("File copied successfully with buffering.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
