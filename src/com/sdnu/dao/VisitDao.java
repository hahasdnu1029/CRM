package com.sdnu.dao;

import org.hibernate.criterion.DetachedCriteria;

import com.sdnu.domain.PageBean;
import com.sdnu.domain.Visit;

public interface VisitDao {

	PageBean<Visit> list(DetachedCriteria criteria, int pageCode, int pageSize);

	void save(Visit visit);

}
