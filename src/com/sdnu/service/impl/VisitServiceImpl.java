package com.sdnu.service.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.sdnu.dao.VisitDao;
import com.sdnu.domain.PageBean;
import com.sdnu.domain.Visit;
import com.sdnu.service.VisitService;
@Transactional
public class VisitServiceImpl implements VisitService {
	private VisitDao visitDao;


	public void setVisitDao(VisitDao visitDao) {
		this.visitDao = visitDao;
	}

	/**
	 * 分页查询
	 */
	public PageBean<Visit> list(DetachedCriteria criteria, int pageCode, int pageSize) {
		return visitDao.list( criteria, pageCode, pageSize);
	}
	/**
	 * 保存客户拜访记录
	 */
	public void save(Visit visit) {
		visitDao.save(visit);
	}
	
}
