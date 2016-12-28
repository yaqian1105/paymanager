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
	<title>商户管理</title>
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
			<!--第二步Start-->
				<input type="hidden" name="merchantId" id = "merchantId" value='${merchantId}'>

				<form  id="submitApply" method="post"  enctype="multipart/form-data">
					<input type="hidden" name="id"  value="${payInformation.id}"/>
					<input type="hidden" name="restaurantId"  id = "restaurantId"  value="${payInformation.restaurantId}"/>
					<input type="hidden" name="restaurantSignType" id="restaurantSignType" value="${payInformation.restaurantSignType}">
					<input type="hidden" name="platform" id="platform" value="${payInformation.platform}">
					<input type="hidden" name="paymentChannel" id="paymentChannel" value="${payInformation.paymentChannel}" >
				<div class="content legal-person-info" >
				<ul class="information">
					<li><h4>法人信息</h4></li>
					<li><span>法人姓名</span><input type="text" placeholder="必填" name="legalRepresentativeName" data_log="法人姓名"  id="legalRepresentativeName" value="${payInformation.legalRepresentativeName}"></li>
					<li><span>证件号码</span><input type="text"  placeholder="必填" name="legalRepresentativeCertNo"  data_log="证件号码" id="legalRepresentativeCertNo" value="${payInformation.legalRepresentativeCertNo}"></li>
					<li><span>证件有效期</span><input type="text"  placeholder="" name="legalRepresentativeCertIndate"  data_log="证件有效期" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"   value="${payInformation.legalRepresentativeCertIndate}"></li>
					<li><h4>银行卡信息</h4></li>
					<li><span>户名</span><input type="text" placeholder=""  name="bankAccountName"  data_log="户名"  value="${payInformation.bankAccountName}"></li>
					<li><span>银行预留号码</span><input type="text"  placeholder="" data_log="银行预留号码"  name="bankAccountMobile"  value="${payInformation.bankAccountMobile}"></li>
					<li><span>银行账号</span><input type="text"  placeholder=""  data_log="银行账号"  name="bankCardNo" value="${payInformation.bankCardNo}"></li>
	             </ul>	     
				<ul class="upload">
					<li>
						<div><span>证件照正面</span></div>
						<div class="parent-click"><span class="click">点击上传</span><input type="file" data_log="证件照正面"  name="operateIdcardPositive" id="operateIdcardPositive"><b class="showFileName"></b></div>
					</li>
					<li>
						<div><span>证件照反面</span><span style="display: none;"></span></div>
						<div class="parent-click"><span class="click">点击上传</span><input type="file" name="operateIdcardReverse" data_log="证件照反面" id="operateIdcardReverse"><b class="showFileName"></b></div>
					</li>
				</ul>
				<div class="steps">
					<span onclick="javascript:history.go(-1);">上一步</span><span>下一步</span>
				</div>
				</div>			
			    <!--第三步Start-->
			    <div class="content company-info" style="display: none;">					
					<ul class="information">
						<li><h4>企业基本信息</h4></li>
	            		<li><span>企业名称</span><input type="text" placeholder="必填" data_log="企业名称"  id="businessLicenseName" name="businessLicenseName" value="${payInformation.businessLicenseName}"></li>
	            		<li><span>账户名</span><input type="text"  name="accountName" value="${payInformation.accountName}"></li>
	            		<li><span>是否为三证合一</span>
	            			<select name="threeInOne" id="threeInOne">
	            			<option value="1">三证合一</option>
	            			<option value="0">普通</option>
	            		</select>
	            		</li>	            
	            		<li><span>注册号</span><input type="text" placeholder="必填" id="registerNo"  data_log="注册号" name="registerNo" value="${payInformation.registerNo}" ></li>
	            		<li><span>住所</span><input type="text"  name="address" data_log="住所"  value="${payInformation.address}" ></li>
	            		<li><span>经验范围</span><input type="text" name="scope" data_log="经验范围"  value="${payInformation.scope}"></li>
	            		<li class="special-li"><span>经营期限</span><input type="text"  data_log="经营期限"  name="timeLimit" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  value="${payInformation.timeLimit}">
                            <span>长期<input type="checkbox" value="1" name="longDate" id="longDate"></span></li>
	             </ul>	     
					<ul class="upload">

						<li>
							<div><span>营业执照照片</span></div>
							<div class="parent-click"><span class="click">点击上传</span><input type="file" name="businessLicense" data_log="营业执照照片"  id ="businessLicense" /><b class="showFileName"></b></div>
						</li>
						<li>
							<div><span>营业执照授权函</span><span style="display: none;"></span></div>
							<div class="parent-click"><span class="click">点击上传</span><input type="file" name="enterpriseLogo" data_log="营业执照授权函" id ="enterpriseLogo" /><b class="showFileName"></b></div>
						</li>
					   <li class="is-general">
						<div><span>组织机构代码照片</span></div>
						   <div class="parent-click"><span class="click">点击上传</span><input type="file" data_log="组织机构代码照片" id="orgCodeCertificatePic" name="orgCodeCertificatePic"id="orgCodeCertificatePic"><b class="showFileName"></b></div>
					   </li>
					</ul>
					<div class="steps">
						<span>上一步</span><span>下一步</span>
					</div>
				</div>						  		    	
			    <!--第四步Start-->
			     <div class="content operational-information" style="display: none;">					
					<ul class="information">
						<li><h4>经营信息</h4></li>
	            		<li><span>经营类目</span><input type="text" name="operateType"  data_log="经营类目"  value="${payInformation.operateType}"><a href="">查看经营类目</a></li>
	            		<li><span>接入网址</span><input type="text" placeholder="必填" name="webSite" id="webSite" data_log="接入网址"  value="${payInformation.webSite}"></li>
	            		<li><h4>口碑店信息</h4></li>
                        <li><span>证件主体</span><input type="text" name="documentSubject" id="documentSubject"  data_log="证件主体"  value="${payInformation.documentSubject}" placeholder="必填"></li>
                        <li><span>经验范围</span><input type="text" name="rangeOfExperience" id="rangeOfExperience" data_log="经验范围" value="${payInformation.rangeOfExperience}" placeholder="必填"></li>
                        <li><span>门店名称</span><input type="text" name="storeName" id="storeName" data_log="门店名称" value="${payInformation.storeName}" placeholder="必填"></li>
                        <li><span>门店地址</span><input type="text" name="storeAddress" id="storeAddress" data_log="门店地址" value="${payInformation.storeAddress}" placeholder="必填"></li>
                        <li><span>口碑类目</span><input type="text" name="wordMouthCategory" id="wordMouthCategory" data_log="口碑类目" value="${payInformation.wordMouthCategory}"><a href="#">查看口碑类目</a></li>
	             </ul>	     
					<ul class="upload">
						<li>
							<div><span>经营资质</span></div>
							<div class="parent-click"><span class="click">点击上传</span><input type="file"data_log="经营资质"  name="operateConditions" id="operateConditions"><b class="showFileName"></b></div>
						</li>
						<li>
							<div><span>授权函</span><span style="display: none;"></span></div>
							<div class="parent-click"><span class="click">点击上传</span><input type="file" name="authLetter"  data_log="授权函" id="authLetter"><b class="showFileName"></b></div>
					   </li>
					   <li >
						<div><span>店铺照片</span><span style="display: none;"></span></div>
						   <div class="parent-click"><span class="click">点击上传</span><input type="file" name="storeImage" data_log="店铺照片"  id="storeImage"><b class="showFileName"></b></div>
					   </li>
						 <li class="store-interior">
						<div><span>店铺内景照片</span><span style="display: none;"></span></div>
							 <div class="parent-click"><span class="click">点击上传</span><input type="file" name="storeImageInner"data_log="店铺内景照片第一张"  id="storeImageInner"><b class="showFileName"></b></div>
							 <div class="parent-click"><span class="click">点击上传</span><input type="file" name="storeImageSecInner" data_log="店铺内景照片第二张"  id="storeImageSecInner"><b class="showFileName"></b></div>
							<div class="parent-click"><span class="click">点击上传</span><input type="file" name="storeImageThreeInner" data_log="店铺内景照片第三张"  id="storeImageThreeInner"><b class="showFileName"></b></div>
					   </li>
					</ul>
					<div class="steps">
						<span>上一步</span><span>保存</span>
					</div>
				</div>						  		    	
			   </form>
				</div>
			</div>
	</div>	
