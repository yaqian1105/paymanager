package com.qiyu.data.dao;

import com.qiyu.common.data.ObjectMapper;
import com.qiyu.data.vo.AgentPayWithdrawRecordVo;
import com.qiyu.data.vo.MyPage;
import com.qiyu.data.vo.TransactionInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionInfoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 交易记录
     * @param smzfMsgId
     * @param curPage
     * @param pageSize
     * @return
     */
    public MyPage<TransactionInfoVo> transactionInfoList(String smzfMsgId, int curPage, int pageSize) {
        StringBuilder sql = new StringBuilder();
        StringBuilder sqlEle = new StringBuilder();
        StringBuilder sqlTotal = new StringBuilder();
        sqlTotal.append("select count(1) from (");
     /*   sqlEle.append("select tai.id, tai.agent_id, r.name as rest_name, m.name as mer_name, tai.req_msg_id, tai.smzf_msg_id, tai.transaction_number, tai.total_amount, tai.paid_amount, pci.channel_name, tai.channel_no, tai.service_charge, tai.operator " );
        sqlEle.append(" from transaction_info tai LEFT JOIN restaurant r on r.id = tai.restaurant_id LEFT JOIN merchant m on m.id = tai.merchant_id  LEFT JOIN pay_channel_information pci on pci.config_no = tai.chanel_type where 1=1 ");*/
        sqlEle.append("select tai.*, pci.channel_name from transaction_info tai  LEFT JOIN pay_channel_information pci on pci.config_no = tai.channel_type where 1=1" );

        if(smzfMsgId!=null && !smzfMsgId.equals("")){
            sql.append("and (tai.req_msg_id like '%"+smzfMsgId+"%' or tai.smzf_msg_id like '%"+smzfMsgId+"%')" );
        }
        sqlEle.append(sql.toString());
        sqlTotal.append(sqlEle.toString() +" )t");

        Integer num= jdbcTemplate.queryForObject(sqlTotal.toString(), Integer.class);
        MyPage<TransactionInfoVo> page=new MyPage<TransactionInfoVo>();
        page.setTotalNum(num);
        List<TransactionInfoVo> list= jdbcTemplate.query(sqlEle.toString(),new ObjectMapper(TransactionInfoVo.class));
        page.setList(list);
        return page;
    }
}
