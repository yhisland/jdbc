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
	//新增学生信息
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
		System.out.println(ptmt.execute());
		 
	}
	//更新学生信息
	public void updateStudent(Student s) throws Exception{
		Connection conn=DBUtil.getConnection();
		String sql=""+
				" update student "+
				" set name=?,sex=?,age=?,phone=?,isdel=? "+
				" where id = ? ";
		
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		ptmt.setString(1, s.getName());
		ptmt.setInt(2, s.getSex());
		ptmt.setInt(3, s.getAge());
		ptmt.setString(4, s.getPhone());
		ptmt.setInt(5, s.getIsdel());
		ptmt.setInt(6, s.getId());
		
		ptmt.execute();	
		System.out.println(ptmt.execute());
	}
	//删除学生信息
	public void delStudent(int id) throws Exception{
		Connection conn = DBUtil.getConnection();
		String sql = " delete from student where id= ? ";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, id);
		ptmt.execute();
		System.out.println(ptmt.execute());
		
	}
	//遍历学生信息
	public List<Student> query() throws Exception{
		Connection conn=DBUtil.getConnection();
		
		String sql =" select * from student ";
				//"select id,name,sex,age,phone,create_user,create_date,isdel from student";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ResultSet rs=ptmt.executeQuery();
		
//		Statement stmt = conn.createStatement();
//		ResultSet rs = stmt.executeQuery("select id,name,sex,age,phone,create_user,create_date,isdel from student");
		
		List<Student> st=new ArrayList<Student>();
		Student s=null;
		
		while (rs.next()) {
			s=new Student();
			System.out.println(rs.getString("name"));
			String m=rs.getString("name");
			System.out.println(m);
			s.setName(rs.getString("name"));
			s.setSex(rs.getInt("sex"));
			s.setAge(rs.getInt("age"));
			s.setPhone(rs.getString("phone"));
			
			st.add(s);
			/*System.out.println(rs.getInt("id") + "," + rs.getString("name")
					+ "," + rs.getInt("sex")+ "," + rs.getInt("age") + "," + rs.getString("phone")
					+ "," + rs.getString("create_user") + ","
					+ rs.getDate("create_date") + "," + rs.getInt("isdel"));*/
		}
		System.out.println(ptmt.execute());
		rs.close();
		ptmt.close();
		conn.close();
		return st;
	}
	//根据id查找学生信息
	public Student get(int id) throws Exception{
		Connection conn=DBUtil.getConnection();
		String sql= " select * from student where id=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setInt(1, id);
		ResultSet rs=ptmt.executeQuery();
		List<Student> st = new ArrayList<Student>();
		Student s= null;
		
		
		ptmt.execute();
		return null;
	}
}
