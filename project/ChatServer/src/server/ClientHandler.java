package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClientHandler implements Runnable {
    private Socket socket; // 클라이언트의 소켓 정보
    private BufferedReader in; // 클라이언트로부터 입력을 받음
    private PrintWriter out; // 클라이언트로 출력함
    private String nickname; // 클라이언트 사용자의 닉네임
    private int roomId = -1; // 클라이언트의 현재 위치를 나타내는 ID
    private static Set<String> usedNicknames = new HashSet<>(); // 사용 중인 닉네임을 저장하는 Set

    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 클라이언트 입력을 받기 위한 통로 개설
            out = new PrintWriter(socket.getOutputStream(), true); // 클라이언트로 출력을 하기 위한 통로 개설
            ChatServer.addClient(this); // 클라이언트를 서버에 추가
            requestNickname(); // 닉네임 요청
        } catch (IOException e) {
            System.err.println("클라이언트 핸들러 초기화 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }

    // 닉네임 중복을 방지하는 메서드
    private void requestNickname() {
        try {
            String requestedNickname;
            while (true) {
                requestedNickname = in.readLine(); // 클라이언트가 입력한 닉네임을 받음
                if (requestedNickname == null || requestedNickname.trim().isEmpty()) {
                    sendMessage("유효하지 않은 닉네임입니다. 다시 입력하세요.");
                } else if (usedNicknames.contains(requestedNickname)) {
                    sendMessage("이미 사용 중인 닉네임입니다. 다른 닉네임을 입력하세요.");
                } else {
                    break; // 사용 가능한 닉네임일 때 반복문 종료
                }
            }
            this.nickname = requestedNickname;
            this.usedNicknames.add(nickname); // 사용 중인 닉네임 목록에 추가
            sendMessage("닉네임이 설정되었습니다: " + nickname);
        } catch (IOException e) {
            System.err.println("닉네임을 입력하는 도중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            sendMessage(nickname + "님 채팅 프로그램에 오신걸 환영합니다.");
            sendCommands();
            while (true) {
                String input = in.readLine(); // 서버로부터 한줄씩 입력을 받음
                if (input.startsWith("/help")) {
                    sendCommands();
                } else if (input.startsWith("/users")) {
                    listUsers();
                } else if (input.startsWith("/whisper")) {
                    whisperToUser(input);
                } else if (input.startsWith("/create")) {
                    createRoom();
                } else if (input.startsWith("/list")) {
                    listRooms();
                } else if (input.startsWith("/join")) {
                    joinRoom(input);
                } else if (input.startsWith("/roomusers")) {
                    roomListUsers(input);
                } else if (input.startsWith("/exit")) {
                    exitRoom(input);
                } else if (input.startsWith("/bye")) {
                    ChatServer.moveClient(roomId, -1, this); // 현재 방에서 클라이언트 제거
                    ChatServer.removeClient(this); // 서버에 저장된 클라이언트의 정보를 제거
                    break;
                } else if (roomId != -1) {
                    ChatServer.broadcast(roomId, nickname + ": " + input, this);
                } else {
                    sendMessage("잘못된 형식입니다. /help 참고하거나 명령어를 입력해주세요 :)");
                }
            }
        } catch (IOException | NullPointerException e) {
            // 클라이언트가 강제로 종료되었을 때, 서버 콘솔에 원하는 형식으로 오류 메시지를 출력
            System.err.println("클라이언트가 강제로 종료되었습니다.");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    // 명령어 모음 메서드
    private void sendCommands() {
        sendMessage("아래는 명령어입니다.");
        sendMessage("/help - 명령어 목록");
        sendMessage("/users - 현재 접속 중인 사용자 목록");
        sendMessage("/whisper [닉네임] [메세지] - 귓속말 보내기");
        sendMessage("/create - 방 생성");
        sendMessage("/list - 방 목록");
        sendMessage("/join [방 번호] - 방 입장");
        sendMessage("/roomusers - 현재 방에 접속 중인 사용자 목록");
        sendMessage("/exit - 방 떠나기");
        sendMessage("/bye - 종료");
    }

    // 출력 메서드
    void sendMessage(String message) {
        out.println(message);
    }

    // 방이 떠나 현재 클라이언트에 접속 중인 모든 사용자를 출력하는 메서드
    private void listUsers() {
        StringBuilder userList = new StringBuilder("현재 접속 중인 사용자: ");
        for (String nickname : usedNicknames) {
            userList.append(nickname).append(", ");
        }
        userList.delete(userList.length() - 2, userList.length()); // 마지막 ", " 삭제
        sendMessage(userList.toString());
    }

    // 명시한 사용자에게 귓속말을 출력하는 메서드
    private void whisperToUser(String input) {
        String[] parts = input.split(" ", 3); // 최대 3개의 공백을 기준으로 나눔

        if (parts.length < 3) {
            sendMessage("귓속말 형식이 잘못되었습니다. 사용법: /whipsr [닉네임] [메세지]");
            return;
        }

        String targetNickname = parts[1];
        String message = parts[2];

        // 해당 클라이언트에게 귓속말 보내기
        List<ClientHandler> allClients = ChatServer.getAllClients();
        for (ClientHandler client : allClients) {
            if (client.getNickname().equals(targetNickname)) {
                client.sendMessage("[귓속말] " + nickname + ": " + message);
                this.sendMessage("[귓속말] " + nickname + " -> " + targetNickname + ": " + message);
                return;
            }
        }
        sendMessage(targetNickname + "님을 찾을 수 없습니다. /users를 참고하세요:)");
    }

    // 방 생성 메서드
    private void createRoom() {
        if (roomId != -1) { // 이미 방에 속해 있는 경우
            sendMessage("이미 방에 속해 있습니다. 새로운 방을 생성하려면 먼저 현재 방을 나가세요");
            return; // 메서드 종료
        }
        roomId = ChatServer.createRoom();
        sendMessage(roomId + "번 방이 생성되었습니다.");
        ChatServer.moveClient(-1, roomId, this);
    }

    // 방 목록 출력 메서드
    private void listRooms() {
        List<Integer> roomList = ChatServer.getRoomList(); // 현재 존재하는 방 목록을 반환

        if (roomList.isEmpty()) { // 현재 개설된 채팅방이 없을 경우
            sendMessage("개설된 채팅방이 없습니다.");
        } else { // 개설된 채팅방이 있는 경우
            sendMessage("방 목록:"); // 방 목록 안내 메시지 전송
            for (int room : roomList) {
                sendMessage("방 " + room); // 각 방 번호를 반복하면서 클라이언트에게 전송
            }
        }
    }

    // 방 입장 출력 메서드
    private void joinRoom(String input) {
        if (roomId != -1) { // 이미 방에 속해 있는 경우
            sendMessage("이미 방에 속해 있습니다. 다른 방에 입장하려면 먼저 현재 방을 나가세요");
            return;
        }
        String[] parts = input.split(" "); // 공백을 기준으로 배열에 저장
        if (parts.length == 2) { // 문자열 배열의 길이가 2일 경우 실행
            int newRoomId = Integer.parseInt(parts[1]);
            List<Integer> roomList = ChatServer.getRoomList();
            if (roomList.contains(newRoomId)) {
                /*
                if (roomId != -1) { // 현재 클라이언트가 이미 다른 방에 속해 있는 경우
                    // 현재 방에서 퇴장 메시지를 브로드캐스트
                    ChatServer.brocast(roomId, nickname + " has left the room", this);
                    // 클라이언트를 현재 방에서 새로운 방으로 이동 <- 위치 이동
                    ChatServer.moveClient(roomId, newRoomId, this);
                }
                 */
                // 클라이언트의 현재 방 번호를 새로운 방 번호로 전환 후 입장 메시지를 보냄 이때, 기존 방의 클라이언트들에게 브로드캐스트
                ChatServer.moveClient(-1, newRoomId, this);
                roomId = newRoomId;
                // ChatServer.brocast(roomId, nickname + "님이 입장하셨습니다.", this);
                return; // 메서드 종료
            }
            sendMessage(newRoomId + "번 방이 존재하지 않습니다. 방 목록을 확인하려면 /list를 입력해주세요."); // 입력한 방이 존재하지 않는 경우 클라이언트에게 전송
        }
    }

    // 방을 기준으로 위치를 출력하는 메서드
    private void roomListUsers(String input) {
        if (roomId == -1) {
            sendMessage("현재 방에 속해 있지 않습니다.");
        }

        List<ClientHandler> roomClients = ChatServer.getRoomClients(roomId);
        if (roomClients.isEmpty()) {
            sendMessage("그리고 방에 아무도 없습니다.");
            return;
        }

        StringBuilder userList = new StringBuilder("현재 방에 있는 사용자: ");
        for (ClientHandler client : roomClients) {
            userList.append(client.getNickname()).append(", ");
        }
        userList.delete(userList.length() - 2, userList.length()); // 마지막 ", " 삭제
        sendMessage(userList.toString());
    }

    // 방 나가기 출력 메서드
    private void exitRoom(String input) {
        if (roomId != -1) { // 방에 있는지부터 체크!
            sendMessage("방을 나갔습니다.");
            ChatServer.moveClient(roomId, -1, this); // 로비로 이동!
            // ChatServer.brocast(roomId, nickname + "님이 방을 나갔습니다.", this);
            roomId = -1;
            return;
        }
        sendMessage("귀하는 어느 방에도 속해져있지 않습니다."); // 클라이언트가 어느 방에도 속해 있지 않은 경우
    }

    // 닉네임 정보 출력 메서드
    public String getNickname() {
        return nickname;
    }

    // 리소스 관리 메소드
    private void closeConnection() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            System.err.println("클라이언트 소켓 닫기 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }
}