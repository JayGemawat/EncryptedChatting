// ✅ Final ClientHandler.java with Chat Logging
package com.chat;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Set<ClientHandler> clientHandlers;
    private String clientName;

    public ClientHandler(Socket socket, Set<ClientHandler> handlers) {
        this.socket = socket;
        this.clientHandlers = handlers;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println(CryptoUtil.encrypt("Enter your name:"));
            clientName = in.readLine(); // Name sent in plain text

            String joinMsg = "🔔 " + clientName + " joined the chat";
            broadcast(CryptoUtil.encrypt(joinMsg));
            logMessage(joinMsg);

            String encryptedMessage;
            while ((encryptedMessage = in.readLine()) != null) {
                String message = CryptoUtil.decrypt(encryptedMessage);

                if (message.equalsIgnoreCase("/exit")) {
                    break; // Disconnect user
                }

                String chatMsg = "[" + getTime() + "] " + clientName + ": " + message;
                broadcast(CryptoUtil.encrypt(chatMsg));
                logMessage(chatMsg);
            }
        } catch (IOException e) {
            System.out.println("❌ " + clientName + " disconnected.");
        } finally {
            try {
                clientHandlers.remove(this);
                String leaveMsg = "🚪 " + clientName + " left the chat";
                broadcast(CryptoUtil.encrypt(leaveMsg));
                logMessage(leaveMsg);
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void broadcast(String message) {
        for (ClientHandler client : clientHandlers) {
            client.out.println(message);
        }
    }

    private void logMessage(String message) {
        try (FileWriter writer = new FileWriter("chat_log.txt", true)) {
            writer.write(message + "\n");
        } catch (IOException e) {
            System.out.println("⚠️ Failed to log chat message.");
            e.printStackTrace();
        }
    }

    private String getTime() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }
}