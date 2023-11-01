package com.chat;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PasswordSet_admin {
	// 1. 메인 프레임
	JFrame pwd_MainFrame = new JFrame("비밀번호 초기화");
	JPanel pwd_MainPanel = new JPanel();
	JLabel pwd_Title = new JLabel("관리자 로그인");
	JLabel pwd_CodeLabel = new JLabel("관리 코드");
	JTextField pwd_Code = new JTextField("");
	JLabel pwd_PwdLabel = new JLabel("비밀번호");
	JTextField pwd_Pwd = new JTextField("");
	JButton pwd_Login = new JButton("로그인");
	Font labelFont = new Font("Gothic", Font.BOLD, 13);

	// 1-*. 로그인 코드 정보
	String admin_ID = "admin";
	String admin_PWD = "admin";
	String num = "";
	String name = "";

	// 1-1. 사원 정보 조회
	JFrame info_Frame = new JFrame();
	JPanel info_Panel = new JPanel();
	JLabel info_Title = new JLabel("정보 조회");
	JLabel info_NumLabel = new JLabel("사번");
	JTextField info_NumField = new JTextField(20);
	JLabel info_NameLabel = new JLabel("이름");
	JTextField info_NameField = new JTextField(20);
	JButton info_Pefer = new JButton("조회");
	JLabel info_Message = new JLabel("비밀번호를 초기화할 사원의 사번과 이름을 입력하세요.");

	// 1-1-1. 초기화 비밀번호 안내
	JFrame reset_Frame = new JFrame("초기화 비밀번호 안내");
	JPanel reset_Panel = new JPanel();
	JLabel reset_Text = new JLabel(
			"<html><div style='text-align:center;'>" + "초기화된 비밀번호는 사번입니다.<br/>로그인 후 반드시 비밀번호를 변경해 주세요.</div></html>");

	// 1-1-2. 사원 정보 불일치 경고
	JFrame admin_WarningFrame = new JFrame();
	JPanel admin_WarningPanel = new JPanel();
	JLabel admin_WarningText = new JLabel(
			"<html><div style='text-align:center;'>" + "정보가 없습니다.<br/>입력하신 정보를 다시 확인하세요." + "</div></html>");

	// 1-2. 로그인 정보 확인 경고
	JFrame login_WarningFrame = new JFrame();
	JPanel login_WarningPanel = new JPanel();
	JLabel login_WarningText = new JLabel("<html><div style='text-align:center;'>"
			+ "권한이 없습니다.<br/>코드를 다시 확인하거나 관리자가 아닌 경우<br/>정보 수정 권한이 있는 관리자에게 문의하세요." + "</div></html>");

	public String getnum_refer(String num) {
		return num;
	}

	public String getname_refer(String name) {
		return name;
	}

	public PasswordSet_admin() {
		// 관리자 로그인
		pwd_MainFrame.setSize(530, 300);
		pwd_MainFrame.setVisible(true);
		pwd_MainFrame.setResizable(false);
		pwd_MainFrame.setLocationRelativeTo(null);
//        pwd_MainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		pwd_MainPanel.setSize(510, 350);
		pwd_MainPanel.setLayout(null);
		pwd_MainPanel.setBackground(Color.WHITE);
		pwd_MainFrame.add(pwd_MainPanel);

		pwd_MainPanel.add(pwd_Title);
		pwd_Title.setFont(new Font("Gothic", Font.BOLD, 20));
		pwd_Title.setBounds(198, 40, 130, 25);

		pwd_CodeLabel.setBounds(68, 126, 60, 18);
		pwd_CodeLabel.setFont(labelFont);
		pwd_MainPanel.add(pwd_CodeLabel);

		pwd_Code.setBounds(138, 120, 200, 35);
		pwd_MainPanel.add(pwd_Code);

		pwd_PwdLabel.setBounds(68, 166, 60, 18);
		pwd_PwdLabel.setFont(labelFont);
		pwd_MainPanel.add(pwd_PwdLabel);

//		pwd_Pwd.setEchoChar('*');
		pwd_Pwd.setBounds(138, 160, 200, 35);
		pwd_MainPanel.add(pwd_Pwd);

		pwd_Login.setBounds(350, 120, 80, 75);
		pwd_Login.setOpaque(true);
		pwd_MainPanel.add(pwd_Login);

		// 관리자 로그인 성공 -> 사원 정보 조회
		info_Frame.setSize(450, 210);
		info_Frame.setVisible(false);
		info_Frame.setResizable(false);
		info_Frame.setLocationRelativeTo(null);
		info_Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		info_Panel.setLayout(null);
		info_Panel.setBackground(Color.WHITE);
		info_Frame.add(info_Panel);

		info_Title.setFont(new Font("Gothic", Font.BOLD, 20));
		info_Title.setBounds(168, 20, 90, 30);
		info_Panel.add(info_Title);

		info_Panel.add(info_NumLabel);
		info_NumLabel.setBounds(85, 76, 32, 21);

		info_Panel.add(info_NumField);
		info_NumField.setBounds(132, 74, 150, 25);

		info_Panel.add(info_NameLabel);
		info_NameLabel.setBounds(85, 106, 32, 21);
		info_NameField.setBounds(132, 104, 150, 25);
		info_Panel.add(info_NameField);

		info_Pefer.setBounds(310, 70, 70, 60);
		info_Panel.add(info_Pefer);

		info_Message.setBounds(70, 180, 320, 18);
		info_Panel.add(info_Message);

		// 사원 정보 일치 -> 초기화 비밀번호 안내
//        reset_Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		reset_Frame.setLocationRelativeTo(null);
		reset_Frame.setSize(370, 180);
		reset_Frame.setVisible(false);

		reset_Panel.setBackground(Color.WHITE);
		reset_Frame.add(reset_Panel);
		reset_Panel.setLayout(null);

		reset_Panel.add(reset_Text);
		reset_Text.setBounds(60, 40, 250, 50);
		reset_Text.setFont(labelFont);

		// 사원 정보 불일치 -> 경고창
		admin_WarningFrame.setSize(300, 160);
		admin_WarningFrame.setVisible(false);
		admin_WarningFrame.setResizable(false);
		admin_WarningFrame.setLocationRelativeTo(null);
		admin_WarningFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		admin_WarningPanel.setLayout(null);
		admin_WarningPanel.setBackground(Color.WHITE);
		admin_WarningFrame.add(admin_WarningPanel);
		admin_WarningText.setFont(labelFont);
		admin_WarningPanel.add(admin_WarningText);
		admin_WarningText.setBounds(40, 25, 250, 63);

		// 관리자 로그인 정보 확인 경고
		login_WarningFrame.setSize(410, 160);
		login_WarningFrame.setVisible(false);
		login_WarningFrame.setResizable(false);
		login_WarningFrame.setLocationRelativeTo(null);
		login_WarningFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		login_WarningPanel.setSize(410, 160);
		login_WarningPanel.setLayout(null);
		login_WarningPanel.setBackground(Color.WHITE);
		login_WarningFrame.add(login_WarningPanel);
		login_WarningText.setFont(labelFont);
		login_WarningPanel.add(login_WarningText);
		login_WarningText.setBounds(60, 25, 330, 63);

		// 창 닫기
		pwd_MainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				info_Frame.dispose();
				reset_Frame.dispose();
				admin_WarningFrame.dispose();
				login_WarningFrame.dispose();
			}
		});

		// 초기화 종료 시 메인 프레임 종료
		reset_Frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				pwd_MainFrame.dispose();
				info_Frame.dispose();
				admin_WarningFrame.dispose();
				login_WarningFrame.dispose();
			}
		});

		// 이벤트
		pwd_Login.addActionListener(new ActionListener() { // 로그인 버튼 클릭 이벤트
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == pwd_Login) {
					String getAdminCode = pwd_Code.getText();
					String getAdminPwd = pwd_Pwd.getText();
					if (getAdminCode.equals(admin_ID) && getAdminPwd.equals(admin_PWD)) {
						info_Frame.setVisible(true);
						info_Pefer.addActionListener(new ActionListener() { // 조회 버튼 클릭 시
							@Override
							public void actionPerformed(ActionEvent e) {
								if (e.getSource() == info_Pefer) {
									num = info_NumField.getText();
									name = info_NameField.getText();
									// DB 비교 한 값 받아오기
									if (num.equals("admin") && name.equals("admin")) { // 정보 조회 성공하면
										// 해당 사원 비밀번호 DB 업데이트

										reset_Frame.setVisible(true); // 초기화 비밀번호 안내
									} else {
										admin_WarningFrame.setVisible(true); // 사원 정보 불일치 경고
									}
								}
							}
						});

					} else { // 로그인 실패
						login_WarningFrame.setVisible(true); // 로그인 정보 확인 경고
					}
				}
			}
		});
	}

//	public static void main(String[] args) {
//		PasswordSet_admin pwdAdmin = new PasswordSet_admin();
//	}
}