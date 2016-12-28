//模拟数据
var virtualData=(function () {
	var test=[];
	var dt1={
		"data":[
    {"agentName":"旗鱼商家",'personName':'张三','telp':'123456799', "restaurantName":"旗鱼点餐","orderCount":132},
	{"agentName":"旗鱼商家",'personName':'李四','telp':'123456799', "restaurantName":"旗鱼点餐","orderCount":132},
	{"agentName":"旗鱼商家",'personName':'王五','telp':'123456799', "restaurantName":"旗鱼点餐","orderCount":132},
    {"agentName":"旗鱼商家",'personName':'赵六','telp':'123456799', "restaurantName":"旗鱼点餐","orderCount":132},
    {"agentName":"旗鱼商家",'personName':'田七','telp':'123456799', "restaurantName":"旗鱼点餐","orderCount":132},
    {"agentName":"旗鱼商家",'personName':'朱八','telp':'123456799', "restaurantName":"旗鱼点餐","orderCount":132}]
	}
	var dt2={
		"data":[
    {"agentName":"a",'personName':'张三','telp':'123456799', "restaurantName":"旗鱼点餐","orderCount":132},
	{"agentName":"a",'personName':'李四','telp':'123456799', "restaurantName":"旗鱼点餐","orderCount":132},
	{"agentName":"a",'personName':'王五','telp':'123456799', "restaurantName":"旗鱼点餐","orderCount":132},
    {"agentName":"a",'personName':'赵六','telp':'123456799', "restaurantName":"旗鱼点餐","orderCount":132},
    {"agentName":"a",'personName':'田七','telp':'123456799', "restaurantName":"旗鱼点餐","orderCount":132},
    {"agentName":"a",'personName':'朱八','telp':'123456799', "restaurantName":"旗鱼点餐","orderCount":132}]
	}
	return {
		test:test,
		dt1:dt1,
		dt2:dt2,
	}
})();

var handleEvns=(function () {
	//制表
	var makeForm=function (param) {
	 var datas=[];
	  var merchantInfoArr=param;
		for (var i=0;i<merchantInfoArr.length;i++) {
			var obj={
			id: i+1,
	        name:merchantInfoArr[i].agentName,
	        count:merchantInfoArr[i].money,
		}
		datas.push(obj);
	 }
	//制表
		$('#table').bootstrapTable({
           data:datas
  		});		
  		$('#table').bootstrapTable('load',datas);	
 }
	var selectPeriod=function () {
		//周
		$('.table-title-right span:first-child').click(function () {
			$('.table-title-right span').removeClass('active');
			$(this).addClass('active');
			handleEvns.makeForm(agentDetail(6));
		});
		//月
		$('.table-title-right span:nth-child(2)').click(function () {
			$('.table-title-right span').removeClass('active');
			$(this).addClass('active');
			handleEvns.makeForm(agentDetail(29));
		});
		//年
		$('.table-title-right span:last-child').click(function () {
			$('.table-title-right span').removeClass('active');
			$(this).addClass('active');
			handleEvns.makeForm(agentDetail(364));
		});
	}
	return {
		makeForm:makeForm,	
		selectPeriod:selectPeriod,
	}
})();

var index=(function () {
	var init=function () {
		handleEvns.makeForm(agentDetail(6));
		handleEvns.selectPeriod();
	}();
})();






