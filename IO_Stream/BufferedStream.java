package IO_Stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedStream {
    public static void main(String[] args) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("IO_Stream\\media\\file1.txt"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("IO_Stream\\media\\file2.txt"))) {
            
            byte[] buffer = new byte[8];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            System.out.println("File copied successfully with buffering.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
