﻿﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>


<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
$(function(){
	//客户级别
	var url="${pageContext.request.contextPath}/dict.action";
	var param1={"dict_type_code":"006"};
	$.post(url,param1,function(data){
		$(data).each(function(i,n){
			var id="${model.level.dict_id}";
			if(id==n.dict_id){
				$("#levelId").append("<option value='"+n.dict_id+"' selected>"+n.dict_item_name+"</option>");
			}else{
				$("#levelId").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
			}
		});
	},"json");
	//客户来源
	var param2={"dict_type_code":"002"};
	$.post(url,param2,function(data){
		$(data).each(function(i,n){
			var id="${model.source.dict_id}";
			if(id==n.dict_id){
				$("#sourceId").append("<option value='"+n.dict_id+"' selected>"+n.dict_item_name+"</option>");
			}else{
				$("#sourceId").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
			}
			
		});
	},"json");
	//所属行业
	var param3={"dict_type_code":"001"};
	$.post(url,param3,function(data){
		$(data).each(function(i,n){
			var id="${model.industry.dict_id}";
			if(id==n.dict_id){
				$("#industryId").append("<option value='"+n.dict_id+"' selected>"+n.dict_item_name+"</option>");
			}else{
				$("#industryId").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
			}
			
		});
	},"json");
	
});
</script>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/customer_edit.action"
		method=post enctype="multipart/form-data">
		<input type="hidden" name="cust_id" value="${model.cust_id }"/>
		<input type="hidden" name="cust_file_path" value="${model.cust_file_path }"/>
		<input type="hidden" name="cust_file_name" value="${model.cust_file_name }"/>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background=${pageContext.request.contextPath }/images/new_020.jpg
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; 修改客户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<TR>
								<td>客户名称：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_name" value="${model.cust_name}">
								</td>
								<td>客户级别 ：</td>
								<td>
								<select name="level.dict_id" id="levelId" style="WIDTH: 180px" maxLength=50 >
								</select>
								</td>
							</TR>
							
							<TR>
								<td>信息来源 ：</td>
								<td>
								<select name="source.dict_id" id="sourceId" style="WIDTH: 180px" maxLength=50>
								</select>
								</td>
								<td>所属行业 ：</td>
								<td>
								<select name="industry.dict_id" id="industryId" style="WIDTH: 180px" maxLength=50 >
								</select>
								</td>
							</TR>
							<TR>
								<td>固定电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_phone" value="${model.cust_phone}">
								</td>
								<td>移动电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_mobile" value="${model.cust_mobile}">
								</td>
							</TR>
							<TR>
								<td>客户详情 ：</td>
								<td>
								<INPUT type="file" style="WIDTH: 180px" maxLength=50 name="upload" id="upload" >
								</td>
							</TR> 
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value=" 保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
