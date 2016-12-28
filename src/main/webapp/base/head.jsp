<%@ page import="org.apache.shiro.SecurityUtils" %>
<%@ page import="org.apache.shiro.subject.Subject" %>
<%@ page import="com.qiyu.data.entity.RestaurantStaff" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.qiyu.data.entity.SystemUser" %>
<%@page pageEncoding="UTF-8"%>
<title>支付平台系统</title>
<%
	String rootPath = request.getContextPath();
	Subject subject=SecurityUtils.getSubject();
	if(null!=subject){
		SystemUser cur_user = (SystemUser)subject.getPrincipal();
		request.setAttribute("cur_user",cur_user);
	}
	request.setAttribute("rootPath",rootPath);
%>

<script type="text/javascript">
	ROOT = "${rootPath}";
	//必须在iframe中打开
	if(window.top === window){
		location.href = "${rootPath}/#" + location.pathname.replace(ROOT,"");
	}
</script>
<!-- new theme -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<meta charset="utf-8">
<meta name="renderer" content="webkit">

<!-- Bootstrap 3.3.6 -->
<%--<link rel="stylesheet" href="${rootPath}/theme/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="${rootPath}/theme/font-awesome.min.css">--%>
<!-- Ionicons -->
<%--<link rel="stylesheet" href="${rootPath}/theme/ionicons.min.css">
<link rel="stylesheet" href="${rootPath}/theme/zxx.lib.css">--%>
<link rel="shortcut icon" href="../static/images/logo.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="${rootPath}/static/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="${rootPath}/static/css/bootstrap-table.min.css"/>
<link rel="stylesheet" type="text/css" href="${rootPath}/static/css/base.css"/>
<link rel="stylesheet" type="text/css" href="${rootPath}/static/css/common.css"/>


<%--<link rel="stylesheet" href="${rootPath}/js/formValidation/css/formValidation.min.css">
<link rel="stylesheet" href="${rootPath}/js/bsgrid/builds/merged/bsgrid.all.min.css"/>
<link rel="stylesheet" href="${rootPath}/js/bsgrid/builds/css/skins/grid_bootstrap.min.css"/>
<link rel="stylesheet" href="${rootPath}/js/bootstrap/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css"/>
<link rel="stylesheet" href="${rootPath}/theme/cover.css">--%>
<%
	request.setAttribute("version", new Date().getTime());

%>

  <style type="text/css">
  body{background-color: #ecf0f5}
  </style>






