package com.chat;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;

public class MainFrame extends JFrame {

	private ClientConnection clientConnection; // ClientConnection 객체 추가

	// 로그인 패널 및 로그인 정보 필드
	private JPanel loginPanel = new JPanel();
	private JTextField id_TextField = new JTextField();
	private JTextField pwd_TextField = new JTextField();
	private JButton login_Btn = new JButton();
	private String id, pwd, UserEmail, name;
	private boolean pass = false;
	private JButton pwdAdminSet = new JButton();

	// 메인패널
	JPanel main_Panel = new JPanel();
	JPanel left_Panel = new JPanel();
	JButton home_Btn = new JButton();
	JButton search_Btn = new JButton();
	JButton message_Btn = new JButton();
	JButton info_Btn = new JButton();

	CardLayout panelLayout = new CardLayout();
	JPanel card_Panel = new JPanel();

	// HOME 패널
	JPanel home_Panel = new JPanel();
	JPanel home_photo = new JPanel();
	JLabel home_name = new JLabel();
	JLabel home_num = new JLabel();
	JLabel home_email = new JLabel();
	JLabel home_deptNum = new JLabel();
	JPanel home_todo = new JPanel();
	JLabel home_todo_list = new JLabel();

	// 서치 패널
	JPanel search_Panel = new JPanel();
	JPanel search_List = new JPanel();
	JPanel search_Page = new JPanel();
	JTextField search_bar = new JTextField();
	JTree search_Tree = new JTree();

	// 메세지 패널
	JPanel message_Panel = new JPanel();
	JPanel message_Box = new JPanel();
	JScrollPane message_chatBox = new JScrollPane();
	JScrollPane message_chatlog = new JScrollPane();
	JButton message_postBtn = new JButton();
	JPanel message_sendPanel = new JPanel();
	JTextField message_sendBox = new JTextField();
	JButton message_sendBtn = new JButton();

	// 채팅방
	JTextArea messageDisplayArea = new JTextArea(); // JTextArea를 인스턴스 변수로 선언
	JButton addPerson = new JButton();

	// 메세지
	public boolean getPass() {
		return pass;
	}
//	public String getUserEmail() {
//		UserEmail = home_email.getText();
//		return UserEmail;
//	}
//	public String getName() {
//		name = home_name.getText();
//		return name;
//	}
	public MainFrame() {}
	public MainFrame(ClientConnection clientConnection) {
		this.clientConnection = clientConnection; // ClientConnection 초기화

		CardLayout mainLayout = new CardLayout();
		setLayout(mainLayout);
		setSize(800, 560);
		getContentPane().setLayout(mainLayout);
		setResizable(false);

		// 로그인 패널
		add(loginPanel);
		getContentPane().add("loginPanel", loginPanel);
		loginPanel.setLayout(null);
		loginPanel.setSize(800, 560);
		loginPanel.add(id_TextField);
		loginPanel.add(pwd_TextField);
		loginPanel.add(login_Btn);
		id_TextField.setBounds(218, 326, 251, 38);
		pwd_TextField.setBounds(218, 374, 251, 38);
		login_Btn.setBounds(496, 326, 86, 86);
		loginPanel.add(pwdAdminSet);
		pwdAdminSet.setBounds(218, 417, 80, 20);

		// 로그인 버튼
		login_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = id_TextField.getText();
				pwd = pwd_TextField.getText();
				if (!id.isEmpty() && !pwd.isEmpty()) {
					// 서버로 아이디와 비밀번호 전송 (이 부분은 ClientConnection 클래스로 이동)
					try {
						if (clientConnection.login(id, pwd)) {
							mainLayout.show(getContentPane(), "mainPanel");
							pass = true;
							home_name.setText("이름 : " + clientConnection.getName());
							home_email.setText("이메일 : " + clientConnection.getEmail());
							home_num.setText("전화번호 : " + clientConnection.getPhone());
							home_deptNum.setText("내선번호 : " + clientConnection.getDeptNum());
							setTitle(id);
						} else {
							JOptionPane.showMessageDialog(loginPanel, "아이디와 비밀번호를 확인해주세요.", "로그인에 실패했습니다.",
									JOptionPane.WARNING_MESSAGE);
							mainLayout.show(getContentPane(), "mainPanel");
						}
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		pwdAdminSet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PasswordSet_admin pwdSet = new PasswordSet_admin();
			}
		});

		setTitle(id);

		// 메인 패널
		add(main_Panel);
		getContentPane().add("mainPanel", main_Panel);
		main_Panel.setSize(800, 560);
		main_Panel.setLayout(null);
		main_Panel.add(left_Panel);
		left_Panel.setBounds(0, 0, 100, 300);
		left_Panel.setLayout(new GridLayout(3, 1));
		left_Panel.add(home_Btn);
		home_Btn.setText("Home");
		home_Btn.setSize(100, 100);
		left_Panel.add(search_Btn);
		search_Btn.setText("Search");
		search_Btn.setSize(100, 100);
		left_Panel.add(message_Btn);
		message_Btn.setText("Message");
		message_Btn.setSize(100, 100);

		// 변경 패널

		main_Panel.add(card_Panel);
		card_Panel.setLayout(panelLayout);
		card_Panel.setBounds(100, 0, 700, 560);
		card_Panel.setBackground(Color.red);
		card_Panel.add(home_Panel, "homePanel");
		card_Panel.add(search_Panel, "searchPanel");
		card_Panel.add(message_Panel, "messagePanel");

		// 홈패널
		home_Panel.setLayout(null);
		home_Panel.setBackground(Color.gray);
		home_Panel.setBounds(100, 0, 700, 560);
		home_Panel.add(home_photo);
		home_photo.setBounds(268, 25, 165, 210);

