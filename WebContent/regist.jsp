<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<STYLE type=text/css>
BODY {
	FONT-SIZE: 12px; COLOR: #ffffff; FONT-FAMILY: 宋体
}
TD {
	FONT-SIZE: 12px; COLOR: #ffffff; FONT-FAMILY: 宋体
}
.regist{
width:104px;
height:36px;
background:#01389d;
color: white; 
font-size:18px;
border: 1px solid #cccccc;
cursor: pointer;
}
.error{
color:red;
}

</STYLE>

<META content="MSHTML 6.00.6000.16809" name=GENERATOR>
<!-- 引入JQuery -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js">
</script>
<script type="text/javascript">
    //验证登录用户名
	function checkCode(){
    	//获取用户输入的登录名
		var code=$("#user_code").val();
    	//判断用户名是否为空
    	if(code== ""){
    		//给提示
    		$("#codeId").addClass("error");
    		$("#codeId").html("* 登录名不能为空");
    	}else{
    		var url="${pageContext.request.contextPath}/user_checkCode.action";
    		var params={"user_code":code};
    		$.post(url,params,function(data){
    			//操作data进行判断
    			if(data&&data=="no"){
    				//给提示
    	    		$("#codeId").addClass("error")
    	    		$("#codeId").html("* 登录名已存在");
    			}else{
    				$("#codeId").removeClass("error");
    				$("#codeId").html("登录名有效");
    			}
    		});
    	}
	}
    function checkName(){
    	//获得用户名
    	var name=$("#user_name").val();
    	//判断用户名是否为空
    	if(name==""){
    		$("#nameId").addClass("error");
    		$("#nameId").html("* 用户姓名不能为空");
    	}else{
    		$("#nameId").removeClass("error");
    		$("#nameId").html("用户名有效");
    	}
    }
    function checkPassword(){
    	//获得用户名
    	var password=$("#user_password").val();
    	//判断用户名是否为空
    	if(password==""){
    		$("#passwordId").addClass("error");
    		$("#passwordId").html("* 密码不能为空");
    	}else{
    		$("#passwordId").removeClass("error");
    		$("#passwordId").html("密码有效");
    	}
    }
    function checkForm(){
    	//先对表单数据进行检测;
    	checkCode();
    	checkPassword();
    	checkName();
    	//获取error的数目,如果大于0说明不能提交，否则可以提交
    	if($(".error").size()>0){
    		return false;
    	}else{
    		return true;
    	}
    }
</script>

</HEAD>
<BODY>
<FORM id=form1 name=form1 onsubmit=" return checkForm()" method=post action="${pageContext.request.contextPath }/user_regist.action">

<DIV id=UpdatePanel1>
<DIV id=div1 
style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>
<DIV id=div2 
style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>


<DIV>&nbsp;&nbsp; </DIV>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width=900 align=center border=0>
  <TBODY>
  <TR>
    <TD style="HEIGHT: 105px;"><IMG src="images/login_1.gif" 
  border=0></TD></td></TR>
  <TR>
    <TD background=images/login_2.jpg height=300>
      <TABLE height=300 cellPadding=0 width=900 border=0>
        <TBODY>
        <TR>
          <TD colSpan=2 height=35 align="right"></TR>
        <TR>
          <TD width=360></TD>
          <TD>
            <TABLE cellSpacing=0 cellPadding=2 border=0>
              <TBODY>
              <TR>
                <TD style="HEIGHT: 28px" width=80>登 录 名：</TD>
                <TD style="HEIGHT: 28px" width=150>
                	<INPUT id="user_code" style="WIDTH: 130px" name="user_code" onblur="checkCode()" onfocus="true">
                </TD>
                <TD style="HEIGHT: 28px" width=370>
                <SPAN id="codeId" style="FONT-WEIGHT: bold;"></SPAN></TD></TR>
              <TR>
                <TD style="HEIGHT: 28px">用户姓名：</TD>
                <TD style="HEIGHT: 28px">
                	<INPUT id="user_name" style="WIDTH: 130px" type="text" name="user_name" onblur="checkName()">
                </TD>
                <TD style="HEIGHT: 28px">
                <SPAN id="nameId" style="FONT-WEIGHT: bold;">
                </SPAN>
                </TD>
               </TR>
              <TR>
                <TD style="HEIGHT: 28px">登录密码：</TD>
                <TD style="HEIGHT: 28px">
                	<INPUT id="user_password" type="password"style="WIDTH: 130px" name="user_password" onblur="checkPassword()">
                </TD>
                <TD style="HEIGHT: 28px">
                  <SPAN id="passwordId" style="FONT-WEIGHT: bold;"></SPAN>
                 </TD>
              </TR>
              <TR>
                <TD style="HEIGHT: 18px"></TD>
                <TD style="HEIGHT: 18px"></TD>
                <TD style="HEIGHT: 18px"></TD></TR>
              <TR>
                <TD></TD>
                <TD>
                 <input type="submit" value="注册" class="regist"/>
               </TD>
              </TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR>
  <TR>
    <TD><IMG src="images/login_3.jpg" 
border=0></TD></TR></TBODY></TABLE></DIV></DIV>


</FORM></BODY></HTML>


</body>
</html>