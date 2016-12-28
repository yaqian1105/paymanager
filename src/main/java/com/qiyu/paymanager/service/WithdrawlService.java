package com.qiyu.paymanager.service;


import com.qiyu.data.Msg;
import com.qiyu.data.dao.WithdrawlDao;
import com.qiyu.data.entity.AgentPayWithdrawRecord;
import com.qiyu.data.entity.RestaurantStaff;
import com.qiyu.data.repository.AgentPayWithdrawRecordRepository;
import com.qiyu.data.vo.*;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class WithdrawlService extends BaseService{
    private Logger logger = LoggerFactory.getLogger(WithdrawlService.class);

    @Autowired
    private WithdrawlDao withdrawlDao;
    @Autowired
    private AgentPayWithdrawRecordRepository agentPayWithdrawRecordRepository;
    /**
     * 支付提现列表
     * @param agentId
     * @param handleStatus
     * @param curPage
     * @param pageSize
     * @return
     */
    public MyPage<AgentPayWithdrawRecordVo> withdrawlPayList(String reqMsgId,Long agentId,Integer handleStatus,int curPage,int pageSize) {
        return withdrawlDao.withdrawlPayList(reqMsgId, agentId, handleStatus, curPage, pageSize);
    }

    /**
     * 对提现订单进行处理
     * @param vo
     * @return
     */
    @Transactional
    public Msg updateWithdraw(AgentPayWithdrawRecordVo vo) {
        Date now = new Date();
        AgentPayWithdrawRecord withdrawRecord = agentPayWithdrawRecordRepository.findOne(vo.getId());
        if(vo.getShowNo() == 0) {
            withdrawRecord.setShowNo(vo.getShowNo());
        }else{
            if (vo.getHandleStatus() == 2) {
                withdrawRecord.setPayMoney(withdrawRecord.getMoney());
                withdrawRecord.setPaySuccessTime(now);
            }
            withdrawRecord.setHandleStatus(vo.getHandleStatus());
            withdrawRecord.setOperator(getCurrentUser().getUserName());
            withdrawRecord.setUpdateAt(new Date());
        }
        agentPayWithdrawRecordRepository.save(withdrawRecord);
        return Msg.createSucMsg();
    }

    /**
     * 导出列表
     * @return
     */
    public List<Map<String,Object>> withdrawlPayListAll() {
        return withdrawlDao.withdrawlPayListAll();
    }
}