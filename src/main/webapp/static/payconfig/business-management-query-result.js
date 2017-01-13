//模拟数据

var handleEvns=(function () {
	//转换数据格式
	var transformData=function () {
	 var datas=[];
	  var merchantInfoArr=MerchantsQuery();
		for (var i=0;i<merchantInfoArr.length;i++) {
			var statusStr = "";
			if(merchantInfoArr[i].resultStatus==="1"){
				statusStr = "成功";
			}else if(merchantInfoArr[i].resultStatus==="0"){
				statusStr = "申请中";
			}else if(merchantInfoArr[i].resultStatus==="-1"){
				statusStr = "失败";
			}
			var obj={
			id: i+1,
	        name:"<p>店铺："+merchantInfoArr[i].restaurantName+"</p><p>类目："+merchantInfoArr[i].materialCategory+"</p><p>类型："+merchantInfoArr[i].materialType+"</p><p>申请时间："+merchantInfoArr[i].creatAtStr+"</p>",
	        count: statusStr,
	        operate:"<p>"+ merchantInfoArr[i].resultRemark +"</p>"
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