/**
 * @author QIUHX 
 * 2017年10月27日
 */
package com.qhx.myfbrid.service;

import org.springframework.stereotype.Service;

import com.qhx.myfbrid.model.User;
@Service(value = "userService")
public interface UserService {
	int save(User user);
	User checkLogin(String username,String password);
	boolean checkUserExistByUsername(String username);
	void changeUserInfo(User user);
}
