package com.qiyu.paymanager.controller;


import com.qiyu.data.vo.*;
import com.qiyu.paymanager.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by KK on 2016/6/1.
 */
@Controller
@RequestMapping("/merchant")
public class MerchantController  {
    @Autowired
    private MerchantService merchantSer;

    @RequestMapping(value = "/index")
    public String merchantPage(){
        return "merchant/merchant_list";
    }

    /**
     * 商家列表
     * @param merchantName
     * @param curPage
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/merchants")
    @ResponseBody
    public Map  merchantList(@RequestParam(defaultValue = "") String merchantName, @RequestParam(defaultValue = "1") int curPage,@RequestParam(defaultValue = "10") int pageSize){
        Map<String,Object> result=new HashMap<>();
        try{
            MyPage<MerchantVo> page= merchantSer.findMerchant(merchantName,curPage,pageSize);
            result.put("data",page.getList());
            result.put("totalRows",page.getTotalNum());
            result.put("success",true);
            result.put("curPage",curPage);
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 商家信息
     * @param model
     * @param merchantId
     * @return
     */
    @RequestMapping(value = "/datail")
    public String getmerchant(Model model,@RequestParam(defaultValue = "") Long merchantId){
        MerchantVo merchant = merchantSer.findMerchantById(merchantId);
        model.addAttribute("merchant",merchant);
        return "merchant/merchant_detail";
    }

    /**
     * 门店信息
     * @param merchantId
     * @param restaurantName
     * @param curPage
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/restaurantList")
    @ResponseBody
    public Map RestaurantPage(@RequestParam(defaultValue = "") Long merchantId,@RequestParam(defaultValue = "") String restaurantName,
                           @RequestParam(defaultValue = "1") int curPage,@RequestParam(defaultValue = "15") int pageSize){
        Map<String,Object> result=new HashMap<>();
        try{
            MyPage<RestaurantVo> page= merchantSer.findRestaurants(merchantId,restaurantName,curPage,pageSize);
            result.put("data",page.getList());
            result.put("totalRows",page.getTotalNum());
            result.put("success",true);
            result.put("curPage",curPage);
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

}
