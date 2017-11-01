/**

 * @author QIUHX 
 * 2017年10月27日
 */
package com.qhx.myfbrid.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.DisabledAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qhx.myfbird.common.BaseController;
import com.qhx.myfbrid.exception.NullValueException;
import com.qhx.myfbrid.exception.RepeatException;
import com.qhx.myfbrid.model.User;
import com.qhx.myfbrid.service.GoodsService;
import com.qhx.myfbrid.shiro.ShiroManager;
import com.qhx.myfbrid.utils.ResultUtils;

@Controller
public class LoginController extends BaseController{
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private GoodsService goodsService;
	
	//返回所有商品信息到首页
	@RequestMapping(value = "/index")
	public void indexPage(Model model){
		logger.info("---> go to home page <---");
		model.addAttribute("goodsList", goodsService.findAllGoods());
	}
	
	//点击首页上的登录按钮，跳转到登录页面
	@RequestMapping(value="/login")
	public String loginRequest(){
		logger.info("---> user want login <---");
		return "admin/login";
	}
	
	//点击登录页面上的登录按钮，后台对用户提交的登录信息进行校验
	@RequestMapping(value = "/admin/login",method=RequestMethod.POST,
			produces = {"application/json;charset=UTF-8"})
	public String loginByUsernameAndPassword(User user,HttpServletRequest request){
		try{
			//没有异常捕获 说明用户登录信息校验通过
			ShiroManager.login(user);
			logger.info("--->{} login successful at time : {} <---",user.getNickname(),LocalDateTime.now());
			return ResultUtils.getUrlJson(request);
		}catch (NullValueException e) {
			logger.error("--->request user is null !!!!");
			return ResultUtils.getJson(e.getMessage());
		}catch(RepeatException e){
			logger.error("--->user has existed !!!!");
			return ResultUtils.getJson(e.getMessage());
		}catch (DisabledAccountException e) {
			logger.error("--->username wrong !!!!");
			return ResultUtils.getJson(e.getMessage());
		}catch(Exception e){
			logger.error("--->username or password wrong !!!!");
			return ResultUtils.getJson(e.getMessage());
		}
	}
	
	//用户退出登录
	@RequestMapping(value = "/admin/logout")
	public String logout(){
		try{
			ShiroManager.logout();
			logger.info("---> 用户退出成功 <---");
		}catch(Exception exception){
			logger.error("---> 用户退登失败 <---");
		}
		return "admin/login";
	}
	
}
