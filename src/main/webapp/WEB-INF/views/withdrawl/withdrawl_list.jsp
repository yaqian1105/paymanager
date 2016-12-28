<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>代理商列表</title>
    <%@include file="../../../base/head.jsp"%>
    <link rel="stylesheet" type="text/css" href="${rootPath}/static/withdrawl/cash-management.css"/>
</head>
<body>

<div class="wrapper">
    <div class="content-wrapper">
    <div class="content-box">
        <div class="content-title">
            <div class="content-title-left"><img src="../static/images/icon_merchant_show.png"/>提现管理</div>
            <div class="content-title-right"><img src="../static/images/icon_fresh.png"/>${cur_user.userName}
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
                <th data-field="orderInfo">订单信息</th>
                <th data-field="agentInfo">代理商信息</th>
                <th data-field="cashNum">提现金额</th>
                <th data-field="status">提现状态</th>
                <th data-field="operate">操作</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
</div>
</body>
<%@include file="../../../base/script.jsp"%>
<script type="text/javascript">
    function doStatus(handleStatus) {
        $("#handleStatus").val(handleStatus);
        return withdrawlsQuery();
    }
    function withdrawlsQuery(){
        var dataWithdrawls;
        $.ajax({
            url: '${rootPath}/withdrawl/withdrawls',
            type:'POST',
            data: $('#searchForm').serialize(),
            async: false,
            success: function (data) {
                dataWithdrawls = data.data;
            }
        });
        return dataWithdrawls;
    }

     function updateWithdrawl(id,show,status){
         var params =  {};
         params["id"] = id;
         params["showNo"] = show;
         params["handleStatus"] = status;
         if(confirm("确定执行此操作？")){
         $.ajax({
             url: '${rootPath}/withdrawl/updateWithdraw',
             type:'POST',
             data: params,
             async: false,
             success: function (data) {
                 if(data&&data.success){
                     alert("保存成功!");
                     location.reload(true);
                 }else{
                     alert(data.desc);
                 }
             }
         });
         }
     }
    function exportExcel(){
        alert("下载完后请手动刷新");
       var temp = document.createElement("form");
        temp.action="${rootPath}/withdrawl/exportWithdrawlExcel";
        temp.method="post";
        temp.async=false;
        temp.style.dispaly="none";
        document.body.appendChild(temp);
        temp.submit();

    }
</script>
<script src="${rootPath}/static/withdrawl/cash-management.js" type="text/javascript" charset="utf-8"></script>

</body>
</html>
