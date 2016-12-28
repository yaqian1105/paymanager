<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>支付配置</title>
    <%@include file="../../../base/head.jsp"%>
    <link rel="stylesheet" type="text/css" href="${rootPath}/static/payconfig/business-management-detail-config.css"/>

</head>
<body>

<div class="wrapper">

    <div class="content-wrapper">
        <div class="content-box">

            <input type="hidden" name="merchantId" id="merchantId" value="${merchantId}"/>
            <div class="content-title">
                <div class="content-title-left"><a href="#" onclick="javascript:history.go(-1);"><img src="../static/images/icon_back.png"/>返回上一页</a></div>
                <div class="content-title-right"><img onclick="javascript:location.reload();" src="../static/images/icon_fresh.png"/>${cur_user.userName}
                    <div class="content-title-user-img"></div><a href="${rootPath}/loginOut" class="exit">退出<img src="${rootPath}/static/images/icon_exit.png"></a></div>
            </div><div class="blank"></div>
            <div class="select-pay-way">
                <div class="title">选择支付方式</div>
                <div class="main-way">
                    <div class="active wechat"><img src="../static/images/icon_wechat_white.png"/>微信</div>
                    <div class="ali"><img src="../static/images/icon_ali_red.png"/>支付宝</div>
                </div>
                <ul class="second-way wechat">
                    <li class="active" data-id='one' data-no='21'>微信自有商户</li>
                    <li data-id='two' data-no='22'>微信其它子商户</li>
                    <li data-id='six' data-no='23'>旗鱼子商户</li>
                    <li data-id='four' data-no='201'>民生银行微信</li>
                    <li data-id='five' data-no='202'>中信银行微信</li>
                    <li data-id='three' data-no='203'>兴业银行微信</li>
                    <li data-id='twelve' data-no='204'>快付通</li>
                </ul>
                <ul class="second-way ali" style="display: none;">
                    <li class="active" data-id='ten' data-no='11'>支付宝ISV</li>
                    <li data-id='nine' data-no='12' >支付宝2.0</li>
                    <li data-id='eight' data-no='103'>兴业银行支付宝</li>
                    <li data-id='seven' data-no='101'>民生银行支付宝</li>
                    <li data-id='eleven' data-no='102'>中信银行支付宝</li>
                    <li data-id='thirteen' data-no='104'>快付通</li>
                </ul>
            </div>
            <div class="select-pay-channel">
                <div class="title">	选择支付通道  </div>
                <form id="formPayConfig">
                    <input type="hidden" name="restaurantId" id="restaurantId" value="${restaurant.id}">
                    <input type="hidden" name="restaurantName" id="restaurantName" value="${restaurant.name}">
                    <input type="hidden" name="usedType" id="usedType" value="1">
                    <input type="hidden" name="platform" id="platform">
                    <input type="hidden" name="paymentChannel" id="paymentChannel" >
                </form>
                <form id="formPayConfig21">
                    <ul class="select-pay-channel-con wechat-self" data-id='one'>
                        <li><span>商户ID（Mchid）</span><input type="text" name="payMerchantId" class="payMerchantId" placeholder="必填"></li>
                        <li><span>应用ID（AppId）</span><input type="text"  placeholder="必填"  name="appid" class="appid"></li>
                        <li><span>支付秘钥key</span><input type="text"  placeholder="必填" name="payKey" class="payKey"></li>
                        <li><span>AppScret（应用秘钥）</span><input type="text"  placeholder="必填" name="appSecret" class="appSecret"></li>
                        <li><span>费率(%。)</span><input type="number"  placeholder="必填" name="rate"  class="rate"></li>
                        <li><span>apiclient-cert</span><input type="text"  placeholder="必填" class="annotation-input apiclientCert"  name="apiclientCert" ><div class="annotation">pem格式，用于退款及退款查询。微信商户平台=>ApI安全=>API证书=>下载证书</div></li>
                        <li><span>apiclient-key</span><input type="text"   placeholder="必填" class="annotation-input apiclientKey" name="apiclientKey"><div class="annotation">pem格式，用于退款及退款查询。微信商户平台=>ApI安全=>API证书=>下载证书</div></li>
                    </ul>
                </form>
                <form id="formPayConfig22">
                    <!--微信其他子商户start-->
                    <ul class="select-pay-channel-con wechat-other-child" style="display: none;" data-id='two'>
                        <li><span>商户ID（Mchid）</span><input type="text" placeholder="必填" name="payMerchantId" class="payMerchantId"></li>
                        <li><span>应用ID（AppId）</span><input type="text"  placeholder="必填" name="appid" class="appid"></li>
                        <li><span>支付秘钥key</span><input type="text"  placeholder="必填" name="payKey" class="payKey"></li>
                        <li><span>AppScret（应用秘钥）</span><input type="text"  placeholder="必填" name="appSecret" class="appSecret"></li>
                        <li><span>子商户号</span><input type="text"  placeholder="必填" name="subMerchantId" class="subMerchantId"></li>
                        <li><span>费率(%。)</span><input type="number"  placeholder="必填"  name="rate"  class="rate"></li>
                        <li><span>apiclient-cert</span><input type="text"  placeholder="必填" class="annotation-input apiclientCert"  name="apiclientCert"><div class="annotation">pem格式，用于退款及退款查询。微信商户平台=>ApI安全=>API证书=>下载证书</div></li>
                        <li><span>apiclient-key</span><input type="text"   placeholder="必填" class="annotation-input apiclientKey" name="apiclientKey"><div class="annotation">pem格式，用于退款及退款查询。微信商户平台=>ApI安全=>API证书=>下载证书</div></li>
                    </ul>
                </form>
                <form id="formPayConfig203">
                    <!--微信兴业银行start-->
                    <ul class="select-pay-channel-con wechat-xingye" style="display: none;" data-id='three'>
                        <li><span>商户号</span><input type="text" placeholder="必填" class="channelMerchantId" name="channelMerchantId"></li>
                        <li><span>商户密钥</span><input type="text" placeholder="必填" name="channelMerchantKey" class="channelMerchantKey"></li>
                        <li><span>费率(%。)</span><input type="number"  placeholder="必填"  name="rate"  class="rate"></li>
                        <li><span>结算方式</span>
                            <select name="settlementType" class="settlementType">
                                <option value="0">T+0</option><option value="1">T+1</option>
                            </select>
                        </li>
                    </ul>
                </form>
                <form id="formPayConfig201">
                    <!--微信民生银行start-->
                    <ul class="select-pay-channel-con wechat-minsheng" style="display: none;" data-id='four'>
                        <li><span>商户号</span><input type="text" placeholder="必填" class="channelMerchantId" name="channelMerchantId"></li>
                        <li><span>商户密钥</span><input type="text" placeholder="必填" name="channelMerchantKey" class="channelMerchantKey"></li>
                        <li><span>费率(%。)</span><input type="number"  placeholder="必填"  name="rate"  class="rate"></li>
                        <li><span>结算方式</span>
                            <select name="settlementType" class="settlementType">
                                <option value="0">T+0</option><option value="1">T+1</option>
                            </select>
                        </li>
                    </ul>
                </form>
                <form id="formPayConfig202">
                    <!--微信中信银行start-->
                    <ul class="select-pay-channel-con wechat-zhongxin" style="display: none;" data-id='five'>
                        <li><span>商户号</span><input type="text" placeholder="必填" class="channelMerchantId" name="channelMerchantId"></li>
                        <li><span>商户密钥</span><input type="text" placeholder="必填" name="channelMerchantKey" class="channelMerchantKey"></li>
                        <li><span>费率(%。)</span><input type="number"  placeholder="必填"  name="rate"  class="rate"></li>
                        <li><span>结算方式</span>
                            <select name="settlementType" class="settlementType">
                                <option value="0">T+0</option><option value="1">T+1</option>
                            </select>
                        </li>
                    </ul>
                </form>
                <form id="formPayConfig23">
                    <!--旗鱼子商户start-->
                    <ul class="select-pay-channel-con wechat-qiyu-child" style="display: none;" data-id='six'>
                        <li><span>微信子商户号</span><input type="text" placeholder="必填" class="subMerchantId" name="subMerchantId"></li>
                        <li><span>费率(%。)</span><input type="number"  placeholder="必填"  name="rate"  class="rate"></li>
                       <%-- <li><span>结算方式</span>
                            <select name="settlementType" class="settlementType">
                                <option value="0">T+0</option><option value="1">T+1</option>
                            </select>
                        </li>--%>
                    </ul>
                </form>
                <%--微信快付通--%>
                <form id="formPayConfig204">
                    <ul class="select-pay-channel-con wechat-kft" style="display: none;" data-id='twelve'>
                        <li><span>商户号</span><input type="text" placeholder="必填" class="channelMerchantId" name="channelMerchantId"></li>
                        <li><span>商户密钥</span><input type="text" placeholder="必填" name="channelMerchantKey" class="channelMerchantKey"></li>
                        <li><span>费率(%。)</span><input type="text"  placeholder="必填"  name="rate"  class="rate"></li>
                        <li><span>结算方式</span>
                            <select name="settlementType" class="settlementType">
                                <option value="0">T+0</option><option value="1">T+1</option>
                            </select>
                        </li>
                    </ul>
                </form>
                <form id="formPayConfig101">
                    <!--支付宝Start-->
                    <!--民生银行支付宝Start-->
                    <ul class="select-pay-channel-con ali-minsheng" style="display: none;" data-id='seven'>
                        <li><span>商户号</span><input type="text" placeholder="必填" class="channelMerchantId" name="channelMerchantId"></li>
                        <li><span>商户密钥</span><input type="text" placeholder="必填" name="channelMerchantKey" class="channelMerchantKey"></li>
                        <li><span>费率(%。)</span><input type="text"  placeholder="必填"  name="rate"  class="rate"></li>
                        <li><span>结算方式</span>
                            <select name="settlementType" class="settlementType">
                                <option value="0">T+0</option><option value="1">T+1</option>
                            </select>
                        </li>
                    </ul>
                </form>
                <form id="formPayConfig103">
                    <!--兴业银行支付宝Start-->
                    <ul class="select-pay-channel-con ali-xingye" style="display: none;" data-id='eight'>
                        <li><span>商户号</span><input type="text" placeholder="必填" class="channelMerchantId" name="channelMerchantId"></li>
                        <li><span>商户密钥</span><input type="text" placeholder="必填" name="channelMerchantKey" class="channelMerchantKey"></li>
                        <li><span>费率(%。)</span><input type="number"  placeholder="必填"  name="rate"  class="rate"></li>
                        <li><span>结算方式</span>
                            <select name="settlementType" class="settlementType">
                                <option value="0">T+0</option><option value="1">T+1</option>
                            </select>
                        </li>
                    </ul>
                </form>
                <form id="formPayConfig12">
                    <!--支付宝2.0 start-->
                    <ul class="select-pay-channel-con ali-2.0" style="display: none;" data-id='nine'>
                        <li><span>商户应用ID（APPid）</span><input type="text" placeholder="必填" name="appid" class="appid"></li>
                        <li><span>支付宝收款账户</span><input type="text"  placeholder="必填" name="payAccount" class="payAccount"></li>
                        <li><span>安全校验码（key）</span><input type="text"  placeholder="必填" name="saftKey" class="saftKey"></li>
                        <li><span>服务商PID</span><input type="text"  placeholder="必填" name="pid" class="pid"></li>
                        <li><span>费率(%。)</span><input type="number"  placeholder="必填"name="rate"  class="rate"></li>
                        <li><span>RSA私钥</span><input type="text"  placeholder="必填" class="annotation-input privateKey" name="privateKey"></li>
                        <li><span>RSA公钥</span><input type="text"   placeholder="必填" class="annotation-input publicKey" name="publicKey"></li>
                    </ul>
                </form>
                <form id="formPayConfig11">
                    <!--支付宝ISV start-->
                    <ul class="select-pay-channel-con ali-ISV" style="display: none;" data-id='ten'>
                        <li><span>EMAIL</span><input type="text" placeholder="必填" name="email" class="email"></li>
                        <li><span>支付宝口碑店铺ID</span><input type="text"  placeholder="必填" name="aliStoreId" class="aliStoreId"></li>
                        <li><span>合作服务商ID（PID）</span><input type="text"  placeholder="必填" name="aliPid" class="aliPid"></li>
                        <li><span>收款支付宝账号ID</span><input type="text"  placeholder="必填" name="payAccount" class="payAccount"></li>
                        <li><span>费率(%。)</span><input type="number"  placeholder="必填" name="rate"  class="rate"></li>
                    </ul>
                </form>
                <form id="formPayConfig102">
                    <!--中信银行支付宝Start-->
                    <ul class="select-pay-channel-con ali-zhongxin" style="display: none;" data-id='eleven'>
                        <li><span>商户号</span><input type="text" placeholder="必填" class="channelMerchantId" name="channelMerchantId"></li>
                        <li><span>商户密钥</span><input type="text" placeholder="必填" name="channelMerchantKey" class="channelMerchantKey"></li>
                        <li><span>费率(%。)</span><input type="number"  placeholder="必填"  name="rate"  class="rate"></li>
                        <li><span>结算方式</span>
                            <select name="settlementType" class="settlementType">
                                <option value="0">T+0</option><option value="1">T+1</option>
                            </select>
                        </li>
                    </ul>
                    <!--中信银行支付宝End-->
                </form>
                <%--ali快付通--%>
                <form id="formPayConfig104">
                    <ul class="select-pay-channel-con ali-kft" style="display: none;" data-id='thirteen'>
                        <li><span>商户号</span><input type="text" placeholder="必填" class="channelMerchantId" name="channelMerchantId"></li>
                        <li><span>商户密钥</span><input type="text" placeholder="必填" name="channelMerchantKey" class="channelMerchantKey"></li>
                        <li><span>费率(%。)</span><input type="text"  placeholder="必填"  name="rate"  class="rate"></li>
                        <li><span>结算方式</span>
                            <select name="settlementType" class="settlementType">
                                <option value="0">T+0</option><option value="1">T+1</option>
                            </select>
                        </li>
                    </ul>
                </form>
                <div class="userInfo-box">
                    <img src="../static/images/icon_userInfo.png"/>
                    <div class="userInfo-text">
                        <p>代理商：${agent.agentName}</p>
                        <p>联系人：${agent.contactName}</p>
                        <p>联系电话：${agent.phone}</p>
                    </div>
                </div>
                <!--完成按钮-->
                <div class="bottom">
                    <span>完成</span>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="../../../base/script.jsp"%>
