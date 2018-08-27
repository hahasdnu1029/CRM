package com.sdnu.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.sdnu.dao.CustomerDao;
import com.sdnu.domain.Customer;
import com.sdnu.domain.PageBean;
import com.sdnu.service.CustomerService;
@Transactional
public class CustomerServiceImpl implements CustomerService {
	//注入持久层对象
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public PageBean<Customer> list(DetachedCriteria criteria, Integer pageCode, Integer pageSize) {
		return customerDao.findByPage(criteria,pageCode, pageSize);
	}

	@Override
	public void add(Customer customer) {
		customerDao.save(customer);
	}

	@Override
	public Customer findByCust_id(Long cust_id) {
		return customerDao.findByCust_id(cust_id);
	}

	@Override
	public void delete(Long cust_id) {
        customerDao.delete(cust_id);		
	}

	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
	}

	@Override
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	@Override
	public List<Object[]> findBySource() {
		return customerDao.findBySource();
	}

	@Override
	public List<Object[]> findByIndustry() {
		// TODO Auto-generated method stub
		return customerDao.findIndustry();
	}
	

}
