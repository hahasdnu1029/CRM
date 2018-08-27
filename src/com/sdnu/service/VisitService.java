package com.sdnu.service;

import org.hibernate.criterion.DetachedCriteria;

import com.sdnu.domain.PageBean;
import com.sdnu.domain.Visit;

public interface VisitService {

	PageBean<Visit> list(DetachedCriteria criteria, int pageCode, int pageSize);

	void save(Visit visit);

}
