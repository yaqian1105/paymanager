package com.qiyu.paymanager.controller;


import com.qiyu.common.annotation.ServiceExceptionRet;
import com.qiyu.common.utils.MediaTypes;
import com.qiyu.data.entity.TransactionInfo;
import com.qiyu.paymanager.service.TransactionInfoService;
import com.qiyu.paymanager.util.DateUtil;
import com.qiyu.data.Msg;
import com.qiyu.data.vo.*;
import com.qiyu.paymanager.service.WithdrawlService;
import com.qiyu.paymanager.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/withdrawl")
public class WithdrawlController {
    @Autowired
    private WithdrawlService withdrawlService;

    @Autowired
    private TransactionInfoService transactionInfoService;

    @RequestMapping(value = "/index")
    public String merchantPage(){
        return "withdrawl/withdrawl_list";
    }

    /**
     * 提现列表
     * @param agentId
     * @param reqMsgId
     * @param curPage
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/withdrawls")
    @ResponseBody
    public Map  withdrawls(@RequestParam(defaultValue = "")String reqMsgId, @RequestParam(defaultValue = "") Long agentId,@RequestParam(defaultValue = "") Integer handleStatus, @RequestParam(defaultValue = "1") int curPage,@RequestParam(defaultValue = "10") int pageSize){
        Map<String,Object> result=new HashMap<>();
        try{
            MyPage<AgentPayWithdrawRecordVo> page= withdrawlService.withdrawlPayList(reqMsgId, agentId, handleStatus, curPage, pageSize);
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
     * 更新提现记录
     * @param vo
     * @return
     */
    @RequestMapping("/updateWithdraw")
    @ResponseBody
    public Msg updateWithdraw(AgentPayWithdrawRecordVo vo) {
        try {
            return withdrawlService.updateWithdraw(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Msg.createFailMsg("保存失败！");
    }


    @RequestMapping("exportWithdrawlExcel")
    public ResponseEntity<byte[]> exportWithdrawlExcel(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException{

        List<Map<String,Object>> result = withdrawlService.withdrawlPayListAll() ;

        String[] header = {"序号","订单编号","申请时间","代理商","收款账号","银行","开户名","提现金额"};
        String[] cols = { "id","req_msg_id","create_at" ,"agent_name","card_number", "brank","account_name","money"};
        String now = DateUtil.getDays();
        String fileName= now+"_apply_for_record.xls";
        ResponseEntity<byte[]> exportData = ExcelUtil.getExportExcelFileData(request, response, header, cols, fileName, result);
        if (exportData != null) {
            AgentPayWithdrawRecordVo vo = new AgentPayWithdrawRecordVo();
            vo.setHandleStatus(1);
            vo.setShowNo(1);
            for (Map<String, Object> map : result) {
                vo.setId(Long.valueOf(map.get("id").toString()));
                withdrawlService.updateWithdraw(vo);
            }
        }
        return exportData;

    }
/*
    @RequestMapping("exportWithdrawlExcel1")
    @ResponseBody
    public Msg exportWithdrawlExcel1(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException {

        List<Map<String, Object>> result = withdrawlService.withdrawlPayListAll();

        String[] header = {"序号", "订单编号", "申请时间", "代理商", "收款账号", "银行", "开户名", "提现金额"};
        String[] cols = {"id", "req_msg_id", "create_at", "agent_name", "card_number", "brank", "account_name", "money"};
        String now = DateUtil.getDays();
        String fileName = now + "提现申请记录.xls";
        ResponseEntity<byte[]> exportData = ExcelUtil.getExportExcelFileData(request, response, header, cols, fileName, result);
        if (exportData == null) {
            return Msg.createFailMsg("操作失败！请稍后重试");
        } else {
            AgentPayWithdrawRecordVo vo = new AgentPayWithdrawRecordVo();
            vo.setHandleStatus(1);
            vo.setShowNo(1);
            for (Map<String, Object> map : result) {
                vo.setId(Long.valueOf(map.get("id").toString()));
                withdrawlService.updateWithdraw(vo);
            }
        }
        return Msg.createSucMsg("操作成功");
    }*/
    @ResponseBody
    @ServiceExceptionRet
    @RequestMapping(value = "saveTrans", method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
    public Msg save(TransactionInfo transactionInfo){
        try{
        return transactionInfoService.save(transactionInfo);
        } catch (Exception e) {
        e.printStackTrace();
    }
        return Msg.createFailMsg("保存失败！");
    }
}
