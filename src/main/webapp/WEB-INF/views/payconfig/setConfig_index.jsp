<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改通道</title>
    <%@include file="../../../base/head.jsp"%>
    <link rel="stylesheet" type="text/css" href="${rootPath}/static/payconfig/business-management-detail-modify.css"/>
</head>
<body>
<div class="wrapper">
    <div class="content-wrapper">
        <div class="content-box">
            <form  id="searchForm">
                <input type="hidden" name="merchantId" id="merchantId" value="${merchantId}"/>
                <input type="hidden" name="restaurantId" id="restaurantId" value="${restaurant.id}">
            </form>
            <div class="content-title">
                <div class="content-title-left"><a href="#" onclick="javascript:history.go(-1);"><img src="../static/images/icon_back.png"/>返回上一页</a></div>
                <div class="content-title-right"><img onclick="javascript:location.reload();" src="../static/images/icon_fresh.png"/>${cur_user.userName}
                    <div class="content-title-user-img"></div><a href="${rootPath}/loginOut" class="exit">退出<img src="${rootPath}/static/images/icon_exit.png"></a></div>
            </div><div class="blank"></div>
            <!--表格Start-->
            <table data-toggle="table"
                   data-height="1000"
                   id="table">
                <thead>
                <tr>
                    <th data-field="payWay">支付方式</th>
                    <th data-field="channel">通道</th>
                    <th data-field="rate">费率</th>
                    <th data-field="paymentway">结算方式</th>
                    <th data-field="operate">操作</th>
                </tr>
                </thead>
            </table>
            <!--表格End-->
        </div>
    </div>
</div>
<!--蒙版-->
<div class="mask" style="display: none;">
</div>
<form id="changeRate">
    <input type="hidden" name="id" id="id">
<ul class="mask-con" style="display: none;">
    <li>请输入修改内容</li>
    <li>费率（‰）<input type="text"  name="rate"  onkeyup="value=value.replace(/[^\-?\d.]/g,'')" id="rate"></li>
    <li>结算方式 <select  name="settlementType" id="settlementType"><option value="1">T+1</option><option value="0">T+0</option></select></li>
    <li><span onclick="closediv()">取消</span><span onclick="saveChange()">保存</span></li>
</ul>
</form>

<%@include file="../../../base/script.jsp"%>
<script type="text/javascript">

    function getChannelQuery(){
        var getChannelDate;
        $.ajax({
            url: '${rootPath}/payConfig/getChannel',
            type:'POST',
            data: $('#searchForm').serialize(),
            async: false,
            success: function (data) {
                getChannelDate = data.data;
            }
        });
        return getChannelDate;
    }
     function showRateWin(id,rate,settlementType) {
         $("#id").val(id);
         $("#rate").val(rate);
         $("#settlementType").val(settlementType);
     }
     function saveChange(){
         $.ajax({
             url: '${rootPath}/payConfig/updateRate',
             type:'POST',
             data: $("#changeRate").serialize(),
             async: false,
             success: function (data) {
                 if(data&&data.success){
                     $(".mask-con,.mask").css('display','none');
                     alert("保存成功!");
                     location.reload(true);
                 }else{
                     alert(data.desc);
                 }
                 flag = true;
                 }
             });
     }
     function closediv(){
         $("#changeRate")[0].reset();
         $("#myModal").modal("hide");
     }
</script>
<script src="${rootPath}/static/payconfig/business-management-detail-modify.js" type="text/javascript" charset="utf-8"></script>

</body>
</html>
