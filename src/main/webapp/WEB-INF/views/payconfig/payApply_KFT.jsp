<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="via" content="419499973@qq.com"/>
    <meta name="description" content="旗鱼点餐，智能点餐"/>
    <meta name="keywords" content="旗鱼，点餐，智能"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta charset="UTF-8">
    <!--导航图标-->
    <%@include file="../../../base/head.jsp"%>
    <link rel="stylesheet" type="text/css" href="${rootPath}/static/payconfig/business-management-detail-apply-person.css"/>
    <title>支付申请公司</title>
</head>
<body>
<div class="wrapper">
    <div class="content-wrapper">
        <div class="content-box">
            <div class="content-title">
                <div class="content-title-left"><a href="#" onclick="javascript:history.go(-1);"><img src="../static/images/icon_back.png"/>返回上一页</a></div>
                <div class="content-title-right"><img  onclick="javascript:location.reload();" src="../static/images/icon_fresh.png"/>${cur_user.userName}
                    <div class="content-title-user-img"></div><a href="${rootPath}/loginOut" class="exit">退出<img src="${rootPath}/static/images/icon_exit.png"></a></div>
            </div><div class="blank"></div>
            <input type="hidden" name="merchantId" id = "merchantId" value='${merchantId}'>

            <form  id="submitApply"  method="post" action="${rootPath}/payConfig/updateInformationForKFT"  enctype="multipart/form-data">
<%--
                <form  id="submitApply" method="post" action="${rootPath}/payConfig/payApplyPosition"  enctype="multipart/form-data">
