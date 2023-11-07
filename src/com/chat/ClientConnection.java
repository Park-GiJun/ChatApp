package com.chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

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
	private String nameTree[];
	private String inpNameTree;
	private String Dept[];

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

	public String[] getNameTree() {
		return nameTree;
	}

	public ClientConnection() {
	}

	public ClientConnection(String serverAddress, int serverPort) {
		this.serverAddress = serverAddress;
		this.serverPort = serverPort;
		connectToServer();
	}

	public String selectMethod() {
		System.out.println("selectMethod 시작");
		try {
			String inp = (String) in.readObject();
			System.out.println(inp);
			if (inp.equals("[setprofile]")) {
				setProfileStart();
				return "[setprofile]";
			} else if (inp.equals("[chat]")) {
				return "[chat]";
			} else if (inp.equals("[onlinecheck]")) {
				return "[onlinecheck]";
			} else if (inp.equals("[nameTree]")) {
				nameTree();
				return "[nameTree]";
			} else {
				return " ";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("selectMethod 오류");
		}
		return " ";
	}

	public void setProfile(String Pwd, String Phone, String Email) {
		System.out.println("setProfile 시작");
		try {
			out.writeObject("[setprofile]");
			System.out.println("[setprofile] 보냄");
			this.setPwd = Pwd;
			this.setPhone = Phone;
			this.setEmail = Email;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("setprofile 오류");
		}
	}

	public void setProfileStart() {
		System.out.println("setProfileStart 시작");
		try {
			out.writeObject(setPwd);
			System.out.println("setpwd 보냈다");
			out.writeObject(setPhone);
			System.out.println("setPhone 보냈다");
			out.writeObject(setEmail);
			System.out.println("setEmail 보냈다");
			String setDonePwd = (String) in.readObject();
			String setDonePhone = (String) in.readObject();
			String setDoneEmail = (String) in.readObject();
			System.out.println("-------------------------");
			System.out.println("pwd : " + setDonePwd + " phone : " + setDonePhone + " email : " + setDoneEmail);
			System.out.println("사원정보 수정 성공");
			System.out.println("-------------------------");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("사원정보 수정 실패");
			System.out.println("-------------------------");
		}
	}

	public void pwdUp(String id, String name) {
		try {
			out.writeObject("[reset]");
			this.user_id = id;
			this.name = name;
			out.writeObject(user_id);
			out.writeObject(name);
			System.out.println("pwdUpStart method" + (String) in.readObject());
			System.out.println("pwdUpStart method" + (String) in.readObject());
			System.out.println(user_id + " () " + name);
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
		try {

			out.writeObject("[login]");
			this.user_id = id;
			this.user_pwd = pwd;
			out.writeObject(user_id);
			out.writeObject(user_pwd);
			pass_in = (String) in.readObject();
			name = (String) in.readObject();
			email = (String) in.readObject();
			phone = (String) in.readObject();
			dept_num = (String) in.readObject();
			System.out.println("client loginStart method - pass_in : " + pass_in + " name : " + name + " Email : "
					+ email + " phone : " + phone + " dept_num: " + dept_num);
			System.out.println("정보를 읽었습니다.");
			if (pass_in.equals("true")) {
				pass_out = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("clientconnection login : " + pass_out);
		return pass_out;
	}

	public String[] SignUpDept() {
		System.out.println("Client SignUpDept 실행");
		try {
			out.writeObject("[SignUpDept]");
			int ctDept = (Integer) in.readObject();
			Dept = new String[ctDept];
			System.out.println("signupdept ctdept : " + ctDept);
			for (int i = 0; i < Dept.length; i++) {
				Dept[i] = (String) in.readObject();
				System.out.println(Dept[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Client SignUpDept 오류");
		}
		return Dept;
	}

	public void nameTreeStart(String name) {
		System.out.println("nameTreeStart 시작");
		try {
			out.writeObject("[nameTree]");
			System.out.println("[nameTree] 전송");
			this.inpNameTree = name;
			nameTree();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("nameTree stater 오류");
		}
	}

	public String [] nameTree() {
		System.out.println("nameTree 시작");
		String nameList []=null;
		try {
			System.out.println(in.readObject());
			out.writeObject(inpNameTree);
			int innum = (Integer) in.readObject();
			System.out.println(innum);
			nameList = new String[innum];
			for (int i = 0; i < innum; i++) {
				String inpnametest = (String) in.readObject();
				nameList[i] = inpnametest;
				System.out.println("inpnametest" + inpnametest);
			}
			System.out.println("nameTree 끝났다");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("nameTree 오류");
		}
		return nameList;
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
			System.out.println(inp);
			out.writeObject("[chat]");
			out.writeObject(inp);
			out.flush();
			System.out.println(" ClientConnection.java : " + inp);
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
			System.out.println("메세지 결과 : " + inp);
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
