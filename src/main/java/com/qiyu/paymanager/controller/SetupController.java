package com.qiyu.paymanager.controller;

import com.qiyu.data.Msg;
import com.qiyu.data.entity.GlobalConstant;
import com.qiyu.data.vo.GlobalConstantVo;
import com.qiyu.data.vo.MerchantVo;
import com.qiyu.paymanager.constant.Constants;
import com.qiyu.paymanager.service.SetupService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by zyq on 2017/1/9.
 */
@Controller
@RequestMapping("/setup")
public class SetupController {
    @Autowired
    private SetupService setupService;

    /**
     * 页面跳转
     * @param model
     * @return
     */
    @RequestMapping(value = "/index")
    public String merchantPage(Model model){
        //获取代理商结算日
        String accountDay = Constants.GLOBAL_ACCOUNT_DAY;
        GlobalConstant globalConstant = setupService.findByConstantName(accountDay);
        model.addAttribute("accountDay",globalConstant);
        return "setup/setup_index";
    }

    /**
     * 查询商户信息
     * @param type
     * @param simpleName
     * @return
     */
    @RequestMapping(value = "/merchantList")
    @ResponseBody
    public Map merchantList(@RequestParam(defaultValue = "") String type,@RequestParam(defaultValue = "") String simpleName){
        Map<String,Object> result=new HashedMap();
        try {
            List<MerchantVo> list= setupService.findMerchant(type,simpleName);
            result.put("data",list);
            result.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * POS应用设置
     * @param merchantIds
     * @param isPosApplication
     * @return
     */
    @RequestMapping(value = "/updatePosApplication")
    @ResponseBody
    public Msg updatePosApplication (@RequestParam(defaultValue = "") List<Long> merchantIds, @RequestParam(defaultValue = "0") int isPosApplication){
        try {
            return setupService.updatePosApplication(merchantIds,isPosApplication);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Msg.createFailMsg("保存失败！");
    }

    /**
     * 修改代理商结算日设置
     * @return
     */
    @RequestMapping(value = "/editAccountDay")
    @ResponseBody
    public Msg editAccountDay(GlobalConstantVo globalConstantVo){
        try {
            return setupService.updateAccountDay(globalConstantVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Msg.createFailMsg("保存失败！");
    }

}
