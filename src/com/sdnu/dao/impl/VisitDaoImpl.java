package com.sdnu.dao.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import com.sdnu.dao.VisitDao;
import com.sdnu.domain.PageBean;
import com.sdnu.domain.Visit;

public class VisitDaoImpl extends HibernateDaoSupport implements VisitDao {
	/**
	 * 分页查询
	 */
	@SuppressWarnings("unchecked")
	public PageBean<Visit> list(DetachedCriteria criteria, int pageCode, int pageSize) {
		       //封装pageBean
				PageBean<Visit> pageBean=new PageBean<>();
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
				List<Visit> visits = (List<Visit>) this.getHibernateTemplate().findByCriteria(criteria, (pageCode-1)*pageSize, pageSize);
				//设置当前页记录
				pageBean.setBeanList(visits);
				return pageBean;
	}
	/**
	 * 保存客户拜访记录
	 */
	public void save(Visit visit) {
		this.getHibernateTemplate().save(visit);
	}

}
