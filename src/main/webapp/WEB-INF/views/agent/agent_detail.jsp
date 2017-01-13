<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>代理商详情</title>
    <%@include file="../../../base/head.jsp"%>
    <link rel="stylesheet" type="text/css" href="${rootPath}/static/agent/agent-management-detail.css"/>
</head>
<body>
<div class="wrapper">

    <div class="content-wrapper">
        <div class="content-box">
            <form  id="searchForm">
                <input type="hidden" name="agentid"  value="${agent.id}"/>
            </form>
            <div class="content-title">
                <div class="content-title-left"><a href="javascript:history.go(-1);"><img src="../static/images/icon_back.png"/>返回上一页</a></div>
                <div class="content-title-right"><img onclick="javascript:location.reload();" src="../static/images/icon_fresh.png"/>${cur_user.userName}
                    <div class="content-title-user-img"></div><a href="${rootPath}/loginOut" class="exit">退出<img src="${rootPath}/static/images/icon_exit.png"></a></div>
            </div>
            <div class="blank"></div>
            <div class="personInfo">
                <div class="personInfo-left">
                    <div class="personInfo-left-top">
                        <div class="left"><img src="../static/images/icon_agent_user.png"/></div>
                        <div class="right">
                            <p>代理商名称：${agent.agentName}</p>
                            <p><span>简称：${agent.simpleName}</span><span>用户名：${agent.name}</span></p>
                        </div>
                    </div>
                    <ul class="personInfo-left-bottom">
                        <li>
                            <span>所在区域：${agent.address}</span>
                            <span>负责人：${agent.contactName}</span>
                            <span>业务员：${agent.salesman}</span>
                        </li>
                        <li><span>固话：${agent.fixedPhone}</span><span>手机：${agent.phone}</span></li>
                        <li>详细地址：${agent.detailAddress}</li>
                    </ul>
                </div>
                <div class="personInfo-right">
                    <div class="left">
                        <p class="back-radio">${agent.returnPercentage}</p>
                        <p>返佣比例（%）</p>
                    </div>
                    <div class="right on">
                        <p>添加比例按阶梯</p>
                        <p>来结算返佣比例</p>
                        <span class="Modify-btn on">修改比例</span>
                    </div>
                    <div class="right off"style="display: none;">
                        <p>修改返佣比例</p>
                        <form id="returnPercentage_form">
                            <input type="hidden" name="id"  value="${agent.id}"/>

                            <input type="text" name="returnPercentage"  onkeyup="this.value=this.value.replace(/[^\d]/g,'')" >
                            <span class="Modify-btn off" onclick="updateReturnP()">确定修改</span>
                        </form>
                    </div>
                </div>
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
                    <th data-field="id">序号</th>
                    <th data-field="name">商户信息</th>
                    <th data-field="count">店铺数量</th>
                    <th data-field="traddingData">交易数据</th>
                    <th data-field="commissionData">佣金数据</th>
                </tr>
                </thead>
            </table>
            <!--表格End-->
        </div>
    </div>
</div>
<%@include file="../../../base/script.jsp"%>
<script type="text/javascript">
   function agentMerchantsQuery(){
       var dataAgentMerchants;
       $.ajax({
           url: '${rootPath}/agent/merchants',
           type:'POST',
           data: $('#searchForm').serialize(),
           async: false,
           success: function (data) {
               dataAgentMerchants = data.data;
           }
       });
       return dataAgentMerchants;
   }
function updateReturnP(){
    var params =  $("#returnPercentage_form").serialize();
    $.ajax({
        url: '${rootPath}/agent/updateReturnPer',
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

</script>
<script src="${rootPath}/static/agent/agent-management-detail.js" type="text/javascript" charset="utf-8"></script>

</body>
</html>
