package com.chat;

//중간 다리 역할 클래스
public class Adapter {
	private String user_id;
	private String user_pwd;
	private String name;
	private String num;
	private String email;
	private String cn;
	private String phone;
	private String DBcn;
	private String DBname;
	private boolean pass;
	private ClientConnection client;
	// 입력없이 저장된 정보를 불러오기 위한 생성자
//	public Adapter(ClientConnection clientConnection) {
//		this.clientConnection = clientConnection;
//		clientConnection.pwdUp(cn, name);
//		System.out.println(DBcn+"**"+DBname);
//	}
//	// 사번 조회
//	public Adapter(String cn) {
//		setCn(cn);
//	}
//	// 패스워드 초기화 프레임 사번과 이름
//	public Adapter(String cn, String name) {
//		setCn(cn);
//		setName(name);
//		System.out.println(cn+"@@"+name);
//	}
//	
//	// 홈 프레임 정보확인
//	public Adapter(String name, String email, String num, String phone) {
//		setName(name);
//		setEmail(email);
//		setNum(num);
//		setPhone(phone);
//	}
	public Adapter() {
		
	}
	public Adapter(ClientConnection clientconnection) {
		this.client = clientconnection;
	}
	public Adapter(String name, String num) {
		this.name = name;
		this.cn = num;
		System.out.println(name+"---"+cn);
	}
	
	public void pwdUP(String id, String name) {
		client.pwdUp(id, name);
		System.out.println("adapter pwdup 실행");
		setDBcn(id);
		setDBname(name);
	}
	
	public void setInfo(String pwd, String phone, String email) {
		client.setProfile(pwd, phone, email);
		System.out.println("adapter setInfo 실행");
		System.out.println(client.setPwd+" "+client.setPhone+" "+client.setEmail);
		setPwd(client.setPwd);
		setPhone(client.setPhone);
		setEmail(client.setEmail);
	}
	
	
	public void setDBcn(String cn) {
		this.DBcn = cn;
}
	public void setDBname(String name) {
		this.DBname = name;
	}

	public void setPass(boolean pass) {
		this.pass = pass;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCn(String cn) {
		this.cn = cn;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNum(String num) {
		this.num = num;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setId(String id) {
		this.user_id = id;
	}
	public void setPwd(String pwd) {
		this.user_pwd = pwd;
	}
	
	public String getDBcn() {
		return DBcn;
	}

	public String getDBname() {
		return DBname;
	}

	public boolean getPass() {
		return pass;
	}

	public String getName() {
		return name;
	}

	public String getCn() {
		return cn;
	}

	public String getEmail() {
		return email;
	}

	public String getNum() {
		return num;
	}

	public String getPhone() {
		return phone;
	}

	public String getId() {
		return user_id;
	}

	public String getPwd() {
		return user_pwd;
	}
}
