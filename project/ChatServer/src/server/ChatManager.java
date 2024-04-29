package server;

import java.util.List;

public interface ChatManager {
    // 클라이언트 관리 메서드
    void addClient(ClientHandler client);
    void removeClient(ClientHandler client);
    List<ClientHandler> getAllClients();

    // 방 관리 메서드
    int createRoom();
    void moveClient(int oldRoomId, int newRoomId, ClientHandler client);
    void removeRoom(int roomId);
    List<Integer> getRoomList();
    List<ClientHandler> getRoomClients(int roomId);

    // 방송 메서드
    void broadcast(int roomId, String message, ClientHandler sender);
}