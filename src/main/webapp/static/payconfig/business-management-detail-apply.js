var virtueData=(function () {
	
})();
var handleEvns=(function () {
	var selectType=function () {
		$('.business-natrue>li:first-child>span').on('click',function () {
			$(".business-natrue>li:first-child>span").removeClass("active") && $(this).addClass("active");
			$(".business-natrue>li:nth-child(2)>span").removeClass("active");
			$(".business-natrue>li:nth-child(2)>span:first-of-type").addClass("active");
			$('#restaurantSignType').val($(this).attr('data-type'));

			//点击个人
         if($(this).attr('data-type')=='2'){
			 $(".business-natrue>li:nth-child(2)>span:first-of-type").css('display','none');
			 $(".business-natrue>li:nth-child(2)>span:nth-of-type(2)").addClass("active");
			 $('#paymentChannel').val($(".business-natrue>li:nth-child(2)>span:nth-of-type(2)").attr('data-type'));
		 }else {
			 $(".business-natrue>li:nth-child(2)>span:first-of-type").css('display','inline-block');
			 $('#paymentChannel').val($(".business-natrue>li:nth-child(2)>span:first-of-type").attr('data-type'));
		 }
		});		
	}
	var selectSecond=function () {
		$('.business-natrue>li:nth-child(2)>span').on('click',function () {
			$(".business-natrue>li:nth-child(2)>span").removeClass("active") && $(this).addClass("active");
                $('#paymentChannel').val($(this).attr('data-type'));
		});
	}
	var nextStep=function (param) {
		$('#restaurantSignType').val(0);
		$('#paymentChannel').val(11);
		$(".next-step").on('click', function(){
			$('.business-natrue>li:first-child>span').each(function () {
				var target_class=$(this).attr('class');
				if(target_class=='active'){
					savePayInformationBack();
				}
			});                   
		});
	}
	return {
		nextStep:nextStep,
		selectType:selectType,
		selectSecond:selectSecond,
	}
})();
var index=(function () {
	var init=function () {
		handleEvns.nextStep();
		handleEvns.selectType();
		handleEvns.selectSecond();
	}();
})();
