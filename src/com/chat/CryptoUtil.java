package com.chat;

import java.util.Base64;

public class CryptoUtil {
    private static final int SHIFT = 4;

    public static String encrypt(String message) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : message.toCharArray()) {
            encrypted.append((char) (c + SHIFT));
        }
        return Base64.getEncoder().encodeToString(encrypted.toString().getBytes());
    }

    public static String decrypt(String encryptedMessage) {
        String decoded = new String(Base64.getDecoder().decode(encryptedMessage));
        StringBuilder decrypted = new StringBuilder();
        for (char c : decoded.toCharArray()) {
            decrypted.append((char) (c - SHIFT));
        }
        return decrypted.toString();
    }
}
