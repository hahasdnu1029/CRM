package com.sdnu.web.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sdnu.domain.User;
import com.sdnu.service.UserService;
import com.sdnu.utils.MD5Utils;

/**
 * 用户控制器
 * 
 * @author yangpengyu
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 8022722235350289325L;
	// 模型注入对象
	private User user = new User();
	// 依赖注入的用户业务层对象
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 用户注册功能
	 */
	public String regist() {
		userService.regist(user);
		return LOGIN;
	}

	/**
	 * 检测登录名是否已经注册
	 */
	public String checkCode() {
		// 获得response对象
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置编码字符集
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 得到输出字符流
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 调用业务层进行判断
		User registUser = userService.checkCode(user.getUser_code());
		// 判断user1是否为空
		if (registUser != null) {
			// 不能注册
			pw.write("no");
		} else {
			// 可以注册
			pw.write("ok");
		}
		return NONE;
	}

	/**
	 * 登录功能
	 */
	private String txt_code;
	
	public String getTxt_code() {
		return txt_code;
	}

	public void setTxt_code(String txt_code) {
		this.txt_code = txt_code;
	}

	public String login() {
		// 获取request对象
		HttpServletRequest request = ServletActionContext.getRequest();
		// 获得session对象
		HttpSession session = request.getSession();
		// 要用业务层方法
		if (txt_code!=null&&!txt_code.equalsIgnoreCase((String) session.getAttribute("data"))) {
			// 用户不存在，转发到登录页面并提示消息
			request.setAttribute("info", "验证码不正确");
			return LOGIN;
		}
		User loginUser = userService.login(user);
		if (loginUser == null) {
			// 用户不存在，转发到登录页面并提示消息
			request.setAttribute("info", "用户名或密码错误");
			return LOGIN;
		} else {
			// 用户存在,转发到主页面并显示用户信息
			session.setAttribute("user", loginUser);
			return "loginOk";
		}
	}

	/**
	 * 安全退出功能
	 */
	public String exit() {
		// 获得session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		// 从session中移除该用户
		session.removeAttribute("user");
		return LOGIN;
	}
	/**
	 * 修改密码
	 */
	private String oldPwd;
	
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}
	public String changePwd(){
		//获得session对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user1 = (User) session.getAttribute("user");
		String md5 = MD5Utils.md5(oldPwd);
		if(!md5.equals(user1.getUser_password())){
			request.setAttribute("info2", "* 输入的原密码不正确");
			return "changeError";
		}
		user1.setUser_password(MD5Utils.md5(user.getUser_password()));
		userService.update(user1);
		return "login";
	}
	public String initChangePwd(){
		return "initChangePwdOk";
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}
