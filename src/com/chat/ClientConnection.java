package com.chat;

import java.io.*;
import java.net.Socket;

public class ClientConnection {
	private String serverAddress;
	private int serverPort;
	private ObjectOutputStream out;

	public ClientConnection(String serverAddress, int serverPort) {
		this.serverAddress = serverAddress;
		this.serverPort = serverPort;
		connectToServer();
	}

	public void login(String id, String pwd) throws IOException {
		// 서버로 아이디와 비밀번호 전송
		out.writeObject(id);
		out.writeObject(pwd);
		// 이후 로그인 처리를 서버에서 수행
	}

	// 서버에 연결하는 메서드
	private void connectToServer() {
		try {
			Socket socket = new Socket(serverAddress, serverPort);
			out = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 메시지를 서버로 전송하는 메서드
	public void sendMessage(String message, String recipient) {
		try {
			out.writeObject(message);
			out.writeObject(recipient);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
