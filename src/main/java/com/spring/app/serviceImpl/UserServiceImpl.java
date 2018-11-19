package com.spring.app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.app.dao.UserDao;
import com.spring.app.dto.UserDTO;
import com.spring.app.modelBeean.School;
import com.spring.app.modelBeean.Student;
import com.spring.app.modelBeean.Subject;
import com.spring.app.modelBeean.Teacher;
import com.spring.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Transactional
	public UserDTO validateUserService(String userName,String password) throws Exception {
		// TODO Auto-generated method stub
		return userDao.validateUserDao(userName, password);
	}
	@Transactional
	public boolean saveSchoolDetails(School school) throws Exception {
		// TODO Auto-generated method stub
		return userDao.saveSchoolDetails(school);
	}
	@Transactional
	public boolean saveTeacherDetails(Teacher teacher) throws Exception {
		// TODO Auto-generated method stub
		return userDao.saveTeacherDetails(teacher);
	}
	@Transactional
	public boolean saveStudentDetails(Student student) throws Exception {
		// TODO Auto-generated method stub
		return userDao.saveStudentDetails(student);
	}
	@Transactional
	public boolean saveClassDetails(com.spring.app.modelBeean.Class class1) throws Exception {
		// TODO Auto-generated method stub
		return userDao.saveClassDetails(class1);
	}
	@Transactional
	public boolean saveSubjectDetails(Subject subject) throws Exception {
		// TODO Auto-generated method stub
		return userDao.saveSubjectDetails(subject);
	}

}
