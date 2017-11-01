/**
 * @author QIUHX 
 * 2017年10月27日
 */
package com.qhx.myfbrid.dao;

import org.springframework.stereotype.Repository;

import com.qhx.myfbrid.model.User;

@Repository(value = "userMapper")
public interface UserMapper {
	User findUserByUsernameAndPassword(String username,String password);
	int findUserByUserName(String username);
	int register(User user);
	void updateUserInfoByUserId(User user);
}
