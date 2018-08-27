package com.sdnu.dao.impl;

import java.util.List;


import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.sdnu.dao.CustomerDao;
import com.sdnu.domain.Customer;
import com.sdnu.domain.PageBean;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@SuppressWarnings("unchecked")
	@Override
	public PageBean<Customer> findByPage(DetachedCriteria criteria, Integer pageCode, Integer pageSize) {
		//封装pageBean
		PageBean<Customer> pageBean=new PageBean<>();
		pageBean.setPageCode(pageCode);
		pageBean.setPageSize(pageSize);
		//查询总的记录数目 
		criteria.setProjection(Projections.rowCount());
		List<Number> counts = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria);
		//设置总的记录数
		if(counts!=null&&counts.size()>0){
			int totalCount=counts.get(0).intValue();
			pageBean.setTotalCount(totalCount);
		}
		//清除聚合函数
		criteria.setProjection(null);
		List<Customer> customers = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, (pageCode-1)*pageSize, pageSize);
		//这只当当前页记录
		pageBean.setBeanList(customers);
		return pageBean;
	}
	/**
	 * 保存客户
	 */
	public void save(Customer customer) {
		this.getHibernateTemplate().save(customer);
		
	}
	/**
	 * 根据id查找对应的客户
	 */
	@SuppressWarnings("unchecked")
	public Customer findByCust_id(Long cust_id) {
		List<Customer> customers = (List<Customer>) this.getHibernateTemplate().find("from Customer where cust_id=?", cust_id);
		if(customers!=null&&customers.size()>0){
			return customers.get(0);
		}
		return null;
	}
	/**
	 * 根据用户id删除用户
	 * @param cust_id 用户id
	 */
	@SuppressWarnings("unchecked")
	public void delete(Long cust_id) {
		List<Customer> customers = (List<Customer>) this.getHibernateTemplate().find("from Customer where cust_id=?", cust_id);
		if(customers!=null&&customers.size()>0){
			this.getHibernateTemplate().delete(customers.get(0));
		}
	}
	/**
	 * 更新客户信息
	 */
	public void update(Customer customer) {
		this.getHibernateTemplate().update(customer);
	}
	/**
	 *查找所有客户
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> findAll() {
		return (List<Customer>) this.getHibernateTemplate().find("from Customer");
	}
	/**
	 * 根据客户来源统计客户数目
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]>findBySource() {
		String hql="select c.source.dict_item_name,count(*) from Customer c inner join c.source group by c.source";
		return (List<Object[]>) this.getHibernateTemplate().find(hql);
	}
	/**
	 * 根据客户所属行业统计客户数目
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> findIndustry() {
		String hql="select c.industry.dict_item_name,count(*) from Customer c inner join c.industry group by c.industry";
		return (List<Object[]>) this.getHibernateTemplate().find(hql);
	}

}
