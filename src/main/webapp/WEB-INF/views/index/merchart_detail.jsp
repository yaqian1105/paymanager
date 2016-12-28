<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta name="via" content="419499973@qq.com"/>
	<meta name="description" content="旗鱼点餐，智能点餐"/>
	<meta name="keywords" content="旗鱼，点餐，智能"/>
	<meta http-equiv="Pragma" content="no-cache"/>
	<meta charset="UTF-8">

<!--导航图标-->
<title>提现管理</title>
<%@include file="../../../base/head.jsp"%>
<link rel="stylesheet" type="text/css" href="${rootPath}/static/index/home_detail.css"/>
</head>
<body>
<div class="wrapper">
	<div class="content-wrapper">
		<div class="content-box">
		<div class="content-title">
			<div class="content-title-left"><img src="../static/images/icon_merchant_show.png"/>商家排行榜</div>
			 <div class="content-title-right"><img onclick="javascript:location.reload();" src="../static/images/icon_fresh.png"/>${cur_user.userName}
				 <div class="content-title-user-img"></div><a href="${rootPath}/loginOut" class="exit">退出<img src="${rootPath}/static/images/icon_exit.png"></a></div>
		</div>
		<div class="blank"></div>
		<div class="table-title">
			<div class="table-title-left">商家流水交易流水排行榜</div>
			<div class="table-title-right">
			<span class="active">周</span>
			<span>月</span>
			<span>年</span></div>
		</div>
	<!--表格Start-->
	<table data-toggle="table"
       data-query-params="queryParams"
       data-pagination="true"
       data-page-size="10"
       data-height="1000"
       id="table">
    <thead>    
     <tr>
        <th data-field="id">排名序号</th>
        <th data-field="name">商户名称</th>
        <th data-field="count">交易额</th>
    </tr>	    
    </thead>
    </table>
	<!--表格End-->
		</div>
		</div>
	</div>
</body>
<%@include file="../../../base/script.jsp"%>
<script type="text/javascript">
		function merchartDetail(day){
			var chartData;
			$.ajax({
				url : '${rootPath}/echart/merchartDetail',
				type : 'GET',
				async : false,
				data : {
					day : day,
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
	</script>
	<script src="${rootPath}/static/index/merchart_detail.js" type="text/javascript" charset="utf-8"></script>
</html>
