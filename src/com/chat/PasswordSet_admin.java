package com.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordSet_admin {
	JFrame pwd_MainFrame = new JFrame("관리자 로그인");
	JPanel pwd_MainPanel = new JPanel();
	JLabel pwd_Title = new JLabel();
	JLabel pwd_CodeLabel = new JLabel("관리 코드");
	JTextField pwd_Code = new JTextField("");
	JLabel pwd_PwdLabel = new JLabel("비밀번호");
	JPasswordField pwd_Pwd = new JPasswordField("");
	JButton pwd_Login = new JButton("로그인");

	public PasswordSet_admin() {
//        pwd_MainFrame = new JFrame("관리자 로그인");
		pwd_MainFrame.setSize(530, 300);
		pwd_MainFrame.setVisible(true);
		pwd_MainFrame.setResizable(false);
		pwd_MainFrame.setLocationRelativeTo(null);
		pwd_MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        pwd_MainPanel = new JPanel();
		pwd_MainFrame.add(pwd_MainPanel);
		pwd_MainPanel.setSize(510, 350);
		pwd_MainPanel.setLayout(null);
		pwd_MainPanel.setBackground(Color.WHITE);
//        pwd_Title = new JLabel();
		pwd_Title.setText("관리자 로그인");
		pwd_MainPanel.add(pwd_Title);
		pwd_Title.setFont(new Font("Gothic", Font.BOLD, 20));
		pwd_Title.setBounds(198, 40, 130, 25);

		Font labelFont = new Font("Gothic", Font.BOLD, 12);

//        pwd_CodeLabel = new JLabel("관리 코드");
		pwd_CodeLabel.setBounds(78, 125, 60, 18);
		pwd_CodeLabel.setFont(labelFont);
		pwd_MainPanel.add(pwd_CodeLabel);
//        pwd_Code = new JTextField("");
		pwd_Code.setBounds(148, 120, 200, 35);
		pwd_MainPanel.add(pwd_Code);

//        pwd_PwdLabel = new JLabel("비밀번호");
		pwd_PwdLabel.setBounds(78, 165, 60, 18);
		pwd_PwdLabel.setFont(labelFont);
		pwd_MainPanel.add(pwd_PwdLabel);
//        pwd_Pwd = new JPasswordField("");
		pwd_Pwd.setBounds(148, 160, 200, 35);
		pwd_MainPanel.add(pwd_Pwd);
//        pwd_Login = new JButton("로그인");
		pwd_Login.setBounds(360, 120, 80, 75);
		pwd_Login.setOpaque(true);
		pwd_MainPanel.add(pwd_Login);
		pwd_Login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == pwd_Login) {
//                    로그인 정보 DB랑 비교
//                    if () { // 로그인 성공
					// 정보 조회 프레임 오픈
					JFrame admin_ResetFrame = new JFrame();
					admin_ResetFrame.setSize(450, 210);
					admin_ResetFrame.setVisible(true);
					admin_ResetFrame.setResizable(false);
					admin_ResetFrame.setLocationRelativeTo(null);
					admin_ResetFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

					JPanel admin_ResetPanel = new JPanel();
					admin_ResetPanel.setLayout(null);
					admin_ResetPanel.setBackground(Color.WHITE);
					admin_ResetFrame.add(admin_ResetPanel);

					JLabel admin_ResetTitle = new JLabel("정보 조회");
					admin_ResetTitle.setFont(new Font("Gothic", Font.BOLD, 20));
					admin_ResetTitle.setBounds(168, 20, 90, 30);
					admin_ResetPanel.add(admin_ResetTitle);

					JLabel reset_NumLabel = new JLabel("사번");
					admin_ResetPanel.add(reset_NumLabel);
					reset_NumLabel.setBounds(85, 76, 32, 21);
					JTextField reset_NumField = new JTextField(20);
					admin_ResetPanel.add(reset_NumField);
					reset_NumField.setBounds(132, 74, 150, 25);

					JLabel reset_NameLabel = new JLabel("이름");
					admin_ResetPanel.add(reset_NameLabel);
					reset_NameLabel.setBounds(85, 106, 32, 21);
					JTextField reset_NameField = new JTextField(20);
					reset_NameField.setBounds(132, 104, 150, 25);
					admin_ResetPanel.add(reset_NameField);

					JButton reset_Refer = new JButton("조회");
					reset_Refer.setBounds(310, 70, 70, 60);
					admin_ResetPanel.add(reset_Refer);

					JLabel reset_Message = new JLabel("비밀번호를 초기화할 사원의 사번과 이름을 입력하세요.");
					reset_Message.setBounds(70, 180, 320, 18);
					admin_ResetPanel.add(reset_Message);

					reset_Refer.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if (e.getSource() == reset_Refer) { // 버튼 클릭 시
								String userNumber = reset_NumField.getText();
								String systemNumber = "12345";
								if (userNumber.equals(systemNumber)) { // 정보 조회 성공하면
									JFrame password_ResetFrame = new JFrame("초기화 비밀번호 안내");
									password_ResetFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									password_ResetFrame.setLocationRelativeTo(null);
									password_ResetFrame.setSize(370, 180);
									password_ResetFrame.setVisible(true);

									JPanel password_ResetPanel = new JPanel();
									password_ResetPanel.setBackground(Color.WHITE);
									password_ResetFrame.add(password_ResetPanel);
									password_ResetPanel.setLayout(null);

									JLabel password_ResetText = new JLabel("<html><div style='text-align:center;'>"
											+ "초기화된 비밀번호는 사번입니다.<br/>로그인 후 반드시 비밀번호를 변경해 주세요.</div></html>");
									password_ResetPanel.add(password_ResetText);
									password_ResetText.setBounds(60, 40, 250, 50);
								} else {
									JFrame admin_WarningFrame = new JFrame();
									admin_WarningFrame.setSize(410, 160);
									admin_WarningFrame.setVisible(true);
									admin_WarningFrame.setResizable(false);
									admin_WarningFrame.setLocationRelativeTo(null);
									admin_WarningFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

									JPanel admin_WarningPanel = new JPanel();
									admin_WarningPanel.setSize(410, 160);
									admin_WarningPanel.setLayout(null);
									admin_WarningPanel.setBackground(Color.WHITE);
									admin_WarningFrame.add(admin_WarningPanel);
									JLabel admin_WarningText = new JLabel("<html><div style='text-align:center;'>"
											+ "권한이 없습니다.<br/>코드를 다시 확인하거나 관리자가 아닌 경우<br/>정보 수정 권한이 있는 관리자에게 문의하세요."
											+ "</div></html>");
									admin_WarningText.setFont(new Font("Gothic", Font.BOLD, 13));
									admin_WarningPanel.add(admin_WarningText);
									admin_WarningText.setBounds(60, 30, 330, 63);
								}
							}
						}
					});

