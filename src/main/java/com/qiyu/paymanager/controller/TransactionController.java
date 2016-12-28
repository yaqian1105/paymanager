package com.qiyu.paymanager.controller;

/**
 * Created by Administrator on 2016/11/30.
 */

import com.qiyu.data.vo.MyPage;
import com.qiyu.data.vo.TransactionInfoVo;
import com.qiyu.paymanager.service.TransactionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    private TransactionInfoService transactionInfoService;
    @RequestMapping(value = "/index")
    public String merchantPage(){
        return "transaction/transaction_list";
    }

    @RequestMapping(value = "/transactionInfos")
    @ResponseBody
    public Map withdrawls(@RequestParam(defaultValue = "")String smzfMsgId, @RequestParam(defaultValue = "1") int curPage, @RequestParam(defaultValue = "20") int pageSize){
        Map<String,Object> result=new HashMap<>();
        try{
            MyPage<TransactionInfoVo> page= transactionInfoService.transactionInfoList(smzfMsgId, curPage, pageSize);
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
