import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int PORT_NUMBER = 12345;
    private static final Map<Integer, List<ClientHandler>> rooms = new HashMap<>();
    private static int roomCounter = 1;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT_NUMBER)) {
            System.out.println("Server started on port " + PORT_NUMBER);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket);

                ClientHandler clientHandler = new ClientHandler(clientSocket);
                Thread clientThread = new Thread(clientHandler);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static synchronized int createRoom() {
        rooms.put(roomCounter, new ArrayList<>());
        return roomCounter++;
    }

    private static synchronized void removeRoom(int roomId) {
        rooms.remove(roomId);
        System.out.println("Room " + roomId + " has been removed.");
    }

    static synchronized void broadcast(int roomId, String message, ClientHandler sender) {
        List<ClientHandler> clients = rooms.get(roomId);
        for (ClientHandler client : clients) {
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }

    static synchronized void moveClient(int oldRoomId, int newRoomId, ClientHandler client) {
        rooms.get(oldRoomId).remove(client);
        rooms.get(newRoomId).add(client);
    }

    static synchronized List<Integer> getRoomList() {
        return new ArrayList<>(rooms.keySet());
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String nickname;
    private int roomId = -1;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            sendCommands();
            while (true) {
                String input = in.readLine();
                if (input == null) {
                    break;
                }
                if (input.startsWith("/create")) {
                    createRoom();
                } else if (input.startsWith("/list")) {
                    listRooms();
                } else if (input.startsWith("/join")) {
                    joinRoom(input);
                } else if (input.startsWith("/exit")) {
                    exitRoom();
                } else if (roomId != -1) {
                    ChatServer.broadcast(roomId, nickname + ": " + input, this);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private void sendCommands() {
        sendMessage("Available commands:");
        sendMessage("/create - Create a new room");
        sendMessage("/list - List all available rooms");
        sendMessage("/join [room number] - Join a room");
        sendMessage("/exit - Leave the current room");
    }

    private void createRoom() {
        roomId = ChatServer.createRoom();
        sendMessage("Room " + roomId + " has been created.");
        ChatServer.moveClient(-1, roomId, this);
    }

    private void listRooms() {
        List<Integer> roomList = ChatServer.getRoomList();
        sendMessage("Available rooms:");
        for (int room : roomList) {
            sendMessage("Room " + room);
        }
    }

    private void joinRoom(String input) {
        String[] parts = input.split(" ");
        if (parts.length == 2) {
            int newRoomId = Integer.parseInt(parts[1]);
            if (ChatServer.getRoomList().contains(newRoomId)) {
                if (roomId != -1) {
                    ChatServer.broadcast(roomId, nickname + " has left the room.", this);
                }
                roomId = newRoomId;
                sendMessage("You have joined room " + roomId);
                ChatServer.moveClient(-1, roomId, this);
                ChatServer.broadcast(roomId, nickname + " has joined the room.", this);
            } else {
                sendMessage("Room " + newRoomId + " does not exist.");
            }
        } else {
            sendMessage("Invalid command. Usage: /join [room number]");
        }
    }

    private void exitRoom() {
        if (roomId != -1) {
            ChatServer.broadcast(roomId, nickname + " has left the room.", this);
            ChatServer.moveClient(roomId, -1, this);
            sendMessage("You have left the room.");
            roomId = -1;
        } else {
            sendMessage("You are not in any room.");
        }
    }

    void sendMessage(String message) {
        out.println(message);
    }
    
    private void closeConnection() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}