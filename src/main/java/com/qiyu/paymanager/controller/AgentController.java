package com.qiyu.paymanager.controller;


import com.qiyu.data.Msg;
import com.qiyu.data.entity.Agent;
import com.qiyu.data.vo.AgentVo;
import com.qiyu.data.vo.MerchantVo;
import com.qiyu.data.vo.MyPage;
import com.qiyu.paymanager.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by KK on 2016/5/25.
 */
@Controller
@RequestMapping("/agent")
public class AgentController {
    @Autowired
    private AgentService agentSer;

    @RequestMapping(value = "/index")
    public String agentPage() {
        return "agent/agent_list";
    }

    @RequestMapping("/agents")
    @ResponseBody
    public Map agentList( @RequestParam(defaultValue = "") String agentName,@RequestParam(defaultValue = "1") int curPage,@RequestParam(defaultValue = "10") int pageSize) {
        Map<String,Object> result=new HashMap<>();
        try{
            MyPage<AgentVo> page = agentSer.findAgent(agentName, curPage, pageSize);
            result.put("data",page.getList());
            result.put("totalRows",page.getTotalNum());
            result.put("success",true);
            result.put("curPage",curPage);
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/datail")
    public String merchantPage(Model model, @RequestParam(defaultValue = "") Long id) {
        Agent agent = agentSer.findAgentById(id);
        model.addAttribute("agent", agent);
        return "agent/agent_detail";
    }

    @RequestMapping("/merchants")
    @ResponseBody
    public Map merchantList( @RequestParam(defaultValue = "") Long agentid,@RequestParam(defaultValue = "1") int curPage,@RequestParam(defaultValue = "10") int pageSize) {
        Map<String,Object> result=new HashMap<>();
        try{
            MyPage<MerchantVo> page = agentSer.findMerchants(agentid,curPage,pageSize);
            result.put("data",page.getList());
            result.put("totalRows",page.getTotalNum());
            result.put("success",true);
            result.put("curPage",curPage);
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    @RequestMapping("/updateReturnPer")
    @ResponseBody
    public Msg updateReturnPer(AgentVo vo) {
        try {
            return agentSer.updateReturnPer(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Msg.createFailMsg("保存失败！");
    }
}
