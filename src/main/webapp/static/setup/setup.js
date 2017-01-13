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
	  var merchantInfoArr = merchantList();
		for (var i=0;i<merchantInfoArr.length;i++) {
			var obj={
				id: i+1,
				message:"<p>名称：" + merchantInfoArr[i].merchantName + "</p><p>负责人姓名：" + merchantInfoArr[i].contact + "</p><p>电话:" + merchantInfoArr[i].phone + "</p><p class='belong'>所属代理商："+merchantInfoArr[i].agentName+"</p>",
	       		count:"<span>开通商户:"+ merchantInfoArr[i].restaurantCount+"家</span>",
				operate:"<input class='operate_img' type='checkbox' name='check' value='" + merchantInfoArr[i].id + "' id='yes'>",
			}
		datas.push(obj);
	  }
		$('#table').bootstrapTable({
			data:datas
		})
		$('#table').bootstrapTable('load',datas);
		showAgent();
	}


	//添加搜索按钮
	var addSearchBtn=function(){
		//添加下拉列表
		$(".form-control").before("<select class='set-select' id='type' name='type'><option value='A'>代理商</option><option value='M'>商户</option></select>");
		//添加搜索按钮
		$(".form-control").after("<span class='search-btn' onclick='handleEvns.transformData();'>搜索<img src='../static/images/icon_search.png'</span>").css('display','inline-block').prop('name','simpleName').prop('id','simpleName').prop("placeholder",'请输入代理商名称进行搜索');
	}

	return {
		transformData:transformData,
		addSearchBtn:addSearchBtn,
	}
})();

var index=(function () {
	var init=function () {
		handleEvns.transformData();
		handleEvns.addSearchBtn();
	}();
})();