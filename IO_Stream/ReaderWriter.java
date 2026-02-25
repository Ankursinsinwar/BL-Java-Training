package IO_Stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class ReaderWriter {
    public static void main(String[] args) {
        try (Reader reader = new InputStreamReader(new FileInputStream("IO_Stream\\media\\file1.txt"),"UTF-8");
            Writer writer = new OutputStreamWriter(new FileOutputStream("IO_Stream\\media\\file1.txt"), "UTF-8")) {
            char[] buffer = new char[8];
            int charsRead;
            while ((charsRead = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, charsRead);
            }
            System.out.println("File copied successfully with character encoding.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}