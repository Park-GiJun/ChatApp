package com.chat;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	// ClientConnection 객체 추가
	private ClientConnection clientConnection;
	private Map<String, String> receivedMessages = new HashMap<>();
	private Adapter adapter;
	LocalDateTime currentDateTime = LocalDateTime.now();
	List<JCheckBox> todoList = new ArrayList<>();

	// 로그인 패널 및 로그인 정보 필드
	private JPanel loginPanel = new JPanel();
	private JTextField id_TextField = new JTextField();
	private JPasswordField pwd_TextField = new JPasswordField();
	private JButton login_Btn = new JButton();
	private String id, pwd, UserEmail, name, userImage;
	private boolean pass = false;
	String username = System.getProperty("user.home");
	ImageIcon img = new ImageIcon(username + "/git/ChatApp/src/com/chat/chats/logo.png");

	Image icon = Toolkit.getDefaultToolkit().getImage(username + "/git/ChatApp/src/com/chat/chats/icon.png");
	private JLabel logo_Img = new JLabel(img);
	Color aColor = new Color(211, 211, 211);

	Color bColor = new Color(45, 47, 59);
	Color cColor = new Color(109, 134, 154);
	Color dColor = new Color(192, 210, 219);
	Color eColor = new Color(174, 191, 199);

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
	JList<String> search_DBlist = new JList<String>(new String[] { "김사장", "김이사" });
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

	// 관리자
	JFrame admin_Frame = new JFrame();
	JPanel admin_Panel = new JPanel();
	JButton signUp_Btn = new JButton();
	JButton pwdSet_Btn = new JButton();

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
		setIconImage(icon);

		// 로그인 패널
		add(loginPanel);
		getContentPane().add("loginPanel", loginPanel);
		loginPanel.setLayout(null);
		loginPanel.setSize(800, 560);
		loginPanel.add(id_TextField);
		loginPanel.add(pwd_TextField);
		loginPanel.add(login_Btn);
		login_Btn.setText("Login");
		loginPanel.add(logo_Img);

		logo_Img.setBounds(170, 80, 450, 175);
		id_TextField.setBounds(218, 326, 251, 38);
		pwd_TextField.setBounds(218, 374, 251, 38);
		login_Btn.setBounds(496, 326, 86, 86);
		
		

		// 로그인 버튼
		login_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = id_TextField.getText();
				pwd = pwd_TextField.getText();

				if (!id.isEmpty() && !pwd.isEmpty()) {
					// 서버로 아이디와 비밀번호 전송 (이 부분은 ClientConnection 클래스로 이동)
					try {
						if (!id.equals("admin") && !pwd.equals("admin")) {
							pass = clientConnection.login(id, pwd);

							if (pass) {
								mainLayout.show(getContentPane(), "mainPanel");
								name = clientConnection.getName();
								UserEmail = clientConnection.getEmail();
								String phone = clientConnection.getPhone();
								String Dept_num = clientConnection.getDeptnum();
								BufferedImage originalImage = clientConnection.getUserImage();
								int newWidth = 165; // 원하는 너비
								int newHeight = 190; // 원하는 높이

								BufferedImage resizedImage = resize(originalImage, newWidth, newHeight);
								JLabel userImageLabel = new JLabel(new ImageIcon(resizedImage));
								home_photo.add(userImageLabel);
								home_photo.setBackground(aColor);
								String[] todoarr = clientConnection.getDoing().split("//");
								for (String a : todoarr) {
									sop(a);
								}
								home_name.setText("이름 : " + name);
								home_email.setText("이메일 : " + UserEmail);
								home_num.setText("전화번호 : " + phone);
								home_deptNum.setText("내선번호 : " + Dept_num);
								for (int i = 0; i < todoarr.length; i++) {
									String todoStr = todoarr[i];
									JCheckBox todoBox = new JCheckBox(todoStr);
									todoBox.setBackground(eColor);
									todoBox.setForeground(Color.white);
									todoList.add(todoBox);

									// 할 일 목록을 그리드 레이아웃에 추가
									home_todo.add(todoBox);

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
								adapter.setId(id);
								adapter.setPwd(pwd);
								adapter.setName(name);
								adapter.setEmail(UserEmail);
								adapter.setPhone(phone);
								adapter.setNum(Dept_num);
								setTitle(id);
							} else {
								JOptionPane.showMessageDialog(loginPanel, "아이디와 비밀번호를 확인해주세요.", "로그인에 실패했습니다.",
										JOptionPane.WARNING_MESSAGE);
							}
						} else if (id.equals("admin") && pwd.equals("admin")) {
							System.out.println("관리자 로그인");
							setVisible(false);
							admin_Frame.setVisible(true);
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
		signUp_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp signup = new SignUp(adapter);
			}
		});

		// 관리자 액션 리스너
		pwdSet_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PasswordSet_admin pwdSet = new PasswordSet_admin(adapter);
			}
		});

		// 관리자 화면 닫기 버튼 시 프로그램 종료
		admin_Frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				System.out.println("@관리자 접속 종료");
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
		home_Btn.setBackground(dColor);
		home_Btn.setBorder(null);
		search_Btn.setBackground(dColor);
		search_Btn.setBorder(null);
		message_Btn.setBackground(dColor);
		message_Btn.setBorder(null);
		info_Btn.setBackground(dColor);
		info_Btn.setBorder(null);
		main_Panel.setBackground(aColor);
		message_postBtn.setBackground(cColor);
		addPerson.setBackground(cColor);
		message_postBtn.setBorder(null);
		addPerson.setBorder(null);
		home_todo.setBackground(eColor);
		login_Btn.setBorder(null);
		login_Btn.setBackground(aColor);
		loginPanel.setBackground(cColor);
		left_Panel.setBackground(aColor);

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
		home_Panel.setBackground(aColor);
		home_Panel.setBounds(100, 0, 700, 560);
		home_Panel.add(home_photo);
		home_photo.setBounds(268, 25, 165, 190);

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

		// 관리자 패널
		admin_Frame.setTitle("관리자 로그인");
		admin_Frame.setSize(350, 200);
		admin_Frame.setLayout(null);
		admin_Frame.setVisible(false);
		admin_Frame.setLocationRelativeTo(null);
		admin_Frame.setResizable(false);
		admin_Panel.setBackground(Color.white);
		signUp_Btn.setText("등록");
		signUp_Btn.setBounds(70, 50, 80, 60);
		pwdSet_Btn.setText("초기화");
		pwdSet_Btn.setBounds(190, 50, 80, 60);

		admin_Frame.add(signUp_Btn);
		admin_Frame.add(pwdSet_Btn);

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
		search_List.setBackground(cColor);
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
		search_Page.setBackground(aColor);

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

		search_btnclick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search = search_bar.getText();
				System.out.println(search);
				clientConnection.nameTree(search);
				System.out.println("search 버튼 이벤트 끝났다");
			}
		});

		// 메세지 패널
		message_Panel.setLayout(null);
		message_Panel.setBounds(100, 0, 700, 500);
		message_Panel.setBackground(dColor);
		message_Panel.add(message_Box);
		message_Box.setBounds(0, 0, 90, 540);
		message_Box.setBackground(aColor);
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
		message_Panel.setBorder(null);
		message_chatlog.setBorder(null);
		message_sendPanel.setBorder(null);

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
				message_postBtn.setBackground(dColor);
				String recipient = JOptionPane.showInputDialog("수신자: ");
				JButton personButton = new JButton(recipient);
				personButton.setBackground(dColor);
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
				search_Btn.setBackground(eColor);
				home_Btn.setBackground(cColor);
				message_Btn.setBackground(eColor);
				info_Btn.setBackground(eColor);
			}
		});
		search_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLayout.show(card_Panel, "searchPanel");
				search_Btn.setBackground(cColor);
				home_Btn.setBackground(eColor);
				message_Btn.setBackground(eColor);
				info_Btn.setBackground(eColor);
			}
		});
		message_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLayout.show(card_Panel, "messagePanel");
				search_Btn.setBackground(eColor);
				home_Btn.setBackground(eColor);
				message_Btn.setBackground(cColor);
				info_Btn.setBackground(eColor);
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
						clientConnection.sendTodo(id, todoStr, state);

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
		File file = new File(filePath);
		File parentDir = file.getParentFile();
		LocalDateTime currentDateTime = LocalDateTime.now(); // 현재 시간 가져오기

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
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy:MM:dd:HH:mm:ss");
			String formattedDateTime = currentDateTime.format(formatter);
			bufferedWriter.write(formattedDateTime + " // " + me + " : " + message);
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
		File file = new File(filePath);
		File parentDir = file.getParentFile();
		LocalDateTime currentDateTime = LocalDateTime.now(); // 현재 시간 가져오기

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
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy:MM:dd:HH:mm:ss");
			String formattedDateTime = currentDateTime.format(formatter);
			bufferedWriter.write(formattedDateTime + " // " + me + " : " + message);
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
		LocalDateTime currentDateTime = LocalDateTime.now(); // 현재 시간 가져오기
		FileWriter fileWriter = new FileWriter(filePath, true);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy:MM:dd:HH:mm:ss");
		String formattedDateTime = currentDateTime.format(formatter);
		bufferedWriter.write(formattedDateTime + " // " + post + " : " + message);
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
		LocalDateTime currentDateTime = LocalDateTime.now();
		String username = System.getProperty("user.home");
		String filePath = username + "/git/ChatApp/src/com/chat/chats/post.txt";
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
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy:MM:dd:HH:mm:ss");
			String formattedDateTime = currentDateTime.format(formatter);
			bufferedWriter.write(formattedDateTime + " // " + "post" + " : " + message);
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

	public static BufferedImage resize(BufferedImage img, int newWidth, int newHeight) {
		Image tmp = img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = resizedImage.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();

		return resizedImage;
	}

	public String getId() {
		return id_TextField.getText();
	}

	void sop(String a) {
		System.out.println(a);
	}
	
}