
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

//转换数据格式
var datas=[];
var handleEvns=(function () {
	var transformData=function () {
		var json = transactionInfoQuery();
		for (var i=0; i<json.length; i++) {
			var orderStatus = "";
				if(json[i].status=="0"){
					orderStatus = "<img src='../static/images/icon_sucess.png' class='bg-green'><p class='green'>成功</p>"
				}else if(json[i].status=="1"){
					orderStatus = "<img src='../static/images/icon_deals.png' style='width: 30px;height: 30px'><p class='blue'>处理中</p>"
				}else{
					orderStatus = "<img src='../static/images/icon_lose.png' class='bg-red'><p class='red'>失败</p>"
				}
			var obj={
			id: i+1,
	        orderInfo:"<p>名称："+json[i].reqMsgId+"</p><p>订单号："+json[i].smzfMsgId+"</p><p>交易号："+json[i].channelNum+"</p>",
	        buySellInfo:"<p>商户:"+json[i].merchantName+"</p><p>门店："+json[i].restaurantName+"</p>",
	        amountInfo:"<p class='red'>订单金额："+json[i].orderAmount+"</p><p class='red'>实收金额："+json[i].totalAmount+"</p><p class='blue'>服务费："+json[i].serviceCharge+"</p>",
	        operate:"<p>通道："+json[i].channelName+"</p><p>来源："+json[i].platform+"</p><p>操作："+json[i].operator+"</p>",
	        status:orderStatus
		}
		datas.push(obj);
	  }
		return {
			datas:datas,
		}
	}
	//制表
	var makeForm=function () {
		$('#table').bootstrapTable({
           data: datas
  		});		
 }
	//添加搜索按钮
	var addSearchBtn=function(){			
	$(".form-control").after("<span class='search-btn'>搜索<img src='../static/images/icon_search.png'</span>").css('display','inline-block').prop("placeholder",'请输入订单名/订单号进行搜索');
  }
	return {
		transformData:transformData,
		makeForm:makeForm,
		addSearchBtn:addSearchBtn,
	}
})();

var index=(function () {
	var init=function () {
		handleEvns.transformData();
		handleEvns.makeForm();
		handleEvns.addSearchBtn();
	}();
})();