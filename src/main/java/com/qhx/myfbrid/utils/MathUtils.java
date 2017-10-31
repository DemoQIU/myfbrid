/**
 * @author QIUHX 
 * 2017年10月31日
 */
package com.qhx.myfbrid.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.StringUtils;

public class MathUtils {
	/**
	 * 对用户输入的密码进行md5加密
	 * 方法说明:getCharMd5Pwd
	 * @return
	 */
	public static char[] getCharMd5Pwd(String password){
		return StringUtils.hasText(password) ? 
					DigestUtils.md5Hex(password.trim() + "@qiuhx").toCharArray() : null;
	}
}
