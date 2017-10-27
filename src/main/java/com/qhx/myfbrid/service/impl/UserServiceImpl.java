/**
 * @author QIUHX 
 * 2017年10月27日
 */
package com.qhx.myfbrid.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.qhx.myfbrid.dao.UserMapper;
import com.qhx.myfbrid.model.User;
import com.qhx.myfbrid.service.UserService;

public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void save(User user) {
		userMapper.register(user);
	}

	@Override
	public boolean checkLogin(String username, String password) {
		int count = userMapper.findUserByUsernameAndPassword(username, password);
		if(count > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean checkUserExistByUsername(String username) {
		int count = userMapper.findUserByUserName(username);
		if(count > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void changeUserInfo(User user) {
		userMapper.updateUserInfoByUserId(user);
	}
}
