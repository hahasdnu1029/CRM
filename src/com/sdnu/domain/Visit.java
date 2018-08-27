package com.sdnu.domain;

import java.io.Serializable;

public class Visit implements Serializable {
	private static final long serialVersionUID = -2527382184056641516L;
	/**
	 * CREATE TABLE `sale_visit` (
  `visit_id` varchar(32) NOT NULL,
  `visit_cust_id` bigint(32) DEFAULT NULL COMMENT '客户id',
  `visit_user_id` bigint(32) DEFAULT NULL COMMENT '负责人id',
  `visit_time` date DEFAULT NULL COMMENT '拜访时间',
  `visit_interviewee` varchar(32) DEFAULT NULL COMMENT '被拜访人',
  `visit_addr` varchar(128) DEFAULT NULL COMMENT '拜访地点',
  `visit_detail` varchar(256) DEFAULT NULL COMMENT '拜访详情',
  `visit_nexttime` date DEFAULT NULL COMMENT '下次拜访时间',
  PRIMARY KEY (`visit_id`),
  KEY `FK_sale_visit_cust_id` (`visit_cust_id`),
  KEY `FK_sale_visit_user_id` (`visit_user_id`),
  CONSTRAINT `FK_sale_visit_cust_id` FOREIGN KEY (`visit_cust_id`) REFERENCES `cst_customer` (`cust_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_sale_visit_user_id` FOREIGN KEY (`visit_user_id`) REFERENCES `sys_user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
   */
	//主键
	private String visit_id;
	private Customer customer;
	private User user;
	//拜访时间
	private String visit_time;
	//被拜访人
	private String visit_interviewee;
	//拜访地点
	private String visit_addr;
	//拜访详情
	private String visit_detail;
    //下次拜访时间
	private String visit_nexttime;
	public String getVisit_id() {
		return visit_id;
	}
	public void setVisit_id(String visit_id) {
		this.visit_id = visit_id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getVisit_time() {
		return visit_time;
	}
	public void setVisit_time(String visit_time) {
		this.visit_time = visit_time;
	}
	public String getVisit_interviewee() {
		return visit_interviewee;
	}
	public void setVisit_interviewee(String visit_interviewee) {
		this.visit_interviewee = visit_interviewee;
	}
	public String getVisit_addr() {
		return visit_addr;
	}
	public void setVisit_addr(String visit_addr) {
		this.visit_addr = visit_addr;
	}
	public String getVisit_detail() {
		return visit_detail;
	}
	public void setVisit_detail(String visit_detail) {
		this.visit_detail = visit_detail;
	}
	public String getVisit_nexttime() {
		return visit_nexttime;
	}
	public void setVisit_nexttime(String visit_nexttime) {
		this.visit_nexttime = visit_nexttime;
	}
	
	@Override
	public String toString() {
		return "Visit [visit_id=" + visit_id + ", customer=" + customer + ", user=" + user + ", visit_time="
				+ visit_time + ", visit_interviewee=" + visit_interviewee + ", visit_addr=" + visit_addr
				+ ", visit_detail=" + visit_detail + ", visit_nexttime=" + visit_nexttime + "]";
	}

}
