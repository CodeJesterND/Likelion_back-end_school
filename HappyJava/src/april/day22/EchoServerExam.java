package april.day22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerExam {
    public static void main(String[] args) throws Exception {
        // 1. ServerSocket 생성
        ServerSocket server = new ServerSocket(9999);
        System.out.println("서버가 준비되었습니다.");

        // 2. 클라이언트 연결 수학.
        Socket sock = server.accept(); // 클라이언트 소켓 얻어옴.
        System.out.println(sock.getInetAddress().getHostAddress() + " 로부터 연결되었습니다.");

        // 3. 데이터를 읽고 쓰기.
        // 입력통로
        // 클라이언트의 출력이 서버의 입력이 된다.
        // sock.getOutputStream(); 클라이언트의 출력
        BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));

        // 출력통로
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));

        String line = null;

        while((line = reader.readLine()) != null) {
            System.out.println("클라이언트에서 받은 메시지 : " + line);

            // 클라이언트가 보낸 메시지를 그대로 다시 클라이언트에게 보낸다.
            writer.println(line);
            writer.flush();
        }

        reader.close();
        writer.close();
        sock.close();
    }
}