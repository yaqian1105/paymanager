package com.qiyu.paymanager.service;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.series.Line;
import com.qiyu.common.utils.DateUtils;
import com.qiyu.data.dao.PlatformOperationalDao;
import com.qiyu.data.vo.OptionVo;
import com.qiyu.data.vo.PlatformOperationalVo;
import com.qiyu.paymanager.util.DateUtil;
import com.qiyu.paymanager.util.EchartUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/***
 * 获取平台统计数据
 * @author yq
 *
 */
@Service
@Transactional
public class PlatformOperationalService implements Serializable {

	@Autowired
	private PlatformOperationalDao platformOperationalDao;

/************************************************************************************    	数据汇总		********************************************************************************/

	/**
	 * 获取今日汇总(交易额，订单数)及商户总数
	 *
	 * @return
	 */
	public PlatformOperationalVo getGather() {
		PlatformOperationalVo merchant = platformOperationalDao.getMerchantGather();
		PlatformOperationalVo today = platformOperationalDao.getTodayGather();
		today.setRestaurantCount(merchant.getRestaurantCount());
		return today;
	}

	/***	--------------------------------------------- 封装坐标量	---------------------------------------------   */
	/**
	 * agent排行统计数据
	 * @param day
	 * @param title
	 * @return
	 */

	public OptionVo getAgentOption(int day,String title) {
		List<PlatformOperationalVo> operational = platformOperationalDao.getAgentList(day);
		OptionVo option =new OptionVo();
		List<Object> series = new ArrayList<>();
		List<Object> yAxis = new ArrayList<>();
		if(operational!=null && operational.size()> 0){
			for(PlatformOperationalVo data : operational){
				series.add(data.getMoney());
				yAxis.add(data.getAgentName());
			}
		};
		option.setTitle(title);
		option.setSeries(series);
		option.setyAxis(yAxis);
		return option;
	}

	/**
	 * 商家排行统计数据
	 * @param day
	 * @param title
	 * @return
	 */
	public OptionVo getMerchantOption(int day,String title) {
		List<PlatformOperationalVo> operational = platformOperationalDao.getMerchantList(day);
		OptionVo option =new OptionVo();
		List<Object> series = new ArrayList<>();
		List<Object> yAxis = new ArrayList<>();
		if(operational!=null && operational.size()> 0){
			for(PlatformOperationalVo data : operational){
				series.add(data.getMoney());
				yAxis.add(data.getMerchantName());
			}
		};
		option.setTitle(title);
		option.setSeries(series);
		option.setyAxis(yAxis);
		return option;
	}

	/**
	 * 代理商交易流水报表
	 * @param day
	 * @param title
	 * @return
	 */
	public OptionVo getOrderOption(int day, String title) {
		List<PlatformOperationalVo> operational = platformOperationalDao.getOrderList(day);
		String beginDate = DateUtil.getDayStr(DateUtil.getDateBefore(new Date(),day));
		String endDate =  DateUtil.getDayStr(new Date());
		OptionVo option = new OptionVo();
		List<Object> series = new ArrayList<>();
		List<Object> xAxis = new ArrayList<>();
		while(DateUtil.getDaySub(beginDate,endDate)>=0){
			if (operational != null && operational.size()> 0) {
				PlatformOperationalVo data = operational.get(0);
				if(DateUtil.getDaySub(beginDate,data.getDayStr())==0){
					series.add(data.getMoney());
					xAxis.add(data.getDayStr());
					for(int i=1; i<operational.size();i++){
						data = operational.get(i);
						setNullValue(beginDate, data.getDayStr(), series, xAxis);
						series.add(data.getMoney());
						xAxis.add(data.getDayStr());
						beginDate = data.getDayStr();
					}
					beginDate = DateUtil.getAfterDayDate(beginDate,"1");
					continue;
				}
			}
			series.add(0);
			xAxis.add(beginDate);
			beginDate = DateUtil.getAfterDayDate(beginDate,"1");
		}
		option.setTitle(title);
		option.setSeries(series);
		option.setxAxis(xAxis);
		return option;
	}


	//填充空缺
	private void setNullValue(String beginDate,String endDate, List<Object> series, List<Object> xAxis){
		if(DateUtil.getDaySub(beginDate,endDate)>1){
			beginDate = DateUtil.getAfterDayDate(beginDate,"1");
			series.add(0);
			xAxis.add(beginDate);
			setNullValue(beginDate,endDate,series,xAxis);
		}
	}

	// 商家排行统计数据详情
	public List<PlatformOperationalVo> getMerchantListDetail(int day) {
		return platformOperationalDao.getMerchantListDetail(day);
	}


	// 代理商排行统计数据详情
	public List<PlatformOperationalVo> getAgentListDetail(int day) {
		return platformOperationalDao.getAgentListDetail(day);
	}
}
