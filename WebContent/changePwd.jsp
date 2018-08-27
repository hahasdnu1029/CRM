<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>修改密码</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css rel=stylesheet>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
   function checkOldPwd(){
	   var oldPwd=$("#oldPwd").val();
	   if(oldPwd.trim()==""){
		   document.getElementById("error1").innerHTML="<font style='color:red'>* 请输入原密码</font>";
		   return false;
	   }else{
		   document.getElementById("error1").innerHTML="";
	   }
   }
   function checkNewPwd(){
	   var newPwd=$("#user_password").val();
	   if(newPwd.trim()==""){
		   document.getElementById("error2").innerHTML="<font style='color:red'>* 请输入新密码</font>";
	   }else{
		   document.getElementById("error2").innerHTML="";
	   }
   }
   function checkNewPwd2(){
	   var newPwd=$("#user_password2").val();
	   if(newPwd.trim()==""){
		   document.getElementById("error3").innerHTML="<font style='color:red'>* 请输入确认密码</font>";
	   }else{
		   document.getElementById("error3").innerHTML="";
	   }
	   var newPwd2=$("#user_password").val();
	   if(newPwd!=newPwd2){
		   document.getElementById("error2").innerHTML="<font style='color:red'>* 两次输入的密码不一致</font>";
		   document.getElementById("error3").innerHTML="<font style='color:red'>* 两次输入的密码不一致</font>";
		   document.getElementById("user_password2").value="";
	   }else{
		   document.getElementById("error2").innerHTML="";
		   document.getElementById("error3").innerHTML="";
	   }
   }
   function check(){
	   var oldPwd=$("#oldPwd").val();
	   var params="oldPwd="+oldPwd;
	   if(oldPwd.trim()==""){
		   document.getElementById("error1").innerHTML="<font style='color:red'>* 请输入原密码</font>";
		   return false;
	   }
	   var newPwd=$("#user_password").val();
	   if(newPwd.trim()==""){
		   document.getElementById("error2").innerHTML="<font style='color:red'>* 请输入新密码</font>";
		   return false;
	   }
	   var newPwd=$("#user_password2").val();
	   if(newPwd.trim()==""){
		   document.getElementById("error3").innerHTML="<font style='color:red'>* 请输入确认密码</font>";
		   return false;
	   }
	   return true;
   }
   $(function(){
	   document.getElementById("error1").innerHTML="<font style='color:red'>${ info2 }</font>";
   });
   
</script>
</HEAD>
<BODY>
	<FORM onsubmit="return check()" id=form1 name=form1 action="${pageContext.request.contextPath }/user_changePwd.action" method=post >
	 <input type="hidden" name="user.user_id" value="${sessionScope.user.user_id }"/>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
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
								<TD class=manageHead>当前位置：修改密码</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<tr>
								<td> 原密码：</td>
								<td>
									<INPUT type="password" class=textbox style="WIDTH: 180px" maxLength=50 name="oldPwd" id="oldPwd" onblur="checkOldPwd();">
								</td>
								<td>
									<span name="error1" id="error1"></span>
								</td>
		
							<TR>
								<td>新密码：</td>
								<td>
									<INPUT type="password" class=textbox style="WIDTH: 180px" maxLength=50 name="user_password" id="user_password" onblur="checkNewPwd()">
								</td>
								<td>
									<span name="error2" id="error2"></span>
								</td>
							</TR>
							
							<TR>
								<td>确认密码 ：</td>
								<td>
									<INPUT type="password" class=textbox  style="WIDTH: 180px" maxLength=50 name="user_password2" id="user_password2" onblur="checkNewPwd2()">
								</td>
								<td>
									<span name="error3" id="error3"></span>
								</td>
							</TR>
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type="submit"
														value="保存 " name=sButton2>
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
