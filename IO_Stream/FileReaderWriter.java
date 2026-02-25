package IO_Stream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriter {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("IO_Stream\\media\\file1.txt");
                FileWriter fw = new FileWriter("IO_Stream\\media\\file2.txt"))
        {
            int charData;
            while ((charData = fr.read()) != -1) {
                fw.write(charData);
            }

            System.out.println("File copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
