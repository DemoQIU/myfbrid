/**
 * @author QIUHX 
 * 2017年11月1日
 */
package com.qhx.myfbrid.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qhx.myfbrid.exception.NullValueException;
import com.qhx.myfbrid.exception.RepeatException;
import com.qhx.myfbrid.model.User;
import com.qhx.myfbrid.shiro.ShiroRealm;
import com.qhx.myfbrid.utils.ResultUtils;
import com.qhx.myfbrid.utils.UserUtils;

@Controller
public class UserController {
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private ShiroRealm shiroRealm;
	
	//用户在首页点击注册按钮,页面跳转到注册页面
	@RequestMapping(value = "/admin/register")
	public String registerPage(){
		return "admin/register";
	}
	
	//用户在注册页面点击提交注册信息按钮,后台对用户输入进行处理
	@RequestMapping(value = "/admin/register",method = RequestMethod.POST,
						produces = {"application/json;charset=UTF-8"})
	public String register(User user,HttpServletRequest request){
		try{
			if(UserUtils.isSecurity(user)){
				shiroRealm.register(user);
			}
			logger.info("---> register successful !!! <---");
			return ResultUtils.getUrlJson(request);
		}catch (NullValueException e) {
			logger.error("---> register user's info is null <---");
			return ResultUtils.getJson(e.getMessage());
		}catch (RepeatException e) {
			logger.error("---> register user has exist <---");
			return ResultUtils.getJson(e.getMessage());
		}catch (Exception e) {
			logger.error("---> register failed <---");
			return ResultUtils.getJson(e.getMessage());
		}
	}
	
	//注册成功,返回到成功页面
	@RequestMapping(value = "/registerSuccess")
	public String registerSuccess(){
		return "success/200";
	}
}
