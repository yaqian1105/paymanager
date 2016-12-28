package com.qiyu.data.entity;


import com.qiyu.common.data.IdLongEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by lizeyu on 2016/5/7.
 */
@Entity
@Table(name = "agent_pay_withdraw_record")
public class AgentPayWithdrawRecord extends IdLongEntity {

    /**
     * 代理商
     */
    private Long agentId;
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

    public Integer getShowNo() {
        return showNo;
    }

    public void setShowNo(Integer showNo) {
        this.showNo = showNo;
    }

    public Integer getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(Integer handleStatus) {
        this.handleStatus = handleStatus;
    }
}
