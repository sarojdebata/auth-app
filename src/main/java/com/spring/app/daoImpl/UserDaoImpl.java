package com.spring.app.daoImpl;


import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.app.dao.UserDao;
import com.spring.app.dto.UserDTO;
import com.spring.app.modelBeean.User;


@Repository
public class UserDaoImpl implements UserDao{

	@Transactional
	public UserDTO validateUserDao(String userName,String password) throws Exception{
		
		/*Session session = SessionUtil.getSession();
		
		//String qry = "select username_v,password_v  from user_details where username_v="+userName+" and password_v="+password;
		String hql = "FROM User U where U.userName=:user_name and password =:password";
		Query query = session.createQuery(hql);
		query.setParameter("user_name",userName );
		query.setParameter("password",password );
		User res =  (User) query.list().get(0);
		System.out.println("res  :: "+res);
		boolean flag  =  false;
		UserDTO userDTO = new UserDTO();
		if(res!= null)
		{
			userDTO.setUserId(res.getUserId());
			userDTO.setUserName(res.getUserName());
			userDTO.setPassword(res.getPassword());
			userDTO.setCreatedDateTime(res.getCreatedDateTime());
			userDTO.setLastUpdatedTime(res.getLastUpdatedDateTime());
			
			return userDTO;
		}
		
		return null;*/
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName("saroj");
		userDTO.setPassword("kumar");
		return userDTO;
	}

	/*@Transactional
	public boolean saveSchoolDetails(School school) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Inside UserDaoImpl saveSchoolDetails()");
		Session session = SessionUtil.getSession();
		System.out.println(session.toString());
		Integer id = null;
		
		try 
		{
			 System.out.println("school id : "+school.getSchoolId());
			 System.out.println("school name : "+school.getSchoolName());
			 System.out.println("school Address : "+school.getSchoolAddrs());
			 System.out.println("Email id :"+school.getEmail());
			 System.out.println("Fax :"+school.getFax());
			 System.out.println("Comment :"+school.getComment());
			 System.out.println("created date : "+school.getCreatedDate());
			 System.out.println("Last Updated date :"+school.getLastUpdatedDate());
			 
			   session.saveOrUpdate(school);
			   
			 //id = (Integer) session.load(School.class, school.getSchoolId());
			   session.flush();
			 
			   school = (School) session.get(School.class, school.getSchoolId());
			   id = school.getSchoolId();	
			   
			 System.out.println("ID ::"+id);
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		boolean flag =  false;
		if(id != null)
		{
			flag = true;
		}
		return flag;
	}

	public boolean saveTeacherDetails(Teacher teacher) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inside saveTeacherDetails()");
		Session session = SessionUtil.getSession();
		Integer id = null;
		try {
			//teacher.setSchoolId(200);
			session.saveOrUpdate(teacher);
			session.flush();
			teacher = (Teacher) session.get(Teacher.class, teacher.getTeacherId());
			id = teacher.getTeacherId();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		boolean flag =  false;
		if(id != null)
		{
			flag = true;
		}
		return flag;
		
	}

	@Transactional
	public boolean saveStudentDetails(Student student) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inside saveStudentDetails()");
		Session session = SessionUtil.getSession();
		Integer id = null;
		try {
			//teacher.setSchoolId(200);
			session.saveOrUpdate(student);
			session.flush();
			student = (Student) session.get(Student.class, student.getStudentId());
			id = student.getStudentId();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		boolean flag =  false;
		if(id != null)
		{
			flag = true;
		}
		return flag;
	}

	public boolean saveClassDetails(com.sd.modelBean.Class class1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inside saveClassDetails()");
		Session session = SessionUtil.getSession();
		Integer id = null;
		try {
			//teacher.setSchoolId(200);
			session.saveOrUpdate(class1);
			session.flush();
			class1 = (com.sd.modelBean.Class) session.get(com.sd.modelBean.Class.class, class1.getClassId());
			id = class1.getClassId();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		boolean flag =  false;
		if(id != null)
		{
			flag = true;
		}
		return flag;
	}

	public boolean saveSubjectDetails(Subject subject) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inside saveSubjectDetails()");
		Session session = SessionUtil.getSession();
		Integer id = null;
		try {
			//teacher.setSchoolId(200);
			session.saveOrUpdate(subject);
			session.flush();
			subject = (Subject) session.get(Subject.class, subject.getSubjectId());
			id = subject.getSubjectId();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		boolean flag =  false;
		if(id != null)
		{
			flag = true;
		}
		return flag;
	}*/

}