--%>

                <input type="hidden" name="id"  value="${payInformation.id}"/>
                <input type="hidden" name="restaurantId"  id = "restaurantId"  value="${payInformation.restaurantId}"/>
                <input type="hidden" name="restaurantSignType" id="restaurantSignType" value="${payInformation.restaurantSignType}">
                <input type="hidden" name="platform" id="platform" value="${payInformation.platform}">
                <input type="hidden" name="paymentChannel" id="paymentChannel" value="${payInformation.paymentChannel}" >
            </form>
                <div class="content kft-person">
                    <form  id="submitApplyP" method="post" action="${rootPath}/payConfig/updateInformationForKFT"  enctype="multipart/form-data">
                    <ul class="information">
                        <li><h4>个人信息</h4></li>
                        <li><span>商户名称</span><input type="text" name="merchantName" data_log="商户名称" value="${payInformation.merchantName}" style="width: 320px;border-radius: 0 10px 10px 0"placeholder="必填"></li>
                        <li><span>商户简称</span><input type="text" name="merchantSimpleName"  data_log="商户简称" value="${payInformation.merchantSimpleName}" placeholder="必填"></li>
                        <li><span>商户地址</span><input type="text" name="merchantAddress"  data_log="商户地址" value="${payInformation.merchantAddress}" placeholder="必填"></li>
                        <li><span>联系电话</span><input type="text" name="merchantPhone"  data_log="联系电话" value="${payInformation.merchantPhone}" placeholder="必填"></li>
                        <li><span>银行卡帐号</span><input type="text" name="bankCardNo"  data_log="银行卡帐号" value="${payInformation.bankCardNo}" placeholder="必填"></li>
                        <li><span>银行卡户名</span><input type="text" name="bankAccountName"  data_log="银行卡户名" value="${payInformation.bankAccountName}" placeholder="必填"></li>
                        <li><span>银行卡开户行</span><input type="text" name="businessBankSub"  data_log="银行卡开户行" value="${payInformation.businessBankSub}"placeholder="必填"></li>
                        <li><span>银行预留手机号</span><input type="text" name="bankAccountMobile"  data_log="银行预留手机号" value="${payInformation.bankAccountMobile}" style="width: 320px;border-radius: 0 10px 10px 0"placeholder="必填"></li>
                        <li><span>费率（%。）</span><input type="text" name="rate"  data_log="费率" value="${payInformation.rate}"placeholder="必填"></li>
                    </ul>
                    <ul class="upload must_upload">
                        <li>
                            <div><span>身份证正面照</span></div>
                            <div class="parent-click"><span class="click">点击上传</span><input type="file" name="operateIdcardPositive" data_log="身份证正面照"><b class="showFileName"></b></div>
                        </li>
                        <li>
                            <div><span>身份证反面照</span></div>
                             <div class="parent-click"><span class="click">点击上传</span><input type="file" name="operateIdcardReverse" data_log="身份证反面照"><b class="showFileName"></b> </div>
                        </li>
                        <li>
                            <div><span>银行卡正面照</span></div>
                            <div class="parent-click"><span class="click">点击上传</span><input type="file" name="legalPersonSettlementCard" data_log="银行卡正面照"><b class="showFileName"></b></div>
                        </li>
                        <li>
                            <div><span>银行卡反面照</span></div>
                            <div class="parent-click"><span class="click">点击上传</span><input type="file" name="legalSettlementCard" data_log="银行卡反面照"><b class="showFileName"></b></div>
                        </li>
                        <li >
                            <div><span>手持身份证正面照</span><span style="display: none;"></span></div>
                            <div class="parent-click"><span class="click">点击上传</span><input type="file" name="accountOpeningLicense" data_log="手持身份证正面照"><b class="showFileName"></b></div>
                        </li>

                    </ul>
                    <div class="steps">
                        <span onclick="javascript:history.go(-1);">上一步</span><span  onclick="verificationParams('#submitApplyP');">保存</span>
                    </div>
                    </form>
                </div>
                <div class="content kft-company">
                    <form  id="submitApplyC" method="post" action="${rootPath}/payConfig/updateInformationForKFT"  enctype="multipart/form-data">

                    <ul class="information">
                        <li><h4>个人信息</h4></li>
                        <li><span>商户名称</span><input type="text" name="merchantName" data_log="商户名称" value="${payInformation.merchantName}" style="width: 320px;border-radius: 0 10px 10px 0"placeholder="必填"></li>
                        <li><span>商户简称</span><input type="text" name="merchantSimpleName"  data_log="商户简称" value="${payInformation.merchantSimpleName}" placeholder="必填"></li>
                        <li><span>商户地址</span><input type="text" name="merchantAddress"  data_log="商户地址" value="${payInformation.merchantAddress}" placeholder="必填"></li>
                        <li><span>联系电话</span><input type="text" name="merchantPhone"  data_log="联系电话" value="${payInformation.merchantPhone}" placeholder="必填"></li>
                        <li><span>银行卡帐号</span><input type="text" name="bankCardNo"  data_log="银行卡帐号" value="${payInformation.bankCardNo}" placeholder="必填"></li>
                        <li><span>银行卡户名</span><input type="text" name="bankAccountName"  data_log="银行卡户名" value="${payInformation.bankAccountName}" placeholder="必填"></li>
                        <li><span>银行卡开户行</span><input type="text" name="businessBankSub"  data_log="银行卡开户行" value="${payInformation.businessBankSub}"placeholder="必填"></li>
                        <li><span>银行预留手机号</span><input type="text" name="bankAccountMobile"  data_log="银行预留手机号" value="${payInformation.bankAccountMobile}" style="width: 320px;border-radius: 0 10px 10px 0"placeholder="必填"></li>
                        <li><span>费率（%。）</span><input type="text" name="rate"  data_log="费率" value="${payInformation.rate}"placeholder="必填"></li>
                    </ul>
                    <ul class="upload">
                        <li>
                            <div><span>营业执照(三证合一)</span></div>
                            <div class="parent-click "><span class="click">点击上传</span><input type="file" data_log="营业执照(三证合一)" id="businessLicenses" name="businessLicense"><b class="showFileName"></b></div>
                        </li>
                        <li>
                            <div><span>营业执照</span></div>
                            <div class="parent-click select_upload"><span class="click">点击上传</span><input type="file" data_log="营业执照" id="businessLicense"  name="businessLicense"><b class="showFileName"></b></div>
                        </li>
                        <li>
                            <div><span>税务登记</span></div>
                            <div class="parent-click select_upload"><span class="click">点击上传</span><input type="file" data_log="税务登记"  id="taxRegistration" name="taxRegistration"><b class="showFileName"></b></div>
                        </li>
                        <li>
                            <div><span>组织机构代码</span></div>
                            <div class="parent-click select_upload"><span class="click">点击上传</span><input type="file" data_log="组织机构代码"  id="accountOpeningLicense" name="accountOpeningLicense"><b class="showFileName"></b></div>
                        </li>
                        <li style="color: #cccccc;">
                           *三证合一或者营业执照、税务登记、组织机构代码，选择其中一种上传
                        </li>
                    </ul>
                    <ul class="upload-bottom must_upload">
                        <li>
                            <div><span>法人身份证正面</span></div>
                            <div class="parent-click"><span class="click">点击上传</span><input type="file" data_log="法人身份证正面"  name="operateIdcardPositive"><b class="showFileName"></b></div>
                        </li>
                        <li>
                            <div><span>法人身份证反面</span></div>
                            <div class="parent-click"><span class="click">点击上传</span><input type="file" data_log="法人身份证反面"  name="operateIdcardReverse"><b class="showFileName"></b></div>
                        </li>
                        <li>
                            <div><span>法人结算卡正面</span></div>
                            <div class="parent-click"><span class="click">点击上传</span><input type="file" data_log="法人结算卡正面" name="legalPersonSettlementCard"><b class="showFileName"></b></div>
                        </li>
                        <li>
                            <div><span>法人结算卡反面</span></div>
                            <div class="parent-click"><span class="click">点击上传</span><input type="file" data_log="法人结算卡反面"  name="legalSettlementCard"><b class="showFileName"></b></div>
                        </li>
                        <li>
                            <div><span>开户许可证</span></div>
                            <div class="parent-click"><span class="click">点击上传</span><input type="file" data_log="开户许可证"  name="accountOpeningLicense"><b class="showFileName"></b></div>
                        </li>
                    </ul>
                    <div class="steps">
                        <span onclick="javascript:history.go(-1);">上一步</span><span onclick="verificationParams('#submitApplyC');">保存</span>
                    </div>
                    </form>
                </div>

        </div>
    </div>
