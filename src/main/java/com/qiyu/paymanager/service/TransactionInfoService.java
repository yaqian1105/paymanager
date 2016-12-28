package com.qiyu.paymanager.service;


import com.qiyu.data.Msg;
import com.qiyu.data.dao.TransactionInfoDao;
import com.qiyu.data.entity.TransactionInfo;
import com.qiyu.data.repository.TransactionInfoRepo;
import com.qiyu.data.vo.MyPage;
import com.qiyu.data.vo.TransactionInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransactionInfoService extends BaseService{
    private Logger logger = LoggerFactory.getLogger(TransactionInfoService.class);

    @Autowired
    private TransactionInfoDao transactionInfoDao;

    @Autowired
    private TransactionInfoRepo transactionInfoRepo;
    /**
     * 交易列表
     * @param smzfMsgId
     * @param curPage
     * @param pageSize
     * @return
     */
    public MyPage<TransactionInfoVo> transactionInfoList(String smzfMsgId, int curPage, int pageSize) {
        return transactionInfoDao.transactionInfoList(smzfMsgId, curPage, pageSize);
    }

    /**
     * 创建
     * @param transactionInfo
     */
    public Msg save(TransactionInfo transactionInfo){

       /* transactionInfo.setCreateAt(new Date());
        transactionInfo.setSmzfMsgId("1481882097381NhSvvn0P9oWQ");
        transactionInfo.setReqMsgId("148187660704X0DM2U6LW1go");
        transactionInfo.setRestaurantId(112l);
        transactionInfo.setRestaurantName("旗鱼餐馆");
        transactionInfo.setAgentId(12l);
        transactionInfo.setBuyerId(null);
        transactionInfo.setChannelType("101");
        transactionInfo.setMerchantId(105l);
        transactionInfo.setMerchantName("旗鱼餐馆");
        transactionInfo.setChannelNo("101");
        transactionInfo.setTotalAmount(10);
        transactionInfo.setCommission(10);
        transactionInfo.setOrderAmount(1);
        transactionInfo.setServiceCharge(0.03);
        transactionInfo.setMerchantCode("2016111704678504");
        transactionInfo.setStatus("1");
        transactionInfo.setTransactionNumber(null);
        transactionInfoRepo.save(transactionInfo);*/
        return Msg.createSucMsg();
    }
}