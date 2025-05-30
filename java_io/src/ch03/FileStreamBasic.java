package ch03;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileStreamBasic {

    public static void main(String[] args) {
        // 함수 호출
        //writeToFile("basic_output.txt");

        //함수 호출 파일에서 텍스트 읽기
       readFromFile("basic_output.txt");


    } // end of main

    // 파일에 텍스트를 쓰는 함수(문자 기반 스트림 사용)
    public static void writeToFile(String fileName) {
        /**
         * FileWriter는 문자 기반 출력 스트림으로, 텍스트를 파일에 기록할 수 있다.
         *
         */

        try (FileWriter writer = new FileWriter(fileName)) {
            // 파일에 기록할 텍스트를 선언
            String text = " 자바 문자 기반 스트림예제\n";
            writer.write(text); // 파일이 없다면 새로운 파일 생성 , 텍스트를 파일에 쓴다.

            writer.write("추가 문자열을 기록합니다.");

            // 스트림을 비워 주자. 물을 내리다.
            writer.flush();

            System.out.println("파일에 텍스트를 잘 기록 하였다");
        } catch (IOException e) {
            System.out.println("파일 쓰기 중 오류 발생" + e.getMessage());
        }
    } // end of writeToFile

    public static void readFromFile(String fileName){
        /**
         * FileReader 는 문자 기반 입력 스트림으로, 파일에서 텍스트를 읽음.
          */
        try(FileReader reader = new FileReader(fileName)) {

            //read()메서드는 한 문자씩 읽어 유니코드 값(정수)로 반환 한다.
//            int charCode = reader.read();
//            System.out.println(charCode);
//            System.out.println((char) charCode);

            // 파일에 모든 텍스트를 읽을 수 있도록 코딩을 하세요 , -1 은 파일의 끝을 의미한다.
            int charCode;
            while((charCode = reader.read()) != -1){
                System.out.print((char) charCode);
            }


        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }
}
