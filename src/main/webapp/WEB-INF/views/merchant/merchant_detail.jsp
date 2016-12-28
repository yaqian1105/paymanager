<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>代理商详情</title>
    <%@include file="../../../base/head.jsp"%>
    <link rel="stylesheet" type="text/css" href="${rootPath}/static/merchant/business-management-detail.css"/>
</head>
<body>

<div class="wrapper">
    <div class="content-wrapper">
        <div class="content-box">
            <form  id="searchForm">
                <input type="hidden" name="merchantId"  value="${merchant.id}"/>
            </form>
            <div class="content-title">
                <div class="content-title-left"><a href="#" onclick="javascript:history.go(-1);"><img src="../static/images/icon_back.png"/>返回上一页</a></div>
                <div class="content-title-right"><img onclick="javascript:location.reload();" src="../static/images/icon_fresh.png"/>${cur_user.userName}
                    <div class="content-title-user-img"></div><a href="${rootPath}/loginOut" class="exit">退出<img src="${rootPath}/static/images/icon_exit.png"></a></div>
            </div><div class="blank"></div>
            <div class="personInfo">
                <div class="personInfo-left"><img src="../static/images/icon_merchant_user.png"/></div>
                <div class="personInfo-center">
                    <div class="restaurantName">商户名称 ${merchant.merchantName}</div>
                    <div class="telephone">${merchant.contact}</div>
                </div>
                <div class="personInfo-right">
                    <div class="personName">${merchant.phone}</div>
                    <div class="agentName">${merchant.agentName}</div>
                </div>
            </div>
            <!--表格Start-->
            <table data-toggle="table"
                   data-query-params="queryParams"
                   data-pagination="true"
                   data-page-size="10"
                   data-search="true"
                   data-height="1000"
                   id="table">
                <thead>
                <tr>
                    <th data-field="id">序号</th>
                    <th data-field="name">门店信息</th>
                    <th data-field="count">支付信息</th>
                    <th data-field="operate">操作</th>
                </tr>
                </thead>
            </table>
            <!--表格End-->
        </div>
    </div>
</div>


<%@include file="../../../base/script.jsp"%>
<script type="text/javascript">

function MerchantsRestQuery(){
    var dataRestaurantList;
    $.ajax({
        url: '${rootPath}/merchant/restaurantList',
        type:'POST',
        data: $('#searchForm').serialize(),
        async: false,
        success: function (data) {
            dataRestaurantList = data.data;
        }
    });
    return dataRestaurantList;
}
    //支付配置
    function payConfig(id){
        window.location.href="${rootPath}/payConfig/paylist?merchantId=${merchant.id}&restaurantId="+id;
    }
    //支付申请
    function payApply(id){
        window.location.href="${rootPath}/payConfig/payApplyPage?merchantId=${merchant.id}&restaurantId="+id;
    }
    //设置
    function setConfig(id){
        window.location.href="${rootPath}/payConfig/setConfigPage?merchantId=${merchant.id}&restaurantId="+id;
    }
</script>
<script src="${rootPath}/static/merchant/business-management-detail.js" type="text/javascript" charset="utf-8"></script>

</body>
</html>
