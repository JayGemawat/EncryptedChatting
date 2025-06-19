# 🔐 Encrypted Chat System (Java)

A multi-user, console-based encrypted chat system using Java sockets, multithreading, and custom encryption.

## 💡 Features
- Multi-client support using threads
- End-to-end encryption using Caesar + Base64
- Real-time chat broadcast
- `/exit` command for safe disconnect
- Auto-saves chat logs to `chat_log.txt`

## 📁 Project Structure
src/
└── com/chat/
├── Server.java
├── Client.java
├── ClientHandler.java
└── CryptoUtil.java
chat_log.txt (auto-created)


Copy
Edit

## 🚀 How to Run
1. Compile all Java files in the `com.chat` package.
2. Run `Server.java`
3. Open 2+ terminals and run `Client.java` in each
4. Chat securely and use `/exit` to disconnect.

## 📦 Tech Stack
- Java SE
- Sockets & Multithreading
- Base64 + Caesar Cipher encryption


