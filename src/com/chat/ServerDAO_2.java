package com.chat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ServerDAO_2 {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##chatapp";
	String password = "chatapp1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public ArrayList<ServerVO_2> list(String id) {
		ArrayList<ServerVO_2> list = new ArrayList<ServerVO_2>();

		try {
			connDB();

			String query = "SELECT * FROM login";
			if (id != null) {
				query += " where user_id='" + id + "'";
			}
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected .....");
			} else {
				System.out.println(rs.getRow() + " rows selected.....");
				rs.previous();

				while (rs.next()) {
					String pwd = rs.getString("user_pwd");
					ServerVO_2 data = new ServerVO_2(id, pwd);
					list.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("statement create success.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
