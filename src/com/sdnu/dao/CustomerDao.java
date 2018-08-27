package com.sdnu.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.sdnu.domain.Customer;
import com.sdnu.domain.PageBean;

public interface CustomerDao {
	/**
	 * 分页查询 
	 * @param criteria 查询条件
	 * @param pageCode 当前页
	 * @param pageSize 每页记录数
	 * @return
	 */
	PageBean<Customer> findByPage(DetachedCriteria criteria, Integer pageCode, Integer pageSize);
	/**
	 * 保存客户到数据库
	 * @param customer
	 */
	void save(Customer customer);
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
	 * 更新客户信息
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
	/**
	 * 根据客户所属行业统计客户数目
	 */
	List<Object[]> findIndustry();

}
