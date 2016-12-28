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
	//转换数据格式
	var makeForm=function (status_data) {
	 var datas=[];
	  var json=status_data;
		for (var i=0;i<json.length;i++) {
			if(json[i].handleStatus === 1 || json[i].handleStatus === 0){
				msg = "<a class='operate-on'  onclick=\'updateWithdrawl("+ json[i].id +", 1, 2);\'>完成</a> " +
					"<a class='operate-on' onclick=\'updateWithdrawl("+ json[i].id +", 1, 3);\'>取消</a>";
			}else{
				msg = "<a class='operate-on' onclick=\'updateWithdrawl("+ json[i].id +", 0, 3);\'>删除</a>";
			}
			var obj={
			id: i+1,
	        orderInfo:"<p>订单编号："+json[i].reqMsgId+"</p><p>时间："+json[i].creatAtStr+"</p>",
	        agentInfo:"<p>"+json[i].agentName+"</p><p>账号："+json[i].cardNumber+"</p><p>银行:"+json[i].brank+"</p><p>开户名："+json[i].accountName+"</p>",
	        cashNum:"<p class='red'>"+json[i].moneyStr+"</p>",
	        status:"<p>"+json[i].handleStatusStr+"</p>",
	        operate:msg
		}
		datas.push(obj);
		}
		$('#table').bootstrapTable({
			data:datas
		});
		$('#table').bootstrapTable('load', datas);
	}


	//添加搜索按钮
	var addSearchBtn=function(){ 
		  $(".form-control").after("<span class='search-btn'>搜索<img src='../static/images/icon_search.png'</span>").css('display','inline-block').prop("placeholder",'请输入订单名/订单号进行搜索');
		  $(".search-btn").after("<form  id='searchForm'><input type='hidden' name='handleStatus' id='handleStatus'>" +
			  "<div class='btns'><span class='status active'>全部</span><span class='status'>未处理</span><span class='status'>处理中</span>" +
			  "<span class='status'>已完成</span><span onclick='exportExcel()'>下载</span></div></form>");
	}
	var selectStatus=function (status) {
		//全部订单
		$(document).on('click','.btns .status:first-child',function () {
			$(".btns .status").removeClass("active");
			$(this).addClass("active");
			handleEvns.makeForm(doStatus());
		});
		//未处理订单
		$(document).on('click','.btns .status:nth-child(2)',function () {
			$(".btns .status").removeClass("active");
			$(this).addClass("active");
			handleEvns.makeForm(doStatus(0));
		});
		//处理中订单
		$(document).on('click','.btns .status:nth-child(3)',function () {
			$(".btns .status").removeClass("active");
			$(this).addClass("active");
			handleEvns.makeForm(doStatus(1));
		});
		//已完成订单
		$(document).on('click','.btns .status:nth-child(4)',function () {
			$(".btns .status").removeClass("active");
			$(this).addClass("active");
			handleEvns.makeForm(doStatus(2));
		});
	}
	return {
		makeForm:makeForm,
		addSearchBtn:addSearchBtn,
		selectStatus:selectStatus,
	}
})();

var index=(function () {
	var init=function () {
		handleEvns.makeForm(withdrawlsQuery());
		handleEvns.addSearchBtn();
		handleEvns.selectStatus(status);
	}();
})();