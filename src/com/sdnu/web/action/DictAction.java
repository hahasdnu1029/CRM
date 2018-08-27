package com.sdnu.web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sdnu.domain.Dictionary;
import com.sdnu.service.DictService;


public class DictAction extends ActionSupport implements ModelDriven<Dictionary> {

	private static final long serialVersionUID = 8815991292900809068L;
	//注入字典对象
	private Dictionary dict=new Dictionary();
	//注入字典业务层对象
	private DictService dictService;
	

	public void setDictService(DictService dictService) {
		this.dictService = dictService;
	}
	/**
	 * 根据字典的类型码查找信息
	 * @return
	 */
	public String findByCode(){
		//调用业务层进行查询
		List<Dictionary>list=dictService.findbyCode(dict.getDict_type_code());
		//使用fastjson转化成字符串
		String jsonString = JSON.toJSONString(list,SerializerFeature.DisableCircularReferenceDetect);
		
		// 获取response对象
		HttpServletResponse response = ServletActionContext.getResponse();
		//设置传输的类型
		response.setContentType("application/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		//把json串返回到客户端
		try {
			response.getWriter().write(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return NONE;
	}

	public Dictionary getModel() {
		return dict;
	}

}
