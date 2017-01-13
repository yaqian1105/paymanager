<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商户管理</title>
    <%@include file="../../../base/head.jsp"%>
    <link rel="stylesheet" type="text/css" href="${rootPath}/static/payconfig/business-management-query-result.css"/>

</head>
<body>

<div class="wrapper">
    <div class="content-wrapper">
        <div class="content-box">
            <div class="content-title">
                <div class="content-title-left"><a href="#" onclick="javascript:history.go(-1);"><img src="../static/images/icon_back.png"/>返回上一页</a></div>
                <div class="content-title-right"><img onclick="javascript:location.reload();" src="../static/images/icon_fresh.png"/>${cur_user.userName}
                    <div class="content-title-user-img"></div><a href="${rootPath}/loginOut" class="exit">退出<img src="${rootPath}/static/images/icon_exit.png"></a></div>
            </div><div class="blank"></div>
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
                    <th data-field="name">信息</th>
                    <th data-field="count">状态</th>
                    <th data-field="operate">备注</th>
                </tr>
                </thead>
            </table>
            <!--表格End-->
        </div>
    </div>
</div>


<%@include file="../../../base/script.jsp"%>
<script type="text/javascript">
   function MerchantsQuery(){
       var dataMerchants;
       $.ajax({
           url: '${rootPath}/payConfig/queryResult',
           type:'POST',
           data: { restaurantId:'${restaurantId}'},
           async: false,
           success: function (data) {
               dataMerchants = data.data;
           }
       });
       return dataMerchants;
   }

</script>
<script src="${rootPath}/static/payconfig/business-management-query-result.js" type="text/javascript" charset="utf-8"></script>

</body>
</html>
