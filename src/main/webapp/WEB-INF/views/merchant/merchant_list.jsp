<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商户管理</title>
    <%@include file="../../../base/head.jsp"%>
    <link rel="stylesheet" type="text/css" href="${rootPath}/static/merchant/business-management.css"/>

</head>
<body>

<div class="wrapper">
    <div class="content-wrapper">
        <div class="content-box">
            <div class="content-title">
                <div class="content-title-left"><img src="../static/images/icon_merchant_show.png"/>商户管理</div>
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
                    <th data-field="name">商户信息</th>
                    <th data-field="count">店铺数</th>
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
   function MerchantsQuery(){
       var dataMerchants;
       $.ajax({
           url: '${rootPath}/merchant/merchants',
           type:'POST',
           data: $('#searchForm').serialize(),
           async: false,
           success: function (data) {
               dataMerchants = data.data;
           }
       });
       return dataMerchants;
   }

     function showWin(id){
         window.location.href="${rootPath}/merchant/datail?merchantId="+id;
     }

</script>
<script src="${rootPath}/static/merchant/business-management.js" type="text/javascript" charset="utf-8"></script>

</body>
</html>
