package com.sdnu.service;

import com.sdnu.domain.User;

public interface UserService {
	
	/**
	 * 登录用户名校验
	 * @param user_code 用户登录名
	 * @return 用户对象
	 */
	User checkCode(String user_code);
	/**
	 * 注册用户功能
	 * @param user 用户对象
	 */
	void regist(User user);
	/**
	 * 用户登录功能
	 * @param user 用户对象
	 * @return 查询的用户对象
	 */
	User login(User user);
	/**
	 * 更新用户
	 * @param user
	 */
	void update(User user);


}
