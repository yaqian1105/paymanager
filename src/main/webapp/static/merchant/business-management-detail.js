//模拟数据
var virtualData=(function () {
	var test=[];
	var dt={
		"data":[
    {"agentName":"旗鱼商家",'personName':'张三','telp':'123456799', "restaurantName":"旗鱼点餐","orderCount":132},
	{"agentName":"旗鱼商家",'personName':'李四','telp':'123456799', "restaurantName":"旗鱼点餐","orderCount":132},
	{"agentName":"旗鱼商家",'personName':'王五','telp':'123456799', "restaurantName":"旗鱼点餐","orderCount":132},
    {"agentName":"旗鱼商家",'personName':'赵六','telp':'123456799', "restaurantName":"旗鱼点餐","orderCount":132},
    {"agentName":"旗鱼商家",'personName':'田七','telp':'123456799', "restaurantName":"旗鱼点餐","orderCount":132},
    {"agentName":"旗鱼商家",'personName':'朱八','telp':'123456799', "restaurantName":"旗鱼点餐","orderCount":132}]
	}
	return {
		test:test,
		dt:dt,
	}
})();

var handleEvns=(function () {
	//制表
	var makeForm=function () {
	 var datas=[];
	  var json=MerchantsRestQuery();
		for (var i=0;i<json.length;i++) {
			var aliType = (json[i].aliType);
			var wxType = (json[i].wxType);
			if(json[i].ali!='ali'){
				aliType = "未开通";
			}
			if(json[i].wx!='weixin'){
				wxType = "未开通";
			}
			var obj={
			id: i+1,
	        name:"<span class='res-id'>门店ID:"+json[i].id+"</span><span>门店名称："+json[i].restName+"</span>" ,
	        count:"<span class='pay-way'>支付宝："+aliType+"</span><span>微信："+wxType+"</span>",
	        operate:"<a href='#'  class='a-view-detail'   onclick=\'payConfig("+  json[i].id +");\'>支付配置</a>" +
			"<a href='#' class='a-view-detail center' onclick=\'payApply("+ json[i].id +");\'>支付申请</a>" +
			"<a href='#' class='a-view-detail' onclick=\'setConfig("+ json[i].id +");\'>配置通道</a>"
		}
		datas.push(obj);
	 }
	//制表
		$('#table').bootstrapTable({
           data:datas
  		});		
 }
	//添加搜索按钮
	var addSearchBtn=function(){			
	 //添加一个搜索按钮
  $(".form-control").before("<span class='search-left'>门店列表</span>");
  $(".form-control").after("<span class='search-btn'>搜索<img src='../static/images/icon_search.png'</span>").css('display','inline-block').prop("placeholder",'请输入商户名称进行搜索');
  }
	var showUserInfo=function () {
		$(".personInfo-center div:first-child").text("商户名称 ");
		$(".personInfo-center div:nth-child(2)").text("电话：6546546414");
		$(".personInfo-right div:first-child").text("张三");
		$(".personInfo-right div:nth-child(2)").text("xx代理商公司");
	}
	return {
		makeForm:makeForm,
		addSearchBtn:addSearchBtn,
		//showUserInfo:showUserInfo,
	}
})();

var index=(function () {
	var init=function () {
		handleEvns.makeForm();
		handleEvns.addSearchBtn();
		//handleEvns.showUserInfo();
	}();
})();






