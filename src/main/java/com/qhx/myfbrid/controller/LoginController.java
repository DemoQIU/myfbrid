/**

 * @author QIUHX 
 * 2017年10月27日
 */
package com.qhx.myfbrid.controller;

import org.apache.shiro.authc.DisabledAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(value="/login")
	public String loginRequest(){
		logger.info("---> user want login <---");
		return "admin/login";
	}
	
	@RequestMapping(value = "/admin/login",method=RequestMethod.POST,
			produces = {"application/json;charset=UTF-8"})
	public String loginByUsernameAndPassword(User user,HttpRequest request){
		try{
			ShiroManager.login(user);
			logger.info("--->{} login successful <---",user.getNickname());
//			return ResultUtils.getUrlJson();
			return null;
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
}
