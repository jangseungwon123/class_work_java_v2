package ch02;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test {

    public static void main(String[] args) {
        int readData;
        try (FileInputStream in = new FileInputStream("my1.txt");
             FileOutputStream fos = new FileOutputStream("my2.txt", true)
        ) {

            while ((readData = in.read()) != -1) {
                fos.write(readData);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
