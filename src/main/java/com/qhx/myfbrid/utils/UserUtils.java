/**
 * @author QIUHX 
 * 2017年10月31日
 */
package com.qhx.myfbrid.utils;

import javax.swing.Spring;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.util.StringUtils;

import com.qhx.myfbrid.exception.CommonException;
import com.qhx.myfbrid.exception.NullValueException;
import com.qhx.myfbrid.exception.RepeatException;
import com.qhx.myfbrid.model.User;

/**用来判断用户可能出现的情况工具类**/
public class UserUtils {
	public static boolean isSecurity(User user) throws CommonException{
		String security = securityCheck(user);
		if(!StringUtils.hasText(security)){
			throw new NullValueException(security);
		}
		return true;
	}

	/**
	 * 方法说明:securityCheck
	 * @param user
	 * @return
	 */
	private static String securityCheck(User user) throws RepeatException{
		if(!StringUtils.hasText(user.getUsername()))
			return RequestStates.nameNull.getResultInfo();
		if(!StringUtils.hasText(user.getPassword()))
			return RequestStates.pswdNull.getResultInfo();
		
		if(isLogin()){
			throw new RepeatException(((User)(SecurityUtils.getSubject().getPrincipal())).getNickname()
					+RequestStates.repeat.getResultInfo());
		}
		return null;
	}

	/**
	 * 方法说明:isLogin 是否重复登录
	 * @return
	 */
	private static boolean isLogin() {
		return SecurityUtils.getSubject().isAuthenticated();
	}
}
