package IO_Stream;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


public class ByteArrayStream {
    public static void main(String[] args) {
        String data = "Hello, ByteArray Streams!";
        byte[] bytes = data.getBytes();

        try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            
            int byteData;
            while ((byteData = bais.read()) != -1) {
                baos.write(Character.toUpperCase((char) byteData));
            }

            System.out.println("Original: " + data);
            System.out.println("Transformed: " + baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

