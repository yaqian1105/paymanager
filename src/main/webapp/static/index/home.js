//虚拟数据
var virtualData=(function () {
	var test=[];
	var dt={"title":null,"xAxis":["2016-11-14","2016-11-22","2016-11-18","2016-11-17","2016-11-16","2016-11-16","2016-11-16","2016-11-16","2016-11-16","2016-11-16","2016-11-16","2016-11-16"],
			"yAxis":null,"series":[15.0,29.0,38.0,1000,15.0,29.0,29.0,29.0,55,66,33,100]};
	var dd=[261, 52, 1,140, 150, 160,170, 180, 190, 200];
	return {
		test:test,
		dt:dt,
		dd:dd,
	  }
})();
//执行函数
var handleEvns=(function () {	
//交易量信息
   var showTradingInfo=function (datas) {
   	$(".trading-volume>p:nth-child(2)").text(datas);
   	$(".trading-order-count>p:nth-child(2)").text(datas);
   	$(".trading-merchant-count>p:nth-child(2)").text(datas);
   };
    //绘制交易趋势图
	 var TradingTrendChart=function (datas) {
	    var myChart = echarts.init(document.getElementById('line-chart'));
		var option = {
	    title: {
	        text: ''
	    }
	    ,
	  tooltip: {
	      trigger: ''
	  },
	    legend: {
	        data:['邮件营销']
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    xAxis: {
	        type: 'category',
	        boundaryGap: false,
	        data: datas.xAxis
	    },
	    yAxis: {
	        type: 'value',
	        axisLine:{
	        	show:false
	        },
	        axisTick:{
	        	show:false
	        },
	        axisLabel:{
	        	show:false
	        }
	    },
	    series: [
	        {
	            name:'交易量',
	            type:'line',
	            stack: '额度',
	             label: {
	                normal: {
	                    show: true,
	                    position: 'top',
	                     textStyle:{
	                    	color:'#f04648',
	                    	fontSize:16
	                    }
	                 }
	               },
	             smooth: true,
	            data:datas.series,
	            areaStyle: {normal: {
	            	color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
						  offset: 0, color: '#ffb5b6' // 0% 处的颜色
						}, {
						  offset: 1, color: '#fffce9' // 100% 处的颜色
						}], false)
	            }}
	        }
	    ]
	};
	  // 使用刚指定的配置项和数据显示图表。
	        myChart.setOption(option);	
		};	 
	//绘制代理商排行柱形图
	 var agentRankingChart=function (datas) {	
	 var myChart = echarts.init(document.getElementById('agent-chart'));
	//app.title = '世界人口总量 - 条形图';
	 var option = {   
	//  tooltip: {
	//      trigger: 'axis',
	//      axisPointer: {
	//          type: 'shadow'
	//      }
	//  },
	    legend: {
	        data: ['']//按钮    
	    },
	    grid: {
	    	show:false,
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    xAxis: {
	        type: 'value',
	        boundaryGap: [0, 0],
	         splitLine: {
	            show: false
	        },
	        axisLine:{
	        	show:false
	        },
	        axisTick:{
	        	show:false
	        },
	        axisLabel:{
	        	show:false
	        }
	    },
	    yAxis: {
	        type: 'category',
	        data: datas.yAxis,
	        nameTextStyle:{
	        	color:'#f04648',
	        	fontSize:'16px'
	        }
	    },
	     textStyle:{
	    	color:'#f04648',
	    	fontSize:10
	    },
	    series: [
	        {
	            name: '周',
	            type: 'bar',       
	            data: datas.series,
	             label: {
	                normal: {
	                    show: true,
	                     position: ['30%', '8%'],
	                    textStyle:{
	                    	color:'#fff'
	                    }
	                 }
	              },
	              barWidth:20
	        }
	       
	    ],
	    color:['#f04648'],//柱状图颜色
	    backgroundColor:'#ffffff'
	   
	};
	
	// 使用刚指定的配置项和数据显示图表。
	        myChart.setOption(option);	
	}
	//绘制商家排行柱形图	
	 var merchantsRankingChart=function (datas) {
	var myChart = echarts.init(document.getElementById('bussiness-chart'));
//app.title = '世界人口总量 - 条形图';
var option = {
//  tooltip: {
//      trigger: 'axis',
//      axisPointer: {
//          type: 'shadow'
//      }
//  },
    legend: {
        data: ['']
    },  
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: {
        type: 'value',
        boundaryGap: [0, 0],
         splitLine: {
            show: false
        },
        axisLine:{
        	show:false
        },
        axisTick:{
        	show:false
        },
        axisLabel:{
        	show:false
        }
    },
    yAxis: {
        type: 'category',
        data: datas.yAxis
        
    },
    textStyle:{
    	color:'#f04648',
    	fontSize:10
    },
    series: [
        {
            name: '周',
            type: 'bar',
             
           data: datas.series,
             label: {
                normal: {
                    show: true,
                      position: ['30%', '8%'],
                      textStyle:{
                    	color:'#fff'
                    }
                 }
               },
			barWidth:20
        }
       
    ],
    color:['#f04648','#fff'],
    backgroundColor:'#ffffff'
};

// 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);	
}
	//选择周期
	var selectPeriod=function () {
	 	//周-交易趋势
		$(".line-chart-btns>span:first-child").click(function () {
			handleEvns.TradingTrendChart(orderEchart(6));
			$(".line-chart-btns>span").removeClass("active");
			$(this).addClass("active");
		});
		//月-交易趋势
		$(".line-chart-btns>span:nth-child(2)").click(function () {
			handleEvns.TradingTrendChart(orderEchart(29));
			$(".line-chart-btns>span").removeClass("active");
			$(this).addClass("active");
		});
		//年-交易趋势
		$(".line-chart-btns>span:nth-child(3)").click(function () {
			handleEvns.TradingTrendChart(orderEchart(364));
			$(".line-chart-btns>span").removeClass("active");
			$(this).addClass("active");
		});
		//周-代理商
		$(".agent-chart-btns>span:first-child").click(function () {
			handleEvns.agentRankingChart(agentEchart(6));
			$(".agent-chart-btns>span").removeClass("active");
			$(this).addClass("active");
		});
		//月-代理商
		$(".agent-chart-btns>span:nth-child(2)").click(function () {
			handleEvns.agentRankingChart(agentEchart(29));
			$(".agent-chart-btns>span").removeClass("active");
			$(this).addClass("active");
		});
		//年-代理商
		$(".agent-chart-btns>span:nth-child(3)").click(function () {
			handleEvns.agentRankingChart(agentEchart(364));
			$(".agent-chart-btns>span").removeClass("active");
			$(this).addClass("active");
		});
		//周-商家
		$(".bussiness-chart-btns>span:first-child").click(function () {
			handleEvns.merchantsRankingChart(merchartEchart(6));
			$(".bussiness-chart-btns>span").removeClass("active");
			$(this).addClass("active");
		});
		//月-商家
		$(".bussiness-chart-btns>span:nth-child(2)").click(function () {
			handleEvns.merchantsRankingChart(merchartEchart(29));
			$(".bussiness-chart-btns>span").removeClass("active");
			$(this).addClass("active");
		});
		//年-商家
		$(".bussiness-chart-btns>span:nth-child(3)").click(function () {
			handleEvns.merchantsRankingChart(merchartEchart(364));
			$(".bussiness-chart-btns>span").removeClass("active");
			$(this).addClass("active");
		});
	};

	return {
		TradingTrendChart:TradingTrendChart,
		agentRankingChart:agentRankingChart,
		merchantsRankingChart:merchantsRankingChart,
		selectPeriod:selectPeriod,
		showTradingInfo:showTradingInfo,
	}
})();
//入口
var index=(function () {
	var init=function () {
		handleEvns.TradingTrendChart(orderEchart(6));
		handleEvns.agentRankingChart(agentEchart(6));
		handleEvns.merchantsRankingChart(merchartEchart(6));
		handleEvns.selectPeriod();
		//handleEvns.showTradingInfo();
	}();
})();
 
 


   

                                  
            