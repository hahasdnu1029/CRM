package com.sdnu.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sdnu.dao.DictDao;
import com.sdnu.domain.Dictionary;
import com.sdnu.service.DictService;
@Transactional
public class DictServiceImpl implements DictService {
	//注入dao层对象
	private DictDao dictDao;


	public void setDictDao(DictDao dictDao) {
		this.dictDao = dictDao;
	}

	//根据字典表类型查找信息 
	public List<Dictionary> findbyCode(String dict_type_code) {
		return dictDao.findByCode(dict_type_code);
	}
	

}
