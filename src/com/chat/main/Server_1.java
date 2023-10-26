package com.chat.main;

import java.awt.BorderLayout;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Server_1 extends JFrame {
	private static final long serialVersionUID = 1L;
	private ArrayList<MultiServerThread> list;
	private Socket socket;
	JTextArea ta;
	JTextField tf;
	private String id, pwd;
	private ServerDAO_1 dao = new ServerDAO_1();
	
	public Server_1(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}
	public boolean Login() {
		if(!id.equals("")&&!pwd.equals("")) {
			ArrayList<ServerVO_1> ar = dao.list(id);
			if(ar.size()!=0 && ar.get(0).getPwd().equals(pwd))
			{return true;}
			else {return false;}
		} else {
			return false;
		}
	}
	
	public Server_1() {
		setTitle("채팅 서버 ver 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ta = new JTextArea();
		add(new JScrollPane(ta));
		tf = new JTextField();
		tf.setEditable(false);
		add(tf, BorderLayout.SOUTH);
		setSize(300, 300);
		setVisible(true);
		// 채팅 관련 코드
		list = new ArrayList<MultiServerThread>();
		try {
			ServerSocket serverSocket = new ServerSocket(5000);
			MultiServerThread mst = null;
			boolean isStop = false;
			tf.setText("서버 실행\n");
			while (!isStop) {
				// 클라이언트별 소켓 생성
				socket = serverSocket.accept();
				// 채팅 객체 생성
				mst = new MultiServerThread();
				list.add(mst);
				mst.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Server_1();
	}

	// 내부 클래스
	class MultiServerThread extends Thread {
		private ObjectInputStream ois;
		private ObjectOutputStream oos;

		@Override
		public void run() {
			boolean isStop = false;
			try {
				ois = new ObjectInputStream(socket.getInputStream());
				oos = new ObjectOutputStream(socket.getOutputStream());
				// 채팅 내용을 저장할 변수
				String message = null;
				while (!isStop) {
					message = (String) ois.readObject();
					String[] str = message.split("#");
					if (str[1].equals("exit")) {
						broadCasting(message);
						isStop = true;
					} else {
						// 모든 사용자에게 채팅 내용 전달
						broadCasting(message);
					}
				}
				list.remove(this);
				ta.append(socket.getInetAddress() + " IP 주소의 사용자께서 종료하셨습니다.\n");
				tf.setText("남은 사용자 수 : " + list.size());
			} catch (Exception e) {
				list.remove(this);
				ta.append(socket.getInetAddress() + " IP 주소의 사용자께서 비정상 종료하셨습니다.");
				tf.setText("남은 사용자 수 : " + list.size());
			}
		}

		// 모두에게 전송
		public void broadCasting(String message) {
			for (MultiServerThread ct : list) {
				ct.send(message);
			}
		}

		// 한 사용자에게 전송
		public void send(String message) {
			try {
				oos.writeObject(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
