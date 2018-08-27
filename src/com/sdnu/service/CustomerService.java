package com.sdnu.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.sdnu.domain.Customer;
import com.sdnu.domain.Linkman;
import com.sdnu.domain.PageBean;

public interface CustomerService {
	/**
	 * 实现客户列表
	 * @param criteria 查询条件
	 * @param pageCode 当前页
	 * @param pageSize 每页显示的记录数目
	 * @return
	 */

	PageBean<Customer> list(DetachedCriteria criteria, Integer pageCode, Integer pageSize);
	/**
	 * 添加客户
	 * @param customer
	 */
	void add(Customer customer);
	/**
	 * 根据客户id查找客户
	 * @param cust_id客户id
	 * @return 客户对象
	 */
	Customer findByCust_id(Long cust_id);
	/**
	 * 根据用户id删除用户
	 * @param cust_id 用户id
	 */
	void delete(Long cust_id);
	/**
	 * 保存修改后的客户
	 * @param customer
	 */
	void update(Customer customer);
	/**
	 * 查询所有客户
	 * @return
	 */
	List<Customer> findAll();
	/**
	 * 根据客户来源统计客户数目
	 */
	List<Object[]> findBySource();
	List<Object[]> findByIndustry();

}
