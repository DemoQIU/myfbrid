/**
 * @author QIUHX 
 * 2017年10月31日
 */
package com.qhx.myfbrid.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

import com.qhx.myfbrid.exception.CommonException;
import com.qhx.myfbrid.model.User;
import com.qhx.myfbrid.utils.MathUtils;
import com.qhx.myfbrid.utils.UserUtils;

/**shiro管理类**/
public class ShiroManager {
	private static Logger logger = LoggerFactory.getLogger(ShiroManager.class);
	
	//控制用户登录
	public static void login(User user) throws CommonException{
		//判断用户是否已登录，用户名密码是否为空
		//为true，用户校验通过，往shiro中存入登录信息
		if(UserUtils.isSecurity(user)){
			//如果用户登录过程正常 则通过登录
			UsernamePasswordToken usernamePasswordToken = 
											new UsernamePasswordToken(
															user.getUsername(), 
															MathUtils.getCharMd5Pwd(user.getPassword())); 
			//登录成功
			SecurityUtils.getSubject().login(usernamePasswordToken);
		}
	}
	
	//退登
	public static void logout(){
		if(UserUtils.isLogin()){
			SecurityUtils.getSubject().logout();
			logger.info("--->logout successful !!! <---");
		}else{
			logger.warn("--->user {} has't login <---",((User)(SecurityUtils.getSubject().getPrincipal())).getNickname());
		}
	}
	
	//获得当前用户
	public static User getCurrentUser(){
		return (User)SecurityUtils.getSubject().getPrincipal();
	}
}
