<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.qiyu.data.entity.RestaurantStaff" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8"%>
<%
    String rootPath = request.getContextPath();
    request.setAttribute("rootPath",rootPath);
%>
<html>
<head>
    <title>旗鱼点餐移动支付平台</title>
    <!-- new theme -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <script type="text/javascript">
        //防止在iframe中打开
        if(window.top != window){
            window.parent.location.href = "${rootPath}/login";
        }
    </script>
    <link rel="shortcut icon" href="../static/images/logo.ico" type="image/x-icon" />
    <link rel="stylesheet" type="text/css" href="${rootPath}/static/login/login.css">

</head>
<body style="background-color: #f04648;">
<div >
    <div class="login-box-1 wrapper">
        <div class="oneLine"><img src="${rootPath}/static/index/logo_login.png"/></div>
        <div class="twoLine">旗鱼点餐移动支付平台</div>
        <!-- /.login-logo -->
        <div class="login-box-body-1">
            <c:if test="${not empty authticationError}">
                <div class="alert alert-danger alert-dismissible alert-1">
                    <button type="button" class="close close-1" data-dismiss="alert" aria-hidden="true">×</button>
                    <h4><i class="icon fa fa-warning fa-1"></i> ${authticationError}</h4>
                </div>
            </c:if>
            <%--<p class="login-box-msg red"></p>--%>
            <form action="${rootPath}/login" method="post" id="loginForm">
                <div class="form-group has-feedback threeLine">
                    <img src="${rootPath}/static/index/ico_user.png"/>
                    <input type="text" name="username"  placeholder="请输入您的用户名" required>
                    <span class="icon-wrong" style="visibility: hidden;">x</span>
                </div>
                <div class="form-group has-feedback fourLine">
                    <img src="${rootPath}/static/index/ico_pass.png"/>
                    <input type="password" name="password"  placeholder="请输入您的密码" required>
                    <span class="icon-wrong" style="visibility: hidden;">x</span>
                </div>
                <div class="form-group has-feedback">
                    <div class="fiveLine">
                        <button type="button" class="btn btn-primary-1 btn-block btn-flat">登 陆</button>
                    </div>
                </div>
                <div class="sixLine"><a href="#">忘记密码</a><div class="lineCenter"></div><a href="#">注册</a></div>
            </form>
        </div>
    </div>
</div>
<script src="${rootPath}/static/js/jquery-2.2.4.min.js"></script>

<script>
 /*   $('button[type="button"]').on('click', function () {
        console.log(13);
    });

*/
    $(".fiveLine button").click(function () {
        if($('.threeLine input').val()==""){//用户名输入框为空时候
            $('.threeLine .icon-wrong').css('visibility','inherit');
            $('.threeLine input').css('color','#F04648');
            return;
        }else if($('.fourLine input').val()==""){//密码为空时候
            $('.threeLine .icon-wrong').css('visibility','hidden');
            $('.threeLine input').css('color','#CCCCCC');
            $('.fourLine .icon-wrong').css('visibility','inherit');
            $('.fourLine input').css('color','#CCCCCC');
        }	else{//都不为空的时候
            //....
            $('.icon-wrong').css('visibility','hidden');
            $('input').css('color','#CCCCCC');
            $("#loginForm").submit();
        }
    });

</script>
</body>
</html>
