<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<STYLE type=text/css>
BODY {
	FONT-SIZE: 12px;
	COLOR: #ffffff;
	FONT-FAMILY: 宋体
}

TD {
	FONT-SIZE: 12px;
	COLOR: #ffffff;
	FONT-FAMILY: 宋体
}

a {
	text-decoration: none;
	color: white;
}

#image1 {
	cursor: pointer;
}
</STYLE>

<META content="MSHTML 6.00.6000.16809" name=GENERATOR>
<!-- 引入JQuery -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js">
	
</script>
<script type="text/javascript">

	function info() {
		var info="${requestScope.info}";
		if(info!=""){
			alert(info);
		}
	}
	function change() {
		document.getElementById("image1").src = "${pageContext.request.contextPath}/code.action?time="
				+ new Date().getTime();
	}
	function checkForm() {
		//获取用户登录名
		var userCode = $("#user_code").val();
		if (userCode== "") {
			alert("用户名不能为空");
			document.getElementById("image1").src = "${pageContext.request.contextPath}/code.action?time="
					+ new Date().getTime();
			document.getElementById("txt_code").value = "";
			document.getElementById("user_password").value = "";
			return false;
		}
		//获取密码
		var userPassword = $("#user_password").val().trim();
		if (userPassword== "") {
			alert("密码不能为空");
			document.getElementById("txt_code").value = "";
			document.getElementById("image1").src = "${pageContext.request.contextPath}/code.action?time="
					+ new Date().getTime();
			return false;
		}
		//获取验证码
		var txt_code = $("#txt_code").val();
		if (txt_code == "") {
			document.getElementById("user_password").value = "";
			document.getElementById("image1").src = "${pageContext.request.contextPath}/code.action?time="
					+ new Date().getTime();
			return false;
		} 
		return true;
	}
</script>
</HEAD>
<BODY onload="info()">
	<FORM id=form1 name=form1 onsubmit="return checkForm();" method=post
		action="${pageContext.request.contextPath}/user_login.action">
		<DIV id=UpdatePanel1>
			<DIV id=div1
				style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>
			<DIV id=div2
				style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>
			<DIV>&nbsp;&nbsp;</DIV>
			<DIV>
				<TABLE cellSpacing=0 cellPadding=0 width=900 align=center border=0>
					<TBODY>
						<TR>
							<TD style="HEIGHT: 105px;"><IMG src="images/login_1.gif"
								border=0></TD>
						</TR>
						<TR>
							<TD background=images/login_2.jpg height=300>
								<TABLE height=300 cellPadding=0 width=900 border=0>
									<TBODY>
										<TR>
											<TD colSpan=2 height=35 align="right">
										</TR>
										<TR>
											<TD width=360></TD>
											<TD>
												<TABLE cellSpacing=0 cellPadding=2 border=0>
													<TBODY>
														<TR>
															<TD style="HEIGHT: 28px" width=80>登 录 名：</TD>
															<TD style="HEIGHT: 28px" width=150><INPUT
																id="user_code" style="WIDTH: 130px" name="user_code"></TD>
															<TD style="HEIGHT: 28px" width=370><a
																href="${pageContext.request.contextPath}/regist.jsp"
																class="regist">注册账号?</a></TD>
														</TR>
														<TR>
															<TD style="HEIGHT: 28px">登录密码：</TD>
															<TD style="HEIGHT: 28px"><INPUT id="user_password"
																style="WIDTH: 130px" type=password name="user_password"></TD>
															<TD style="HEIGHT: 28px"><a
																href="${pageContext.request.contextPath}/regist.jsp"
																class="regist">找回密码</a></TD>
														</TR>
														<TR>
															<TD style="HEIGHT: 28px">验证码：</TD>
															<TD style="HEIGHT: 28px"><INPUT id="txt_code" style="WIDTH: 130px" name="txt_code"></TD>
															<TD style="HEIGHT: 28px">
																<img title="看不清？换一张" src="${pageContext.request.contextPath}/code.action" id="image1" onclick="change()">
															</TD>
														</TR>
														<TR>
															<TD style="HEIGHT: 18px"></TD>
															<TD style="HEIGHT: 18px"></TD>
															<TD style="HEIGHT: 18px"></TD>
														</TR>
														<TR>
															<td></td>
															<TD><INPUT id=btn
																style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px"
																onclick='javascript:WebForm_DoPostBackWithOptions(new WebForm_PostBackOptions("btn", "", true, "", "", false, false))'
																type=image src="images/login_button.gif" name=btn>
															</TD>
														</TR>
													</TBODY>
												</TABLE>
											</TD>
										</TR>
									</TBODY>
								</TABLE>
							</TD>
						</TR>
						<TR>
							<TD><IMG src="images/login_3.jpg" border=0></TD>
						</TR>
					</TBODY>
				</TABLE>
			</DIV>
		</DIV>
	</FORM>
</BODY>
</HTML>