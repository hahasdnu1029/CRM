package com.sdnu.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.sdnu.domain.Customer;
import com.sdnu.domain.Dictionary;
import com.sdnu.domain.PageBean;
import com.sdnu.service.CustomerService;
import com.sdnu.utils.Genertor;

/**
 * @author yangpengyu
 *
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	private static final long serialVersionUID = -1301529625701631628L;
	// 客户对象
	private Customer customer = new Customer();
	// 注入客户业务层对象
	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	// 分页查询的当前页数
	private Integer pageCode = 1;
	// 分页查询每页要显示的记录数
	private Integer pageSize = 20;

	public void setPageCode(Integer pageCode) {
		if (pageCode != null) {
			this.pageCode = pageCode;
		}
	}

	public void setPageSize(Integer pageSize) {
		if (pageSize != null) {
			this.pageSize = pageSize;
		}
	}

	/**
	 * 显示用户列表
	 */
	public String list() {
		// 封装查询条件
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		// 拼接客户姓名
		String cust_name = customer.getCust_name();
		if (cust_name != null && !cust_name.trim().isEmpty()) {
			criteria.add(Restrictions.like("cust_name", "%" + cust_name + "%"));
		}
		// 拼接客户来源
		Dictionary source = customer.getSource();
		if (source != null && !source.getDict_id().trim().isEmpty()) {
			System.out.println(source.getDict_id());
			criteria.add(Restrictions.eq("source.dict_id", source.getDict_id()));
		}
		// 拼接客户级别对象
		Dictionary level = customer.getLevel();
		if (level != null && !level.getDict_id().trim().isEmpty()) {
			criteria.add(Restrictions.eq("level.dict_id", level.getDict_id()));
		}
		// 拼接客户所属行业对象
		Dictionary industry = customer.getIndustry();
		if (industry != null && !industry.getDict_id().trim().isEmpty()) {
			criteria.add(Restrictions.eq("industry.dict_id", industry.getDict_id()));
		}

		// 调用业务层查询
		PageBean<Customer> pageBean = customerService.list(criteria, pageCode, pageSize);
		// 放到值栈中
		for (Customer customer : pageBean.getBeanList()) {
			System.out.println(customer);
		}
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.set("page", pageBean);
		return "listOk";
	}

	/**
	 * 添加用户
	 */
	// 上传的文件
	private File upload;
	// 文件的名称
	private String uploadFileName;
	// 文件的MIME类型
	@SuppressWarnings("unused")
	private String uploadContentType;

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String add() {
		// 文件上传
		if (uploadFileName != null) {
			/*
			 * //存放目录 String storeDirectory =
			 * ServletActionContext.getServletContext().getRealPath("/files");
			 */
			// 服务器上的一个路径
			String storeDirectory = "D:/Bianchengruanjian/tomcat/ecplise-tomcat/apache-tomcat-7.0.76/webapps/upload";
			String uuidFileName = UUID.randomUUID().toString() + "_" + uploadFileName;
			// 给模型设置：path filename
			customer.setCust_file_name(uuidFileName);
			// 计算子目录
			String path = Genertor.genClildDir(storeDirectory, uuidFileName);
			customer.setCust_file_path(path);
			// 文件上传
			try {
				FileUtils.copyFile(upload, new File(storeDirectory + File.separator + path, uuidFileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		customerService.add(customer);
		return "addOk";
	}

	/**
	 * 下载文件
	 */
	// 下载的流
	private String name;

	private InputStream inputStream;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		name=name.substring(name.indexOf('_')+1);
		this.name = name;
	}
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String downLoad() 
	{
		// 调用业务层查
		Customer customer1 = customerService.findByCust_id(customer.getCust_id());
		String storeDirectory = "D:/Bianchengruanjian/tomcat/ecplise-tomcat/apache-tomcat-7.0.76/webapps/upload";
		if (StringUtils.isNotEmpty(customer1.getCust_file_name())) {
			try {
				setName(customer1.getCust_file_name());
				HttpServletResponse response = ServletActionContext.getResponse();
				/*response.setHeader("Content-Disposition", "attachment;filename="
						+ customer1.getCust_file_name().substring(customer1.getCust_file_name().lastIndexOf(".") + 1));*/
				inputStream = new FileInputStream(storeDirectory + File.separator + customer1.getCust_file_path()
						+ File.separator + customer1.getCust_file_name());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "downLoadOk";
		} else {
			// 获得request对象存错误信息
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("info", "您未上传文件！");
			return "downLoadError";
		}

	}

	/**
	 * 删除客户
	 * 
	 * @return
	 */
	public String delete() {
		// 调用业务层
		if (customer != null && customer.getCust_id() != null) {
			Customer customer1 = customerService.findByCust_id(customer.getCust_id());
			String path = customer1.getCust_file_path();
			String name = customer1.getCust_file_name();
			// 删除源文件
			String storeDirectory = "D:/Bianchengruanjian/tomcat/ecplise-tomcat/apache-tomcat-7.0.76/webapps/upload";
			if (StringUtils.isNotEmpty(path) && StringUtils.isNotEmpty(name)) {
				File file = new File(storeDirectory + File.separator + path + File.separator + name);
				file.delete();
			}
			customerService.delete(customer.getCust_id());
		}
		return "deleteOk";
	}

	/**
	 * 更新客户的初始化页面
	 */
	public String initUpdate() {
		customer = customerService.findByCust_id(customer.getCust_id());
		return "initupdateOk";
	}

	/**
	 * 编辑客户
	 */
	public String edit() {
		if (StringUtils.isNotEmpty(uploadFileName)) {
			// 删除源文件
			String path = customer.getCust_file_path();
			String name = customer.getCust_file_name();
			String storeDirectory = "D:/Bianchengruanjian/tomcat/ecplise-tomcat/apache-tomcat-7.0.76/webapps/upload";
			if (StringUtils.isNotEmpty(path) && StringUtils.isNotEmpty(name)) {
				File file = new File(storeDirectory + File.separator + path + File.separator + name);
				file.delete();
			}
			// 服务器上的一个路径
			String uuidFileName = UUID.randomUUID().toString() + "_" + uploadFileName;
			// 给模型设置：path filename
			customer.setCust_file_name(uuidFileName);
			// 计算子目录
			String newPath = Genertor.genClildDir(storeDirectory, uuidFileName);
			customer.setCust_file_path(newPath);
			// 文件上传
			try {
				FileUtils.copyFile(upload, new File(storeDirectory + File.separator + newPath, uuidFileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		customerService.update(customer);
		return "editOk";
	}
	/**
	 * 查询所有客户
	 */
	public String findAll(){
		List<Customer>list=customerService.findAll();
		String jsonString = JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
		//获得response对象
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(jsonString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
	}
	/**
	 * 根据客户来源统计客户数目
	 */
	public String findBySource(){
		List<Object[]> objs=customerService.findBySource();
		//放入值栈
		ActionContext context = ActionContext.getContext();
		ValueStack valueStack = context.getValueStack();
		valueStack.set("objs", objs);
		return "findSourceOk";
	}
	/**
	 * 根据客户所属行业统计客户数目
	 */
	public String findByIndustry(){
		List<Object[]> objs=customerService.findByIndustry();
		ActionContext context = ActionContext.getContext();
		ValueStack valueStack = context.getValueStack();
		valueStack.set("objs", objs);
		return "findIndustryOk";
	}
	public Customer getModel() {
		return customer;
	}
	public String initCustomerAdd(){
		return "initCustomerAddOk";
	}

}
