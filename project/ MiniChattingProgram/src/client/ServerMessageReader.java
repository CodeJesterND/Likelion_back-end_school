package client;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServerMessageReader implements Runnable {
    private BufferedReader in;
    private static final String CHAT_HISTORY_FILE = "server_chat_history.txt";

    public ServerMessageReader(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        try (FileWriter writer = new FileWriter(CHAT_HISTORY_FILE, true)) {
            String serverLine;
            while ((serverLine = in.readLine()) != null) {
                System.out.println(serverLine); // 서버로부터 받은 메시지를 출력
                writer.write("[" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "] " + serverLine + "\n");
            }
        } catch (IOException e) {
            System.err.println("서버가 종료되었습니다.");
            e.printStackTrace();
        }
    }
}