package com.qiyu.data.dao;


import com.qiyu.common.data.ObjectMapper;
import com.qiyu.data.entity.Agent;
import com.qiyu.data.vo.AgentVo;
import com.qiyu.data.vo.MerchantVo;
import com.qiyu.data.vo.MyPage;
import com.qiyu.data.repository.AgentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Created by Administrator on 2016/5/26.
 */
@Component
public class AgentDao {
    private static Logger logger = LoggerFactory.getLogger(AgentDao.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private AgentRepo repo;

    /**
     * 代理商列表
     * @param agentName
     * @param curPage
     * @param pageSize
     * @return
     */
    public MyPage<AgentVo> findAgent(String agentName, int curPage, int pageSize) {
        StringBuilder sql = new StringBuilder();
        StringBuilder sqlEle = new StringBuilder();
        StringBuilder totalSql = new StringBuilder();
        totalSql.append("select count(*) from (");
        sqlEle.append("select a.id, a.agent_name, a.contact_name, a.phone, (select DISTINCT count(r.id) from restaurant r where r.agent_id = a.id )as restaurant_count from agent a where 1=1 " );

        if (org.apache.commons.lang3.StringUtils.isNotEmpty(agentName)){
            sql.append("AND a.agent_name like '%" +agentName+ "%' ");
        }

        sqlEle.append(sql.toString());
        totalSql.append(sqlEle.toString() +" )t");

        Integer num= jdbcTemplate.queryForObject(totalSql.toString(), Integer.class);
        MyPage<AgentVo> page=new MyPage<AgentVo>();
        page.setTotalNum(num);
        sqlEle.append(" ORDER BY a.id ");
        List<AgentVo> list= jdbcTemplate.query(sqlEle.toString(), new ObjectMapper(AgentVo.class));
        page.setList(list);
        return page;
    }

    /**
     * 客户列表
     * @param agentid
     * @param curPage
     * @param pageSize
     * @return
     */
    public MyPage<MerchantVo> findMerchants(Long agentid, int curPage, int pageSize) {
        StringBuilder sql = new StringBuilder();
        StringBuilder sqlEle = new StringBuilder();
        StringBuilder totalSql = new StringBuilder();
        totalSql.append("select count(*) from (");
//        sqlEle.append("select m.id, m.name as merchant_name,m.fixed_phone, m.contact, m.phone,(select count(1) from restaurant r where r.merchant_id = m.id )as restaurant_count ," +
//                "(select count(1) from transaction_info ti where ti.merchant_id = m.id  and ti.status = 0 ) as transaction_count," +
//                "(select SUM(ti.total_amount) from transaction_info ti where ti.merchant_id = m.id and ti.status = 0) as transaction_flow," +
//                "(select SUM(ti.service_charge) from transaction_info ti where ti.merchant_id = m.id and ti.status = 0) as return_water," +
//                "(select SUM(ti.commission) from transaction_info ti where ti.merchant_id = m.id and ti.status = 0) as commission " +
//                "from merchant m where 1=1");

        sqlEle.append("select m.id, m.name as merchant_name,m.fixed_phone, m.contact, m.phone,(select count(1) from restaurant r where r.merchant_id = m.id )as restaurant_count , " +
                "(select count(1) from transaction_info ti where ti.merchant_id = m.id  and ti.status = 0 )as transaction_count , t.transaction_flow , t.return_water, t.commission from merchant m " +
                "LEFT JOIN(select ti.merchant_id, SUM(ti.total_amount) as transaction_flow, SUM(ti.service_charge)as return_water ,SUM(ti.commission)as commission from transaction_info ti  where ti.status = 0 GROUP BY ti.merchant_id )t on t.merchant_id=m.id ");

        if (agentid!=null){
            sql.append(" where m.agent_id ="+agentid);
        }
        sqlEle.append(sql.toString());
        totalSql.append(sqlEle.toString() +" )t");

        Integer num= jdbcTemplate.queryForObject(totalSql.toString(), Integer.class);
        MyPage<MerchantVo> page=new MyPage<MerchantVo>();
        page.setTotalNum(num);
        sqlEle.append(" ORDER BY m.id DESC ");
        List<MerchantVo> list= jdbcTemplate.query(sqlEle.toString(), new ObjectMapper(MerchantVo.class));

        logger.info(sqlEle.toString());
        page.setList(list);
        return page;
    }

    /**
     * 通过商户号查找代理商信息
     * @param restaurantId
     * @return
     */
    public Agent findAgentByRestaurantId(Long restaurantId){
        StringBuilder sql = new StringBuilder();
        sql.append("select * from agent a where id = (select r.agent_id from restaurant r where r.id = ?)");
        List<Agent> list= jdbcTemplate.query(sql.toString(), new Object[]{restaurantId}, new ObjectMapper(Agent.class));
        Agent agent = null;
        if(list!=null && list.size()>0){
            for(Agent a : list){
                agent = a;
            }
        }
        return agent;
    }
}