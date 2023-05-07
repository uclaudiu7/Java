package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread{
    private final Socket clientSocket;
    private final GameServer gameServer;
    private boolean closed;

    public ClientThread(Socket clientSocket, GameServer gameServer){
        this.clientSocket = clientSocket;
        this.gameServer = gameServer;
        closed = false;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            while (!closed) {
                String request = input.readLine();
                if(request == null){
                    break;
                }

                if(request.equals("stop")){
                    gameServer.stop();
                    output.println("Server stopped!");
                    break;
                } else {
                    output.println("Server received the request: " + request);
                }
            }
        } catch (IOException e) {
            if(!closed){
                e.printStackTrace();
            }
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            closed = true;
        }
    }

    public void close() throws IOException{
        closed = true;
        interrupt();
    }

}
