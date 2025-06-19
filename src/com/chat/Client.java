// ✅ Final Client.java
package com.chat;

import java.io.*;
import java.net.*;

public class Client {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            // Reader thread to listen for messages from server
            Thread reader = new Thread(() -> {
                String encrypted;
                try {
                    while ((encrypted = in.readLine()) != null) {
                        try {
                            System.out.println(CryptoUtil.decrypt(encrypted));
                        } catch (IllegalArgumentException e) {
                            // Fallback for unencrypted messages
                            System.out.println(encrypted);
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Connection closed.");
                }
            });
            reader.start();

            // Main loop for sending messages
            boolean isFirstMessage = true;
            while (true) {
                String input = userInput.readLine();

                if (isFirstMessage) {
                    out.println(input); // Send name
                    isFirstMessage = false;
                } else if (input.equalsIgnoreCase("/exit")) {
                    System.out.println("🔒 Disconnected from chat.");
                    socket.close();
                    System.exit(0);
                } else {
                    out.println(CryptoUtil.encrypt(input));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
