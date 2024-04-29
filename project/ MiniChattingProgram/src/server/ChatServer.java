package server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatServer {
    private static final int PORT_NUMBER = 12345; // 서버 포트 번호
    private static List<ClientHandler> allClients = new ArrayList<>(); // 모든 클라이언트의 정보
    private static final Map<Integer, List<ClientHandler>> rooms = new HashMap<>(); // 각방의 정보들을 지니고 있음
    private static int roomCounter = 0; // 방 번호 카운터
    private static List<Integer> unusedRoomIds = new ArrayList<>(); // 삭제된 방 번호 목

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT_NUMBER)) {
            System.out.println("서버가 실행되었습니다. 포트 번호는 ["+PORT_NUMBER+"]입니다. 클라이언트의 접속을 기다리고 있습니다.");

            while (true) {
                Socket clientSocket = serverSocket.accept(); // 클라이언트와 connect !!!
                InetAddress clientAddress = clientSocket.getInetAddress();
                int clientPort = clientSocket.getPort();

                System.out.println("클라이언트가 접속했습니다. IP: " + clientAddress + ", 포트: " + clientPort);

                ClientHandler clientHandler = new ClientHandler(clientSocket); // 클라이언트와 소통하기 위한 객체
                Thread clientThread = new Thread(clientHandler);
                clientThread.start();

                // System.out.println("클라이언트와의 연결이 종료되었습니다. IP: " + clientAddress + ", 포트: " + clientPort);
            }
        } catch (IOException e) {
            System.err.println("서버 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }

    // 클라이언트를 리스트에 추가하는 메서드
    static synchronized void addClient(ClientHandler client) {
        allClients.add(client); // 해당 클라이어트 추가
    }

    // 클라이언트를 리스트에서 제거하는 메서드
    static synchronized void removeClient(ClientHandler client) {
        allClients.remove(client); // 해당 클라이언트를 제거
    }

    // 현재 서버에 접속중인 모든 클라이언트의 정보를 반환하는 메서드
    static synchronized List<ClientHandler> getAllClients() {
        return new ArrayList<>(allClients); // 익명 리스트로 반환
    }

    // 방 생성 관리 메서드
    static synchronized int createRoom() {
        int roomId;
        if (!unusedRoomIds.isEmpty()) {
            roomId = unusedRoomIds.remove(0); // 삭제된 방 번호 재사용
        } else {
            roomId = ++roomCounter; // 새로운 방 번호 생성
        }
        rooms.put(roomId, new ArrayList<>()); // 방 목록에 추가
        return roomId;
    }

    // 클라이언트 위치 변경 메소드
    static synchronized void moveClient(int oldRoomId, int newRoomId, ClientHandler client) {
        if (oldRoomId != -1) {
            List<ClientHandler> clients = rooms.get(oldRoomId);
            clients.remove(client); // 클라이언트 제거
            if (clients.isEmpty()) { // 이전 방에 클라이언트가 없는 경우
                removeRoom(oldRoomId); // 방 삭제
                client.sendMessage("그리고 " + oldRoomId + "번 방에 더이상 사용자가 없어 방이 사라졌습니다.");
            } else {
                // 방에 다른 클라이언트가 있는 경우, 나갔음을 알려줌
                for(ClientHandler otherClient : clients) {
                    if (otherClient != client) {
                        otherClient.sendMessage(client.getNickname() + "님이 방을 나갔습니다.");
                    }
                }
            }
        }

        if (newRoomId != -1) { // 새로운 방의 아이디가 유효한 경우에만 추가
            List<ClientHandler> newRoomClients = rooms.get(newRoomId);
            if (newRoomClients != null) { // 방이 존재하는 경우에만 추가
                newRoomClients.add(client); // 새로운 방에 클라이언트 추가
                client.sendMessage(newRoomId + "번 방에 입장하셨습니다.");
                for (ClientHandler otherClient : newRoomClients) {
                    if (otherClient != client) {
                        otherClient.sendMessage(client.getNickname() + "님이 입장하셨습니다.");
                    }
                }

                // 새로운 방에 다른 클라이언트가 있는 경우에만 메시지를 보냄
                if (newRoomClients.size() > 1) {
                    StringBuilder userList = new StringBuilder("현재 방에 있는 다른 사용자: ");
                    for (ClientHandler otherClient : newRoomClients) {
                        if (otherClient != client) {
                            userList.append(otherClient.getNickname()).append(", ");
                        }
                    }
                    userList.delete(userList.length() - 2, userList.length()); // 마지막 ", " 삭제
                    client.sendMessage(userList.toString());
                }
            }
        }
    }

    // 방 삭제 관리 메서드
    static synchronized void removeRoom(int roomId) {
        rooms.remove(roomId); // 방 목록에서 제거
        unusedRoomIds.add(roomId); // 삭제된 방 번호를 재사용하기 위해 추가
    }

    // 방 목록 관리 메서드
    static synchronized List<Integer> getRoomList() {
        return new ArrayList<>(rooms.keySet());
    }

    // 각 방의 속해있는 클라이언트의 정보를 출력하는 메서드
    static synchronized List<ClientHandler> getRoomClients(int roomId) {
        return rooms.getOrDefault(roomId, new ArrayList<>());
    }

    // 위치가 같은 클라이언트에게만 메시지를 전송하는 메서드
    static synchronized void broadcast(int roomId, String message, ClientHandler sender) {
        List<ClientHandler> clients = rooms.get(roomId);
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }
}