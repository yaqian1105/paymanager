package com.qiyu.data.vo;


import com.qiyu.common.data.IdLongEntity;
import com.qiyu.common.utils.DateUtil;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

public class AgentPayWithdrawRecordVo  implements Serializable {
    /**
     * 处理状态
     */
    //未处理
    public static final int STATUS_PAY_APPLY=0;
    //已导出/处理中
    public static final int STATUS_PAY_HANDLE=1;
    //完成
    public static final int STATUS_PAY_SUCCESS=2;
    //取消
    public static final int STATUS_PAY_FAIL=3;
    private Long id;
    /**
     * 代理商
     */
    private Long agentId;
    private String agentName;
    /**
     * 订单流水号
     */
    private String reqMsgId;
    /**
     * 平台流水号
     */
    private String smzfMsgId;
    /**
     * 提现金额
     */
    private Double money;

    /**
     * 操作人
     */
    private String operator;
    /**
     * 提现成功日期
     */
    private Date paySuccessTime;
    /**
     * 打款金额
     */
    private Double payMoney;
    /**
     * 收款银行
     */
    private String brank;
    /**
     * 支行
     */
    private String branch;
    /**
     * 收款卡号
     */
    private String cardNumber;
    /**
     * 账户名
     */
    private String accountName;
    /**
     * 后台显示状态（0，不可见  1，可见）
     */
    private Integer showNo;
    /**
     * 处理状态 默认0(0=未处理|1=已导出|3=完成|-1=取消)
     */
    private Integer handleStatus;
    private Date createAt;
    private String creatAtStr;
    private Date updateAt;
    private String moneyStr;

    private String handleStatusStr;

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public String getReqMsgId() {
        return reqMsgId;
    }

    public void setReqMsgId(String reqMsgId) {
        this.reqMsgId = reqMsgId;
    }

    public String getSmzfMsgId() {
        return smzfMsgId;
    }

    public void setSmzfMsgId(String smzfMsgId) {
        this.smzfMsgId = smzfMsgId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getPaySuccessTime() {
        return paySuccessTime;
    }

    public void setPaySuccessTime(Date paySuccessTime) {
        this.paySuccessTime = paySuccessTime;
    }

    public Double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Double payMoney) {
        this.payMoney = payMoney;
    }

    public String getBrank() {
        return brank;
    }

    public void setBrank(String brank) {
        this.brank = brank;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Integer getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(Integer handleStatus) {
        this.handleStatus = handleStatus;
    }

    public Integer getShowNo() {
        return showNo;
    }

    public void setShowNo(Integer showNo) {
        this.showNo = showNo;
    }

    public String getMoneyStr() {
        if(money!=0) {
            moneyStr = money + "元";
        }
        return moneyStr;
    }

    public void setMoneyStr(String moneyStr) {
        this.moneyStr = moneyStr;
    }

    public String getHandleStatusStr() {
        if(handleStatus==STATUS_PAY_HANDLE){
            handleStatusStr = "处理中";
        }else if(handleStatus==STATUS_PAY_APPLY){
            handleStatusStr = "未处理";
        }else if(handleStatus==STATUS_PAY_FAIL){
            handleStatusStr = "已取消";
        }else if(handleStatus==STATUS_PAY_SUCCESS){
            handleStatusStr = "已成功";
        }
        return handleStatusStr;
    }

    public void setHandleStatusStr(String handleStatusStr) {
        this.handleStatusStr = handleStatusStr;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getCreatAtStr() {
        if(createAt!=null){
            creatAtStr = DateUtil.getTimeStr(createAt);
        }
        return creatAtStr;
    }

    public void setCreatAtStr(String creatAtStr) {
        this.creatAtStr = creatAtStr;
    }
}
