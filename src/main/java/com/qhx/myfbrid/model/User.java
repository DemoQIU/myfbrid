/**
 * @author QIUHX 
 * 2017年10月27日
 */
package com.qhx.myfbrid.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
public class User {
	/** 用户名 */
	@Setter
	@Getter
	private String username = "";
    /** 用户id */
	@Setter
	@Getter
	private int userId = 0;
    /** 昵称 */
	@Setter
	@Getter
	private String nickname = "";
    /** 0:女  1:男 */
	@Setter
	@Getter
	private int gender = 0;
    /** 密码 */
	@Setter
	@Getter
    private transient String password = "";
    /** 邮箱 */
	@Setter
	@Getter
	private String usermail = "";
    /** -2:未启用  2:启用 */
	@Setter
	@Getter
	private int state = -2;
    /** -3:非卖家  3:卖家 */
	@Setter
	@Getter
	private int isSeller = -3;
    /** 最后登录时间 */
	@Setter
	@Getter
	private LocalDateTime lastLoginTime = LocalDateTime.of(1970, 1, 1, 0, 0, 0);
    /** 创建日期 */
	@Setter
	@Getter
	private LocalDateTime createTime = LocalDateTime.of(1970, 1, 1, 0, 0, 0);
}
