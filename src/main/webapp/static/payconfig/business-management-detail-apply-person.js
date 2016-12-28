var virtueData=(function () {
	
})();
var handleEvns=(function () {
	var  previousStep=function () {
			$(".company-info .steps span:first-child").click(function () {
				$('.legal-person-info').css('display','inline-block');
			    $('.company-info').css('display','none');
			});
			$(".operational-information .steps span:first-child").click(function () {
				$('.operational-information').css('display','none');
			    $('.company-info').css('display','inline-block');
			});
	};
	var nextStep=function () {
		$(".legal-person-info .steps span:nth-child(2)").click(function () {
			$('.legal-person-info').css('display','none');
			$('.company-info').css('display','inline-block');
		});
		$(".company-info .steps span:nth-child(2)").click(function () {
			$('.company-info').css('display','none');
			$('.operational-information').css('display','inline-block');
		});
		$(".operational-information .steps span:nth-child(2)").click(function () {
			verificationParams();
		});
	};
	var showFileName=function () {
		$(document).on("change",".parent-click input[type='file']",function(){
			var filePath=$(this).val();
			var showFileName=$(this).parent(".parent-click").find('.showFileName');
			if(filePath.indexOf("png")!=-1||filePath.indexOf("jpg")!=-1){
				var arr=filePath.split('\\');
				var fileName=arr[arr.length-1];
				var filelength = fileName.length;
				if(filelength>14){
					var headUrl=fileName.substring(0,5);
					var bodyUrl=fileName.substr(filelength-8,8);
					showFileName.html(headUrl+'...'+bodyUrl);
				}else{
					showFileName.html(fileName);
				}
			}else{
				showFileName.html("不支持该格式图片！");
				return false;
			}
		})
	}
	//是否三证合一
	var isGeneral=function () {
//		$("select.is-general").on('change',function () {
//			console.log($(this).children('option:selected').text());
//		})
		$("select#threeInOne").on('change',function () {
			if($(this).val()==1){//三證合一
				$('li.is-general').css('display','none');
			}else{//普通
				$('li.is-general').css('display','inline-block');
			}
		})

	};

	return {
		previousStep:previousStep,
		nextStep:nextStep,
		showFileName:showFileName,
		isGeneral:isGeneral,
	}
})();

var index=(function () {
	var init=function () {
		handleEvns.previousStep();
		handleEvns.nextStep();
		handleEvns.showFileName();
		handleEvns.isGeneral();
	}();
})();
