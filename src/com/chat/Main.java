package com.chat;

import com.chat.ClientConnection.MessageResult;

public class Main {
	public static void main(String[] args) {
		// 클라이언트 연결 관리 클래스 생성
		ClientConnection clientConnection = new ClientConnection("14.42.124.35", 5000);

		// 메인 프레임 생성 및 연결 관리 객체 전달
		MainFrame mainFrame = new MainFrame(clientConnection);

		// 메인 프레임 표시
		mainFrame.setVisible(true);
		System.out.println(mainFrame.getPass());
		while (!mainFrame.getPass()) {
			System.out.println("1");
		}
		// 메시지 수신 스레드 시작
		Thread messageReceiverThread = new Thread(new Runnable() {

			public void run() {
				System.out.println("1");
				while (true) {
					System.out.println("2");
					MessageResult receivedMessage = clientConnection.receiveMessage();
					String senderName = receivedMessage.getSendName();
					String receiveMessage = receivedMessage.getReceivedMessage();
					String receipent = receivedMessage.getRecipient();
					System.out.println("메세지 수신");
					if (receivedMessage != null) {
						System.out.println("3");
						String id = mainFrame.getId();
						System.out.println("발신자: " + senderName + " 메세지 :" + receiveMessage + " 수신자 : " + receipent
								+ " ID : " + id);
						if (receipent.equals(id)) {
							mainFrame.appendMessageToTextArea(receiveMessage, senderName);
							System.out.println("수신자 = id");

						}
					}
				}
			}
		});

		messageReceiverThread.start();

	}
}