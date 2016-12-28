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
	var transformData=function () {
	 var datas=[];
	  var merchantInfoArr=MerchantsQuery();
		for (var i=0;i<merchantInfoArr.length;i++) {
			var obj={
			id: i+1,
	        name:"<p>"+merchantInfoArr[i].merchantName+"</p><p>"+merchantInfoArr[i].contact+"</p><p>"+merchantInfoArr[i].phone+"</p><p>"+merchantInfoArr[i].agentName+"</p>",
	        count: merchantInfoArr[i].restaurantCount+"家门店",
	        operate:"<a href='#'  onclick=\'showWin("+ merchantInfoArr[i].id +");\' class='a-view-detail'>详情</a>"
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
           data: transformData().datas
  		});		
 }
	//添加搜索按钮
	var addSearchBtn=function(){			
	$(".form-control").after("<span class='search-btn'>搜索<img src='../static/images/icon_search.png'</span>").css('display','inline-block').prop("placeholder",'请输入店铺名进行搜索');
  }
	return {
		transformData:transformData,
		makeForm:makeForm,
		addSearchBtn:addSearchBtn,
	}
})();

var index=(function () {
	var init=function () {
		//handleEvns.transformData();
		handleEvns.makeForm();
		handleEvns.addSearchBtn();
	}();
})();