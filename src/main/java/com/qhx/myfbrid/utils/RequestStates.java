/**
 * @author QIUHX 
 * 2017年10月31日
 */
package com.qhx.myfbrid.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
public enum RequestStates {
	disabled(2,"账户未启用"),  //状态码=2 : 启用 
    unseller(3,"您不是卖家"),  //状态码=3 : 卖家
    success(200,"操作成功"),
    
    nameNull(403,"用户名不能为空"),
    pswdNull(403,"密码不能为空"),
    failed(400,"用户名与密码不匹配"),
    repeat(205," : 您早已登录啦"),
    
    registerRepeat(202,"改用户名已被注册"),
    registerExistence(202,"邮箱已被使用"),
    registerFailed(205,"注册失败，请重试");
	
	@Setter
	@Getter
	private int status = 0;
	@Setter
	@Getter
	private String resultInfo = "";
}
