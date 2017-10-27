/**

 * @author QIUHX 
 * 2017年10月27日
 */
package com.qhx.myfbrid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.qhx.myfbird.common.BaseController;
import com.qhx.myfbrid.service.UserService;

@Controller
public class LoginController extends BaseController{
	@Autowired
	private UserService userService;
	
}
