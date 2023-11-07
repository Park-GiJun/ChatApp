package com.chat;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	// ClientConnection 객체 추가
	private ClientConnection clientConnection;
	private Map<String, String> receivedMessages = new HashMap<>();
	private Adapter adapter;
	LocalDateTime currentDateTime = LocalDateTime.now();

	// 로그인 패널 및 로그인 정보 필드
	private JPanel loginPanel = new JPanel();
	private JTextField id_TextField = new JTextField();
	private JTextField pwd_TextField = new JTextField();
	private JButton login_Btn = new JButton();
	private String id, pwd, UserEmail, name;
	private boolean pass = false;
	private JButton pwdAdminSet = new JButton();
	Color aColor = new Color(121, 144, 163);
	Color bColor = new Color(193, 223, 249);
	Color cColor = new Color(116, 140, 219);
	Color dColor = new Color(22, 59, 136);
	Color eColor = new Color(25, 45, 69);

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
	String state = "";
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
	JTextField search_bar = new JTextField(12);
	JButton search_btnclick = new JButton();
	JTree search_Tree = new JTree();
	JList<String> search_DBlist = new JList<String>(new String[] { "item1", "item2" });
	JScrollPane search_listPanel = new JScrollPane();

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
	JScrollBar verticalScrollBar = new JScrollBar();
	String clickedRecipient;
	Map<String, JButton> recipientButtons = new HashMap<>();

	public boolean getPass() {
		return pass;
	}

	public MainFrame(ClientConnection clientConnection, Adapter adapter) {
		this.clientConnection = clientConnection; // ClientConnection 초기화
		this.adapter = adapter;
		CardLayout mainLayout = new CardLayout();
		setLayout(mainLayout);
		setSize(800, 560);
		getContentPane().setLayout(mainLayout);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
						if (!id.equals("admin") && !pwd.equals("admin")) {
							clientConnection.login(id, pwd);
							mainLayout.show(getContentPane(), "mainPanel");
							pass = true;
							name = clientConnection.getName();
							UserEmail = clientConnection.getEmail();
							String phone = clientConnection.getPhone();
							String Dept_num = clientConnection.getDeptnum();
							home_name.setText("이름 : " + name);
							home_email.setText("이메일 : " + UserEmail);
							home_num.setText("전화번호 : " + phone);
							home_deptNum.setText("내선번호 : " + Dept_num);
							adapter.setId(id);
							adapter.setPwd(pwd);
							adapter.setName(name);
							adapter.setEmail(UserEmail);
							adapter.setPhone(phone);
							adapter.setNum(Dept_num);

							setTitle(id);
						} else if (id.equals("admin") && pwd.equals("admin")) {
							// 관리자 프레임 만들어서 넣기
//							mainLayout.show(getContentPane(), "mainPanel");
						} else {
							JOptionPane.showMessageDialog(loginPanel, "아이디와 비밀번호를 확인해주세요.", "로그인에 실패했습니다.",
									JOptionPane.WARNING_MESSAGE);
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(loginPanel, "아이디와 비밀번호를 확인해주세요.", "로그인에 실패했습니다.",
							JOptionPane.WARNING_MESSAGE);

				}
			}
		});
		pwdAdminSet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PasswordSet_admin pwdSet = new PasswordSet_admin(adapter);

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
		left_Panel.setLayout(new GridLayout(4, 1));
		left_Panel.add(home_Btn);
		home_Btn.setText("Home");
		home_Btn.setSize(100, 100);
		left_Panel.add(search_Btn);
		search_Btn.setText("Search");
		search_Btn.setSize(100, 100);
		left_Panel.add(message_Btn);
		message_Btn.setText("Message");
		message_Btn.setSize(100, 100);

		// 색상
		home_Btn.setBackground(aColor);
		home_Btn.setBorder(null);
		search_Btn.setBackground(aColor);
		search_Btn.setBorder(null);
		message_Btn.setBackground(aColor);
		message_Btn.setBorder(null);
		info_Btn.setBackground(aColor);
		info_Btn.setBorder(null);
		main_Panel.setBackground(aColor);
		message_postBtn.setBackground(cColor);
		addPerson.setBackground(cColor);
		message_postBtn.setBorder(null);
		addPerson.setBorder(null);
		home_todo.setBackground(eColor);

		// 변경 패널
		main_Panel.add(card_Panel);
		card_Panel.setLayout(panelLayout);
		card_Panel.setBounds(100, 0, 700, 560);
		card_Panel.add(home_Panel, "homePanel");
		card_Panel.add(search_Panel, "searchPanel");
		card_Panel.add(message_Panel, "messagePanel");

		// 홈패널
		home_Panel.setLayout(null);
		home_Panel.setBackground(dColor);
		home_Panel.setBounds(100, 0, 700, 560);
		home_Panel.add(home_photo);
		home_photo.setBounds(268, 25, 165, 190);

		ImageIcon mario = new ImageIcon("src/com/images/test1.jfif");
		JLabel home_test = new JLabel("ONE", mario, SwingConstants.CENTER);

		home_photo.add(home_test);
		home_photo.setBackground(dColor);

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
		home_todo.setBorder(new LineBorder(eColor, 30, true));

		// 정보수정 버튼 추가 액션 추가
		info_Btn.setSize(100, 100);
		left_Panel.add(info_Btn);
		info_Btn.setText("SetInfo");
		info_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Information info = new Information(adapter);
			}
		});

		// 서치패널
		search_Panel.setLayout(null);
		search_Panel.setBounds(0, 0, 700, 560);

		// 검색 리스트 패널 (search_List) 설정
		search_List.setBackground(bColor);
		search_List.setLayout(null);
		search_List.setBounds(0, 0, 230, 560);

		// 검색 바 설정
		search_bar.setText("");
		search_bar.setBounds(10, 20, 150, 40);
		search_List.add(search_bar);

		// 검색 버튼 설정
		search_btnclick.setBounds(170, 20, 50, 40);
		search_btnclick.setText("검색");
		search_List.add(search_btnclick);

		// 검색 결과 페이지 (search_Page) 설정
		search_Page.setBounds(230, 0, 470, 560);
		search_Page.setBackground(dColor);

		// 검색 리스트 패널 (search_listPanel) 설정
		search_listPanel.setBounds(0, 80, 230, 450);

		// search_Panel에 모든 컴포넌트를 추가합니다.
		search_Panel.add(search_List);
		search_Panel.add(search_Page);

		// search_List 패널에 search_bar와 search_btnclick를 추가합니다.
		search_List.add(search_bar);
		search_List.add(search_btnclick);
		search_List.add(search_DBlist);
		search_DBlist.setBounds(10, 90, 210, 350);

