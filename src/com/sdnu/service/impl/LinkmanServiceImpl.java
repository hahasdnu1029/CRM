package com.sdnu.service.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.sdnu.dao.LinkmanDao;
import com.sdnu.domain.Linkman;
import com.sdnu.domain.PageBean;
import com.sdnu.service.LinkmanService;
@Transactional
public class LinkmanServiceImpl implements LinkmanService {
	//注入dao
	private LinkmanDao linkmanDao;

	public LinkmanDao getLinkmanDao() {
		return linkmanDao;
	}

	public void setLinkmanDao(LinkmanDao linkmanDao) {
		this.linkmanDao = linkmanDao;
	}
	/**
	 * 查找所有用户
	 */
	public PageBean<Linkman> findAll(DetachedCriteria criteria, int pageCode, int pageSize) {
		return linkmanDao.findAll(criteria, pageCode, pageSize);
	}

	@Override
	public void delete(Linkman linkman) {
		linkmanDao.delete(linkman);
	}

	@Override
	public void edit(Linkman linkman) {
		 linkmanDao.update(linkman);
	}

	@Override
	public void add(Linkman linkman) {
		linkmanDao.save(linkman);
	}

	@Override
	public Linkman findById(Long lkm_id) {
		return linkmanDao.findById(lkm_id);
	}

	
}
