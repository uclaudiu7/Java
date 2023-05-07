package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClient {
    private final String host;
    private final int port;

    public GameClient(String host, int port){
        this.host = host;
        this.port = port;
    }

    public void start() throws IOException {
        Socket socket = new Socket(host, port);
        BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

        System.out.println("Connected to the server on port " + port);
        System.out.println("Type a request to send to the server or type 'exit' to stop the client");

        while(true) {
            System.out.print("Request: ");
            String request = keyboardInput.readLine();

            if(request == null || request.equals("exit")){
                break;
            }

            output.println(request);
            String response = input.readLine();
            System.out.println("Server response: " + response);
            if(response.equals("Server stopped!")){
                break;
            }
        }

        socket.close();
        System.out.println("Client stopped!");
    }
}