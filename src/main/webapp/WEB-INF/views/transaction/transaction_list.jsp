<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>交易列表</title>
    <%@include file="../../../base/head.jsp"%>
    <link rel="stylesheet" type="text/css" href="${rootPath}/static/transaction/transaction-management.css"/>
</head>
<body>
<div class="wrapper">
    <div class="content-wrapper">
        <div class="content-box">
            <div class="content-title">
                <div class="content-title-left"><img src="${rootPath}/static/images/icon_merchant_show.png"/>交易管理</div>
                <div class="content-title-right"><img src="${rootPath}/static/images/icon_fresh.png"/>${cur_user.userName}
                    <div class="content-title-user-img"></div><a href="${rootPath}/loginOut" class="exit">退出<img src="${rootPath}/static/images/icon_exit.png"></a></div>
            </div>
            <div class="blank"></div>
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
                    <th data-field="orderInfo">订单信息</th>
                    <th data-field="buySellInfo">买卖家信息</th>
                    <th data-field="amountInfo">金额详情</th>
                    <th data-field="operate">通道/来源/操作员</th>
                    <th data-field="status">状态</th>
                </tr>
                </thead>
            </table>
            <!--表格End-->
        </div>
    </div>


</div>


<%@include file="../../../base/script.jsp"%>

<script type="text/javascript">
function transactionInfoQuery(){
    var dataTransaction;
    $.ajax({
        url: '${rootPath}/transaction/transactionInfos',
        type:'POST',
        data: $('#searchForm').serialize(),
        async: false,
        success: function (data) {

            dataTransaction = data.data;
        }
    });
    return dataTransaction;
}
</script>
<script src="${rootPath}/static/transaction/transaction-management.js" type="text/javascript" charset="utf-8"></script>

</body>

</html>