//		JButton example = new JButton("12");
//		search_List.add(example);
//		example.setBounds(10, 90, 210, 350);

		search_btnclick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search = search_bar.getText();

				System.out.println(search);
			}
		});

//		search_List.add(search_Tree);
//		search_List.setBounds(0, 81, 230, 450);

		// 메세지 패널
		message_Panel.setLayout(null);
		message_Panel.setBounds(100, 0, 700, 500);
		message_Panel.setBackground(dColor);
		message_Panel.add(message_Box);
		message_Box.setBounds(0, 0, 90, 540);
		message_Box.setBackground(bColor);
		BoxLayout boxLayoutY = new BoxLayout(message_Box, BoxLayout.Y_AXIS);
		message_Box.setLayout(boxLayoutY);
		message_Panel.add(message_chatBox);
		message_chatBox.setBounds(90, 0, 610, 520);
		message_Box.add(message_postBtn);
		message_postBtn.setMaximumSize(new Dimension(90, 50));
		message_postBtn.setText("Post");
		message_chatBox.add(message_sendBox);
		message_chatBox.setLayout(null);
		message_chatBox.add(message_sendPanel);
		message_sendPanel.setLayout(null);
		message_sendPanel.setBounds(0, 485, 610, 40);

		// 메세지 입력창
		message_sendPanel.add(message_sendBox);
		message_sendBox.setBounds(0, 0, 520, 50);
		message_sendBox.setBorder(null);

		// 메세지 전송 버튼
		message_sendPanel.add(message_sendBtn);
		message_sendBtn.setBounds(520, 0, 90, 40);
		message_sendBtn.setText("Send");

		// 메세지 로그
		message_chatBox.add(message_chatlog);
		message_chatlog.setBounds(0, 0, 610, 490);
		message_chatlog.setBackground(Color.red);
		message_Box.add(addPerson);
		addPerson.setText("Add Person");
		addPerson.setMaximumSize(new Dimension(90, 70));

		// 새로운 JPanel을 만들어서 메시지를 표시할 것입니다.
		messageDisplayArea = new JTextArea();
		messageDisplayArea.setEditable(false);
		messageDisplayArea.setLayout(new BoxLayout(messageDisplayArea, BoxLayout.Y_AXIS));

		// message_chatlog에 messageDisplayPanel을 추가합니다.
		message_chatlog.setViewportView(messageDisplayArea);

