package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GameServer{
    private final int port;
    private boolean running;
    private ServerSocket serverSocket;
    private final List<ClientThread> clients;

    public GameServer(int port) {
        running = true;
        this.port = port;
        clients = new ArrayList<>();
    }

    public void start() throws IOException{
        serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);
        while(running){
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

            ClientThread clientThread = new ClientThread(clientSocket, this);
            clients.add(clientThread);
            clientThread.start();
        }

        stop();
    }

    public void stop() throws IOException{
        running = false;
        serverSocket.close();
        for(ClientThread clientThread : clients){
            clientThread.close();
        }
    }

}