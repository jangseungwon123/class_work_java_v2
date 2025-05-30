package ch02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MyFileInputStream {

    public static void main(String[] args) {

        // 파일을 바이트 단위로 읽어 들이는 녀석
        FileInputStream in = null;
        int readData;
        try {
            in = new FileInputStream("a.txt");

            readData = in.read();

            System.out.println("readDate : " + readData);
            System.out.println("readDate : " + (char)readData);

            readData = in.read();
            System.out.println("readDate : " + readData);
            System.out.println("readDate : " + (char)readData);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    } // end of main

}
