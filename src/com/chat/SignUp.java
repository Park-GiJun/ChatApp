package com.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SignUp extends JFrame {
	private Adapter adapter;

	// 1. 메인 프레임
	JPanel signPanel = new JPanel();
	JLabel signText = new JLabel();
	JLabel signName_Label = new JLabel();
	JLabel signImg_Label = new JLabel();
	JLabel signDept_Label = new JLabel();

	JComboBox<String> dept_Box = new JComboBox<String>();

	JLabel signCN_Label = new JLabel();
	JTextField signName = new JTextField();
	JTextField signImg = new JTextField();
	JTextField signCN = new JTextField();
	JButton signOK_Btn = new JButton();
	JButton signImg_Btn = new JButton();

	final JFileChooser sign_fc = new JFileChooser();

	// 1-*. 중복 / 입력 안 된 필드 확인
	JFrame overlap_Frame = new JFrame();
	JLabel overlap_Message = new JLabel();
	JFrame null_Frame = new JFrame();
	JLabel null_Message = new JLabel();

	// 1-1. 생성 버튼 클릭->입력한 정보 확인
	JFrame checkFrame = new JFrame("정보 확인");
	JPanel checkPanel = new JPanel();
	JLabel checkText = new JLabel();
	JButton check_Yes = new JButton();
	JButton check_No = new JButton();

	String name;
	String cn;
	String dept;
	String img;

	// 1-1-1. 생성 완료
	JFrame saveFrame = new JFrame("등록 완료");
	JPanel savePanel = new JPanel();
	JLabel saveTitle = new JLabel();
	JLabel saveText = new JLabel();
	JButton save_Btn = new JButton();

	Font mainFont = new Font("Gothic", Font.BOLD, 20);

//	public SignUp() { 
	public SignUp(Adapter adapter) {
		this.adapter = adapter;
		dept_Box = new JComboBox<String>(adapter.getDeptList());
		// 1. 메인 프레임
		setTitle("사원 정보 등록");
		setSize(450, 400);
		setVisible(true);

//		setResizable(false);
		setLocationRelativeTo(null);

		signPanel.setBackground(Color.white);
		signPanel.setLayout(null);

		signText.setText("사원 정보 등록");
		signText.setBounds(150, 30, 200, 30);
		signText.setFont(mainFont);
		signName_Label.setText("이름");
		signName_Label.setBounds(80, 110, 80, 25);
		signName.setBounds(130, 108, 145, 25);
		signImg_Label.setText("이미지");
		signImg_Label.setBounds(80, 145, 80, 25);
		signImg.setBounds(130, 143, 145, 25);
		signImg_Btn.setText("불러오기");
		signImg_Btn.setBounds(285, 143, 90, 25);

		signDept_Label.setText("부서");
		signDept_Label.setBounds(80, 180, 80, 25);
		dept_Box.setBounds(130, 178, 145, 25);
		signCN_Label.setText("사번");
		signCN_Label.setBounds(80, 215, 80, 25);
		signCN.setBounds(130, 213, 145, 25);
		signOK_Btn.setText("등록");
		signOK_Btn.setBounds(300, 280, 80, 40);

		// 1-*. 중복 시 확인 메세지 / 입력 안 된 필드 확인 메세지
		overlap_Frame.setTitle("중복 확인");
		overlap_Frame.setSize(380, 150);
		overlap_Frame.setLocationRelativeTo(null);
		overlap_Frame.setLayout(null);
		overlap_Frame.setVisible(false);
		overlap_Message.setText("중복된 사번입니다. 다시 확인하세요.");
		overlap_Message.setBounds(80, 50, 250, 25);

		null_Frame.setTitle("입력 확인");
		null_Frame.setSize(380, 150);
		null_Frame.setLocationRelativeTo(null);
		null_Frame.setLayout(null);
		null_Frame.setVisible(false);
		null_Message.setText("입력되지 않은 정보가 있습니다.");
		null_Message.setBounds(80, 50, 250, 25);

		// 1-*. 중복 시 확인 메세지 / 입력 안 된 필드 확인 메세지
		overlap_Frame.setTitle("중복 확인");
		overlap_Frame.setSize(380, 250);
		overlap_Frame.setLocationRelativeTo(null);
		overlap_Frame.setLayout(new BorderLayout());
		overlap_Message.setText("중복된 사번입니다. 다시 확인하세요.");

		null_Frame.setTitle("입력 확인");
		null_Frame.setSize(380, 250);
		null_Frame.setLocationRelativeTo(null);
		null_Frame.setLayout(new BorderLayout());
		null_Message.setText("입력되지 않은 정보가 있습니다.");

		// 1-1. 입력 정보 확인
		checkFrame.setSize(400, 250);
		checkFrame.setVisible(false);
		checkFrame.setResizable(false);
		checkFrame.setLocationRelativeTo(null);

		checkPanel.setBackground(Color.white);
		checkPanel.setLayout(null);

		checkText.setText("<html><div style='text-align: center;'>" + "이름 : " + name + ", 부서 : " + dept + ", 사번 : " + cn
				+ "<br/>" + "위 정보로 등록할까요?" + "</div></html>");
		checkText.setBounds(90, 60, 250, 50);
		check_Yes.setText("예");
		check_Yes.setBounds(100, 140, 80, 25);
		check_No.setText("아니요");
		check_No.setBounds(200, 140, 80, 25);

		// 1-1-1. 등록 완료
		saveFrame.setSize(330, 200);
		saveFrame.setResizable(false);
		saveFrame.setLocationRelativeTo(null);
		saveFrame.setVisible(false);

		savePanel.setBackground(Color.white);
		savePanel.setLayout(null);

		saveTitle.setText("정보 등록 완료!");
		saveTitle.setBounds(80, 30, 150, 30);
		saveTitle.setFont(mainFont);
		saveText.setText("새로운 정보 등록에 성공했습니다.");
		saveText.setBounds(70, 60, 250, 20);
		save_Btn.setText("추가 등록");
		save_Btn.setBounds(100, 100, 100, 25);

		add(signPanel);
		signPanel.add(signText);
		signPanel.add(signName_Label);
		signPanel.add(signName);
		signPanel.add(signImg_Label);
		signPanel.add(signImg);
		signPanel.add(signDept_Label);
		signPanel.add(dept_Box);
		signPanel.add(signCN_Label);
		signPanel.add(signCN);
		signPanel.add(signOK_Btn);
		signPanel.add(signImg_Btn);
		signPanel.revalidate();
		signPanel.repaint();

		overlap_Frame.add(overlap_Message);
		null_Frame.add(null_Message);

		overlap_Frame.add(overlap_Message, BorderLayout.CENTER);
		null_Frame.add(null_Message, BorderLayout.CENTER);

		checkFrame.add(checkPanel);
		checkPanel.add(checkText);
		checkPanel.add(check_Yes);
		checkPanel.add(check_No);

		saveFrame.add(savePanel);
		savePanel.add(saveTitle);
		savePanel.add(saveText);
		savePanel.add(save_Btn);

		// 파일 탐색기 기본 설정
		sign_fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		sign_fc.setDialogTitle("이미지 선택");
		sign_fc.setCurrentDirectory(new File("C:\\Users")); // 초기 디렉토리 지정
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "gif"); // 지정 확장자만 선택 가능
		sign_fc.setFileFilter(filter); // 필터 추가
		sign_fc.setAcceptAllFileFilterUsed(false); // 확장자 필터 "모든 파일" 제외
		sign_fc.setMultiSelectionEnabled(false); // 파일 다중 선택 불가

// * 버튼 이벤트 + 로그 출력
		// 이미지 불러오기
		signImg_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("이미지 불러오기 버튼 클릭");
				int i = sign_fc.showOpenDialog(sign_fc);
				System.out.println("파일 탐색기 오픈");

				if (i == JFileChooser.APPROVE_OPTION) {
					File f = sign_fc.getSelectedFile();
					String fileName = f.getName(); // 선택한 파일명
					signImg.setText(fileName);
					System.out.println(fileName + " 불러오기");
				}
			}
		});

		// 사원 정보 등록 [등록] 버튼
		String dbCN = "20231107"; // 테스트용 사번
		signOK_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("등록 버튼 클릭");
				name = signName.getText();
				cn = signCN.getText();

				if (name.isEmpty() || cn.isEmpty()) { // 비어있는 필드 있으면
					null_Frame.setVisible(true);
					System.out.println("---누락된 정보 발견");
				} else if (cn.equals(dbCN)) { // 입력된 정보와 DB 비교
					System.out.println("---입력된 정보 DB와 중복됨");
					overlap_Frame.setVisible(true); // 중복 경고 프레임 오픈
				} else {
					System.out.println("입력 완료 --- 정보 확인");
					checkFrame.setVisible(true);
				}
			}
		});

		// 정보 확인 [예] 버튼
		check_Yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkFrame.dispose();
				System.out.println(name + " / " + cn + " / " + dept + img + " <- 등록 시도");
				// DB에 저장 성공하면 savaFrame 오픈
				saveFrame.setVisible(true);
			}
		});

		// 정보 확인 [아니요] 버튼
		check_No.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkFrame.dispose();
				System.out.println("등록 안 해");
			}
		});

		// 등록 완료 [추가 등록] 버튼
		save_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveFrame.dispose();
				System.out.println("*추가 등록*");
			}
		});

		// 등록 완료 시 전체 프레임 닫는 윈도우 리스너
		saveFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.out.println("등록 종료!");
			}
		});

	}

//	public static void main(String[] args) {
//		SignUp sign = new SignUp();
//	}
}
