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
	private Adapter adapter;
	// 1. 메인 프레임
	Font labelFont = new Font("Gothic", Font.BOLD, 13);

	// 1-*. 로그인 코드 정보
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
	JButton info_Refer = new JButton("조회");
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
	public PasswordSet_admin(Adapter adapter) {
		this.adapter = adapter;
		// 관리자 로그인

		// 관리자 로그인 성공 -> 사원 정보 조회
		info_Frame.setSize(450, 210);
		info_Frame.setVisible(true);
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

		info_Refer.setBounds(290, 70, 70, 60);
		info_Panel.add(info_Refer);

		info_Message.setBounds(70, 180, 320, 18);
		info_Panel.add(info_Message);

		// 사원 정보 일치 -> 초기화 비밀번호 안내
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

		// 초기화 종료 시 메인 프레임 종료
		reset_Frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

				info_Frame.dispose();
				admin_WarningFrame.dispose();

			}
		});

		// 이벤트
		info_Refer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num = info_NumField.getText();
				name = info_NameField.getText();
				adapter.pwdUP(num, name);
				// DB 비교 한 값 받아오기
				if (num.equals(adapter.getDBcn()) && name.equals(adapter.getDBname())) { // 정보 조회 성공하면
					// 해당 사원 비밀번호 DB 업데이트
					System.out.println("패스워드 초기화 DB 데이터 조회 완료");
					reset_Frame.setVisible(true); // 초기화 비밀번호 안내
				} else {
					admin_WarningFrame.setVisible(true); // 사원 정보 불일치 경고
				}
			}
		});

	}

}
