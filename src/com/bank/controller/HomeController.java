package com.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.bank.bll.UserBLL;

@Controller
@RequestMapping("/")
public class HomeController {
	
	UserBLL userBLL=new UserBLL();
	@RequestMapping("/index")
	public ModelAndView Index(){
		ModelAndView mv=new ModelAndView("index");
		
		String s="Spring MVC Hello World";
		mv.addObject("Home", s);
		return mv;
	}
	
	//获取用户信息
		@RequestMapping("/getUserInfo")
		public ModelAndView getUserInfoById(){
			ModelAndView view=new ModelAndView("user");
			view.addObject("user", userBLL.getUserInfo(1));
			
			return view;
		}

}
