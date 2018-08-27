package com.sdnu.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.sdnu.dao.DictDao;
import com.sdnu.domain.Dictionary;

public class DictDaoImpl extends HibernateDaoSupport implements DictDao {
	// 根据字典表类型查找信息
	@SuppressWarnings("unchecked")
	public List<Dictionary> findByCode(String dict_type_code) {
		List<Dictionary> list = (List<Dictionary>) this.getHibernateTemplate()
				.find("from Dictionary where dict_type_code=? ", dict_type_code);
		return list;
	}

}
