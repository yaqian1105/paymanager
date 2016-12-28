
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <%@include file="../../../base/head.jsp"%>
    <link rel="stylesheet" type="text/css" href="${rootPath}/static/index/home.css"/>
</head>
<body>
<!-- 柱状图 -->
<div class="wrapper">
<div class="content-wrapper">
    <div class="content-box" style>
        <div class="content-title">
            <div class="content-title-left"><img src="${rootPath}/static/images/icon_home_show.png"/>首页</div>
            <div class="content-title-right"><img src="${rootPath}/static/images/icon_fresh.png" onclick="window.location.reload();"/><span class="merchant-info">${cur_user.userName}</span>
                <div class="content-title-user-img"></div><a href="${rootPath}/loginOut" class="exit">退出<img src="${rootPath}/static/images/icon_exit.png"></a> </div>
        </div><div class="blank"></div>
        <div class="content-tradding-details">
         <%--   <a href="${rootPath}/withdrawl/saveTrans">添加交易</a>--%>
            <div class="tradding trading-volume">
                <p>今日交易流水</p>
                <p id = "sumMoney"></p>
                <p>单位（元）</p>
            </div>
            <div class="tradding trading-order-count">
                <p>今日订单数</p>
                <p id = "orderCount"></p>
                <p>单位（笔）</p>
            </div>
            <div class=" tradding trading-merchant-count">
                <p>商户数量</p>
                <p id = "restaurantCount"></p>
                <p>单位（家）</p>
            </div>
        </div>
        <!--折线图-->
        <div class="container line" style="width: 920px !important;">
            <div class="chart-title-wrapper">
                <p class="chart-title">交易趋势图    <span>单位（元）</span> </p>
                <div class="btns line-chart-btns">
                    <span class="active" >周</span>
                    <span >月</span>
                    <span >年</span>
                </div>
            </div>
            <div id="line-chart"></div>
        </div>
        <!--代理商-柱状图1-->
        <div class="container pillar left">
            <div class="chart-title-wrapper">
                <p class="chart-title">代理商前十排行  <span>单位（元）</span> </p>
                <div class="btns agent-chart-btns">
                    <span class="active" >周</span>
                    <span>月</span>
                    <span >年</span>
                </div>
            </div>
            <div id="agent-chart"></div>
            <div class="a-view-detail"><a href="${rootPath}/echart/agentDetailPage">查看详情</a></div>
        </div>
        <!--商家-柱状图2-->
        <div class="container pillar right">
            <div class="chart-title-wrapper">
                <p class="chart-title">商家前十排行    <span>单位（元）</span> </p>
                <div class="btns bussiness-chart-btns">
                    <span class="active">周</span>
                    <span>月</span>
                    <span>年</span>
                </div>
            </div>
            <div id="bussiness-chart"></div>
            <div class="a-view-detail"><a href="${rootPath}/echart/merchartDetailPage">查看详情</a></div>
        </div>
    </div>
</div>
    </div>
<script src="${rootPath}/static/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${rootPath}/static/js/echarts.common.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${rootPath}/static/js/common.js" type="text/javascript" charset="utf-8"></script>

<script type="text/javascript">
    $(function () {
        todayEchart();
    })
    function todayEchart(){
        $.ajax({
            url : '${rootPath}/echart/todayEchart',
            type : 'GET',
            async : true,
            dataType:"json",
            success : function(json){
                if (json.success) {
                    var data = json.data;
                    $("#restaurantCount").html(data.restaurantCount);
                    $("#orderCount").html(data.orderCount );
                    $("#sumMoney").html(data.sumMoney);
                }else{
                    alert("查询数据失败！");
                }
            }
        });
    }
    function orderEchart(type){
        var chartData;
        $.ajax({
            url : '${rootPath}/echart/orderEchart',
            type : 'GET',
            async : false,
            data : {
                day : type,
            },
            dataType:"json",
            success : function(json){
                if (json.success) {
                    chartData=json.data;
                }else{
                    alert("查询数据失败！");
                }
            }
        });

        return chartData;
    }
    function agentEchart(type){
        var chartData;
        $.ajax({
            url : '${rootPath}/echart/agentEchart',
            type : 'GET',
            async : false,
            data : {
                day : type,
                title : '代理商前十排名'
            },
            dataType:"json",
            success : function(json){
                if (json.success) {
                    chartData= json.data;
                }else{
                    alert("查询数据失败！");
                }
            }
        });
        return chartData;
    }
    function merchartEchart(day){
        var chartData;
        $.ajax({
            url : '${rootPath}/echart/merchartEchart',
            type : 'GET',
            async : false,
            data : {
                day : day,
                title : '商家前十排名'
            },
            dataType:"json",
            success : function(json){
                if (json.success) {
                    chartData = json.data;
                }else{
                    alert("查询数据失败！");
                }
            }
        });
        return chartData;
    }

</script>
<script src="${rootPath}/static/index/home.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
