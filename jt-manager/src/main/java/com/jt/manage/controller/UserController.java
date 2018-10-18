package com.jt.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.manage.pojo.User;
import com.jt.manage.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/findAll")
	public String findList(Model model) {
		List<User> userList = userService.findAll();
		// model对象将数据存入request域
		model.addAttribute("userList", userList);
		
		// 页面跳转
		return "userList";
		/**
		 * SpringMVC将返回
		 * 
		 * url路径： /WEB_INF/views/userList.jsp
		 */
		
	}

}
