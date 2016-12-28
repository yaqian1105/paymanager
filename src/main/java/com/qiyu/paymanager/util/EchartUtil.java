package com.qiyu.paymanager.util;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.*;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.style.TextStyle;
import com.qiyu.data.vo.OptionVo;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 百度Echart 帮助类
 * @author king
 *
 */
public class EchartUtil {
	
	/**
	 * 传入 Map 返回图表OPtion
	 * @param title  图标标题
	 * @param legend_Data  图标图例
	 * @param YUnit  数据单位
	 * @param xAxis_series_Map  OptionVo
	 * @return
	 */
	public static Option getLineOptionOfMap(String title, String xAxisName, String yAxisName, OptionVo xAxis_series_Map, String legend_Data) {
		/** 横坐标数组 */
		List<Object> xAxisData;
		/** 数据 数组 */
		List<Object> data;
		
		xAxisData = new ArrayList<Object>(xAxis_series_Map.getxAxis());
		data = new ArrayList<Object>(xAxis_series_Map.getSeries());
	
		List<Line> LineList = new ArrayList<Line>();
		LineList.add(getSeriesLine(legend_Data,data));
		Option option = new Option();
		option = getLineOPtion(title, xAxisName, yAxisName,true,xAxisData, LineList, legend_Data);
		
		return option;
	}
	
    /**
     * 传入List<Map<String,Object>> 返回折线图
     * @param title  图表标题
     * @param xAxisName x轴名称
     * @param yAxisName y轴名称
     * @param xAxis_series_List	数据
     * @param keyName	x轴（分类轴在Map中的key名称）
     * @param legend_Data 图例 (图例的个数，及顺序必须与传入的 List<Map>中的key 顺序一致，不包括x轴的key)
     * @return
     * <br/>
     * 例子：<br/>
     * {invest_user_account=13,invest_user=13, time=2015年4月}<br/>
     * keyName : time<br/>
     * legend_Date : 统计A 统计B<br/>
     */
	public static Option getLineOptionOfListMap(String title, String xAxisName, String yAxisName, List<Map<String, Object>> xAxis_series_List, String keyName, String... legend_Data) {
		/** 横坐标数组 */
		List<Object> xAxisData = new ArrayList<Object>();
		/** 数据 Map */
		Map<Object,List<Object>> lineMap = new HashMap<Object, List<Object>>();
		
		//遍历List<Map<String,Object>>
		for(Map<String,Object> map : xAxis_series_List){
			//获取map的 key，并遍历
			List<Object> map_key = new ArrayList<Object>(map.keySet());
			for(int i=0;i<map_key.size();i++){
				//如果当前的 key 是x轴（分类轴），则放入x轴list中
				if(keyName.equals(map_key.get(i))){
					xAxisData.add(map.get(map_key.get(i)));
				//如果当前的 key 不是x轴 （值轴），则根据key放入相对应的list中
				}else{
					if(lineMap.get(map_key.get(i))==null){
						List<Object> tempList = new ArrayList<Object>();
						tempList.add(map.get(map_key.get(i)));
						lineMap.put(map_key.get(i),tempList);
					}else{
						lineMap.get(map_key.get(i)).add(map.get(map_key.get(i)));
					}
				}
			}
		}
		
		//将存入lineMap中的 值轴放入List中
		List<List<Object>> lineList = new ArrayList<List<Object>>(lineMap.values());
		List<Line> LineList = new ArrayList<Line>();
		
		//图例的个数，及顺序必须与传入的 List<Map>中的key 顺序一致
		for(int i=0;i<legend_Data.length;i++){			
			LineList.add(getSeriesLine(legend_Data[i],lineList.get(i)));
		}
		Option option = new Option();
		option = getLineOPtion(title, xAxisName, yAxisName,true,xAxisData, LineList, legend_Data);
		return option;
	}
	
