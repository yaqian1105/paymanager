var handleEvns=(function () {
//选择支付方式
	var selectMainWay=function () {
		//选择微信方式
		$(".main-way .wechat").click(function () {
			$("#platform").val("weixin");
			//改变样式
			$(".main-way div").removeClass("active");
			$(this).addClass("active");
			var target_li_no=$(".second-way.wechat li:first-child").attr('data-no');
			$("#paymentChannel").val(target_li_no);
            /*  var old = $("#paymentChannel").val();
             $("#paymentChannel").val(target_li_no);
             if(old!=target_li_no){
             showConfigWin();
             }*/
            showConfigWin();
			$(".main-way .wechat img").prop("src","../static/images/icon_wechat_white.png");
			$(".main-way .ali img").prop("src","../static/images/icon_ali_red.png");
			$(".second-way.wechat").css('display','inline-block');
			$(".second-way.ali").css('display','none');
			$(".second-way.wechat li").removeClass('active');
			$(".second-way.wechat li:first-child").addClass('active');
			$(".select-pay-channel-con").css("display",'none');
			$(".select-pay-channel-con.wechat-self").css('display','inline-block');

		});
		//选择阿里方式
		$(".main-way .ali").click(function () {
			$("#platform").val("ali");
			$(".main-way div").removeClass("active");
			$(this).addClass("active");
			var target_li_no=$(".second-way.ali li:first-child").attr('data-no');
			$("#paymentChannel").val(target_li_no);
            showConfigWin();
			$(".main-way .ali img").prop("src","../static/images/icon_ali_white.png");
			$(".main-way .wechat img").prop("src","../static/images/icon_wechat_red.png");
			$(".second-way.ali").css('display','inline-block');
			$(".second-way.wechat").css('display','none');	
			$(".second-way.ali li").removeClass('active');
			$(".second-way.ali li:first-child").addClass('active');
			$(".select-pay-channel-con").css("display",'none');
			$(".select-pay-channel-con.ali-ISV").css('display','inline-block');

		});
	}
//选择支付渠道	
	var selectSecondWay=function () {
		$(document).on('click',".second-way li",function (event) {
			var target_li_no=$(this).attr('data-no');
			$("#paymentChannel").val(target_li_no);
			showConfigWin();
			$(".second-way li").removeClass("active");
			$(this).addClass("active");
			var target_li_id=$(this).attr('data-id');
			$(".select-pay-channel-con").each(function (i,e) {
				var target_li_con_id=$(this).attr('data-id');
				if(target_li_con_id===target_li_id){
					$(this).css('display','inline-block');
				}else{
					$(this).css('display','none');
				}
			});
		});
	}
	//点击完成
	var finish=function () {
		$(".bottom>span").click(function () {
			//window.location.href="BusinessManagementDetail.html";
			updatePayConfig();
		})
	}
	return {
		selectMainWay:selectMainWay,
		selectSecondWay:selectSecondWay,
		finish:finish,
	}
})();
var index=(function () {
	var init=function() {
		handleEvns.selectMainWay();
		handleEvns.selectSecondWay();
		handleEvns.finish();
	}();
	return {
		init:init,
	};
})();
