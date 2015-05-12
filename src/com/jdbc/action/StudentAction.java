package com.jdbc.action;

import java.util.List;

import com.jdbc.dao.StudentDao;
import com.jdbc.model.Student;

public class StudentAction {
	public static void main(String[] args) throws Exception {
/*		StudentDao s=new StudentDao();
		List<Student> st=s.query();
		for (Student student : st) {
			System.out.println(student.getName()+","+student.getAge());
		}*/
		
		StudentDao ss=new StudentDao();
		Student s1=new Student();
		s1.setName("ะกรภ");
		s1.setSex(1);
		s1.setAge(22);
		ss.addStudent(s1);
	}
}