    /**
	 * 返回 普通的 折线图 + 柱状图  option
	 * 参照 echarts 普通折线图demo
     * @param title  图标标题 默认居中显示
     * @param xAxisName 横坐标名称
     * @param yAxisName 纵坐标名称
     * @param isScale 是否 脱离0值比例，放大聚焦到最终_min，_max区间 
     * @param xAxisData 横轴目录数据
     * @param LineList 显示数据
     * @param legend_Data 图标图例  （注：如启用legend，系列名称 line.name 将被legend.data索引相关 ）
     * @return
     */
	public static Option getLineOPtion(String title, String xAxisName, String yAxisName, boolean isScale, List<Object> xAxisData, List<Line> LineList, String... legend_Data){
		//创建option对象
		Option option = new Option();
		
		//1.设置图标标题，并居中显示   2.设置平台名称
		TextStyle textStyle = new TextStyle();
		textStyle.setFontSize(15);
		option.title().text(title).x(X.center).textStyle(textStyle)
					  .subtext("190.com");
		
		//提示框，鼠标悬浮交互时的信息提示 默认 axis
		option.tooltip().trigger(Trigger.axis);//可选为：'item' | 'axis'
		
		//图例，每个图表最多仅有一个图例 并显示于底部
		option.legend().data(legend_Data).y(Y.bottom);
		
		//配置工具栏，统一默认显示,如果有多条线，启用堆积功能
		option.toolbox().show(true);
		if(LineList.size()>2){
			option.toolbox().feature(Tool.mark, Tool.dataView, new MagicType(Magic.line, Magic.bar, Magic.stack, Magic.tiled), Tool.restore, Tool.saveAsImage);
		}else{
			option.toolbox().feature(Tool.mark, Tool.dataView, new MagicType(Magic.line, Magic.bar), Tool.restore, Tool.saveAsImage);
		}
		//启用拖拽重计算特性
		option.calculable(true);
		
		//横轴 x轴  为类目录
		CategoryAxis categoryAxis = new CategoryAxis();
		categoryAxis.data(xAxisData.toArray()).name(xAxisName).boundaryGap(false); //空白处置顶处理
		option.xAxis(categoryAxis);
		
		//纵轴 y轴 为值轴
		option.yAxis(new ValueAxis().name(yAxisName).scale(isScale));
		
		//series 驱动图表生成的数据内容数组
		option.series().addAll(LineList);
		
		return option;
	}
	
	/**
	 * 返回数据 line
	 * @param name 系列名称  鼠标移动到数据点上显示
	 * @param data 系列数据<br/>
	 * 默认 type ： line，如需设置markPoint markLine 等其他属性请参照api自行配置
	 * @return
	 */
	public static Line getSeriesLine(String name, List<Object> data){
		Line line = new Line();
		//系列名称  图表类型   数据
		line.name(name).type(SeriesType.line).smooth(true).data(data.toArray()).stack("总量");
		return line;
	}
	
    /**
     * 给 line 设置 标线 标注，参数为空则不设置
     * @param line
     * @param pointMaxName  标注最大值
     * @param pointMinName  标注最小值
     * @param lineAvgName   标线平均值
     * @param lineMaxName	标线最大值	
     * @param lineMinName	标线最小值
     * @return
     */
	public static Line setMarkPointAndMarkLine(Line line, String pointMaxName, String pointMinName, String lineAvgName, String lineMaxName, String lineMinName){
		List<Map<String,String>> markPoint = new ArrayList<Map<String,String>>(); //标注
		List<Map<String,String>> markLine = new ArrayList<Map<String,String>>();  //标线
		if(StringUtils.isNotBlank(pointMaxName)){
			Map<String,String> map = new HashMap<String, String>();
			map.put("type","max");
			map.put("name",pointMaxName);
			markPoint.add(map);
		}
		
		if(StringUtils.isNotBlank(pointMinName)){
			Map<String,String> map = new HashMap<String, String>();
			map.put("type","min");
			map.put("name",pointMinName);
			markPoint.add(map);
		}
		
		if(StringUtils.isNotBlank(lineAvgName)){
			Map<String,String> map = new HashMap<String, String>();
			map.put("type","average");
			map.put("name",lineAvgName);
			markLine.add(map);
		}
		
		if(StringUtils.isNotBlank(lineMaxName)){
			Map<String,String> map = new HashMap<String, String>();
			map.put("type","max");
			map.put("name",lineMaxName);
			markLine.add(map);
		}
		
		if(StringUtils.isNotBlank(lineMinName)){
			Map<String,String> map = new HashMap<String, String>();
			map.put("type","min");
			map.put("name",lineMinName);
			markLine.add(map);
		}
		
		line.markPoint().data(markPoint.toArray());
		line.markLine().data(markLine.toArray());
		return line;
	}
	
	/**
	 * TODO
	 * 获取饼状图option
	 * @return
	 */
	public Option getPieOption(String title, String...legend_Data){
		Option option = new Option();
		//1.设置图标标题，并居中显示   2.设置平台名称
		TextStyle textStyle = new TextStyle();
		textStyle.setFontSize(15);
		option.title().text(title).x(X.center).textStyle(textStyle)
					  .subtext("190.com");
		//2.提示框
		option.tooltip().trigger(Trigger.item);//可选为：'item' | 'axis'
		//3.图例，每个图表最多仅有一个图例 并显示于底部
		option.legend().data(legend_Data).y(Y.bottom);
		//4.驱动图表生成的数据内容数组
		option.series();
		return option;
	}
	
}
