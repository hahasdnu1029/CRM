package com.sdnu.dao;



import org.hibernate.criterion.DetachedCriteria;

import com.sdnu.domain.Linkman;
import com.sdnu.domain.PageBean;

public interface LinkmanDao {
	/**
	 * 查找所有用户
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
	 * @return
	 */
	void update(Linkman linkman);
	/**
	 * 保存联系人
	 * @param linkman 
	 */
	void save(Linkman linkman);
	/**
	 * 根据id查找联系人
	 * @return
	 */
	Linkman findById(Long lkm_id);

}
