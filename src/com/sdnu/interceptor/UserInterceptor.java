package com.sdnu.interceptor;

import javax.servlet.http.HttpSession;


import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class UserInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = 788992120332643564L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//获得session
		HttpSession session = ServletActionContext.getRequest().getSession();
		//判断
		Object user = session.getAttribute("user");
		System.out.println(user);
		if(user==null){
			return "login";
		}
		return invocation.invoke();
	}

}
