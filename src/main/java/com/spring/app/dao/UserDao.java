package com.spring.app.dao;

import com.spring.app.dto.UserDTO;
import com.spring.app.modelBeean.School;
import com.spring.app.modelBeean.Student;
import com.spring.app.modelBeean.Subject;
import com.spring.app.modelBeean.Teacher;

public interface UserDao {

	public UserDTO validateUserDao(String userName,String password)throws Exception;
	public boolean saveSchoolDetails(School school) throws Exception;
	public boolean saveTeacherDetails(Teacher teacher) throws Exception;
	public boolean saveStudentDetails(Student student) throws Exception;
	public boolean saveClassDetails(com.spring.app.modelBeean.Class class1) throws Exception;
	public boolean saveSubjectDetails(Subject subject) throws Exception;
}