</div>
</body>
<%@include file="../../../base/script.jsp"%>
<script type="text/javascript" src="${rootPath}/static/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${rootPath}/static/js/jquery.form.js"></script>
<script src="${rootPath}/static/payconfig/business-management-detail-apply-person.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
    (function () {
    if($('#restaurantSignType').val()==1){
        $('.content.kft-person').css('display','none');
        $('.content.kft-company').css('display','block');
    }else {
        $('.content.kft-person').css('display','block');
        $('.content.kft-company').css('display','none');
    }
    })();
    function verificationParams(dom){
        var fileflag = false;
        var data_log = "";
       $(dom+" .must_upload input[type='file']").each(function(){
           var filePath = $(this).val();
           if((filePath=="" || (filePath.indexOf("png")==-1 && filePath.indexOf("jpg")==-1))) {
                fileflag = true;
                data_log = data_log +$(this).attr("data_log")+"\n";
                return;
            }
        });
        if(fileflag){
            alert(data_log+"请正确选择上述文件后提交！");
            return;
        }
        if(dom=="#submitApplyC"){
            if($("#businessLicenses").val()==""){
                $(dom+" .select_upload input[type='file']").each(function(){
                    var filePath = $(this).val();
                    if((filePath=="" || (filePath.indexOf("png")==-1 && filePath.indexOf("jpg")==-1))) {
                        fileflag = true;
                        return;
                    }
                });
                if(fileflag){
                    alert("三证合一或者营业执照、税务登记、组织机构代码，请选择其中一种上传");
                    return;
                }
            }
        }

        $(dom+" input[placeholder='必填']").each(function(){
            if($(this).val()=="" ) {
                fileflag = true;
                data_log = data_log +$(this).attr("data_log")+"\n";
                return;
            }
        })
        if(fileflag){
            alert(data_log+"正确填写上述信息！");
            return;
        }
        //payApplyUpdate(dom);
    }
    function payApplyUpdate(dom){
        var params = $("#submitApply").serialize()+"&"+ $(dom).serialize();
        console.log(params);
        var options = {
            url: "${rootPath}/payConfig/updateInformationForKFT?"+params,
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function(data) {
                if(data.success){
                    window.location.href="${rootPath}/merchant/datail?merchantId="+$("#merchantId").val();
                }else{
                    alert("失败了");
                }
            }
        };
        $(dom).ajaxSubmit(options);
    }

</script>
</html>
