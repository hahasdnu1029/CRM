package com.sdnu.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

public class Customer implements Serializable {

	private static final long serialVersionUID = 3354123398257344416L;
/**
 * CREATE TABLE `cst_customer` (
			  `cust_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号(主键)',
			  `cust_name` varchar(32) NOT NULL COMMENT '客户名称(公司名称)',
			  `cust_user_id` bigint(32) DEFAULT NULL COMMENT '负责人id',
			  `cust_create_id` bigint(32) DEFAULT NULL COMMENT '创建人id',
			  `cust_source` varchar(32) DEFAULT NULL COMMENT '客户信息来源',
			  `cust_industry` varchar(32) DEFAULT NULL COMMENT '客户所属行业',
			  `cust_level` varchar(32) DEFAULT NULL COMMENT '客户级别',
			  `cust_linkman` varchar(64) DEFAULT NULL COMMENT '联系人',
			  `cust_phone` varchar(64) DEFAULT NULL COMMENT '固定电话',
			  `cust_mobile` varchar(16) DEFAULT NULL COMMENT '移动电话',
    PRIMARY KEY (`cust_id`)
 */
	//客户id 主键，自增递增
	private Long cust_id;
	//客户姓名
	private String cust_name;
	//以后补充
	private Long cust_user_id;
	private Long cust_create_id;
	//客户信息来源
	private Dictionary source;
	//客户所属行业
	private Dictionary industry;
	//客户级别
	private Dictionary level;
	@JSONField(serialize=false)
	private Set<Linkman> linkmans=new HashSet<Linkman>();
	@JSONField(serialize=false)
	private Set<Visit> visits=new HashSet<Visit>();
	//固定电话
	private String cust_phone;
	//移动电话
	private String cust_mobile;
	//上传文件名称
	private String cust_file_name;
	//上传文件路径
	private String cust_file_path;
	
	public String getCust_file_name() {
		return cust_file_name;
	}
	public void setCust_file_name(String cust_file_name) {
		this.cust_file_name = cust_file_name;
	}
	public String getCust_file_path() {
		return cust_file_path;
	}
	public void setCust_file_path(String cust_file_path) {
		this.cust_file_path = cust_file_path;
	}
	public Long getCust_id() {
		return cust_id;
	}
	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public Long getCust_user_id() {
		return cust_user_id;
	}
	public void setCust_user_id(Long cust_user_id) {
		this.cust_user_id = cust_user_id;
	}
	public Long getCust_create_id() {
		return cust_create_id;
	}
	public void setCust_create_id(Long cust_create_id) {
		this.cust_create_id = cust_create_id;
	}

	public Set<Linkman> getLinkmans() {
		return linkmans;
	}
	public void setLinkmans(Set<Linkman> linkmans) {
		this.linkmans = linkmans;
	}
	public String getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	public String getCust_mobile() {
		return cust_mobile;
	}
	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}
	public Dictionary getSource() {
		return source;
	}
	public void setSource(Dictionary source) {
		this.source = source;
	}
	public Dictionary getIndustry() {
		return industry;
	}
	public void setIndustry(Dictionary industry) {
		this.industry = industry;
	}
	public Dictionary getLevel() {
		return level;
	}
	public void setLevel(Dictionary level) {
		this.level = level;
	}
	public Set<Visit> getVisits() {
		return visits;
	}
	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}
	
	
}
