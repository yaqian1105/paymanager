package com.qiyu.data.dao;

import com.qiyu.common.data.ObjectMapper;
import com.qiyu.data.vo.MerchantVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zyq on 2017/1/9.
 */

@Component
public class SetupDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 商家列表
     * @return
     */
    public List<MerchantVo> findMerchant(String type,String simpleName){
        StringBuilder sql = new StringBuilder();
        StringBuilder sqlEle = new StringBuilder();
        sqlEle.append("select m.id, m.name as merchant_name, m.contact, m.phone, a.agent_name, (select DISTINCT count(r.id) from restaurant r where r.merchant_id = m.id )as restaurant_count " +
                "from merchant m LEFT JOIN agent a on a.id = m.agent_id where 1=1 ");
        if (type!=null && !type.equals("")) {
            if(type.equals("M")) {
                sql.append("AND m.name like '%" + simpleName + "%' ");
            }else if(type.equals("A")){
                sql.append("AND m.agent_id in(select ag.id from agent ag where ag.agent_name like '%" + simpleName + "%') ");
            }
        }
        sqlEle.append(sql.toString());
        sqlEle.append(" ORDER BY m.id DESC" );
        List<MerchantVo> list = jdbcTemplate.query(sqlEle.toString(), new ObjectMapper(MerchantVo.class));
        return list;
    }



}
