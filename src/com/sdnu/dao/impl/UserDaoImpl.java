package com.sdnu.dao.impl;

import java.util.List;


import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.sdnu.dao.UserDao;
import com.sdnu.domain.User;


/**
 * 用户持久层
 * 
 * @author yangpengyu
 *
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	/**
	 * 登录用户名校验
	 */
	public User findByUserCode(String user_code) {
		@SuppressWarnings("unchecked")
		// 根据用户登录名查询用户集合
		List<User> users = (List<User>) this.getHibernateTemplate().find("from User where user_code=?", user_code);
		// 判断是否存在用户
		if (users != null & users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	/**
	 * 保存用户
	 */
	public void save(User user) {
		// 获取模板类保存用户对象到数据库
		this.getHibernateTemplate().save(user);
	}

	/**
	 * 根据用户名和密码查询用户
	 */
	public User find(User user) {
		//QBC查询
		DetachedCriteria criteria=DetachedCriteria.forClass(User.class);
		//添加条件
		criteria.add(Restrictions.eq("user_code", user.getUser_code()));
		criteria.add(Restrictions.eq("user_password", user.getUser_password()));
		criteria.add(Restrictions.eq("user_state", "1"));
		@SuppressWarnings("unchecked")
		//执行查询语句
		List<User> users = (List<User>) this.getHibernateTemplate().findByCriteria(criteria);
		//判断是否存在这样的用户
		if(users!=null&&users.size()>0){
			return users.get(0);
		}
		return null;
	}
	/**
	 * 更新用户
	 */
	@Override
	public void update(User user) {
		this.getHibernateTemplate().update(user);
		
	}

}
