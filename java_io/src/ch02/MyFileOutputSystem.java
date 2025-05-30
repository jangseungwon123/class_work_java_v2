package ch02;

import java.io.FileOutputStream;

/**
 * 파일 출력 스트림을 사용해 보자.
 */
public class MyFileOutputSystem {

    public static void main(String[] args) {
        String data = "Hello, Java FileOutputSystem abc abc 안녕 반가워";

        // new FileOutputStream("output.txt")  <-- 파일 없으면 새로 생성해서 데이틀 쓴다.
        // Append 모드 활성화 처리 (두번째 인자값)
        // new FileOutputStream("output.txt", true)  <-- 파일 없으면 새로 생성해서 데이틀 쓴다.
        try (FileOutputStream fos = new FileOutputStream("output.txt", true)) {
            // 문자열 data 값을 byte 배열로 변환 시켜 보자.
            byte[] dataBytes = data.getBytes();
            // [72, 101, 108 .. .. ..]

            // 바이트 단위로 파일에 데이터를 쓴다.
            fos.write(dataBytes);

            System.out.println("파일 출력 완료 : output.txt " );

            //참고 output.txt 파일을 열었을 대 텍스트로 보이는 이유는 에디터가
            // 문자로 해석해서 보여줬기 때문이다.
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    } // end of main
}
