/**
 * @author QIUHX 
 * 2017年10月31日
 */
package com.qhx.myfbrid.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.StringUtils;

import com.qhx.myfbrid.exception.CommonException;
import com.qhx.myfbrid.exception.NullValueException;
import com.qhx.myfbrid.exception.RepeatException;
import com.qhx.myfbrid.model.User;

/**用来判断用户可能出现的情况工具类**/
public class UserUtils {
	
	public static boolean isSecurity(User user) throws CommonException{
		//校验用户登录的信息
		String security = securityCheck(user);
		//如果有异常值返回，说明登录出现问题，返回异常信息
		if(StringUtils.hasText(security)){
			throw new NullValueException(security);
		}
		//true代表用户校验通过
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
	public static boolean isLogin() {
		return SecurityUtils.getSubject().isAuthenticated();
	}
	
	/**
	 * 获得登录之前的正在访问页面的url,如果为空，返回到index主页
	 * 方法说明:getBeforeLoginUrl
	 * @return
	 */
	public static String getBeforeLoginUrl(HttpServletRequest request){
		SavedRequest savedRequest = WebUtils.getSavedRequest(request);
		return savedRequest == null ? "/index" : savedRequest.getRequestUrl();
	}
}
