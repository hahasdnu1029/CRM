package com.sdnu.web.results;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;

import com.opensymphony.xwork2.ActionInvocation;
import com.sdnu.utils.CodeFactory;

public class Captcha extends StrutsResultSupport {

	private static final long serialVersionUID = -7142885432952283829L;

	@Override
	protected void doExecute(String arg0, ActionInvocation arg1) throws Exception {
		       //得到request对象
				HttpServletRequest request = ServletActionContext.getRequest();
				//得到response对象
				HttpServletResponse response = ServletActionContext.getResponse();
				//获得验证码制造工厂
				CodeFactory factory=new CodeFactory();
				//获取验证码并输出
				factory.getRandCode(request, response);
	}

}
