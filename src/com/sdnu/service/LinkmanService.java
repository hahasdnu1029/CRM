package com.sdnu.service;


import org.hibernate.criterion.DetachedCriteria;

import com.sdnu.domain.Linkman;
import com.sdnu.domain.PageBean;

public interface LinkmanService {
	/**
	 * 参照所有联系人
	 * @return
	 */
	PageBean<Linkman> findAll(DetachedCriteria criteria, int pageCode, int pageSize);
	/**
	 * 删除客户
	 * @param linkman
	 */
	void delete(Linkman linkman);
	/**
	 * 更新联系人
	 * @param linkman
	 */
	void edit(Linkman linkman);
	/**
	 * 添加联系人
	 * @param linkman
	 */
	void add(Linkman linkman);
	/**
	 * 根据id查找联系人
	 * @param lkm_id
	 * @return
	 */
	Linkman findById(Long lkm_id);

}