</body><%@include file="../../../base/script.jsp"%>
<script type="text/javascript" src="${rootPath}/static/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${rootPath}/static/js/jquery.form.js"></script>
<script src="${rootPath}/static/payconfig/business-management-detail-apply-person.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
		$(function(){
			$("#threeInOne").val("${payInformation.threeInOne}");
			if("${payInformation.longDate}"==="1"){
				$("#longDate").prop('checked',true);
			}
		});
		function verificationParams() {
			var fileflag = false;
			var data_log = "";
			$("input[type='file']").each(function(){
				var filePath = $(this).val();
				if((filePath=="" || (filePath.indexOf("png")==-1 && filePath.indexOf("jpg")==-1))) {
					if($("#threeInOne").val()==1&&$(this).attr("id")=="orgCodeCertificatePic"){
						return;
					}
					fileflag = true;
					data_log = data_log +$(this).attr("data_log")+"\n";
					return;
				}
			});
			if(fileflag){
				alert(data_log+"请正确选择上述文件后提交！");
				return;
			}

			var legalRepresentativeName = $("#legalRepresentativeName").val();
			if (legalRepresentativeName == "" || legalRepresentativeName.length <= 0) {
				alert("法人姓名不为空！");
				return;
			}
			var legalRepresentativeCertNo = $("#legalRepresentativeCertNo").val();
			if (legalRepresentativeCertNo == "" || legalRepresentativeCertNo.length <= 0) {
				alert("证件号码不为空！");
				return;
			}
			var businessLicenseName = $("#businessLicenseName").val();
			if (businessLicenseName == "" || businessLicenseName.length <= 0) {
				alert("企业名称不为空！");
				return;
			}
			var registerNo = $("#registerNo").val();
			if (registerNo == "" || registerNo.length <= 0) {
				alert("注册号不为空！");
				return;
			}

			var webSite = $("#webSite").val();
			if (webSite == "" || webSite.length <= 0) {
				alert("接入网站不为空！");
				return;
			}
			var documentSubject = $("#documentSubject").val();
			if (documentSubject == "" || documentSubject.length <= 0) {
				alert("证件主体不为空！");
				return;
			}
			var rangeOfExperience = $("#rangeOfExperience").val();
			if (rangeOfExperience == "" || rangeOfExperience.length <= 0) {
				alert("经验范围不为空！");
				return;
			}
			var storeName = $("#storeName").val();
			if (storeName == "" || storeName.length <= 0) {
				alert("门店名称不为空！");
				return;
			}
			var storeAddress = $("#storeAddress").val();
			if (storeAddress == "" || storeAddress.length <= 0) {
				alert("门店地址不为空！");
				return;
			}
			payApplyUpdate();
		}
		function payApplyUpdate(){
			var options = {
			url: "${rootPath}/payConfig/payApplyUpdate?"+$("#submitApply").serialize(),
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
		$('#submitApply').ajaxSubmit(options);
		}
	</script>
</html>
