package com.bank.bll;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bank.idal.IUserDAL;
import com.bank.model.UserInfo;

public class UserBLL {
	//´´½¨ÈÝÆ÷
	ApplicationContext ac=new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	IUserDAL dal=(IUserDAL)ac.getBean("userDAL");
	
	//×°Åä
	public UserInfo getUserInfo(int id) {
		return dal.getUserInfo(id);
	}

}
