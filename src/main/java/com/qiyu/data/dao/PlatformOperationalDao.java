package com.qiyu.data.dao;

import com.qiyu.common.data.ObjectMapper;
import com.qiyu.data.vo.PlatformOperationalVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2016/11/15.
 */
@Component
public class PlatformOperationalDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /**
     * 汇总今日信息（交易流水，订单数）
     * @return
     */
    public PlatformOperationalVo getTodayGather() {
        StringBuilder sql = new StringBuilder();
        sql.append("select count(*) order_count ,SUM(total_amount) sum_money  from transaction_info t where TO_DAYS(t.create_at) = TO_DAYS(NOW()) and t.status = 0");
        return (PlatformOperationalVo)jdbcTemplate.queryForObject(sql.toString(), new ObjectMapper(PlatformOperationalVo.class));
    }
    /**
     * 汇总商户总数
     * @return
     */
    public PlatformOperationalVo getMerchantGather() {
        StringBuilder sql = new StringBuilder();
        sql.append("select count(*) as restaurant_count from merchant m ");
        return (PlatformOperationalVo)jdbcTemplate.queryForObject(sql.toString(), new ObjectMapper(PlatformOperationalVo.class));
    }

    /**
     * 流水曲线图
     * @param type
     * @return
     */
    public List<PlatformOperationalVo> getOrderList(int type) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from (SELECT sum(ri.total_amount) as money,DATE_FORMAT(ri.create_at,'%Y-%m-%d') as day_str FROM transaction_info ri WHERE ri.create_at>=DATE( date_add(curdate(), INTERVAL - ? DAY)) " +
                " and ri.status = 0 GROUP BY day_str order by day_str desc) t order by day_str");
        return jdbcTemplate.query(sql.toString(),new Object[]{type}, new ObjectMapper(PlatformOperationalVo.class));
    }
    /**
     * 代理商排行信息
     * @param type
     * @return
     */
    public List<PlatformOperationalVo> getAgentList(int type) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from (select t.simple_name as agent_name, SUM(t.money) as money from (select ri.merchant_id,m.name, a.simple_name ,ri.total_amount as money from transaction_info ri LEFT JOIN merchant m on m.id = ri.merchant_id LEFT JOIN agent a on a.id = m.agent_id " +
                "WHERE ri.create_at>=DATE( date_add(curdate(), INTERVAL - ? DAY)) and ri.status = 0 )t GROUP BY agent_name ORDER BY money desc LIMIT ?,?) t order by money");
        return jdbcTemplate.query(sql.toString(),new Object[]{type, 0, 10}, new ObjectMapper(PlatformOperationalVo.class));
    }

    /**
     * 商家排行信息
     * @param type
     * @return
     */
   public List<PlatformOperationalVo> getMerchantList(int type) {
       StringBuilder sql = new StringBuilder();
       sql.append("select * from (select m.simple_name as merchant_name,sum(ri.total_amount) as money  from transaction_info ri LEFT JOIN merchant m on m.id = ri.merchant_id " +
               "WHERE ri.create_at>=DATE( date_add(curdate(), INTERVAL - ? DAY))  and ri.status = 0 GROUP BY ri.merchant_id ORDER BY money desc LIMIT ?,?) t order by money ");
       return jdbcTemplate.query(sql.toString(),new Object[]{type, 0, 10}, new ObjectMapper(PlatformOperationalVo.class));
   }

    /**
     * 代理商排行信息
     * @param type
     * @return
     */
    public List<PlatformOperationalVo> getAgentListDetail(int type) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from (select t.simple_name as agent_name, SUM(t.money) as money from (select ri.merchant_id,m.name, a.simple_name ,ri.total_amount as money from transaction_info ri LEFT JOIN merchant m on m.id = ri.merchant_id LEFT JOIN agent a on a.id = m.agent_id " +
                "WHERE ri.create_at>=DATE( date_add(curdate(), INTERVAL - ? DAY)) and ri.status = 0 )t GROUP BY agent_name ORDER BY money desc ) t order by money");
        return jdbcTemplate.query(sql.toString(),new Object[]{type}, new ObjectMapper(PlatformOperationalVo.class));
    }

    /**
     * 商家排行信息
     * @param type
     * @return
     */
    public List<PlatformOperationalVo> getMerchantListDetail(int type) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from (select m.simple_name as merchant_name,sum(ri.total_amount) as money  from transaction_info ri LEFT JOIN merchant m on m.id = ri.merchant_id " +
                "WHERE ri.create_at>=DATE( date_add(curdate(), INTERVAL - ? DAY)) and ri.status = 0 GROUP BY ri.merchant_id ORDER BY money desc) t order by money ");
        return jdbcTemplate.query(sql.toString(),new Object[]{type}, new ObjectMapper(PlatformOperationalVo.class));
    }

}

