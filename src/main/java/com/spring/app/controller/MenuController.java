//package com.spring.app.controller;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.propertyeditors.CustomDateEditor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.ServletRequestDataBinder;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import com.google.gson.Gson;
//import com.spring.app.dto.UserDTO;
//import com.spring.app.exception.UserNotFoundException;
//import com.spring.app.modelBeean.Class;
//import com.spring.app.modelBeean.Constant;
//import com.spring.app.modelBeean.School;
//import com.spring.app.modelBeean.Student;
//import com.spring.app.modelBeean.Subject;
//import com.spring.app.modelBeean.Teacher;
//import com.spring.app.modelBeean.User;
//import com.spring.app.serviceImpl.UserServiceImpl;
//
//@Controller
//@EnableWebMvc
//public class MenuController {
//
//	@Autowired
//	UserServiceImpl userService;
//	
//
//	@Value("${CONSTANT.ADDSCHOOL}")
//	private String addSchool;
//	
//	@Value("${CONSTANT.ADDTEACHER}")
//	private String addTeacher;
//	
//	@Value("${CONSTANT.ADDSTUDENT}")
//	private String addStudent;
//	
//	@Value("${CONSTANT.ADDCLASS}")
//	private String addClass;
//	
//	@Value("${CONSTANT.ADDSUBJECT}")
//	private String addSubject;
//	
//	
//	@InitBinder
//	public void initBinder(WebDataBinder binder,HttpServletRequest request, ServletRequestDataBinder servletRequestDataBinder) {
//	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//	    sdf.setLenient(true);
//	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
//	}
//	
//	@RequestMapping(value="/homeSubmenu",method = RequestMethod.GET,headers="Accept=*/*")
//	public @ResponseBody String subMenuHomeController(@RequestParam String userName,@RequestParam String password) throws UserNotFoundException
//	{
//		System.out.println("inside subMenuController()");
//		System.out.println("userName ::"+userName+"password ::"+password);
//		
//		UserDTO userDetails = null;
//		try {
//			//userDetails = userService.validateUserService(userName, password);
//			userDetails = userService.validateUserService(userName, password);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		if(userDetails != null)
//		{
//			Gson gson = new Gson();
//			String jsonStr = null;
//			HashMap<String, UserDTO> hashMap = new HashMap<String, UserDTO>();
//			try {
//				 hashMap.put("dtls", userDetails);
//				 jsonStr = gson.toJson(hashMap);
//	            System.out.println(jsonStr);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//			return jsonStr;
//		}else
//		{
//			throw new UserNotFoundException("User Details not available");
//		}
//	}
//	
//	@RequestMapping(value="/about",method = RequestMethod.GET)
//	public String about()
//	{
//		return "home";
//	}
//	
//	@RequestMapping(value="/onboardSchool",method = RequestMethod.GET)
//	public ModelAndView onboardSchool()
//	{
//		ModelAndView model = new ModelAndView("school");
//		model.addObject("schoolForm",new School());
//		
//		return model;
//	}
//
//	@RequestMapping(value="/onboardTeacher",method = RequestMethod.GET)
//	public String onboardTeacher()
//	{
//		return "teacher";
//	}
//	
//	@RequestMapping(value="/onboardStudent",method = RequestMethod.GET)
//	public String onboardStudent()
//	{
//		return "student";
//	}
//	
//	@RequestMapping(value="/onboardClass",method = RequestMethod.GET)
//	public String onboardClass()
//	{
//		return "class";
//	}
//	
//	@RequestMapping(value="/onboardSubject",method = RequestMethod.GET)
//	public String onboardSubject()
//	{
//		return "subject";
//	}
//	
//	@RequestMapping(value="/faQ",method = RequestMethod.GET)
//	public String faQ()
//	{
//		return "faq";
//	}
//	
//	@RequestMapping(value="/contact",method = RequestMethod.GET)
//	public String contact()
//	{
//		return "contact";
//	}
//	
//	
//	@RequestMapping(value="/addSchool",method = RequestMethod.POST)
//	public String addSchool(HttpServletRequest request) throws ParseException
//	{
//		System.out.println("inside addSchool ::");
//		String schoolName = request.getParameter("schoolName");
//		String schoolAddrs = request.getParameter("schoolAddrs");
//		//String createdDate = request.getParameter("createdDate");
//		String emailAddrs = request.getParameter("email");
//		String fax = request.getParameter("fax");
//		String comment = request.getParameter("comment");
//		
//		System.out.println("schoolName ::"+schoolName);
//		System.out.println("schoolAddrs ::"+schoolAddrs);
//		String dateStr = request.getParameter("createdDate");
//		  SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
//		  Date result = formater.parse(dateStr);
//		  SimpleDateFormat AppDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		  System.out.println(AppDateFormat.format(result));
//		  
//		//System.out.println("createdDate ::"+result);
//		System.out.println("emailAddrs ::"+emailAddrs);
//		System.out.println("fax ::"+fax);
//		System.out.println("comment ::"+comment);
//		
//		School school = new School();
//		school.setSchoolName(schoolName);
//		school.setSchoolAddrs(schoolAddrs);
//		school.setCreatedDate(result);
//		school.setEmail(emailAddrs);
//		school.setFax(fax);
//		school.setComment(comment);
//		
//		boolean flag = false;
//		
//		try 
//		{
//			flag = userService.saveSchoolDetails(school);
//			HttpSession session = request.getSession();
//			Constant constants =  new Constant();
//			constants.setConstant(addSchool);
//			if(school.getSchoolName() != null)
//			{
//				constants.setConstname(school.getSchoolName());	
//			}
//			
//			session.setAttribute("add", constants);
//			System.out.println("add  :: "+constants.getConstant());
//		} catch (Exception e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if(flag == true)
//		{
//			return "home";
//		}
//		else{
//			return "school";	
//		}
//		
//	}
//	@RequestMapping(value="/addTeacher",method = RequestMethod.POST)
//	public String addTeacher(HttpServletRequest request) throws ParseException
//	{
//		System.out.println("inside addTeacher()***");
//		String firstName = request.getParameter("firstName");
//		String lastName = request.getParameter("lastName");
//		String addrs = request.getParameter("teacherAddrs");
//		String dateStr = request.getParameter("cretdDate");
//		String schoolId = request.getParameter("schlIdAndName");
//		
//		  SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
//		  Date result = formater.parse(dateStr);
//		  SimpleDateFormat AppDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		  System.out.println(AppDateFormat.format(result));
//		  
//		  Teacher teacher = new Teacher();
//		  teacher.setFirstName(firstName);
//		  teacher.setLastName(lastName);
//		  teacher.setAddress(addrs);
//		  teacher.setCreatedDate(result);
//		  
//		  if(!schoolId.equals(null) && !schoolId.isEmpty())
//		  {
//			  teacher.setSchoolId(Integer.parseInt(schoolId));
//		  }
//		 
//			
//		  boolean flag = false;
//		  try 
//		  {
//			flag = userService.saveTeacherDetails(teacher);
//			HttpSession session = request.getSession();
//			 Constant constants =  new Constant();
//				constants.setConstant(addTeacher);
//				if(teacher.getFirstName() != null)
//				{
//					constants.setConstname(teacher.getFirstName());	
//				}
//			session.setAttribute("add",constants);
//		  } 
//		  catch (Exception e) 
//		  {
//			// TODO: handle exception
//			e.printStackTrace();
//		  }
//		  if(flag == true)
//		  {
//			  return "home";
//		  }
//		  else{
//			  return "teacher";
//		  }
//	}
//	
//	
//	@RequestMapping(value="/addStudent",method = RequestMethod.POST)
//	public String addStudent(HttpServletRequest request) throws ParseException
//	{
//		System.out.println("inside addStudent()***");
//		String firstName = request.getParameter("firstName");
//		String lastName = request.getParameter("lastName");
//		String addrs = request.getParameter("studentAddrs");
//		String dateStr = request.getParameter("cretdDate");
//		String schoolId = request.getParameter("schlIdAndName");
//		
//		  SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
//		  Date result = formater.parse(dateStr);
//		  SimpleDateFormat AppDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		  System.out.println(AppDateFormat.format(result));
//		  
//		  Student student = new Student();
//		  student.setFirstName(firstName);
//		  student.setLastName(lastName);
//		  student.setAddress(addrs);
//		  student.setCreatedDate(result);
//		  
//		  if(!schoolId.equals(null) && !schoolId.isEmpty())
//		  {
//			  student.setSchoolId(Integer.parseInt(schoolId));
//		  }
//		  
//		  boolean flag = false;
//		  try
//		  {
//			flag = userService.saveStudentDetails(student);
//			HttpSession session = request.getSession();
//			Constant constants =  new Constant();
//			constants.setConstant(addStudent);
//			if(student.getFirstName() != null)
//			{
//				constants.setConstname(student.getFirstName());	
//			}
//			session.setAttribute("add",constants);
//		  } catch (Exception e)
//		  {
//			// TODO: handle exception
//			e.printStackTrace();
//		  }
//		  if(flag == true)
//		  {
//			  return "home";
//		  }
//		  else{
//			  return "student";
//		  }
//	}
//	@RequestMapping(value="/addClass",method = RequestMethod.POST)
//	public String addClass(HttpServletRequest request) throws ParseException
//	{
//		System.out.println("inside addClass()***");
//		String className = request.getParameter("className");
//		String teacherId = request.getParameter("teacherName");
//		String dateStr = request.getParameter("cretdDate");
//		
//		  SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
//		  Date result = formater.parse(dateStr);
//		  SimpleDateFormat AppDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		  System.out.println(AppDateFormat.format(result));
//		  
//		  com.spring.app.modelBeean.Class class1 = new Class();
//		  class1.setClassName(className);
//		  if(!teacherId.equals(null) && !teacherId.isEmpty())
//		  {
//			  class1.setTeacherId(Integer.parseInt(teacherId));
//		  }
//		  
//		  class1.setCreatedDate(result);
//		  boolean flag = false;
//		  try
//		  {
//			flag = userService.saveClassDetails(class1);
//			HttpSession session = request.getSession();
//			Constant constants =  new Constant();
//			constants.setConstant(addClass);
//			if(class1.getClassName() != null)
//			{
//				constants.setConstname(class1.getClassName());	
//			}
//			session.setAttribute("add",constants);
//		  } catch (Exception e)
//		  {
//			// TODO: handle exception
//			e.printStackTrace();
//		  }
//		  if(flag == true)
//		  {
//			  return "home";
//		  }
//		  else{
//			  return "class";
//		  }
//	}
//	
//	@RequestMapping(value="/addSubject",method = RequestMethod.POST)
//	public String addSubject(HttpServletRequest request) throws ParseException
//	{
//		System.out.println("inside addSubject()***");
//		String subjectName = request.getParameter("subjectName");
//		String teacherId = request.getParameter("teacherName");
//		String classId = request.getParameter("className");
//		String dateStr = request.getParameter("cretdDate");
//		
//		  SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
//		  Date result = formater.parse(dateStr);
//		  SimpleDateFormat AppDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		  System.out.println(AppDateFormat.format(result));
//		  
//		  Subject subject = new Subject();
//		  subject.setSubjectName(subjectName);
//		  if(!classId.equals(null) && !classId.isEmpty())
//		  {
//			  subject.setClassId(Integer.parseInt(classId));  
//		  }
//		  
//		  if(!teacherId.equals(null) && !teacherId.isEmpty())
//		  {
//			  subject.setTeacherId(Integer.parseInt(teacherId));
//		  }
//		  
//		  subject.setCreatedDate(result);
//		  boolean flag = false;
//		  try
//		  {
//			flag = userService.saveSubjectDetails(subject);
//			HttpSession session = request.getSession();
//			Constant constants =  new Constant();
//			constants.setConstant(addSubject);
//			if(subject.getSubjectName() != null)
//			{
//				constants.setConstname(subject.getSubjectName());	
//			}
//			session.setAttribute("add",constants);
//		  } catch (Exception e)
//		  {
//			// TODO: handle exception
//			e.printStackTrace();
//		  }
//		  if(flag == true)
//		  {
//			  return "home";
//		  }
//		  else
//		  {
//			  return "subject";
//		  }
//	}
//	
//	@RequestMapping(value="/cancel" ,method = RequestMethod.GET)
//	public String cancel()
//	{
//		System.out.println("inside cancel()");
//		return "home";
//	}
//}
