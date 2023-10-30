package com.chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientConnection {
	private String serverAddress;
	private int serverPort;
	private ObjectOutputStream out;
	private ObjectInputStream in;

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
			in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage(String userName, String message, String recipient) {
		try {
			String inp = userName + ":" + message + ":" + recipient;
			out.writeObject(inp);
			System.out.println(inp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String receiveMessage() {
		String receivedMessage = null; // 메시지를 저장할 변수를 미리 선언
		try {
			String inp = (String) in.readObject();
			System.out.println(inp);
			String[] arr = inp.split(":");
			String sendName = arr[0];
			receivedMessage = arr[1];
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return receivedMessage;
	}
}
