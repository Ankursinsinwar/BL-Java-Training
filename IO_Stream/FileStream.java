package IO_Stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStream {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("IO_Stream\\media\\file1.txt");
                FileOutputStream fos = new FileOutputStream("IO_Stream\\media\\file2.txt"))
        {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
