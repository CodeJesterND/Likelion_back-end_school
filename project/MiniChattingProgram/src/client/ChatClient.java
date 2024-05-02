package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    private static final String HOST_NAME = "localhost"; // 서버가 실행 중인 호스트의 이름 또는 IP 주소
    private static final int PORT_NUMBER = 12345; // 서버와 동일한 포트 번호 사용

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST_NAME, PORT_NUMBER); // 서버에 클라이언트 연결
             // 서버로 데이터를 보내는 스트림
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             // 서버로부터 데이터를 받는 스트림
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             // 사용자 입력을 받기 위한 Scanner 생성
             Scanner stdIn = new Scanner(System.in);
             // 파일에 메시지를 기록하기 위한 BufferedWriter 생성
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter("chat_history.txt", true))) {

            // 사용자에게 닉네임 입력 요청
            System.out.print("Enter your nickname: ");
            String nickname = stdIn.nextLine();
            out.println(nickname); // 서버에 닉네임을 전송

            // 서버로부터 메시지를 읽어 화면에 출력하는 별도의 스레드
            Thread readThread = new Thread(new ServerMessageReader(in));
            readThread.start(); // 메시지 읽기 스레드 시작

            // 사용자 입력 처리
            String userInput;
            while (true) {
                userInput = stdIn.nextLine();

                /*
                // '/bye'를 입력하면 클라이언트를 종료
                if ("/bye".equals(userInput)) {
                    out.println(userInput); // 서버에 종료 메시지를 전송
                    break;
                }

                else if ("/clear".equals(userInput)) {
                    clearConsole(); // 콘솔 창을 지우는 메서드 호출
                }
                 */

                // 서버에 메시지를 전송합니다.
                out.println(userInput);

                // 파일에 메시지를 기록
                fileWriter.write(nickname + ": " + userInput);
                fileWriter.newLine();
                fileWriter.flush();
            }
        } catch (IOException e) {
            System.out.println("포트 " + PORT_NUMBER + "의 " + HOST_NAME + "에 연결을 시도하는 중에 예외가 발생했습니다.");
            e.printStackTrace();
        }
    }

    /*
    // 인텔리제이에서는 System Console를 호출하기 위해서는 여러 환경설정이 필요해 현재 기능은 주석처리 했습니다.
    // 콘솔 창을 지우는 메서드
    private static void clearConsole() {
        try {
            // 맥 OS에서 콘솔 창을 지우는 명령어
            String command = "clear";
            // 명령어 실행
            Process process = Runtime.getRuntime().exec(command);
            // 프로세스 종료까지 대기
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
     */
}