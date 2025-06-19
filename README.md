# 🔐 Encrypted Chat System (Java)

A **multi-user encrypted chat system** built with Java sockets and multithreading.  
Each message is **securely encoded** using Caesar cipher + Base64 and shared in real-time across connected clients.

> ✨ Ideal for demonstrating Core Java skills, networking, concurrency, and basic cryptography — all in one neat project!

---

## 💡 Features

✅ Multi-client support using Java threads  
🔐 End-to-end encryption (custom Caesar + Base64 encoding)  
📡 Real-time message broadcasting  
🧾 Chat logging to `chat_log.txt`  
🛑 `/exit` command for graceful disconnect  
🧵 Thread-safe client handling with `Collections.synchronizedSet`

---

## 📁 Project Structure

```
EncryptedChat/
├── src/
│   └── com/chat/
│       ├── Server.java           # Starts server, handles connections
│       ├── Client.java           # Connects to server, sends/receives messages
│       ├── ClientHandler.java    # Threaded handler for each user
│       └── CryptoUtil.java       # Simple encryption/decryption logic
├── chat_log.txt                  # Auto-created log of chat messages
└── README.md                     # You're reading it!
```

---

## 🚀 How to Run

> Make sure you have Java (11 or above) and your project structure is intact.

### 🔧 Compile:
```bash
javac src/com/chat/*.java
```

### 🟢 Run Server:
```bash
java -cp src com.chat.Server
```

### 🧑‍💻 Open 2+ Terminals → Run Clients:
```bash
java -cp src com.chat.Client
```

- Enter your name when prompted.
- Chat freely with others in real-time.
- Type `/exit` to leave the chat.

---

## 🛠 Tech Stack

- ⚙️ Java SE (Core Java)
- 🧵 Java Threads & Concurrency
- 🌐 Java Sockets (TCP)
- 🔐 Base64 + Caesar Cipher Encryption
- 📁 File I/O for message logging

---

## 🤔 Why This Project?

This project demonstrates your ability to:
- Work with **real-time networking** using Java sockets
- Implement **custom encryption**
- Manage **thread safety**
- Create **clean CLI-based user experiences**
- Build scalable communication systems from scratch

Great for portfolios, interviews, and networking module practice!

---

## 📄 License

This project is licensed under the MIT License.

---

## 📬 Feedback & Contributions

Found a bug? Want to improve something?  
Feel free to [open an issue](https://github.com/JayGemawat/EncryptedChatting/issues) or submit a pull request!

---

⭐ Don’t forget to **star** the repository if you found it helpful!
