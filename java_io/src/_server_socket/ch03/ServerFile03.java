package _server_socket.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 서버측 코드
 * 양방향 통신 구현(1: 1 채팅)
 */
public class ServerFile02 {

    public static void main(String[] args) {

        // 준비물
        // 1. 서버 소켓이 필요함 . 포트 번호는 5000번
        // 2. 입력 스트림 필요 함(클라이언트에 메세지 수신)
        // 3. 출력 스트림 필요 함(클라이언트에 데이터 전송)

        //1. 서버 소켓 생성
        ServerSocket serverSocket = null;

        // 서버 소켓에서는 나의 ip 주소를 이미 알고 있다.
        try {
            serverSocket = new ServerSocket(5000);

            // 클라이언트 연락 대기
            Socket clientSocket = serverSocket.accept();
            System.out.println(">>>클라이언트가 연결 했습니다.");

            // 클라이언트로 부터 데이터를 입력 받을 스티림이 필요한데 --> Socket
            BufferedReader reader
                    = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


            // reader <-- 데이터를 이제 마구 읽을 수 있다.

            // 클라이언트 측과 연결된 소켓에서 출력 스트림을 뽑고 + 문자 기반 스트림으로 확장했다.
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(),true);

            // writer <--- 데이터를 마구 보낼 수 있다.

            // 데이터 수신해보기
            String message = reader.readLine();
            System.out.println("클라이언트에게 온 메세지 " + message);

            // 데이터 송신해 보기
            writer.println("난 서버야, client 반가워");
            writer.flush(); // 물 내리기

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    System.out.println("소켓 close() 시 오류 발생");
                    e.printStackTrace();
                }
            }
        }

    } // end of main
}
