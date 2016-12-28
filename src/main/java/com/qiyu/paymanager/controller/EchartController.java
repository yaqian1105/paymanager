package com.qiyu.paymanager.controller;

import com.github.abel533.echarts.Option;
import com.qiyu.common.result.ModelResult;
import com.qiyu.common.utils.MediaTypes;
import com.qiyu.data.vo.OptionVo;
import com.qiyu.data.vo.PlatformOperationalVo;
import com.qiyu.paymanager.service.PlatformOperationalService;
import com.qiyu.paymanager.util.EchartUtil;
import org.apache.commons.collections.map.ListOrderedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * 支付平台Echarts数据
 */
@Controller
@RequestMapping("/echart")
public class EchartController {

@Autowired
private PlatformOperationalService platformOperationalService;

    /**
     * 首页
     * @return
     */
    @RequestMapping(value = "/welcome", method = RequestMethod.GET ,produces = MediaTypes.JSON_UTF_8)
    public String welcome(Model model){
        return "index/welcome";
    }
    /**
     * 统计今日数据及商家数
     * @return
     */
    @RequestMapping(value = "todayEchart",method = RequestMethod.GET )
    @ResponseBody
    public ModelResult todayEchart(){
        ModelResult result = new ModelResult();
        try {
            PlatformOperationalVo platformOperationalVo = platformOperationalService.getGather();
            result.isSuccess();
            result.setData(platformOperationalVo);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 交易流水
     * @param day
     * @return
     */
    @RequestMapping(value = "orderEchart",method = RequestMethod.GET )
    @ResponseBody
    public ModelResult orderEchart(int day, String title){
        ModelResult result = new ModelResult();
        try {
            OptionVo option = platformOperationalService.getOrderOption(day,title);
            result.isSuccess();
            result.setData(option);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     *
     * @param day
     * @param title
     * @return
     */
    @RequestMapping(value = "agentEchart",method = RequestMethod.GET )
    @ResponseBody
    public ModelResult agentEchart(int day, String title){
        ModelResult result = new ModelResult();
        try {
            OptionVo option = platformOperationalService.getAgentOption(day,title);
            result.isSuccess();
            result.setData(option);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 商家数据
     * @param day
     * @param title
     * @return
     */
    @RequestMapping(value = "merchartEchart",method = RequestMethod.GET )
    @ResponseBody
    public ModelResult MerchartEchart(int day, String title){
        ModelResult result = new ModelResult();
        try {
            OptionVo option = platformOperationalService.getMerchantOption(day,title);
            result.isSuccess();
            result.setData(option);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /***************************************      查看详情      *********************************/
    @RequestMapping(value = "/agentDetailPage")
    public String agentPage() {
        return "index/agent_detail";
    }

    @RequestMapping(value = "/merchartDetailPage")
    public String merchartPage() {
        return "index/merchart_detail";
    }

    @ResponseBody
    @RequestMapping("/agentDetail")
    public Map agentOption(int day){
        Map<String,Object> result=new HashMap<>();
        try{
        List<PlatformOperationalVo> operational = platformOperationalService.getAgentListDetail(day);
            result.put("data",operational);
            result.put("success",true);
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    @ResponseBody
    @RequestMapping("/merchartDetail")
    public Map merchartOption(int day){
        Map<String,Object> result=new HashMap<>();
        try{
            List<PlatformOperationalVo> operational = platformOperationalService.getMerchantListDetail(day);
            result.put("data",operational);
            result.put("success",true);
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

}
