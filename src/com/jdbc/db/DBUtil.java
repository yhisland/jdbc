package com.jdbc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/jdbc";
	private static final String USER = "root";
	private static final String PASSWORD = "cjadmin999";
	private static Connection conn=null;
	static{
		try {
			// 1.������������
			Class.forName("com.mysql.jdbc.Driver");
			// 2.��ȡ���ݿ�����
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		return conn;
	}
	public static void main(String[] args) throws Exception {

/*		// 1.������������
		Class.forName("com.mysql.jdbc.Driver");
		// 2.��ȡ���ݿ�����
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		// 3.ͨ�����ݿ����Ӳ������ݿ⣬ʵ����ɾ�Ĳ�
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt
				.executeQuery("select id,name,sex,age,phone,create_user,create_date,isdel from student");
		while (rs.next()) {
			System.out.println(rs.getInt("id") + "," + rs.getString("name")
					+ "," + rs.getInt("sex") + "," + rs.getString("phone")
					+ "," + rs.getString("create_user") + ","
					+ rs.getDate("create_date") + "," + rs.getInt("isdel"));
		}*/
	}
}
