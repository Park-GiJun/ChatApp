package com.chat;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Information {
	// 1. 메인 프레임
	JFrame main_Frame = new JFrame("정보 수정");
	JPanel main_Panel = new JPanel();
	JLabel main_Title = new JLabel("사원 정보 수정"); // 타이틀
	JLabel main_NumberLabel = new JLabel("사번"); // 사번 라벨
	JLabel main_Number = new JLabel(); // 사번 필드
	JLabel main_NameLabel = new JLabel("이름");
	JLabel main_Name = new JLabel();
	JLabel main_PwdLabel = new JLabel("비밀번호"); // 비밀번호 라벨
	JTextField main_Pwd = new JTextField("", 20); // 비밀번호 수정 필드
	JLabel main_PwdCheckLabel = new JLabel("비밀번호 확인"); // 비밀번호 확인 라벨
	JTextField main_PwdCheck = new JTextField("", 20); // 비밀번호 확인 필드
	JLabel main_PwdMessage = new JLabel("특수문자를 포함해야 안전합니다."); // 비밀번호 작성 안내
	JLabel main_PhoneLabel = new JLabel("휴대폰 번호"); // 핸드폰 번호 라벨
	JTextField main_Phone = new JTextField(13); // 핸드폰 번호 수정 필드
	JLabel main_EmailLabel = new JLabel("이메일 주소"); // 메일 주소 라벨
	JTextField main_Email = new JTextField(50); // 이메일 주소 수정 필드
	JButton main_Button = new JButton("저장"); // 정보 수정 버튼

	// 2. 정보 수정 확인창
	JFrame modify_Frame = new JFrame();
	JPanel modify_Panel = new JPanel();
	JLabel modify_Text = new JLabel("입력한 정보로 변경하시겠습니까?");
	JButton modify_Button_Yes = new JButton("변경");
	JButton modify_Button_No = new JButton("아니요");
	String setPwd;
	String setPhone;
	String setEmail;
	

	// 3. 수정 완료
	JFrame save_Frame = new JFrame();
	JPanel save_Panel = new JPanel();
	JLabel save_Message = new JLabel("회원 정보 수정 완료되었습니다.");
	public Information(String id, String name) {
		// 1. 메인 프레임
		main_Frame.setSize(450, 480);
		main_Frame.setVisible(true);
		main_Frame.setResizable(false);
		main_Frame.setLocationRelativeTo(null);

		main_Frame.add(main_Panel);
		main_Panel.setLayout(null);
		main_Panel.setBackground(Color.white);

		main_Title.setFont(new Font("Gothic", Font.BOLD, 18));
		main_Title.setBounds(166, 33, 250, 40);

		main_NumberLabel.setBounds(66, 98, 250, 25);
		main_Number.setBounds(171, 98, 180, 25);

		main_NameLabel.setBounds(66, 133, 250, 25);
		main_Name.setBounds(171, 133, 180, 25);

		main_PwdLabel.setBounds(66, 173, 250, 25);
//		main_Pwd.setEchoChar('*');
		main_Pwd.setBounds(171, 171, 150, 25);

		main_PwdCheckLabel.setBounds(66, 213, 250, 25);
//		main_PwdCheck.setEchoChar('*');
		main_PwdCheck.setBounds(171, 211, 150, 25);
		main_PwdMessage.setBounds(171, 239, 200, 15);

		main_PhoneLabel.setBounds(66, 265, 250, 25);
		main_Phone.setBounds(171, 263, 150, 25);

		main_EmailLabel.setBounds(66, 305, 250, 25);
		main_Email.setBounds(171, 303, 150, 25);

		main_Button.setBounds(330, 365, 60, 30);

		// 1-1. 로그인 정보 각 필드에 배치
		ClientConnection client = new ClientConnection();
		try {
			
		String db_Number = id;
		String db_Name = name;
		String db_Pwd = client.getUserPwd();
		String db_Phone = client.getPhone();
		String db_Email = client.getEmail();
		
		main_Number.setText(db_Number);
		main_Name.setText(db_Name);
		main_Pwd.setText(db_Pwd);
		main_PwdCheck.setText(db_Pwd);
		main_Phone.setText(db_Phone);
		main_Email.setText(db_Email);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 2. 정보 수정 확인창
		modify_Frame.setSize(300, 180);
		modify_Frame.setVisible(false);
		modify_Frame.setLocationRelativeTo(null);
		modify_Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // x 클릭 시 창닫기
		modify_Panel.setBackground(Color.white);
		modify_Panel.setLayout(null);
		modify_Text.setBounds(50, 30, 200, 20);
		modify_Button_Yes.setBounds(65, 70, 70, 30);
		modify_Button_No.setBounds(145, 70, 75, 30);

		// 3. 수정 완료
		save_Frame.setSize(300, 150);
		save_Frame.setVisible(false);
		save_Frame.setLocationRelativeTo(null);
		save_Panel.setBackground(Color.white);
		save_Panel.setLayout(null);
		save_Message.setBounds(50, 40, 250, 25);

		// 2-1. 비밀번호 체크 메세지
		main_PwdCheck.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				pwdCheckMessage();
			}

			public void removeUpdate(DocumentEvent e) {
				pwdCheckMessage();
			}

			public void changedUpdate(DocumentEvent e) {
				pwdCheckMessage();
			}

			private void pwdCheckMessage() {
				String getPwd = main_Pwd.getText();
				String getPwdCheck = main_PwdCheck.getText();
				if (getPwd.equals(getPwdCheck)) {
					main_PwdMessage.setText("비밀번호 일치");
				} else {
					main_PwdMessage.setText("비밀번호 불일치");
				}
			}
		});
		
		// 메인 창 닫기
		main_Frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				modify_Frame.dispose();
				save_Frame.dispose();
			}
		});

		// 수정 완료 창 닫으면 전체 닫기
		save_Frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				main_Frame.dispose();
				modify_Frame.dispose();
			}
		});

		// 2-2. 저장 버튼 이벤트
		main_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modify_Frame.setVisible(true);
			}
		});

		// 2-2-1. 정보 변경창 "변경" 버튼 클릭 시
		modify_Button_Yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// DB 업데이트
				System.out.println("변경 버튼 눌렀다");
				save_Frame.setVisible(true);
				clientSend();
				client.setProfile(setPwd, setPhone, setEmail);
			}
		});

		// 2-2-2. 정보 변경창 "아니요" 버튼
		modify_Button_No.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modify_Frame.dispose();
			}
		});

		// 메인 패널
		main_Frame.setVisible(true);
		main_Panel.add(main_Title);
		main_Panel.add(main_NameLabel);
		main_Panel.add(main_Name);
		main_Panel.add(main_NumberLabel);
		main_Panel.add(main_Number);
		main_Panel.add(main_PwdLabel);
		main_Panel.add(main_Pwd);
		main_Panel.add(main_PwdCheckLabel);
		main_Panel.add(main_PwdCheck);
		main_Panel.add(main_PwdMessage);
		main_Panel.add(main_PhoneLabel);
		main_Panel.add(main_Phone);
		main_Panel.add(main_EmailLabel);
		main_Panel.add(main_Email);
		main_Panel.add(main_Button);

		// 수정 패널
		modify_Frame.add(modify_Panel);
		modify_Panel.add(modify_Button_No);
		modify_Panel.add(modify_Button_Yes);
		modify_Panel.add(modify_Text);

		// 저장 완료 패널
		save_Frame.add(save_Panel);
		save_Panel.add(save_Message);

	}
	public void clientSend () {
		System.out.println("clientSend 불렀다");
		String pwd1 = main_Pwd.getText();
		String phone = main_Phone.getText();
		String email = main_Email.getText();
		String pwdSet;
		
		if (main_PwdMessage.getText().equals("비밀번호 일치")) {
			pwdSet = pwd1;
		} else {
			pwdSet = " ";
		}
		
		if (pwdSet != null) {
			setPwd = pwdSet;
		} else {
			setPwd = " ";
		}
		
		if (phone != null) {
			setPhone = phone;
		} else {
			setPhone = " ";
		}
		
		if (email != null) {
			setEmail = email;
		} else {
			setEmail = " ";
		}
		System.out.println(setPwd+" == "+setPhone + " == "+ setEmail);
		System.out.println("clientsend 끝났다");
	}
//	public static void main(String[] args) {
//		Information info = new Information();
//	}
}
