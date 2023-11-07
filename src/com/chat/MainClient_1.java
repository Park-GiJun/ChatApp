package com.chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainClient_1 implements ActionListener, Runnable {
	private Socket socket; // 소켓
	private ObjectInputStream ois; // 입력
	private ObjectOutputStream oos; // 출력
	private JFrame jframe; // 윈도우
	private JTextField jtf; // 채팅 입력
	private JTextArea jta; // 채팅 내용
	private JLabel jlb1, jlb2; // 라벨
	private JPanel jp1, jp2; // 판넬
	private String ip; // IP 주소를 저장할 변수
	private String id; // 닉네임(대화명) 저장할 변수
	private JButton jbtn; // 종료 버튼
	private String pwd;

	public MainClient_1(String argIp, String argId, String argpwd) {

		ip = argIp; // IP 주소
		id = argId; // 대화
		pwd = argpwd;
		init();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String msg = jtf.getText();
		if (obj == jtf) {
			if (msg == null || msg.length() == 0) {
				// 내용이 없는 경우 경고창 보여주기
				JOptionPane.showMessageDialog(jframe, "글을 쓰세요", "경고", JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					oos.writeObject(id + "@" + msg);
				} catch (Exception ee) {
					ee.printStackTrace();
				}
				jtf.setText("");
			}
		} else if (obj == jbtn) {
			try {
				oos.writeObject(id + "@exit");
			} catch (Exception ee) {
				ee.printStackTrace();
			}
			System.exit(0);
		}
	}

	public void init() {
		try {
			socket = new Socket(ip, 5000);
			System.out.println("서버에 접속되었습니다... 주인님^^");
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeObject(id);
			oos.writeObject(pwd);
			Thread t = new Thread(this);
			t.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean Login() {
		String pass_in = null;
		boolean pass_out = false;
		try {
			pass_in = (String) ois.readObject();
			if (pass_in.equals("true")) {
				pass_out = true;
			}
		} catch (Exception e) {

		}
		return pass_out;
	}

	@Override
	public void run() {
		String message = null;
		String[] receiveMsg = null;
		boolean isStop = false;
		while (!isStop) {
			try {
				message = (String) ois.readObject();
				receiveMsg = message.split("@");
			} catch (Exception e) {
				e.printStackTrace();
				isStop = true;
			}
			System.out.println(receiveMsg[0] + ":" + receiveMsg[1]);
			if (receiveMsg[1].equals("exit")) {
				if (receiveMsg[0].equals(id)) {
					System.exit(0);
				} else {
					jta.append(receiveMsg[0] + " 님이 종료했습니다\n");
					jta.setCaretPosition(jta.getDocument().getLength());
				}
			} else {
				jta.append(receiveMsg[0] + " : " + receiveMsg[1] + "\n");
				jta.setCaretPosition(jta.getDocument().getLength());
			}
		}
	}
}