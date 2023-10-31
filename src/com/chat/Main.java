package com.chat;

import com.chat.ClientConnection.MessageResult;

public class Main {
	public static void main(String[] args) {
		// 클라이언트 연결 관리 클래스 생성
		ClientConnection clientConnection = new ClientConnection("192.168.0.122", 12345);

		// 메인 프레임 생성 및 연결 관리 객체 전달
		MainFrame mainFrame = new MainFrame(clientConnection);

		// 메인 프레임 표시
		mainFrame.setVisible(true);

		// 메시지 수신 스레드 시작
		Thread messageReceiverThread = new Thread(new Runnable() {
			public void run() {
				while (true) {
					MessageResult receivedMessage = clientConnection.receiveMessage();
					String senderName = receivedMessage.getSendName();
					String receiveMessage = receivedMessage.getReceivedMessage();
					String receipent = receivedMessage.getRecipient();
					if (receivedMessage != null) {
						String id = mainFrame.getId();
						System.out.println("발신자: " + senderName + " 메세지 :" + receiveMessage + " 수신자 : " + receipent + " ID : " + id);
						if (receipent.equals(id)) {
						mainFrame.appendMessageToTextArea(receiveMessage);
						System.out.println("수신자 = id");

						}
					}
				}
			}
		});
		messageReceiverThread.start();
	}
}