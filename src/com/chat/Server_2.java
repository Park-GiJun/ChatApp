package com.chat;

import java.util.ArrayList;
import com.chat.ServerVO_2;

public class Server_2 {
	private String id, pwd;
	
	
	private ServerDAO_2 server = new ServerDAO_2();
	public Server_2(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}
	public boolean Login() {
		if(!id.equals("")&&!pwd.equals("")) {
			ArrayList<ServerVO_2> ar = server.list(id);
			if(ar.size()!=0 && ar.get(0).getPwd().equals(pwd))
			{return true;}
			else {return false;}
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		

	}

}
