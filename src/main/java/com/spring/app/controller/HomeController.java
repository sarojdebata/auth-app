package com.spring.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.app.dto.UserDTO;
import com.spring.app.modelBeean.Constant;
import com.spring.app.service.UserService;

@Controller
public class HomeController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value ="/", method = RequestMethod.GET)
	public String login(Model model)
	{
		//model.addAttribute("employee",new Employee());
		return "login";
	}
	
	@RequestMapping(value="/login" ,method = RequestMethod.POST)
	public ModelAndView home(@RequestParam("username")String uname,@RequestParam("password")String pass,HttpServletRequest request)
	{
		System.out.println("Inside home ::");
		System.out.println("name ::"+uname);
		
		boolean flag = false;
		UserDTO user = null;
		try {
			 user = userService.validateUserService(uname,pass);
			if(user != null)
			{
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView model = new ModelAndView("home");
		if(flag == true)
		{
			model.addObject("user",user);
			
			HttpSession session = request.getSession();
			session.setAttribute("username",user.getUserName());
			session.setAttribute("password",user.getPassword());
			session.setAttribute("add",new Constant());
			/*ServletContext context = request.getServletContext();
			context.setAttribute("username",user.getUserName());
			context.setAttribute("password",user.getPassword());*/
			return model;
		}else
		{
			model.addObject("error","Invalid Credential");
			return new ModelAndView("login");
		}
		
	}
	
	@RequestMapping(value="/logOut" ,method = RequestMethod.GET)
	public String logOut()
	{
		return "login";
	}

}