//		// 사용자 추가
		clickedRecipient = null;

		addPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String recipient = JOptionPane.showInputDialog("수신자: ");
				JButton personButton = new JButton(recipient);
				personButton.setBackground(cColor);
				String buttonText = recipient;
				personButton.setMaximumSize(new Dimension(90, 50)); // 최대 크기 설정
				message_Box.add(personButton);
				recipientButtons.put(recipient, personButton);
				message_Box.revalidate(); // 레이아웃을 갱신하여 버튼을 새 위치에 배치
				String aMessage = "님이 연결 시도했습니다.";
				sendMessage(aMessage, recipient);
				sendMessage(aMessage, recipient);
				personButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						messageDisplayArea.setText("");
						String message = message_sendBox.getText();
						clickedRecipient = recipient;
						message_sendBtn.setText(recipient);
						if (message != null) {
							showMessageForRecipient(buttonText);
							sendMessage(message, recipient);
							saveSendChat(message, recipient, id);
							try {
								readTextFile(id, recipient);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						} else {
							message_sendBox.setText("");
						}

					}
				});
			}
		});

		message_sendBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				messageDisplayArea.setText("");
				String message = message_sendBox.getText();
				if (message != null) {
					sendMessage(message, clickedRecipient);
					saveSendChat(message, clickedRecipient, id);
				}
				try {
					readTextFile(id, clickedRecipient);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		message_sendBox.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					messageDisplayArea.setText("");
					String message = message_sendBox.getText();

					if (message != null) {
						sendMessage(message, clickedRecipient);
						saveSendChat(message, clickedRecipient, id);
					}
					try {
						readTextFile(id, clickedRecipient);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		home_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLayout.show(card_Panel, "homePanel");
				System.out.println(adapter.getEmail() + "*" + adapter.getPhone() + "*" + adapter.getNum());
				home_email.setText("이메일 : " + adapter.getEmail());
				home_num.setText("전화번호 : " + adapter.getPhone());
				home_deptNum.setText("내선번호 : " + adapter.getNum());
				search_Btn.setBackground(aColor);
				home_Btn.setBackground(bColor);
				message_Btn.setBackground(aColor);
			}
		});
		search_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLayout.show(card_Panel, "searchPanel");
				search_Btn.setBackground(bColor);
				home_Btn.setBackground(aColor);
				message_Btn.setBackground(aColor);
			}
		});
		message_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLayout.show(card_Panel, "messagePanel");
				search_Btn.setBackground(aColor);
				home_Btn.setBackground(aColor);
				message_Btn.setBackground(bColor);
			}
		});

		message_postBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = message_sendBox.getText();
				String post = "post";
				sendMessage(message, post);
				try {
					sendPostSave(post, message);
					readPost();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		// home_todo 패널의 레이아웃을 GridLayout(0, 2)로 설정
		home_todo.setLayout(new BoxLayout(home_todo, BoxLayout.Y_AXIS));

		// 할 일 목록을 관리할 리스트
		List<JCheckBox> todoList = new ArrayList<>();
		
		home_todo.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)) { // 좌클릭
					String todoStr = JOptionPane.showInputDialog("할일");
					
					if (todoStr != null && !todoStr.isEmpty()) {
						JCheckBox todoBox = new JCheckBox(todoStr);
						todoBox.setBackground(eColor);
						todoBox.setForeground(Color.white);
						todoList.add(todoBox);
						state = "add";
						// 할 일 목록을 그리드 레이아웃에 추가
						home_todo.add(todoBox);
						
						clientConnection.sendTodo(id, todoStr,state);

						todoBox.addItemListener(new ItemListener() {
							@Override
							public void itemStateChanged(ItemEvent event) {
								if (event.getStateChange() == ItemEvent.SELECTED) {
									state = "delete";
									clientConnection.sendTodo(id, todoStr, state);
									// 체크박스가 선택되면 해당 체크박스와 라벨을 제거
									home_todo.remove(todoBox);
									home_todo.revalidate();
									home_todo.repaint();
								}
							}
						});
						home_todo.setAlignmentY(CENTER_ALIGNMENT);
						// 패널을 다시 그리도록 요청
						home_todo.revalidate();
						home_todo.repaint();
					}
				}
			}
		});
	}

	// 메시지를 전송하는 메서드
	private void sendMessage(String message, String recipient) {
		if (!message.isEmpty()) {
			messageDisplayArea.add(Box.createRigidArea(new Dimension(0, 5)));
			message_sendBox.setText("");
			message_chatlog.revalidate();
			message_chatlog.repaint();
			clientConnection.sendMessage(id, message, recipient);
			message_sendBox.setText("");
		}
	}

	void appendMessageToTextArea(String message) {
		System.out.println("어펜드 메세지 실행");
		messageDisplayArea.add(Box.createRigidArea(new Dimension(0, 5)));
		message_chatlog.revalidate();
		message_chatlog.repaint();
	}

	// 수신자에 해당하는 메시지만 표시하는 메서드
	private void showMessageForRecipient(String recipient) {
		System.out.println("쇼메세지 실행");
		messageDisplayArea.setText("");
		for (String receivedMessage : receivedMessages.keySet()) {
			String senderName = receivedMessages.get(receivedMessage);
			if (recipient.equals(senderName)) {
				String messageText = senderName + " : " + receivedMessage;
				appendMessageToTextArea(messageText);
				saveReceiveChat(receivedMessage, recipient, id);
			}
		}
	}

	void saveSendChat(String message, String opposite, String me) {
		String username = System.getProperty("user.home");
		String filePath = username + "/git/ChatApp/src/com/chat/chats/" + me + "_" + opposite + ".txt";
		int year = currentDateTime.getYear();
		int month = currentDateTime.getMonthValue();
		int day = currentDateTime.getDayOfMonth();
		int hour = currentDateTime.getHour();
		int minute = currentDateTime.getMinute();
		int second = currentDateTime.getSecond();
		File file = new File(filePath);
		File parentDir = file.getParentFile();
		try {
			if (!parentDir.exists()) {
				// 디렉토리가 존재하지 않으면 생성
				parentDir.mkdirs();
			}
			if (!file.exists()) {
				// 파일이 존재하지 않으면 생성
				file.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(filePath, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(year + ":" + month + ":" + day + ":" + hour + ":" + minute + ":" + second + " // " + me
					+ " : " + message);
			bufferedWriter.newLine();
			bufferedWriter.close();
			System.out.println("saved Send Message");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void saveReceiveChat(String message, String opposite, String me) {
		String username = System.getProperty("user.home");
		String filePath = username + "/git/ChatApp/src/com/chat/chats/" + opposite + "_" + me + ".txt";
		int year = currentDateTime.getYear();
		int month = currentDateTime.getMonthValue();
		int day = currentDateTime.getDayOfMonth();
		int hour = currentDateTime.getHour();
		int minute = currentDateTime.getMinute();
		int second = currentDateTime.getSecond();
		File file = new File(filePath);
		File parentDir = file.getParentFile();

		try {
			if (!parentDir.exists()) {
				// 디렉토리가 존재하지 않으면 생성
				parentDir.mkdirs();
			}
			if (!file.exists()) {
				// 파일이 존재하지 않으면 생성
				file.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(filePath, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(year + ":" + month + ":" + day + ":" + hour + ":" + minute + ":" + second + " // " + me
					+ " : " + message);
			bufferedWriter.newLine();
			bufferedWriter.close();
			System.out.println("saved Receive Message");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void readTextFile(String me, String opposite) throws IOException {
		System.out.println("Reading Text...");
		messageDisplayArea.setText("");
		try {
			// 파일 경로
			String username = System.getProperty("user.home");
			String filePath = username + "/git/ChatApp/src/com/chat/chats/" + id + "_" + opposite + ".txt";

			// 파일을 읽어올 BufferedReader 생성
			BufferedReader reader = new BufferedReader(new FileReader(filePath));

			String line;
			while ((line = reader.readLine()) != null) {
				// 한 줄씩 읽어와서 JTextArea에 추가
				messageDisplayArea.append(line + "\n");
				verticalScrollBar.setValue(verticalScrollBar.getMaximum());

			}
			// BufferedReader 닫기
			reader.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	void sendPostSave(String post, String message) throws IOException {
		String username = System.getProperty("user.home");
		String filePath = username + "/git/ChatApp/src/com/chat/chats/post.txt";
		File file = new File(filePath);
		File parentDir = file.getParentFile();
		if (!parentDir.exists()) {
			// 디렉토리가 존재하지 않으면 생성
			parentDir.mkdirs();
		}
		if (!file.exists()) {
			// 파일이 존재하지 않으면 생성
			file.createNewFile();
		}
		int year = currentDateTime.getYear();
		int month = currentDateTime.getMonthValue();
		int day = currentDateTime.getDayOfMonth();
		int hour = currentDateTime.getHour();
		int minute = currentDateTime.getMinute();
		int second = currentDateTime.getSecond();
		FileWriter fileWriter = new FileWriter(filePath, true);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write(year + ":" + month + ":" + day + ":" + hour + ":" + minute + ":" + second + " // " + "post"
				+ " : " + message);
		bufferedWriter.newLine();
		bufferedWriter.close();
		System.out.println("saved Send Post Message");
	}

	void readPost() throws Exception {
		messageDisplayArea.setText("");
		String username = System.getProperty("user.home");
		String filePath = username + "/git/ChatApp/src/com/chat/chats/post.txt";

		// 파일을 읽어올 BufferedReader 생성
		BufferedReader reader = new BufferedReader(new FileReader(filePath));

		String line;
		while ((line = reader.readLine()) != null) {
			// 한 줄씩 읽어와서 JTextArea에 추가
			messageDisplayArea.append(line + "\n");
			verticalScrollBar.setValue(verticalScrollBar.getMaximum());
		}
		// BufferedReader 닫기
		reader.close();

	}

	void receivePost(String message) {
		String username = System.getProperty("user.home");
		String filePath = username + "/git/ChatApp/src/com/chat/chats/post.txt";
		int year = currentDateTime.getYear();
		int month = currentDateTime.getMonthValue();
		int day = currentDateTime.getDayOfMonth();
		int hour = currentDateTime.getHour();
		int minute = currentDateTime.getMinute();
		int second = currentDateTime.getSecond();
		File file = new File(filePath);
		File parentDir = file.getParentFile();

		try {
			if (!parentDir.exists()) {
				// 디렉토리가 존재하지 않으면 생성
				parentDir.mkdirs();
			}
			if (!file.exists()) {
				// 파일이 존재하지 않으면 생성
				file.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(filePath, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(year + ":" + month + ":" + day + ":" + hour + ":" + minute + ":" + second + " // "
					+ "post" + " : " + message);
			bufferedWriter.newLine();
			bufferedWriter.close();
			System.out.println("saved Receive Post Message");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	void makeBtn(String recipient) {

		if (recipientButtons.containsKey(recipient)) {
			System.out.println("이미 같은 이름의 버튼이 존재합니다.");
			return; // 이미 존재하면 더 이상 진행하지 않음
		}
		JButton personButton = new JButton(recipient);
		String buttonText = recipient;
		personButton.setMaximumSize(new Dimension(90, 50)); // 최대 크기 설정
		message_Box.add(personButton);
		recipientButtons.put(recipient, personButton);
		message_Box.revalidate(); // 레이아웃을 갱신하여 버튼을 새 위치에 배치
		String aMessage = "님이 연결 시도했습니다.";
		sendMessage(aMessage, recipient);
		sendMessage(aMessage, recipient);
		personButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				messageDisplayArea.setText("");
				String message = message_sendBox.getText();
				clickedRecipient = recipient;
				if (message != null) {
					showMessageForRecipient(buttonText);
					sendMessage(message, recipient);
					saveSendChat(message, recipient, id);
					try {
						readTextFile(id, recipient);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					message_sendBox.setText("");
				}

			}
		});
	}

	public String getId() {
		return id_TextField.getText();
	}
}
