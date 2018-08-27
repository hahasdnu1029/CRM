package com.sdnu.web.action;

import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sdnu.domain.Customer;
import com.sdnu.domain.Linkman;
import com.sdnu.domain.PageBean;
import com.sdnu.service.LinkmanService;

public class LinkmanAction extends ActionSupport implements ModelDriven<Linkman> {

	private static final long serialVersionUID = -3552090335955862874L;
	// 注入模型
	private Linkman linkman = new Linkman();
	// 注入业务层
	private LinkmanService linkmanService;

	public void setLinkmanService(LinkmanService linkmanService) {
		this.linkmanService = linkmanService;
	}

	public Linkman getLinkman() {
		return linkman;
	}

	/**
	 * 查找所有联系人
	 * 
	 * @param linkman
	 */
	private int pageSize = 20;
	private int pageCode = 1;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCode() {
		return pageCode;
	}

	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}
	/**
	 * 更新联系人
	 */
	public String update(){
		linkmanService.edit(linkman);
		return "updateOk";
	}
	public String list() {
		// 查询条件
		DetachedCriteria criteria = DetachedCriteria.forClass(Linkman.class);
		String lkm_name = linkman.getLkm_name();
		if (StringUtils.isNotEmpty(lkm_name)) {
			criteria.add(Restrictions.like("lkm_name", "%" +lkm_name + "%"));
		}
		Customer customer = linkman.getCustomer();
		if(customer!=null&&customer.getCust_id()!=null){
			criteria.add(Restrictions.eq("customer.cust_id",customer.getCust_id()));
		}
		PageBean<Linkman> page = linkmanService.findAll(criteria, pageCode, pageSize);
		// 获得session
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("page", page);
		return "listOk";
	}
	/**
	 * 删除联系人
	 */
	public String delete(){
		linkmanService.delete(linkman);
		return "deleteOk";
	}
	/**
	 * 更新初始化
	 */
	public String editInit(){
		 linkman=linkmanService.findById(linkman.getLkm_id());
		return "editInitOk";
	}
	public void setLinkman(Linkman linkman) {
		this.linkman = linkman;
	}
	/**
	 * 添加联系人
	 */
	public String add(){
		linkmanService.add(linkman);
		return "addOk";
	}
	@Override
	public Linkman getModel() {
		return linkman;
	}
	public String initLinkmanAdd(){
		return "initLinkmanAddOk";
	}

}
