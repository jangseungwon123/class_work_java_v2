package _server_socket.cho5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

/**
 * 1:n 양방향 통신을 구현하는 서버 측 코드
 * 여러 클라이언트와 연결하여 메세지를 수신하고, 모든 클라이언트에게
 * 브로드캐스트처리한다.
 */
public class MultiNServer {

    private static final int PORT = 5000;
    // List 계열 자료구저 - 사용방법 거의 동일 ( 멀티 스레드 환경에서 안정적이다.)
    private static Vector<PrintWriter> clientWriters = new Vector<>();
    static int connectedCount = 0;

    // 내부 클래스
    public static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        /**
         * 클라이언트와 통신을 처리한다.
         * 메세지를 수신하여 모든 클라이언트엣게 브로드캐스하고, 연결 종료시
         * 자원을 종료한다.
         */
        @Override
        public void run() {

            // 입력 스트림, 출력 스트림
            try {
                // 스트림 준비 완료
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                //1. 자료구조에 서버--클라이언트 연결된 출력 스트림을 저장해 두자
                //2. 클라이언트 측과 연결된 출력스트림(PrintWriter)을 자료구조에 저장
                clientWriters.add(out);

                // 클라이언트로 부터 메세지를 수신하고 방송할 예정
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Recived: " + message);
                    for (PrintWriter writer : clientWriters) {
                        writer.println("방송 : " + message);
                    }
                }

                // 예시
                // 1 사람이면 out.println("message");
                // 2 사람이면 out.println("message");


            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("클라이언트에서 연결 종료");
            } finally {
                try {
                    if (socket != null) socket.close();
                    // static 자료 구조에 저장된 나의 출력 스트림을 제거 하기
                    clientWriters.remove(out);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("소켓 자원 해제 중 오류 발생");
                }
            }

        }
    } // end of inner class

    // 메인함수
    public static void main(String[] args) {

        System.out.println("Server started .....");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            // 메인 쓰레드는 무한 루프를 돌면서 클라이언트 연결을 요청을 기다린다.
            while (true) {
                //Socket socket = serverSocket.accept();
                // ClientHandler <----작업가 1이 자신에 동작을 진행시킬 수 있다.
                new ClientHandler(serverSocket.accept()).start();
                connectedCount++;
                System.out.println("클라이언트 연결 됨" + connectedCount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // end of main
} // end of class
