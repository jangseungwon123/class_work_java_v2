package ch03;

import java.io.*;
/**
 * 바이트 단위 스트림에 이름 형태
 * InputStream(System.in),OutputStream(System.out)
 *  문자 기반 스트림에 이름 형태
 *  xxxReader, xxxWriter (문자 기반 형태 네이밍 형식)
 */
public class KeyboardConsoleStream {
    public static void main(String[] args) {
        System.out.println("알파벳 열 개 쓰고 Enter 를 누르세요");
        int i;
        try{
            // 키보드에서 엔터는 \n 로 표현이 된다.
            while ((i = System.in.read()) != '\n') {
                // 읽은 바이트의 정수값을 출력
                System.out.println("i : " + i);
                System.out.println("문자로 표현 :" + (char)i);
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    } // end of main
}
