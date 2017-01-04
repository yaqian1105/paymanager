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
	var makeForm=function () {
	var datas=[];
	 var merchantInfoArr=agentMerchantsQuery();
		if(merchantInfoArr==null){
			return;
		}
		for (var i=0;i<merchantInfoArr.length;i++) {
		var obj={
			id: i+1,
	        name:"<p>"+merchantInfoArr[i].merchantName+"</p><p>"+merchantInfoArr[i].fixedPhone+"</p><p>"+merchantInfoArr[i].contact+"</p><p>"+merchantInfoArr[i].phone+"</p>",
	        count: merchantInfoArr[i].restaurantCount+"家门店",
	        traddingData:"<p>交易笔数："+merchantInfoArr[i].transactionCount+"</p><p>交易流水："+merchantInfoArr[i].transactionFlow+"</p><p>返佣流水："+merchantInfoArr[i].returnWater+"</p>",
	        commissionData:"<p class='commissionDataFont'>"+merchantInfoArr[i].commission+"</p>"
					}
					datas.push(obj);
				}
			$('#table').bootstrapTable({
		    data: datas
		  }); 
		};
	var modify=function () {
		$(".Modify-btn.on").click(function () {
			$(".right.on").css('display','none');
			$(".right.off").css('display','inline-block');
		});
		$(".Modify-btn.off").click(function () {
			var inpu=$(".right.off input");
			if(inpu.val()){
					$('.back-radio').text(inpu.val()+".00");
					inpu.val("");
			}
			$(".right.on").css('display','inline-block');
			$(".right.off").css('display','none');
		});
	}			
	return {
		makeForm:makeForm,
		modify:modify,
	}	
})();
var index=(function () {
	var init=function () {
		handleEvns.makeForm();
		handleEvns.modify();
	}();
})();
