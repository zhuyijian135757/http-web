package net.flyingfat.web.controller;

import net.flyingfat.web.model.UserVO;
import net.flyingfat.web.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private Logger logger=LoggerFactory.getLogger(getClass());

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public String getAllUsers(Model model)
	{
		model.addAttribute("Users", userService.getAllUsers());
		return "user";
	}
	
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	@ResponseBody
	public UserVO getAllUsers()
	{
		UserVO vo=new UserVO();
		vo.setFirstName("terry3");
		vo.setLastName("zhu");
		return vo;
	}
	
	@RequestMapping(value = "/getInfoByByte", method = RequestMethod.GET)
	@ResponseBody
	public byte[] getInfoByByte()
	{
		try {
			return "byte2".getBytes("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
			return new byte[1];
		}
	}
	
	@RequestMapping(value = "/getInfoByString", method = RequestMethod.GET)
	@ResponseBody
	public String getInfoByString()
	{
		return "string";
	}
	
	@RequestMapping(value = "/getInfoByHeader", method = RequestMethod.HEAD)
	public HttpHeaders getInfoByHeader()
	{
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.add("hi", "2");
		return httpHeaders;
	}
	
	@RequestMapping(value = "/getLogInfo", method = RequestMethod.POST)
	@ResponseBody
	public void getLogInfo(@RequestBody String json)
	{
		logger.warn(json);
	}
	
}
