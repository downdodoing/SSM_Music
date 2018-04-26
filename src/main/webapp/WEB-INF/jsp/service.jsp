<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'service.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<h3 style="text-align: center;margin-bottom: 10px">QQ软件许可及服务协议</h3>
	<div style="margin-bottom: 10px">[首部及导言]</div>
	<div style="text-indent: 2em;line-height: 23px;margin-bottom: 10px">欢迎您使用腾讯QQ软件及服务!</div>
	<div style="text-indent: 2em;line-height: 23px;margin-bottom: 10px">
		使用腾讯QQ软件（以下统称“本软件”）及服务，您应当阅读并遵守《QQ软件许可及服务协议》（以下简称“本协议”），以及《腾讯服务协议》和《QQ号码规则》。请您务必审慎阅读、充分理解各条款内容，特别是免除或者限制
		责任的条款，以及开通或使用某项服务的单独协议，并选择接受或不接受。限制、免责条款可能以加粗形式提示您注意。</div>
	<div style="text-indent: 2em;line-height: 23px">
		除非您已阅读并接受本协议所有条款，否则您无权下载、安装或使用本软件及相关服务。您的下载、安装、使用、登录等行为即视为您已阅读并同意本协议的约束。
	</div>

</body>
</html>
