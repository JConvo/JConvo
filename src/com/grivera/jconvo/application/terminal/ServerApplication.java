package com.grivera.jconvo.application.terminal;

import com.grivera.jconvo.server.Server;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerApplication {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(18000);
        Server server = new Server(serverSocket);
        System.out.println("Server started!");
        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {

            try {

                serverSocket.close();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }));

    }

}