		home_Panel.add(home_name);
		home_name.setBounds(290, 250, 200, 20);
		home_Panel.add(home_num);
		home_num.setBounds(290, 275, 200, 20);
		home_Panel.add(home_email);
		home_email.setBounds(290, 300, 200, 20);
		home_Panel.add(home_deptNum);
		home_deptNum.setBounds(290, 325, 100, 20);

		home_Panel.add(home_todo);
		home_todo.setBounds(195, 356, 310, 170);
		home_todo.add(home_todo_list);
		
		// 정보수정 버튼 추가 액션 추가 
		info_Btn.setBounds(16, 530, 20, 10);
		left_Panel.add(info_Btn);
		info_Btn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				Information info = new Information();
			}
		});

		// 서치패널
		search_Panel.setLayout(null);
		search_Panel.setBounds(0, 0, 700, 560);
		search_Panel.add(search_List);
		search_List.setBackground(Color.darkGray);
		search_List.setBounds(0, 0, 230, 560);
		search_Panel.add(search_Page);
		search_Page.setBounds(230, 0, 470, 560);
		search_Page.setBackground(Color.green);
		search_List.add(search_bar);
		search_bar.setBounds(0, 28, 200, 50);
		search_List.add(search_Tree);
		search_List.setBounds(0, 81, 230, 450);

		// 메세지 패널
		message_Panel.setLayout(null);
		message_Panel.setBounds(100, 0, 700, 500);
		message_Panel.setBackground(Color.blue);
		message_Panel.add(message_Box);
		message_Box.setBounds(0, 0, 90, 520);
		message_Box.setBackground(Color.orange);
		BoxLayout boxLayoutY = new BoxLayout(message_Box, BoxLayout.Y_AXIS);
		message_Box.setLayout(boxLayoutY);
		message_Panel.add(message_chatBox);
		message_chatBox.setBounds(90, 0, 610, 520);
		message_chatBox.setBackground(Color.pink);
		message_Box.add(message_postBtn);
		message_postBtn.setSize(90, 70);
		message_postBtn.setText("Post");
		message_chatBox.add(message_sendBox);
		message_chatBox.setLayout(null);
		message_chatBox.add(message_sendPanel);
		CardLayout chatlistLayout = new CardLayout();
		message_sendPanel.setLayout(null);
		message_sendPanel.setBounds(0, 485, 610, 40);
		// 메세지 입력창
		message_sendPanel.add(message_sendBox);
		message_sendBox.setBounds(0, 0, 520, 40);
		/// 메세지 전송 버튼
		message_sendPanel.add(message_sendBtn);
		message_sendBtn.setBounds(520, 0, 90, 40);
		// 메세지 로그
		message_chatBox.add(message_chatlog);
		message_chatlog.setBounds(0, 0, 610, 520);
		message_chatlog.setBackground(Color.red);
		message_Box.add(addPerson);
		addPerson.setText("Add Person");
		addPerson.setSize(90, 70);

		// 새로운 JPanel을 만들어서 메시지를 표시할 것입니다.
		messageDisplayArea = new JTextArea();
		messageDisplayArea.setEditable(false);
		messageDisplayArea.setLayout(new BoxLayout(messageDisplayArea, BoxLayout.Y_AXIS));

		// message_chatlog에 messageDisplayPanel을 추가합니다.
		message_chatlog.setViewportView(messageDisplayArea);

		// 메세지 입력 필드와 전송 버튼 리스너
		message_sendBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = message_sendBox.getText();
				sendMessage(message);
			}
		});

		// 채팅목록
		// 사용자 추가
		addPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String recipient = JOptionPane.showInputDialog("Enter recipient: ");
				JButton personButton = new JButton(recipient);
				personButton.setMaximumSize(new Dimension(90, 50)); // 최대 크기 설정
				message_Box.add(personButton);
				message_Box.revalidate(); // 레이아웃을 갱신하여 버튼을 새 위치에 배치
				JTextArea recipientChatArea = new JTextArea();

			}
		});

		home_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLayout.show(card_Panel, "homePanel");
			}
		});
		search_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLayout.show(card_Panel, "searchPanel");
			}
		});

		message_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLayout.show(card_Panel, "messagePanel");
			}
		});
	}

	// 메시지를 전송하는 메서드
	private void sendMessage(String message) {
		if (!message.isEmpty()) {
			JLabel messageLabel = new JLabel("Me" + "- send : " + message);
			messageLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
			messageDisplayArea.add(messageLabel);
			messageDisplayArea.add(Box.createRigidArea(new Dimension(0, 5)));
			message_sendBox.setText("");
			message_chatlog.revalidate();
			message_chatlog.repaint();
			String recipient = JOptionPane.showInputDialog("Enter recipient's name:");
			if (recipient != null && !recipient.isEmpty()) {
				clientConnection.sendMessage(id, message, recipient);
				message_sendBox.setText("");
			} else {
				JOptionPane.showMessageDialog(this, "수신자의 이름을 입력하세요.", "전송 오류", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	public void receiveMessages() {
		try {
			while (true) {
				String message = clientConnection.receiveMessage().getReceivedMessage(); // 서버로부터 메시지 받기
				String name = clientConnection.receiveMessage().getSendName();
				if (message != null) {
					appendMessageToTextArea(message, name);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void appendMessageToTextArea(String message, String sendName) {
		JLabel messageLabel = new JLabel(sendName + "- receive : " + message);
		System.out.println("mainFrame :" + message);
		messageLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		messageDisplayArea.add(messageLabel);
		messageDisplayArea.add(Box.createRigidArea(new Dimension(0, 5)));
		// message_chatlog가 스크롤되도록 만듭니다
		message_chatlog.revalidate();
		message_chatlog.repaint();
	}

	public String getId() {
		return id_TextField.getText();
	}
}