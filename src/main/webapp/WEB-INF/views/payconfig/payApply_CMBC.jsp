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
                <div class="content-title-right"><img onclick="javascript:location.reload();" src="../static/images/icon_fresh.png"/>${cur_user.userName}
                    <div class="content-title-user-img"></div><a href="${rootPath}/loginOut" class="exit">退出<img src="${rootPath}/static/images/icon_exit.png"></a></div>
            </div><div class="blank"></div>
            <input type="hidden" name="merchantId" id = "merchantId" value='${merchantId}'>

            <form  id="submitApply">
                <input type="hidden" name="id" value="${payInformation.id}"/>
                <input type="hidden" name="restaurantId" id = "restaurantId" value="${payInformation.restaurantId}"/>
                <input type="hidden" name="restaurantSignType" id="restaurantSignType" value="${payInformation.restaurantSignType}">
                <input type="hidden" name="platform" id="platform" value="${payInformation.platform}">
                <input type="hidden" name="paymentChannel" id="paymentChannel" value="${payInformation.paymentChannel}" >

                <!--第二步Start-->
                <div class="content legal-person-info" style="height: 1050px;">
                    <ul class="information">
                        <li><h4>申请信息</h4></li>
                        <li><span>商户名称</span><input type="text" name="merchantName" id="merchantName" value="${payInformation.merchantName}" placeholder="必填"></li>
                        <li><span>商户简称</span><input type="text" name="merchantSimpleName" placeholder="必填" id="merchantSimpleName" placeholder="必填" value="${payInformation.merchantSimpleName}"></li>
                        <li><span>商户地址</span><input type="text" name="merchantAddress" placeholder="必填" id="merchantAddress" value="${payInformation.merchantAddress}"></li>
                        <li><span>联系电话</span><input type="number" name="merchantPhone" placeholder="必填" id="merchantPhone" onkeyup="this.value=this.value.replace(' ','')"  value="${payInformation.merchantPhone}"></li>
                        <li><span>微信类目</span><input type="text" name="wechatCategory" placeholder="必填" id="wechatCategory"  onkeyup="this.value=this.value.replace(' ','')" value="${payInformation.wechatCategory}"><a href=""style="font-size: 14px;color:#F04648; margin-left: 5px;">查看微信商户类目</a> </li>
                        <li><span>支付宝类目</span><input type="text" name="aliCategory" placeholder="必填" id="aliCategory"  onkeyup="this.value=this.value.replace(' ','')" value="${payInformation.aliCategory}"><a href="${rootPath}/payConfig/aliCategory"target="_blank" style="font-size: 14px;color:#F04648;margin-left: 5px;">查看支付宝商户类目</a></li>
                        <li class="li-tip"> 微信类目与支付宝类目两项最少输入一项，输入哪项则表示申请哪项，两项都输入则微信及支付宝都申请，建议两项同时输入。</li>
                        <li><span>银行卡账号</span><input type="number" name="bankCardNo"  onkeyup="this.value=this.value.replace(' ','')"  placeholder="必填" id="bankCardNo" value="${payInformation.bankCardNo}"></li>
                        <li><span>银行卡户名</span><input type="text" placeholder="必填" name="bankAccountName" id="bankAccountName" value="${payInformation.bankAccountName}"></li>
                        <li><span>银行卡开户行</span><input type="text" placeholder="必填" name="businessBankSub" id="businessBankSub" value="${payInformation.businessBankSub}"></li>
                        <li><span>银行卡账户联名号</span><input type="text" placeholder="必填" name="bankCardNumbe" id="bankCardNumbe" value="${payInformation.bankCardNumbe}"></li>
                        <li><span>T0单笔提现手续费(元/笔)</span><input type="text" placeholder="必填" name="tzHandlingFee"  onkeyup="this.value=this.value.replace(' ','')" id="tzHandlingFee" value="${payInformation.tzHandlingFee}"></li>
                        <li><span>T0交易手续费扣率(%。)</span><input type="text" placeholder="必填" name="tzFeeRate" onkeyup="this.value=this.value.replace(' ','')"  id="tzFeeRate" value="${payInformation.tzFeeRate}"></li>
                        <li><span>T1单笔提现手续费(元/笔)</span><input type="text" placeholder="必填" name="toHandlingFee" onkeyup="this.value=this.value.replace(' ','')"  id="toHandlingFee" value="${payInformation.toHandlingFee}"></li>
                        <li><span>T1交易手续费扣率(%。)</span><input type="text" placeholder="必填" name="toFeeRate" onkeyup="this.value=this.value.replace(' ','')"  id="toFeeRate" value="${payInformation.toFeeRate}"></li>
                        <li><span>商户营业执照号</span><input type="text" name="registerNo" value="${payInformation.registerNo}"></li>
                        <li><span>组织机构代码证号</span><input type="text" name="orgCodeCertificateNo" value="${payInformation.orgCodeCertificateNo}"></li>
                        <li><span>商户身份证号</span><input type="text" name="legalRepresentativeCertNo" value="${payInformation.legalRepresentativeCertNo}"></li>
                        <li><span>联系人姓名</span><input type="text" name="contactName" value="${payInformation.contactName}"></li>
                        <li><span>联系人电话</span><input type="text" name="bankAccountMobile" value="${payInformation.bankAccountMobile}"></li>
                    </ul>

                    <div class="steps">
                        <span onclick="javascript:history.go(-1);">上一步</span><span onclick="verificationParams();">完成申请</span>
                    </div>
                </div>
                </form>
        </div>
    </div>
