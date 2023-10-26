package com.chat;



import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;

public class MainFrame extends JFrame {

	//로그인 패널
	JPanel loginPanel = new JPanel();
	JTextField id_TextField = new JTextField();
	JTextField pwd_TextField = new JTextField();
	JButton login_Btn = new JButton();

	
	//메인패널
	JPanel main_Panel = new JPanel();
	JPanel left_Panel = new JPanel();
	JButton home_Btn = new JButton();
	JButton search_Btn = new JButton();
	JButton message_Btn = new JButton();
	
	CardLayout panelLayout = new CardLayout();
	JPanel card_Panel = new JPanel();
	
	//HOME 패널
	JPanel home_Panel = new JPanel();
	JPanel home_photo = new JPanel();
	JLabel home_name = new JLabel();
	JLabel home_num = new JLabel();
	JPanel home_todo = new JPanel();
	JLabel home_todo_list = new JLabel();
	
	//서치 패널
	JPanel search_Panel = new JPanel();
	JPanel search_List = new JPanel();
	JPanel search_Page = new JPanel();
	JTextField search_bar = new JTextField();
	JTree search_Tree = new JTree();
	
	
	

	public MainFrame() {
		CardLayout mainLayout = new CardLayout();
		setLayout(mainLayout);
		setSize(800, 560);
		getContentPane().setLayout(mainLayout);

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
		
		//로그인 버튼
		login_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = id_TextField.getText();
				String pwd = pwd_TextField.getText();
				Server_2 server = new Server_2(id,pwd);
				if(server.Login()) {
					mainLayout.show(getContentPane(), "mainPanel");
				} else {
					System.out.println("로그인 실패");
				}
			}
		});

		// 메인 패널
		add(main_Panel);
		getContentPane().add("mainPanel", main_Panel);
		main_Panel.setSize(800, 560);
		main_Panel.setLayout(null);
		main_Panel.add(left_Panel);
		left_Panel.setBounds(0, 0, 100, 300);
		left_Panel.setLayout(new GridLayout(3,1));
		left_Panel.add(home_Btn);
		left_Panel.add(search_Btn);
		left_Panel.add(message_Btn);
		
		//변경 패널
		
		main_Panel.add(card_Panel);
		card_Panel.setLayout(panelLayout);
		card_Panel.setBounds(100, 0, 700, 560);
		card_Panel.setBackground(Color.red);
		card_Panel.add(home_Panel, "homePanel");
		card_Panel.add(search_Panel, "searchPanel");
		
		
		//홈패널
		home_Panel.setLayout(null);
		home_Panel.setBackground(Color.gray);
		home_Panel.setBounds(100, 0, 700, 560);
		home_Panel.add(home_photo);
		home_photo.setBounds(268, 25, 165, 210);
		home_Panel.add(home_name);
		home_name.setBounds(220, 255, 60, 27);
		home_Panel.add(home_num);
		home_num.setBounds(210, 292, 80, 20);
		home_Panel.add(home_todo);
		home_todo.setBounds(195, 356, 310, 170);
		home_todo.add(home_todo_list);
		
		//서치패널
		search_Panel.setBackground(Color.green);
		search_Page.setLayout(null);
		search_Panel.setBounds(100, 0, 700, 560);
		search_Panel.add(search_List);
		search_List.setBounds(0, 0, 230, 560);
		search_Panel.add(search_Page);
		search_Page.setBounds(330, 0, 470, 560);
		search_List.add(search_bar);
		search_List.add(search_Tree);
		
		
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
		
		
		
		
	}

}
