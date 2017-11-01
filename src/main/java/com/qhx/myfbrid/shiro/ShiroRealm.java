/**
 * @author QIUHX 
 * 2017年10月31日
 */
package com.qhx.myfbrid.shiro;

import java.time.LocalDateTime;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.qhx.myfbrid.exception.CommonException;
import com.qhx.myfbrid.exception.RepeatException;
import com.qhx.myfbrid.model.User;
import com.qhx.myfbrid.service.UserService;
import com.qhx.myfbrid.utils.MathUtils;
import com.qhx.myfbrid.utils.RequestStates;
import com.qhx.myfbrid.utils.UserUtils;

public class ShiroRealm extends AuthorizingRealm{
	private static Logger logger = LoggerFactory.getLogger(ShiroRealm.class);
	@Autowired
	private UserService userService;
	
	/**
	 * 用户授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		return null;
	}
	
	/**
	 * 用户登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken)authenToken;
		User user = userService.checkLogin(token.getUsername(), new String(token.getPassword()));
		
		if(null == user){
			throw new IncorrectCredentialsException();
		}
		
		//如果用户未被激活，抛出异常
		else if(RequestStates.disabled.getStatus() != user.getState()){
			String errorMsg = RequestStates.disabled.getResultInfo();
			throw new DisabledAccountException(errorMsg);
		}
		
		//校验成功，更新数据库中登录用户的信息
		else{
			//记录用户登录时间
			user.setLastLoginTime(LocalDateTime.now());
			//更新数据库中的用户登录信息
			userService.changeUserInfo(user);
		}
		return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
	}
	
	public void register(User user) throws CommonException{
		if(userService.checkUserExistByUsername(user.getUsername())){
			throw new RepeatException(RequestStates.registerRepeat.getResultInfo());
		}
		//密码MD5加密
		user.setPassword(new String(MathUtils.getCharMd5Pwd(user.getPassword())));
		
		if(userService.save(user) != 1){
			logger.error("---> user register fail !!! <---");
		}
	}
	
}
