package com.jdbc.action;

import java.util.List;

import com.jdbc.dao.StudentDao;
import com.jdbc.model.Student;

public class StudentAction {
	public static void main(String[] args) throws Exception {
		StudentDao s=new StudentDao();
		
/*		Student s1=new Student();
		s1.setName("小美");
		s1.setSex(1);
		s1.setAge(22);
		s.addStudent(s1);*/

/*		Student s1= new Student();
		s1.setName("小美2");
		s1.setSex(1);
		s1.setAge(22);
		s1.setId(3);
		s.updateStudent(s1);*/

/*		s.delStudent(3);*/
//		s.get(1);
		List<Student> st=s.query();
		for (Student student : st) {
			System.out.println(student.getName()+","+student.getAge()+","+student.getPhone());
		}		
		
	}
}
