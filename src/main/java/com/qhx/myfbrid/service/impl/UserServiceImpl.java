/**
 * @author QIUHX 
 * 2017年10月27日
 */
package com.qhx.myfbrid.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qhx.myfbrid.dao.UserMapper;
import com.qhx.myfbrid.model.User;
import com.qhx.myfbrid.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int save(User user) {
		return userMapper.register(user);
	}
	
	//根据用户传入的用户名和密码检查用户是否可以登录
	@Override
	public User checkLogin(String username, String password) {
		User user = userMapper.findUserByUsernameAndPassword(username, password);
		return user;
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
