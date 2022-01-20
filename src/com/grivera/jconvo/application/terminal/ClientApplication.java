package com.grivera.jconvo.application.terminal;

import com.grivera.jconvo.client.Client;

import java.io.IOException;
import java.util.*;

public class ClientApplication {

    public static void main(String[] args) throws IOException {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter a username...");
        String username = keyboard.nextLine();
        Client client = new Client("127.0.0.1", 18000, username);
        System.out.println("Connected to server!");

        client.setOnReceiveMessage((message) -> {

            if (message == null || message.author().equals(username)) return;

            System.out.printf("%s\n", message.getRaw());

        });
        client.start();

        String text;
        while (true) {

            try {

                text = keyboard.nextLine();

            } catch (NoSuchElementException e) {

                keyboard.close();
                break;

            }

            client.requestToSend(text);

        }

    }

}
