package com.qiyu.data.dao;

import com.qiyu.common.data.ObjectMapper;
import com.qiyu.data.vo.AgentPayWithdrawRecordVo;
import com.qiyu.data.vo.MyPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class WithdrawlDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 支付申请提现记录
     * @param agentId
     * @param handleStatus
     * @param curPage
     * @param pageSize
     * @return
     */
    public MyPage<AgentPayWithdrawRecordVo> withdrawlPayList(String reqMsgId,Long agentId,Integer handleStatus,int curPage,int pageSize) {
        StringBuilder sql = new StringBuilder();
        StringBuilder sqlEle = new StringBuilder();
        StringBuilder sqlTotal = new StringBuilder();
        sqlTotal.append("select count(1) from (");
        sqlEle.append("select a.simple_name as agent_name,record.* from agent_pay_withdraw_record record LEFT JOIN agent a on a.id= record.agent_id WHERE record.show_no = 1" );
        //sqlEle.append("select  record.id,record.req_msg_id,record.money,record.req_msg_id,a.simple_name as agent_name,record.brank,record.card_number,record.account_name,DATE_FORMAT( record.create_at, '%Y-%m-%d %H:%i' ) AS apply_date,record.handle_status WHERE 1 = 1" );

        if(reqMsgId!=null && !reqMsgId.equals("")){
            sql.append(" and record.req_msg_id like '%" + reqMsgId+"%' ");
        }
        if(agentId!= null && !agentId.equals("")){
            sql.append(" AND record.agent_id = '"+agentId+"' ");
        }
        if(handleStatus!=null && !handleStatus.equals("")){
            sql.append(" and record.handle_status = " + handleStatus);
        }
        sqlEle.append(sql.toString());
        sqlTotal.append(sqlEle.toString() +" )t");

        Integer num= jdbcTemplate.queryForObject(sqlTotal.toString(), Integer.class);
        MyPage<AgentPayWithdrawRecordVo> page=new MyPage<AgentPayWithdrawRecordVo>();
        page.setTotalNum(num);
        sqlEle.append(" ORDER BY record.handle_status ");
       /* sqlEle.append(" LIMIT ?,?");
        int pageStart=(curPage-1)*pageSize;
        List<AgentPayWithdrawRecordVo> list= jdbcTemplate.query(sqlEle.toString(),new Object[]{pageStart,pageSize},new ObjectMapper(AgentPayWithdrawRecordVo.class));
       */
        List<AgentPayWithdrawRecordVo> list= jdbcTemplate.query(sqlEle.toString(),new ObjectMapper(AgentPayWithdrawRecordVo.class));
       page.setList(list);
        return page;
    }

    /**
     * 导出列表
     * @return
     */
    public  List<Map<String,Object>> withdrawlPayListAll() {
        StringBuilder sqlEle = new StringBuilder();
        sqlEle.append("select a.simple_name as agent_name,record.* from agent_pay_withdraw_record record LEFT JOIN agent a on a.id= record.agent_id WHERE record.show_no = 1 and record.handle_status = 0 " );
        List<Map<String,Object>> list= jdbcTemplate.queryForList(sqlEle.toString());
        return list;
    }
}
