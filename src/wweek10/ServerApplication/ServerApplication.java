package org.example;

import java.io.IOException;

public class ServerApplication
{
    public static void main( String[] args ) {
        try {
            GameServer gameServer = new GameServer(5555);
            gameServer.start();
        } catch (IOException e) {
            System.err.println("Server error... " + e);
        }
    }
}
