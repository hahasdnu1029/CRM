package com.sdnu.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.sdnu.dao.UserDao;
import com.sdnu.domain.User;
import com.sdnu.service.UserService;
import com.sdnu.utils.MD5Utils;

/**
 * 用户业务逻辑层
 * 
 * @author yangpengyu
 *
 */
@Transactional
public class UserServiceImpl implements UserService {
	//依赖注入UserDao对象
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	/**
	 * 登录用户名校验
	 */
	@Override
	public User checkCode(String user_code) {
		return userDao.findByUserCode(user_code);
	}
	/**
	 * 保存用户
	 */
	@Override
	public void regist(User user) {
		//对用户密码进行md5加密
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		//设置用户状态
		user.setUser_state("1");
		//调用dao层进行查询
		userDao.save(user);
	}


	@Override
	public User login(User user) {
		//对用户的登录密码进行md5编码
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		//调用dao层进行查询
		return userDao.find(user);
	}
	/**
	 * 更新用户
	 */
	@Override
	public void update(User user) {
		userDao.update(user);
	}

}
