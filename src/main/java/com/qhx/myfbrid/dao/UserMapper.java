/**
 * @author QIUHX 
 * 2017年10月27日
 */
package com.qhx.myfbrid.dao;

import org.springframework.stereotype.Repository;

import com.qhx.myfbrid.model.User;

@Repository(value = "userMapper")
public interface UserMapper {
	int findUserByUsernameAndPassword(String username,String password);
	int findUserByUserName(String username);
	void register(User user);
	void updateUserInfoByUserId(User user);
}
