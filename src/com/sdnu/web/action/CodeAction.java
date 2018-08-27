package com.sdnu.web.action;


import com.opensymphony.xwork2.ActionSupport;

public class CodeAction extends ActionSupport {

	private static final long serialVersionUID = 6238695421410170853L;

	/**
	 * 读取验证码
	 * @return
	 */
	public String code() {
		return SUCCESS;
	}

}
