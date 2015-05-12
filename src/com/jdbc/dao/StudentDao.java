package com.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.db.DBUtil;
import com.jdbc.model.Student;

public class StudentDao {

	public void addStudent(Student s) throws Exception{
//		DBUtil conn =new DBUtil();
//		conn.getConnection();
		Connection conn=DBUtil.getConnection();
		String sql=""+
				" insert into student "+
				" (name,sex,age,phone,create_user,"+
				" create_date,isdel) "+
				" values (?,?,?,?,?,current_date,?) ";
		
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		ptmt.setString(1, s.getName());
		ptmt.setInt(2, s.getSex());
		ptmt.setInt(3, s.getAge());
		ptmt.setString(4, s.getPhone());
		ptmt.setString(5, s.getCreate_uaer());
//		ptmt.setDate(6, new Date(s.getCreate_date().getTime()));
		ptmt.setInt(6, s.getIsdel());
		
		
		ptmt.execute();
		 
	}
	public void updateStudent(){
		
	}
	public void delStudent(){
		
	}
	public List<Student> query() throws Exception{
		Connection conn=DBUtil.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select id,name,sex,age,phone,create_user,create_date,isdel from student");
		
		List<Student> st=new ArrayList<Student>();
		Student s=null;
		
		while (rs.next()) {
			s=new Student();
			s.setName(rs.getString("name"));
			s.setAge(rs.getInt("age"));
			
			st.add(s);
			/*System.out.println(rs.getInt("id") + "," + rs.getString("name")
					+ "," + rs.getInt("sex")+ "," + rs.getInt("age") + "," + rs.getString("phone")
					+ "," + rs.getString("create_user") + ","
					+ rs.getDate("create_date") + "," + rs.getInt("isdel"));*/
		}
		return st;
	}
	public Student get(){
		return null;
	}
}
