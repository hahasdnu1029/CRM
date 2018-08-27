package com.sdnu.service;

import java.util.List;

import com.sdnu.domain.Dictionary;

public interface DictService {
	/**
	 * 根据字典表类型查找信息 
	 * @param dict_type_code 类型码
	 * @return 返回信息的list集合
	 */

	List<Dictionary> findbyCode(String dict_type_code);

}
