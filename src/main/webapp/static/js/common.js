/*
 * 全局通用，封装起来的公共库
 * 调用方式，引入此库，alert(common.url);，其他类似
*/
var common = (function(){
	//店铺信息
	$("merchant-info").text("xx店铺xx");
	//url，全局通用URL
	//getUrlParam，获取url指定参数
	//localSet，localRemove，localGet，本地缓存，设置，删除，读取
	//ajaxFn，封装的AJAX
	return {
		url:'http://testapi.yunjiangzhe.com',//全局通用URL
		getUrlParam:function(name){//获取url指定参数
			var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");//构造一个含有目标参数的正则表达式对象
		    var r = window.location.search.substr(1).match(reg);//匹配目标参数
		    if (r != null) return unescape(r[2]);
		    return null;//返回参数值
		},
		localSet:function(name, data){
			common.localRemove(name);
			sessionStorage.setItem(name, JSON.stringify(data));
		},
		localRemove:function(name){
			sessionStorage.removeItem(name);
		},
		localGet:function(name){
			return JSON.parse(sessionStorage.getItem(name));
		},
		ajaxFn:function(href, data, type, async, beforeSendFn, successFn, completeFn, errorFn){
			$.ajax({
				'url':common.url + href,
				'data':data || '',
				'type':type || 'POST',
				'async':async || true,
				'dataType':'JSONP',//目前公司用的是JSONP
				'jsonp':'callbackFunName',
				beforeSend:beforeSendFn ||  function(){},
				success:successFn || function(jsonp){
					console.log(JSON.stringify(jsonp));
				},
				complete:completeFn || function(){},
				error:errorFn || function(err){
					console.log(JSON.stringify(err));
				},
			});
		},
	};
})();
