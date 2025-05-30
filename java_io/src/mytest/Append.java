package mytest;

import java.io.*;

public class Append {

    public static void main(String[] args) {

        // 파일 경로 지정
        String sourceFilePath = "save.txt";

        //try catch 문
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new FileWriter(sourceFilePath, true))
             //InputStreamReader isr = new InputStreamReader(System.in);
             //BufferedReader br = new BufferedReader(isr);
             //FileWriter pw = new FileWriter(sourceFilePath,true);
             //BufferedWriter bw = new BufferedWriter(pw);
        ) {

            System.out.println("텍스트를 입력하세요(종료 빈줄 입력)");

            String line;
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                bw.write(line);
                //bw.write(line, 0, line.length()); // 비효율적이다.
                bw.newLine();
            }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("파일복사중 오루발생" + e.getMessage());
        }


    } // end of main

}
