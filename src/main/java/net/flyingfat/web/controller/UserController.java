package net.flyingfat.web.controller;

import net.flyingfat.web.model.UserVO;
import net.flyingfat.web.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public String getAllUsers(Model model)
	{
		model.addAttribute("Users", userService.getAllUsers());
		return "userList";
	}
	
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	@ResponseBody
	public UserVO getAllUsers()
	{
		UserVO vo=new UserVO();
		vo.setFirstName("terry");
		vo.setLastName("zhu");
		return vo;
	}
	
	
}
