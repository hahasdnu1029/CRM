package com.sdnu.dao;

import java.util.List;

import com.sdnu.domain.Dictionary;

public interface DictDao {
	/**
	 * 根据字典表类型查找信息 
	 * @param dict_type_code 字典类型码
	 * @return 信息的list集合
	 */

	List<Dictionary> findByCode(String dict_type_code);

}
