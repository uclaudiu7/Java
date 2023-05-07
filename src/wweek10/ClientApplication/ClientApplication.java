package org.example;

import java.io.IOException;

public class ClientApplication
{
    public static void main( String[] args ) {
        try {
            GameClient gameClient = new GameClient("localhost", 5555);
            gameClient.start();
        } catch (IOException e) {
            System.err.println("Client error... " + e);
        }
    }
}