<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>支付申请</title>
    <%@include file="../../../base/head.jsp"%>
    <link rel="stylesheet" type="text/css" href="${rootPath}/static/payconfig/business-management-detail-apply.css"/>

</head>
<body>

<div class="wrapper">

    <div class="content-wrapper">
        <div class="content-box">
            <form id="formPayConfig">
                <input type="hidden" name="restaurantId" id="restaurantId" value="${restaurant.id}">
                <input type="hidden" name="merchantId" id="merchantId" value="${merchantId}">

                <input type="hidden" name="restaurantSignType" id="restaurantSignType" value="">
<%--
                <input type="hidden" name="platform" id="platform" value="ali">
--%>
                <input type="hidden" name="paymentChannel" id="paymentChannel" value="">
            </form>
            <div class="content-title">
                <div class="content-title-left"><a href="#" onclick="javascript:history.go(-1);"><img src="../static/images/icon_back.png"/>返回上一页</a></div>
                <div class="content-title-right"><img onclick="javascript:location.reload();" src="../static/images/icon_fresh.png"/>${cur_user.userName}
                    <div class="content-title-user-img"></div><a href="${rootPath}/loginOut" class="exit">退出<img src="${rootPath}/static/images/icon_exit.png"></a></div>
            </div><div class="blank"></div>
            <!--第一步Start-->
            <div class="content">
                <ul class="business-natrue">
                    <li><h5>商户性质</h5>
                        <span class="active" data-url='P' data-type="0" >个体工商户</span>
                        <span data-url='C' data-type="1">企业</span>
                        <span data-url='C'  data-type="2">个人</span>
                    </li>
                    <%--<li><h5>选择支付方式</h5>--%>
                        <%--<span class="active">支付宝</span>--%>
                    <%--</li>--%>
                    <li><h5>选择支付通道</h5>
                        <span class="active" data-type="11" >支付宝ISV</span>
                        <span data-type="104" >快付通</span>
                        <span data-type="101">民生银行</span>
                    </li>
                    <li><p>微信子商户请登录微信服务商平台提交商户注册资料</p></li>
                </ul>

                <div class="userInfo-box">
                    <img src="../static/images/icon_userInfo.png"/>
                    <div class="userInfo-text">
                        <p>代理商：${agent.agentName}</p>
                        <p>联系人：${agent.contactName}</p>
                        <p>联系电话：${agent.phone}</p>
                    </div>
                </div>
                <span class="next-step">下一步</span>
            </div>
        </div>
    </div>
</div>

<%@include file="../../../base/script.jsp"%>
<script type="text/javascript">
    //商户入驻类型
    function　savePayInformationBack(){
       window.location.href="${rootPath}/payConfig/payApply?"+$("#formPayConfig").serialize()+"&merchantId="+$("#merchantId").val();
    }

</script>
<script src="${rootPath}/static/payconfig/business-management-detail-apply.js" type="text/javascript" charset="utf-8"></script>

</body>
</html>
