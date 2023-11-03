package com.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordSet_admin {
	Adapter adapter = new Adapter();
	
	JFrame pwd_MainFrame = new JFrame("비밀번호 초기화");
	JPanel pwd_MainPanel = new JPanel();
	JLabel pwd_Title = new JLabel("관리자 로그인");
	JLabel pwd_CodeLabel = new JLabel("관리 코드");
	JTextField pwd_Code = new JTextField("");
	JLabel pwd_PwdLabel = new JLabel("비밀번호");
	JTextField pwd_Pwd = new JTextField("");
	JButton pwd_Login = new JButton("로그인");
	Font labelFont = new Font("Gothic", Font.BOLD, 12);

	// 사원 정보 조회
	JFrame admin_ResetFrame = new JFrame();
	JPanel admin_ResetPanel = new JPanel();
	JLabel admin_ResetTitle = new JLabel("정보 조회");
	JLabel reset_NumLabel = new JLabel("사번");
	JTextField reset_NumField = new JTextField(20);
	JLabel reset_NameLabel = new JLabel("이름");
	JTextField reset_NameField = new JTextField(20);
	JButton reset_Refer = new JButton("조회");
	JLabel reset_Message = new JLabel("비밀번호를 초기화할 사원의 사번과 이름을 입력하세요.");

	// 초기화 비밀번호 안내
	JFrame password_ResetFrame = new JFrame("초기화 비밀번호 안내");
	JPanel password_ResetPanel = new JPanel();
	JLabel password_ResetText = new JLabel(
			"<html><div style='text-align:center;'>" + "초기화된 비밀번호는 사번입니다.<br/>로그인 후 반드시 비밀번호를 변경해 주세요.</div></html>");

	// 사원 정보 불일치 경고
	JFrame admin_WarningFrame = new JFrame();
	JPanel admin_WarningPanel = new JPanel();
	JLabel admin_WarningText = new JLabel(
			"<html><div style='text-align:center;'>" + "정보가 없습니다.<br/>입력하신 정보를 다시 확인하세요." + "</div></html>");

	// 로그인 정보 확인 경고
	JFrame admin_WarningFrame2 = new JFrame();
	JPanel admin_WarningPanel2 = new JPanel();
	JLabel admin_WarningText2 = new JLabel("<html><div style='text-align:center;'>"
			+ "권한이 없습니다.<br/>코드를 다시 확인하거나 관리자가 아닌 경우<br/>정보 수정 권한이 있는 관리자에게 문의하세요." + "</div></html>");

	// 로그인 코드 정보
	String admin_ID = "admin";
	String admin_PWD = "admin";
	String num = "";
	String name = "";
	
	public PasswordSet_admin(Adapter adapter) {
		this.adapter = adapter;
		// 관리자 로그인
		pwd_MainFrame.setSize(530, 300);
		pwd_MainFrame.setVisible(true);
		pwd_MainFrame.setResizable(false);
		pwd_MainFrame.setLocationRelativeTo(null);
		pwd_MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pwd_MainPanel.setSize(510, 350);
		pwd_MainPanel.setLayout(null);
		pwd_MainPanel.setBackground(Color.WHITE);
		pwd_MainFrame.add(pwd_MainPanel);

		pwd_MainPanel.add(pwd_Title);
		pwd_Title.setFont(new Font("Gothic", Font.BOLD, 20));
		pwd_Title.setBounds(198, 40, 130, 25);

//        pwd_CodeLabel = new JLabel("관리 코드");
		pwd_CodeLabel.setBounds(78, 125, 60, 18);
		pwd_CodeLabel.setFont(labelFont);
		pwd_MainPanel.add(pwd_CodeLabel);

		pwd_Code.setBounds(148, 120, 200, 35);
		pwd_MainPanel.add(pwd_Code);

		pwd_PwdLabel.setBounds(78, 165, 60, 18);
		pwd_PwdLabel.setFont(labelFont);
		pwd_MainPanel.add(pwd_PwdLabel);

//      pwd_Pwd.setEchoChar('*');
		pwd_Pwd.setBounds(148, 160, 200, 35);
		pwd_MainPanel.add(pwd_Pwd);

		pwd_Login.setBounds(360, 120, 80, 75);
		pwd_Login.setOpaque(true);
		pwd_MainPanel.add(pwd_Login);

		// 관리자 로그인 성공 -> 사원 정보 조회
		admin_ResetFrame.setSize(450, 210);
		admin_ResetFrame.setVisible(false);
		admin_ResetFrame.setResizable(false);
		admin_ResetFrame.setLocationRelativeTo(null);
		admin_ResetFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		admin_ResetPanel.setLayout(null);
		admin_ResetPanel.setBackground(Color.WHITE);
		admin_ResetFrame.add(admin_ResetPanel);

		admin_ResetTitle.setFont(new Font("Gothic", Font.BOLD, 20));
		admin_ResetTitle.setBounds(168, 20, 90, 30);
		admin_ResetPanel.add(admin_ResetTitle);

		admin_ResetPanel.add(reset_NumLabel);
		reset_NumLabel.setBounds(85, 76, 32, 21);

		admin_ResetPanel.add(reset_NumField);
		reset_NumField.setBounds(132, 74, 150, 25);

		admin_ResetPanel.add(reset_NameLabel);
		reset_NameLabel.setBounds(85, 106, 32, 21);
		reset_NameField.setBounds(132, 104, 150, 25);
		admin_ResetPanel.add(reset_NameField);

		reset_Refer.setBounds(310, 70, 70, 60);
		admin_ResetPanel.add(reset_Refer);

		reset_Message.setBounds(70, 180, 320, 18);
		admin_ResetPanel.add(reset_Message);

		// 사원 정보 일치 -> 초기화 비밀번호
		password_ResetFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		password_ResetFrame.setLocationRelativeTo(null);
		password_ResetFrame.setSize(370, 180);
		password_ResetFrame.setVisible(false);

		password_ResetPanel.setBackground(Color.WHITE);
		password_ResetFrame.add(password_ResetPanel);
		password_ResetPanel.setLayout(null);

		password_ResetPanel.add(password_ResetText);
		password_ResetText.setBounds(60, 40, 250, 50);

		// 사원 정보 불일치 -> 경고창
		admin_WarningFrame.setSize(410, 160);
		admin_WarningFrame.setVisible(false);
		admin_WarningFrame.setResizable(false);
		admin_WarningFrame.setLocationRelativeTo(null);
		admin_WarningFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		admin_WarningPanel.setSize(410, 160);
		admin_WarningPanel.setLayout(null);
		admin_WarningPanel.setBackground(Color.WHITE);
		admin_WarningFrame.add(admin_WarningPanel);
		admin_WarningText.setFont(new Font("Gothic", Font.BOLD, 13));
		admin_WarningPanel.add(admin_WarningText);
		admin_WarningText.setBounds(60, 30, 330, 63);

		// 로그인 정보 확인 경고
		admin_WarningFrame2.setSize(410, 160);
		admin_WarningFrame2.setVisible(false);
		admin_WarningFrame2.setResizable(false);
		admin_WarningFrame2.setLocationRelativeTo(null);
		admin_WarningFrame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		admin_WarningPanel2.setSize(410, 160);
		admin_WarningPanel2.setLayout(null);
		admin_WarningPanel2.setBackground(Color.WHITE);
		admin_WarningFrame2.add(admin_WarningPanel);
		admin_WarningText2.setFont(new Font("Gothic", Font.BOLD, 13));
		admin_WarningPanel2.add(admin_WarningText2);
		admin_WarningText2.setBounds(60, 30, 330, 63);

		pwd_Login.addActionListener(new ActionListener() { // 로그인 버튼 클릭 이벤트
			
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == pwd_Login) {
					String getAdminCode = pwd_Code.getText();
					String getAdminPwd = pwd_Pwd.getText();
					if (getAdminCode.equals(admin_ID) && getAdminPwd.equals(admin_PWD)) {
						pwd_MainFrame.setVisible(false);
						admin_ResetFrame.setVisible(true);
						reset_Refer.addActionListener(new ActionListener() { // 조회 버튼 클릭 시
							@Override
							public void actionPerformed(ActionEvent e) {

								if (e.getSource() == reset_Refer) {
									num = reset_NumField.getText();
									name = reset_NameField.getText();
									adapter.pwdUP(num, name);
									System.out.println(num + "^^" + name);
									// DB 비교 한 값 받아오기
									if (num.equals(adapter.getDBcn()) && name.equals(adapter.getDBname())) { // 정보 조회 성공하면
										// 해당 사원 비밀번호 DB 업데이트
										System.out.println("패스워드 초기화 DB에서 불러오기 성공");
										password_ResetFrame.setVisible(true); // 초기화 비밀번호 안내
										admin_ResetFrame.setVisible(false);
									} else {
										admin_WarningFrame2.setVisible(true); // 사원 정보 불일치 경고
									}
								}
							}
						});

					} else { // 로그인 실패
						admin_WarningFrame.setVisible(true); // 로그인 정보 확인 경고
					}
				}
			}
		});
	}
}