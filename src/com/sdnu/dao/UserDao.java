package com.sdnu.dao;

import com.sdnu.domain.User;

public interface UserDao {
	/**
	 * 根据用户登录名查找用户
	 * @param user_code 用户登录名
	 * @return 用户对象
	 */
	User findByUserCode(String user_code);
	/**
	 * 保存用户
	 * @param user 用户对象
	 */
	void save(User user);
	/**
	 * 根据用户名和密码查询用户
	 * @param user
	 * @return
	 */
	User find(User user);
	/**
	 * 更新用户
	 * @param user
	 */
	void update(User user);

}
