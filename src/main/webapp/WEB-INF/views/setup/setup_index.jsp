<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商户管理</title>
    <%@include file="../../../base/head.jsp"%>
    <link rel="stylesheet" type="text/css" href="${rootPath}/static/setup/setup.css"/>
    <style>

    </style>
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
                   data-page-size="15"
                   data-search="true"
                   data-height="800"
                   id="table">
                <thead>
                <tr>
                    <th data-field="id">序号</th>
                    <th data-field="message">代理商信息</th>
                    <th data-field="count">商户数量</th>
                    <th data-field="operate">操作</th>
                </tr>
                </thead>
            </table>
            <!-- POS机应用设置-->
            <div class="pos-apply">
                <p>POS机应用</p>
                <form id="submitPos">
                    <label for="yes"><input type="radio" name="isPosApplication" value="1" id="yes">是</label>
                    <label for="no"><input type="radio" name="isPosApplication" value="0" id="no" checked>否</label>
                    <input type="hidden" id="merchantIds" name="merchantIds">
                    <button type="button"  onclick="updatePosApplication();">确认</button>
                </form>
                <p>POS机应用表示POS机上的通道使用，"否"是使用POS机支付通道，"是"是使用旗鱼支付通道</p>
            </div>

            <!-- 修改佣金 -->

            <div class="pos-account">
                <span>代理商佣金结算日设置</span>
                    <form id="submitApply">
                        <input type="hidden" name="id" value="${accountDay.id}"/>
                        <input type="hidden" name="constantName" value="${accountDay.constantName}"/>
                        <input type="text" class="accountDay"  id="text-input" name="constantValue" value="${accountDay.constantValue}日" disabled="true" />
                        <button type="button" class="pos-account-btn" data-swith="off">修改</button>
                    </form>
                 </div>
            </div>
        </div>

    </div>
</div>


<%@include file="../../../base/script.jsp"%>
<script type="text/javascript">
    $(".pos-account button").click(function(){
        var status=$(this).attr('data-swith');
        var value= $(".accountDay").val();
        if(status=='off'){
            $(this).html("保存");
            value = value.replace('日','');
            $(".accountDay").val(value);
            $(this).attr('data-swith','on');
            $(".accountDay").attr('disabled',false);
        }else if(status=='on'){
            $(this).html("修改");
            $(this).attr('data-swith','off');
            $(".accountDay").attr('disabled',true);
            submitAccountDay();
        }

    })
    $(document).on('click',"table input",function () {
        var arr=[];
        $("input[type='checkbox']").each(function () {
            if($(this).prop('checked')==true){
                var value=$(this).prop('value');
                arr.push(value);
            }
        })
        $("#merchantIds").val(arr);
    })
   /* $(document).on('change','.set-select',function(event) {
        if($(this).val()==="A"){
            $(".belong").hide();
        }else{
            $(".belong").show();
        }
    });*/
   function showAgent(){
       if($('.set-select').val()==="A"){
           $(".belong").hide();
       }else{
           $(".belong").show();
       }
   }

    //提交返佣信息
    function  submitAccountDay(){
       // console.log($("#text-input").prop('name'));//可以打印 input 的value ；不知道 serialize()方法为何不能打印！
        var param = $("#submitApply").serialize()+"&constantValue="+$(".accountDay").val();
        console.log(param);
        $.ajax({
            url: "${rootPath}/setup/editAccountDay",
            type:'POST',
            data: param,
            success: function (data) {
                if(data.success){
                    alert("修改成功！");
                    $(".accountDay").val(data.data+"日");
                }else{
                    alert(data.data);
                }
            }
        });
    }
    //查询列表
   function merchantList(){
       var dataMerchants;
       $.ajax({
           url: '${rootPath}/setup/merchantList',
           type:'POST',
           data: {
               type: $('#type').val(),
               simpleName:$("#simpleName").val()
           },
           async: false,
           success: function (data) {
               dataMerchants = data.data;
           }
       });
       return dataMerchants;
   }
    function updatePosApplication(){
        var merchantIds = $("#merchantIds").val();
        if(merchantIds == ""){
            alert("请先选择商家");
            return;
        }
        $.ajax({
            url: "${rootPath}/setup/updatePosApplication",
            type:'POST',
            data: $("#submitPos").serialize(),
            success: function (data) {
                if(data.success){
                    alert(data.data);
                }else{
                    alert(data.data);
                }
            }
        });
    }

</script>
<script src="${rootPath}/static/setup/setup.js" type="text/javascript" charset="utf-8"></script>

</body>
</html>