//                    } else { // 로그인 실패
					JFrame admin_WarningFrame = new JFrame();
					admin_WarningFrame.setSize(410, 160);
					admin_WarningFrame.setVisible(true);
					admin_WarningFrame.setResizable(false);
					admin_WarningFrame.setLocationRelativeTo(null);
					admin_WarningFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

					JPanel admin_WarningPanel = new JPanel();
					admin_WarningPanel.setSize(410, 160);
					admin_WarningPanel.setLayout(null);
					admin_WarningPanel.setBackground(Color.WHITE);
					admin_WarningFrame.add(admin_WarningPanel);
					JLabel admin_WarningText = new JLabel("<html><div style='text-align:center;'>"
							+ "권한이 없습니다.<br/>코드를 다시 확인하거나 관리자가 아닌 경우<br/>정보 수정 권한이 있는 관리자에게 문의하세요." + "</div></html>");
					admin_WarningText.setFont(new Font("Gothic", Font.BOLD, 13));
					admin_WarningPanel.add(admin_WarningText);
					admin_WarningText.setBounds(60, 30, 330, 63);
//                    }
//                    JFrame admin_PwdSetFrame = new JFrame("비밀번호 초기화");
//                    admin_PwdSetFrame.setVisible(true);
//                    admin_WarningText.setText("<html><div style='align:center'"+
//                            "권한이 없습니다.</br>코드를 다시 확인하거나 관리자가 아닌 경우</br>정보 수정 권한이 있는 관리자에게 문의하세요."+
//                            "</div></html>");	
				}
			}
		});
	}

	public static void main(String[] args) {
		PasswordSet_admin pwdAdmin = new PasswordSet_admin();
	}
}