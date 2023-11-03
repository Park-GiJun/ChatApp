package com.chat;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Main {
	public static void main(String[] args) {
		// 클라이언트 연결 관리 클래스 생성
		ClientConnection clientConnection = new ClientConnection("14.42.124.35", 5000);

		// 메인 프레임 생성 및 연결 관리 객체 전달
		Adapter adapter = new Adapter(clientConnection);
		MainFrame mainFrame = new MainFrame(clientConnection, adapter);
		// 메인 프레임 표시
		mainFrame.setVisible(true);
		
		while (!mainFrame.getPass()) {
//			System.out.println("Loading...");
			String stop = "stop";
		}
		System.out.println(mainFrame.getPass());
		// 메시지 수신 스레드 시작
		Thread messageReceiverThread = new Thread(new Runnable() {
			public void run() {
				System.out.println("메시지 수신 스레드 시작");
				while (true) {
					try {
						System.out.println("메시지 대기 중...");
						ClientConnection.MessageResult receivedMessage = clientConnection.receiveMessage();
						String senderName = receivedMessage.getSendName();
						String receiveMessage = receivedMessage.getReceivedMessage();
						String recipient = receivedMessage.getRecipient();
						System.out.println(
								"메시지 수신: 발신자=" + senderName + ", 메시지=" + receiveMessage + ", 수신자=" + recipient);
						String id = mainFrame.getId();
						
						if (recipient.equals(id)) {
							JOptionPane.showMessageDialog(mainFrame, senderName + "님이 메세지를 발송했습니다.");
							mainFrame.saveReceiveChat(receiveMessage, recipient, senderName);
							mainFrame.readTextFile(id, senderName);
							SwingUtilities.invokeLater(new Runnable() {
								public void run() {
									mainFrame.appendMessageToTextArea(senderName + " : " + receiveMessage);
								}
							});
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});

		messageReceiverThread.start();

	}
}