</div>

</body>
<%@include file="../../../base/script.jsp"%>
<script type="text/javascript" src="${rootPath}/static/js/jquery.form.js"></script>
<script type="text/javascript">

    function verificationParams() {
        var merchantName = $("#merchantName").val();
        if (merchantName == "" || merchantName.length <= 0) {
            alert("商户名称不为空！");
            return;
        }
        var merchantSimpleName = $("#merchantSimpleName").val();
        if (merchantSimpleName == "" || merchantSimpleName.length <= 0) {
            alert("商户简称不为空！");
            return;
        }
        var merchantAddress = $("#merchantAddress").val();
        if (merchantAddress == "" || merchantAddress.length <= 0) {
            alert("商户地址不为空！");
            return;
        }
        var merchantPhone = $("#merchantPhone").val();
        if (merchantPhone == "" || merchantPhone.length <= 0) {
            alert("联系电话不为空！");
            return;
        }
        var wechatCategory = $("#wechatCategory").val();
     /*   if (wechatCategory == "" || wechatCategory.length <= 0) {
            alert("商户名称不为空！");
            return;
        }*/
        var aliCategory = $("#aliCategory").val();
        if (((aliCategory == "" || aliCategory.length <= 0)&&(wechatCategory == "" || wechatCategory.length <= 0))) {
            alert("微信类目或支付宝之一不能全不填！"+aliCategory+"\t"+wechatCategory);
            return;
        }
        var bankCardNo = $("#bankCardNo").val();
        if (bankCardNo == "" || bankCardNo.length <= 0) {
            alert("银行卡账户不为空！");
            return;
        }
        var bankAccountName = $("#bankAccountName").val();
        if (bankAccountName == "" || bankAccountName.length <= 0) {
            alert("银行卡户名不为空！");
            return;
        }
        var businessBankSub = $("#businessBankSub").val();
        if (businessBankSub == "" || businessBankSub.length <= 0) {
            alert("银行卡开户行不为空！");
            return;
        }
        var bankCardNumbe = $("#bankCardNumbe").val();
        if (bankCardNumbe == "" || bankCardNumbe.length <= 0) {
            alert("银行卡账户联名号不为空！");
            return;
        }
        var tzHandlingFee = $("#tzHandlingFee").val();
        if (tzHandlingFee == "" || tzHandlingFee.length <= 0) {
            alert("T0单笔提现手续费不为空！");
            return;
        }
        var tzFeeRate = $("#tzFeeRate").val();
        if (tzFeeRate == "" || tzFeeRate.length <= 0) {
            alert("T0交易手续费扣率不为空！");
            return;
        }
        var toHandlingFee = $("#toHandlingFee").val();
        if (toHandlingFee == "" || toHandlingFee.length <= 0) {
            alert("T1单笔提现手续费不为空！");
            return;
        }
        var toFeeRate = $("#toFeeRate").val();
        if (toFeeRate == "" || toFeeRate.length <= 0) {
            alert("T1交易手续费扣率不为空！");
            return;
        }
        payApplyUpdate();
    }
    //提交操作
    function payApplyUpdate(){
        $.ajax({
            url: "${rootPath}/payConfig/updateInformationForCMBC",
            type:'POST',
            data: $("#submitApply").serialize(),
            success: function (data) {
                if(data.success){
                    alert(data.data);
                    window.location.href="${rootPath}/merchant/datail?merchantId="+$("#merchantId").val();
                }else{
                    alert(data.desc);
                }
            }
        });
    }

</script>
</html>
