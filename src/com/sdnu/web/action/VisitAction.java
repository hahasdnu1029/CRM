package com.sdnu.web.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.sdnu.domain.PageBean;
import com.sdnu.domain.User;
import com.sdnu.domain.Visit;
import com.sdnu.service.VisitService;

public class VisitAction extends ActionSupport implements ModelDriven<Visit> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6305403759489582336L;
	// 注入客户拜访模型
	private Visit visit = new Visit();
	// 注入业务层对象
	private VisitService visitService;

	public void setVisitService(VisitService visitService) {
		this.visitService = visitService;
	}

	/**
	 * 分页查询
	 */
	private int pageCode = 1;
	private int pageSize = 20;

	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	private String beginDate;
	private String endDate;

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String findByPage() {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if (user == null) {
			return "login";
		}
		// 封装查询条件
		DetachedCriteria criteria = DetachedCriteria.forClass(Visit.class);
		if (StringUtils.isNotBlank(beginDate) && StringUtils.isNotBlank(endDate)) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("beginDate", beginDate);
			request.setAttribute("endDate", endDate);
			criteria.add(Restrictions.ge("visit_time", beginDate));
			criteria.add(Restrictions.le("visit_time", endDate));
		}
		criteria.add(Restrictions.eq("user.user_id", user.getUser_id()));
		// 调用业务层查询
		PageBean<Visit> pageBean = visitService.list(criteria, pageCode, pageSize);
		// 放到值栈中
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.set("page", pageBean);
		return "listOk";
	}
	/**
	 * 保存客户拜访记录
	 */
	public String add(){
		visitService.save(visit);
		return "addOk";
	}
	public Visit getModel() {
		// TODO Auto-generated method stub
		return visit;
	}
	public String initVisitAdd(){
		return "initVisitAddOk";
	}
}
