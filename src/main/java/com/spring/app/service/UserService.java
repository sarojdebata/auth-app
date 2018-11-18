package com.spring.app.service;

import com.spring.app.dto.UserDTO;


public interface UserService {

	public UserDTO validateUserService(String userName,String password) throws Exception;
	/*public boolean saveSchoolDetails(School school) throws Exception;
	public boolean saveTeacherDetails(Teacher teacher)throws Exception;
	public boolean saveStudentDetails(Student student)throws Exception;
	public boolean saveClassDetails(com.sd.modelBean.Class class1)throws Exception;
	public boolean saveSubjectDetails(Subject subject)throws Exception;*/
}
