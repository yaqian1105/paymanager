//模拟数据
var virtualData=(function () {
	var test=[];
	var dt={
		"data":[
            {"merchantId":105,"restaurantId":112,"desk":"001","player":{"userId":1,"openId":null,"userName":"test","headImg":"img/user1.png","isSponsor":true},"foods":[{"foodId":'500',"foodName":'菜品1',"foodCategory":'做法1',"count":'9',"unitPrice":'0.13',"unitType":'1',"unitName":'规格名称',"foodWay":'1'},{"foodId":'500-1',"foodName":'菜品1',"foodCategory":'做法1',"count":'9',"unitPrice":'0.13',"unitType":'1',"unitName":'规格名称',"foodWay":'1'}]},
            {"merchantId":106,"restaurantId":113,"desk":"002","player":{"userId":2,"openId":null,"userName":"test1","headImg":"img/user.png","isSponsor":false},"foods":[{"foodId":'501',"foodName":'菜品2',"foodCategory":'做法2',"count":'8',"unitPrice":'0.13',"unitType":'2',"unitName":'规格名称',"foodWay":'2'}]},
            {"merchantId":107,"restaurantId":114,"desk":"003","player":{"userId":3,"openId":null,"userName":"test2","headImg":"img/user.png","isSponsor":false},"foods":[{"foodId":'502',"foodName":'菜品3',"foodCategory":'做法3',"count":'7',"unitPrice":'0.13',"unitType":'1',"unitName":'规格名称',"foodWay":'3'},{"foodId":'502-1',"foodName":'菜品1',"foodCategory":'做法1',"count":'9',"unitPrice":'0.13',"unitType":'1',"unitName":'规格名称',"foodWay":'3'}]},
            {"merchantId":108,"restaurantId":115,"desk":"004","player":{"userId":4,"openId":null,"userName":"test3","headImg":"img/user.png","isSponsor":false},"foods":[{"foodId":'503',"foodName":'菜品2',"foodCategory":'做法2',"count":'8',"unitPrice":'0.13',"unitType":'2',"unitName":'规格名称',"foodWay":'2'}]},
            {"merchantId":109,"restaurantId":116,"desk":"005","player":{"userId":5,"openId":null,"userName":"test4","headImg":"img/user.png","isSponsor":false},"foods":[{"foodId":'504',"foodName":'菜品1',"foodCategory":'做法1',"count":'9',"unitPrice":'0.13',"unitType":'1',"unitName":'规格名称',"foodWay":'1'}]},
        ]
	};
	return {
		test:test,
		dt:dt,
	}
})();

var handleEvns=(function () {
	//制表
var makeForm=function () {
	var datas=[];
	var json = getChannelQuery();
	for (var i=0;i<json.length;i++) {
		if(json[i].length<=0){
		continue;
		}
		var channelStr="";
		var rateStr="";
		var paymentwayStr="";
		var operateStr="";
		var payWayStr="" ;

		for(var j=0;j<json[i].length;j++){

			if(json[i][j].platform==="ali"){
				payWayStr = "<img src='../static/images/icon_ali_red.png'><p>支付宝</p>";

			}
			if(json[i][j].platform==="weixin"){
				payWayStr = "<img src='../static/images/icon_wechat_red.png'><p>微信</p>"

			}
			var settlementTypeStr;
			if(json[i][j].settlementType===0){
				settlementTypeStr = "T+0"
			}
			if(json[i][j].settlementType===1){
				settlementTypeStr = "T+1"
			}
			channelStr+="<p>"+json[i][j].paymentChannel+"</p>";
			rateStr+="<p>"+json[i][j].rate+"</p>";
			paymentwayStr+="<p>"+settlementTypeStr+"</p>";
			operateStr+="<span class='a-view-detail center'  onclick=\"showRateWin(\'"+ json[i][j].id +"\',\'"+json[i][j].rate +"\',\'"+json[i][j].settlementType +"\');\">修改</span>";
			}
			var obj={
				payWay:payWayStr,
				channel:channelStr,
				rate:rateStr,
				paymentway:paymentwayStr,
				operate:operateStr
			};
			datas.push(obj);
		}
		$('#table').bootstrapTable({
	    data: datas
	 });	
 }
	//修改
	var modify=function () {
		//点击修改
		$(document).on('click','.a-view-detail',function () {
			$(".mask-con,.mask").css('display','inline-block');
			/*var target_modify_id=$(this).attr('data-id');
			var parent_tr=$(this).parent("td").parent("tr");
			var rate_input=$(".mask-con>li:nth-child(2)>input");
			var pay_way_input=$(".mask-con>li:nth-child(3)>input");			
			var rate_ele=parent_tr.find("td:nth-child(3) p");
			var pay_way_ele=parent_tr.find("td:nth-child(4) p");*/

	  });
	};
	//点击蒙版
	var maskClick=function () {
		$(".mask").click(function () {
			$(".mask-con,.mask").css('display','none');
		});
	}	
	//点击取消
		var cancelClick=function () {
			$(".mask-con>li:last-child>span:first-child").click(function () {
			$(".mask-con,.mask").css('display','none');
		  });
		}
	
	return {
		makeForm:makeForm,
		modify:modify,
		cancelClick:cancelClick,
		maskClick:maskClick,
	}
})();
var index=(function () {
	var init=function () {
		handleEvns.makeForm();
		handleEvns.modify();
		handleEvns.cancelClick();
		handleEvns.maskClick();
	}();
})();
