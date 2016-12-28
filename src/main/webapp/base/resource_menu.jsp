<%@ page import="org.apache.shiro.SecurityUtils" %>
<%@ page import="org.apache.shiro.subject.Subject" %>
<%@ page import="com.qiyu.data.entity.RestaurantStaff" %>
<%@ page import="com.qiyu.data.entity.SystemUser" %>
<%@page pageEncoding="UTF-8"%>
<title>支付平台系统</title>
<%
    Subject subject=SecurityUtils.getSubject();
    if(null!=subject){
        SystemUser cur_user = (SystemUser)subject.getPrincipal();
        request.setAttribute("cur_user",cur_user);
    }
	String rootPath = request.getContextPath();
	request.setAttribute("rootPath",rootPath);
	request.setAttribute("imgBasePath", "http://120.25.249.152");
%>
<!-- jQuery 2.2.4 -->
<script src="${rootPath}/static/js/jquery-2.2.4.min.js"></script>
<style type="text/css">
    body{background-color: #ecf0f5}
</style>
<script type="text/javascript">
    ROOT = "${rootPath}";
</script>
<%--
<!-- new theme -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<meta charset="utf-8">
<meta name="renderer" content="webkit">

<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="${rootPath}/theme/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="${rootPath}/theme/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="${rootPath}/theme/ionicons.min.css">
<!-- Theme style -->
&lt;%&ndash;<link rel="stylesheet" href="${rootPath}/theme/dist/css/AdminLTE.min.css">&ndash;%&gt;
<!-- AdminLTE Skins. We have chosen the skin-blue for this starter
page. However, you can choose any other skin. Make sure you
apply the skin class to the body tag so the changes take effect.
-->
&lt;%&ndash;<link rel="stylesheet" href="${rootPath}/theme/dist/css/skins/skin-blue.min.css">&ndash;%&gt;

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="${rootPath}/theme/html5shiv.min.js"></script>
<script src="${rootPath}/theme/respond.min.js"></script>
<![endif]-->

<!-- Bootstrap 3.3.6 -->
<script src="${rootPath}/theme/bootstrap/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
&lt;%&ndash;<script src="${rootPath}/theme/dist/js/app.js"></script>&ndash;%&gt;
<script src="${rootPath}/theme/plugins/slimScroll/jquery.slimscroll.min.js"></script>

  <style type="text/css">
  body{background-color: #ecf0f5}
  </style>
  <script type="text/javascript">
      ROOT = "${rootPath}";
  </script>





--%>