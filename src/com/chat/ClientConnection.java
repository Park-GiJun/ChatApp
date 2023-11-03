package com.chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientConnection {
	private String serverAddress;
	private int serverPort;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private String name;
	private String email;
	private String phone;
	private String dept_num;
	private String user_id;
	private String user_pwd;
	private Socket socket;
	String setPwd, setEmail, setPhone;

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getDeptnum() {
		return dept_num;
	}
	public String getUserPwd() {
		return user_pwd;
	}

	public String getUserID() {
		return user_id;
	}
	public ClientConnection() {
	}
	public ClientConnection(String serverAddress, int serverPort) {
		this.serverAddress = serverAddress;
		this.serverPort = serverPort;
		connectToServer();
	}
	
	public void setProfile(String Pwd, String Phone, String Email) {
		System.out.println(Pwd+" == "+Phone + " == "+ Email);
		try {
			out.writeObject("3");
			System.out.println("3번 보냈다");
			out.writeObject(Pwd);
			System.out.println("setpwd 보냈다");
			out.writeObject(Phone);
			System.out.println("setPhone 보냈다");
			out.writeObject(Email);
			System.out.println("setEmail 보냈다");
			setPwd = (String) in.readObject();
			setPhone = (String) in.readObject();
			setEmail = (String) in.readObject();
			System.out.println("-------------------------");
			System.out.println("pwd : " + setPwd + " phone : " + setPhone + " email : " + setEmail);
			System.out.println("사원정보 수정 성공");
			System.out.println("-------------------------");
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("사원정보 수정 실패");
			System.out.println("-------------------------");
		}
	}
	
	public void pwdUp(String id, String name) {
		try {
			out.writeObject("1");
			out.writeObject(id);
			out.writeObject(name);
			System.out.println((String)in.readObject());
			System.out.println((String)in.readObject());
			System.out.println(id + " () " + name);
			System.out.println("패스워드 초기화 입력 성공");
			
		} catch (Exception e) {
			System.out.println("패스워드 초기화 입력 오류");
			e.printStackTrace();
		}
	}

	public boolean login(String id, String pwd) throws IOException {
		// 서버로 아이디와 비밀번호 전송
		String pass_in = null;
		boolean pass_out = false;
		this.user_id = id;
		this.user_pwd = pwd;
		out.writeObject("2");
		try {
			out.writeObject(id);
			out.writeObject(pwd);
			pass_in = (String) in.readObject();
			name = (String) in.readObject();
			email = (String) in.readObject();
			phone = (String) in.readObject();
			dept_num = (String) in.readObject();
			System.out.println("정보 읽었냐?");
			if (pass_in.equals("true")) {
				pass_out = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(pass_out);
		return pass_out;
	}

	private void connectToServer() {
		try {
			Socket socket = new Socket(serverAddress, serverPort);
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage(String userName, String message, String recipient) {
		try {
			String inp = userName + ":" + message + ":" + recipient;
			out.writeObject(inp);
			out.flush();
			System.out.println(" Sent: " + inp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public class MessageResult {
		private String sendName;
		private String receivedMessage;
		private String recipient;

		public MessageResult(String sendName, String receivedMessage, String recipient) {
			this.sendName = sendName;
			this.receivedMessage = receivedMessage;
			this.recipient = recipient;
		}

		public String getSendName() {
			return sendName;
		}

		public String getReceivedMessage() {
			return receivedMessage;
		}

		public String getRecipient() {
			return recipient;
		}
	}

	public MessageResult receiveMessage() {
		String receivedMessage = null;
		String recipient = null;
		String sendName = null;
		try {
			String inp = (String) in.readObject();
			System.out.println(inp);
			String[] arr = inp.split(":");
			sendName = arr[0];
			receivedMessage = arr[1];
			recipient = arr[2];
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return new MessageResult(sendName, receivedMessage, recipient);
	}
}