<script type="text/javascript">
    function showConfigWin() {
        var param = {};
        param["restaurantId"] = $("#restaurantId").val();
        param["platform"] = $("#platform").val();
        param["paymentChannel"] = $("#paymentChannel").val();
        $("#formPayConfig"+$("#paymentChannel").val())[0].reset();
      $.ajax({
         url: '${rootPath}/payConfig/getPayConfig',
         type:'POST',
         data: param,
         async: false,
         success: function (json) {
         if (json.success) {
         var data = json.data;
         if(data!=null){
             setValue(data);
         }
         $("#savePayConfig").click(updatePayConfig);
         }else{
         alert(json.msg);
         }
         }
         });
    }
    function setValue(recode){
        var channel = recode.paymentChannel;
        if(channel==="21"){
            $(".payMerchantId").val(recode.payMerchantId);
            $(".payKey").val(recode.payKey);
            $(".appid").val(recode.appid);
            $(".appSecret").val(recode.appSecret);
            $(".apiclientCert").val(recode.apiclientCert);
            $(".apiclientKey").val(recode.apiclientKey);

        }else if(channel==="22"){
            $(".payMerchantId").val(recode.payMerchantId);
            $(".payKey").val(recode.payKey);
            $(".appid").val(recode.appid);
            $(".appSecret").val(recode.appSecret);
            $(".subMerchantId").val(recode.subMerchantId);
            $(".apiclientCert").val(recode.apiclientCert);
            $(".apiclientKey").val(recode.apiclientKey);

        }else if(channel==="23"){
            $(".subMerchantId").val(recode.subMerchantId);

        }else if(channel==="11"){
            $(".email").val(recode.email);
            $(".aliStoreId").val(recode.aliStoreId);
            $(".aliPid").val(recode.aliPid);
            $(".payAccount").val(recode.payAccount);

        }else if(channel==="12"){
            $(".appid").val(recode.appid);
            $(".saftKey").val(recode.saftKey);
            $(".pid").val(recode.pid);
            $(".payAccount").val(recode.payAccount);
            $(".privateKey").val(recode.privateKey);
            $(".publicKey").val(recode.publicKey);

        }else{
            $(".channelMerchantId").val(recode.channelMerchantId);
            $(".channelMerchantKey").val(recode.channelMerchantKey);
            $(".settlementType").val(recode.settlementType);
        }
        $(".rate").val(recode.rate);

    }
    function updatePayConfig(){
        var paramst =  $("#formPayConfig").serialize();
        var channel = $("#paymentChannel").val();
        var paramsc = $("#formPayConfig"+channel).serialize();
        var params = paramst+"&"+paramsc;
        var paramsArr= params.split("&");
        for(var i=0;i<paramsArr.length;i++){
            var value= paramsArr[i].split("=");
            if(value[1]==""){
                alert("请完成资料!");
                return;
            }
        }
        $.ajax({
                url: '${rootPath}/payConfig/updatePayConfig',
                type:'POST',
                data: params,
                async: false,
                success: function (data) {
                    if(data&&data.success){
                        alert("保存成功!");
                        window.location.href="${rootPath}/merchant/datail?merchantId="+$("#merchantId").val();
                    }else{
                        alert(data.desc);
                    }
                }
        });
    }
    </script>
<script src="${rootPath}/static/payconfig/business-management-detail-config.js" type="text/javascript" charset="utf-8"></script>

<script type="text/javascript">
    $(".wechat").click();
</script>
</body>
</html>
