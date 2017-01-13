package com.qiyu.data.dao;


import com.alibaba.dubbo.common.utils.StringUtils;
import com.qiyu.common.data.ObjectMapper;
import com.qiyu.data.repository.MerchantRepo;
import com.qiyu.data.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MerchantDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private MerchantRepo repo;

    /**
     * 商家列表
     * @param merchantName
     * @param curPage
     * @param pageSize
     * @return
     */
    public MyPage<MerchantVo> findMerchant(String merchantName, int curPage, int pageSize) {
        StringBuilder sql = new StringBuilder();
        StringBuilder sqlEle = new StringBuilder();
        StringBuilder totalSql = new StringBuilder();
        totalSql.append("select count(*) from (");
        sqlEle.append("select m.id, m.name as merchant_name, m.contact, m.phone, a.agent_name, (select DISTINCT count(r.id) from restaurant r where r.merchant_id = m.id )as restaurant_count " +
                "from merchant m LEFT JOIN agent a on a.id = m.agent_id where 1=1 ");

        if (org.apache.commons.lang3.StringUtils.isNotEmpty(merchantName)){
            sql.append("AND m.name like '%" +merchantName+ "%' ");
        }

        sqlEle.append(sql.toString());
        totalSql.append(sqlEle.toString() +" )t");

        Integer num= jdbcTemplate.queryForObject(totalSql.toString(), Integer.class);
        MyPage<MerchantVo> page=new MyPage<MerchantVo>();
        page.setTotalNum(num);
        sqlEle.append(" ORDER BY m.id DESC " );
        List<MerchantVo> list= jdbcTemplate.query(sqlEle.toString(), new ObjectMapper(MerchantVo.class));
        page.setList(list);
        return page;
    }

    /**
     * 门店汇总
     * @param merchantId
     * @param restaurantName
     * @param curPage
     * @param pageSize
     * @return
     */
    public MyPage<RestaurantVo> findRestaurants(Long merchantId, String restaurantName, int curPage, int pageSize) {
        StringBuilder sql = new StringBuilder();
        StringBuilder sqlEle = new StringBuilder();
        StringBuilder totalSql = new StringBuilder();
        totalSql.append("select count(*) from (");
        sqlEle.append("select r.id , r.merchant_id ,r.name as rest_name,t1.platform as ali,t1.channel_name as ali_type,t2.platform as wx,t2.channel_name as wx_type from restaurant r " +
                "LEFT JOIN (select pc.restaurant_id as id, pc.platform, pi.channel_name from  pay_config pc LEFT JOIN pay_channel_information pi on pi.config_no = pc.payment_channel where pc.platform = 'ali' and pc.used_type= 1)t1 on t1.id = r.id " +
                "LEFT JOIN (select pc.restaurant_id as id, pc.platform, pi.channel_name from  pay_config pc LEFT JOIN pay_channel_information pi on pi.config_no = pc.payment_channel where pc.platform = 'weixin' and pc.used_type= 1)t2 on t2.id = r.id " +
                "where 1=1 ");

        if (StringUtils.isNotEmpty(restaurantName)){
            sql.append(" and r.name like '%" +restaurantName+ "%' ");
        }
        if (merchantId!=null){
            sql.append(" and  r.merchant_id = " +merchantId);
        }
        sqlEle.append(sql.toString());
        totalSql.append(sqlEle.toString() +" )t");

        Integer num= jdbcTemplate.queryForObject(totalSql.toString(), Integer.class);
        MyPage<RestaurantVo> page=new MyPage<RestaurantVo>();
        page.setTotalNum(num);
        List<RestaurantVo> list= jdbcTemplate.query(sqlEle.toString(), new ObjectMapper(RestaurantVo.class));
        page.setList(list);
        return page;
    }

    /**
     * 商户详情
     * @param id
     * @return
     */
    public MerchantVo findMerchantById(Long id){
        StringBuilder sql = new StringBuilder();
        sql.append("select m.id, m.name as merchant_name, m.contact, m.phone, a.agent_name from merchant m left join agent a on a.id = m.agent_id where 1=1 ");
        if(id!=null && !id.equals("")){
            sql.append(" and m.id = "+id);
        }
        MerchantVo merchantVo = (MerchantVo)jdbcTemplate.queryForObject(sql.toString(),  new ObjectMapper(MerchantVo.class));
        MerchantVo merchantVo1 = getMerchantCollect(id);
        if(merchantVo1!=null){
            merchantVo.setTransactionCount(merchantVo1.getTransactionCount());
            merchantVo.setTransactionFlow(merchantVo1.getTransactionFlow());
        }
        return merchantVo;
    }

    /**
     * 查询所有商家名称
     */
    public List<RegistermerVo> findAllMerName(String name, Integer status){
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id,name FROM merchant m where 1=1 ");
        if (StringUtils.isNotEmpty(name)){
            sql.append("AND m.name like '%" +name+ "%' ");
        }
        if (status != null ){
            sql.append("AND m.status = '" +status+ "' " );
        }
        List<RegistermerVo>list= jdbcTemplate.query(sql.toString(),  new ObjectMapper(RegistermerVo.class));
        return list;
    }
    public MerchantRepo getRepo() {
        return repo;
    }


    /**
     * 总交易订单:所有的门店订单总和
     * 总交易额：订单的总交易额，扣除扣费之前的金额
     * @param merchantId
     * @return
     */
    public MerchantVo getMerchantCollect(Long merchantId){
        StringBuilder sql = new StringBuilder();
        sql.append("select COUNT(1) as transaction_count,SUM(total_amount) as transaction_flow from transaction_info where status = 0 ");
        if(merchantId!=null && !merchantId.equals("")){
            sql.append(" and merchant_id = "+ merchantId);
        }
        return (MerchantVo)jdbcTemplate.queryForObject(sql.toString(),  new ObjectMapper(MerchantVo.class));
    }

}
