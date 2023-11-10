package com.chat;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
//github.com/Park-GiJun/ChatApp.git
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.imageio.ImageIO;

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
	private String doing;
	private Socket socket;
	String setPwd, setEmail, setPhone;
	String nameTree[][];
	String treeName;
	BufferedImage userimage;
	private String[] Dept = { "테스트" };
	String searchName, searchEmail, searchPhone, searchDeptNum;
	BufferedImage searchImage;
	String search[];

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

	public String getDoing() {
		return doing;
	}

	public String[] getNameTree() {
		for(int i = 0; i<search.length; i++) {
			search[i] = nameTree[i][0];
		}
		return search;
	}

	public BufferedImage getUserImage() {
		return userimage;
	}

	public ClientConnection() {
	}

	public ClientConnection(String serverAddress, int serverPort) {
		this.serverAddress = serverAddress;
		this.serverPort = serverPort;
		connectToServer();
	}

	public void newUser(String name, String cn, String dept, String imagefile) {
		System.out.println("newUser 시작");
		try {
			out.writeObject("[newUser]");
			out.writeObject(name);
			out.writeObject(cn);
			out.writeObject(dept);
			
			String userImage = imagefile;
			byte [] byteImage;
			File imageFile = new File(userImage);
			BufferedImage buffImage = ImageIO.read(imageFile);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(buffImage, "png", baos);
			baos.flush();
			byteImage = baos.toByteArray();
			
			out.writeObject(byteImage);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("newUser 오류");
		}
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
				System.out.println("select method nametree");
				nameTreeStart();
				return "[nameTree]";
			} else if (inp.equals("[image]")) {
				System.out.println("select method image");
				return "[image]";
			} else if (inp.equals("[searchPerson]")) {
				System.out.println("select method searchPerson");
				searchPersonStart();
				return "[searchPerson]";
			}else {
			
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

	public void sendTodo(String id, String doing, String state) {
		try {
			out.writeObject("[Todo]");
			out.writeObject(id);
			out.writeObject(doing);
			out.writeObject(state);
			System.out.println("Todo : id, doing 서버 전송");

		} catch (Exception e) {
			System.out.println("Todo Error : id" + id + ", doing : " + doing + ", state : " + state);
			e.printStackTrace();
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
			if (pass_in.equals("true")) {
				pass_out = true;
				name = (String) in.readObject();
				email = (String) in.readObject();
				phone = (String) in.readObject();
				dept_num = (String) in.readObject();
				doing = (String) in.readObject();
				userimage = readImage();
				System.out.println("client loginStart method - pass_in : " + pass_in + " name : " + name + " Email : "
						+ email + " phone : " + phone + " dept_num: " + dept_num);
				System.out.println("정보를 읽었습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("clientconnection login : " + pass_out);
		return pass_out;
	}

	public BufferedImage readImage() throws IOException, ClassNotFoundException {
		byte[] receiveImage = (byte[]) in.readObject();
		BufferedImage image = ImageIO.read(new ByteArrayInputStream(receiveImage));
		return image;
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

	public void nameTree(String name) {
		System.out.println("nameTree 시작");
		try {
			out.writeObject("[nameTree]");
			System.out.println("[nameTree] 전송");
			out.writeObject(name);
			System.out.println("nameTree 끝났다");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("nameTree 오류");
		}
	}

	public String[][] nameTreeStart() {
		System.out.println("nameTreeStart 메소드 시작");
		try {
			int listSize = (Integer) in.readObject();
			System.out.println("listsize 받음 listSize : " + listSize);
			nameTree = new String[listSize][2];
			search = new String[listSize];
			for (int i = 0; i < listSize; i++) {
				String name = (String)in.readObject();
				String cn = (String)in.readObject();
				nameTree[i][0] = name;
				nameTree[i][1] = cn;
				System.out.println("배열에 넣기 " + i + "번째 " + nameTree[i][0] + nameTree[i][1]);
			}
			System.out.println("배열넣기 끝났다");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("nameTreeStart 오류");
		}
		System.out.println("return 배열 간다");
		return nameTree;
	}
	
	public void searchPerson(String cn) {
		System.out.println("searchPerson 시작");
		try {
			out.writeObject("[searchPerson]");
			System.out.println("[searchPerson] 전송");
			out.writeObject(cn);
			System.out.println("사번 전송 "+ cn);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("searchPerson 오류");
		}
		System.out.println("serachPerson 종료");
	}
	
	public void searchPersonStart() {
		System.out.println("searchPersonStart 시작");
		try {
			// 사진 이름 전화번호 이메일 내선번호
			searchImage = null;
			searchName = (String)in.readObject();
			searchEmail = (String)in.readObject();
			searchPhone = (String)in.readObject();
			searchDeptNum = (String)in.readObject();
			searchImage = readImage();
			System.out.println("선택한 사람의 정보를 읽었습니다.");
			System.out.println("name : "+searchName+"| Phone : "+searchPhone+"| Email : "+searchEmail+"| DeptNum : "+ searchDeptNum);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("searchPersonStart 오류");
		}
		System.out.println("searchPersonStart 종료");
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