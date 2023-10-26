package com.chat.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ServerDAO_1 {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##chatapp";
	String password = "chatapp1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public ArrayList<ServerVO_1> list(String id) {
		ArrayList<ServerVO_1> list = new ArrayList<ServerVO_1>();

		try {
			connDB();

			String query = "SELECT * FROM emp";
			if (id != null) {
				query += " where cn='" + id + "'";
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
					String pwd = rs.getString("pwd");
					ServerVO_1 data = new ServerVO_1(id, pwd);
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