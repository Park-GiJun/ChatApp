package com.chat;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Main {
	public static void main(String[] args) {
		// 클라이언트 연결 관리 클래스 생성

		ClientConnection clientConnection = new ClientConnection("14.42.124.35", 5000);

		Thread messageReceiverThread = new Thread(new Runnable() {
			public void run() {
				// 메인 프레임 생성 및 연결 관리 객체 전달
				Adapter adapter = new Adapter(clientConnection);
				MainFrame mainFrame = new MainFrame(clientConnection, adapter);
				// 메인 프레임 표시
				mainFrame.setVisible(true);

				while (!mainFrame.getPass()) {
					System.out.println("Loading...");
				}
				System.out.println(mainFrame.getPass());
				// 메시지 수신 스레드 시작
				System.out.println("수신 스레드 시작");
				while (true) {
					String check = clientConnection.selectMethod();
					mainFrame.home_email.setText("이메일 : " + adapter.getEmail());
					mainFrame.home_num.setText("전화번호 : " + adapter.getPhone());
					mainFrame.home_deptNum.setText("내선번호 : " + adapter.getNum());
					if(check.equals("[nameTree]")) {
					mainFrame.search_DBlist.setListData(clientConnection.getNameTree());
					}
					if(check.equals("[searchPerson]")) {
					mainFrame.result_Name.setText("이름 : "+clientConnection.searchName);
					mainFrame.result_Email.setText("이메일 : "+clientConnection.searchEmail);
					mainFrame.result_Num.setText("내선번호 : "+clientConnection.searchDeptNum);
					mainFrame.result_Phone.setText("전화번호 : "+clientConnection.searchPhone);
					
					BufferedImage originalImage = clientConnection.searchImage;
					int newWidth = 165; // 원하는 너비
					int newHeight = 190; // 원하는 높이

					BufferedImage resizedImage = resize(originalImage, newWidth, newHeight);
					JLabel userImageLabel = new JLabel(new ImageIcon(resizedImage));
					mainFrame.result_Photo.add(userImageLabel);
					
					mainFrame.result_Panel.revalidate();
                    mainFrame.result_Panel.repaint();
					
					}
					if (check.equals("[chat]")) {
						try {
							System.out.println("메시지 대기 중...");
							ClientConnection.MessageResult receivedMessage = clientConnection.receiveMessage();
							String senderName = receivedMessage.getSendName();
							String receiveMessage = receivedMessage.getReceivedMessage();
							String recipient = receivedMessage.getRecipient();
							System.out.println(
									"메시지 수신: 발신자=" + senderName + ", 메시지=" + receiveMessage + ", 수신자=" + recipient);
							String id = mainFrame.getId();
							if (recipient.equals("post")) {
								System.out.println("공지사항 수신");
								JOptionPane.showMessageDialog(mainFrame, "공지사항이 있습니다.\n");
								mainFrame.receivePost(receiveMessage);
								mainFrame.readPost();
								SwingUtilities.invokeLater(new Runnable() {
									public void run() {
									}
								});
							} else if (recipient.equals(id)) {
								JOptionPane.showMessageDialog(mainFrame, senderName + "님이 메세지를 발송했습니다.");
								mainFrame.saveReceiveChat(receiveMessage, recipient, senderName);
								mainFrame.readTextFile(id, senderName);
								mainFrame.makeBtn(senderName);
								SwingUtilities.invokeLater(new Runnable() {
									public void run() {
									}
								});
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		messageReceiverThread.start();
	}
	public static BufferedImage resize(BufferedImage img, int newWidth, int newHeight) {
		Image tmp = img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = resizedImage.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();

		return resizedImage;
	}
}
