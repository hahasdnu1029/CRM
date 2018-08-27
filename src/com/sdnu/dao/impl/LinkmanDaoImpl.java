package com.sdnu.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.sdnu.dao.LinkmanDao;
import com.sdnu.domain.Linkman;
import com.sdnu.domain.PageBean;

public class LinkmanDaoImpl extends HibernateDaoSupport implements LinkmanDao {
	/**
	 * 查找所有用户
	 */
	@SuppressWarnings("unchecked")
	public PageBean<Linkman> findAll(DetachedCriteria criteria, int pageCode, int pageSize) {
		//获得page
		PageBean<Linkman> page=new PageBean<Linkman>();
		//设置当前页面
		page.setPageCode(pageCode);
		//设置每页记录数目
		page.setPageSize(pageSize);
		//设置总记录数目
		criteria.setProjection(Projections.rowCount());
		List<Number> list = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria);
		if(list!=null&&list.size()>0){
			page.setTotalCount(list.get(0).intValue());
		}
		criteria.setProjection(null);
		List<Linkman> beanList = (List<Linkman>) this.getHibernateTemplate().findByCriteria(criteria);
		//设置当前页记录 
		page.setBeanList(beanList);
		return page;
	}
	/**
	 * 删除用户
	 */
	public void delete(Linkman linkman) {
		this.getHibernateTemplate().delete(linkman);
	}
	/**
	 * 更新用户
	 */
	public void update(Linkman linkman) {
		this.getHibernateTemplate().update(linkman);
	}
	/**
	 * 保存联系人
	 */
	public void save(Linkman linkman) {
		this.getHibernateTemplate().save(linkman);
	}
	/**
	 * 根据用户id查找用户
	 */
	@SuppressWarnings("unchecked")
	public Linkman findById(Long lkm_id) {
		List<Linkman> list = (List<Linkman>) this.getHibernateTemplate().find("from Linkman where lkm_id=?", lkm_id);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
