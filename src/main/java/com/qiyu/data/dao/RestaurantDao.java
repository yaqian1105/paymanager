package com.qiyu.data.dao;

import com.qiyu.common.data.ObjectMapper;
import com.qiyu.data.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestaurantDao {
     @Autowired
     private JdbcTemplate jdbcTemplate;

    public MyPage<RestaurantVo> findRestaurant(String merchantId){
        StringBuilder sql = new StringBuilder();
        StringBuilder sqlEle = new StringBuilder();
        StringBuilder totalSql = new StringBuilder();
        totalSql.append("select count(*) from ");
        sqlEle.append("select r.id,r.name,r.fixed_phone,r.last_pay_time,s.user_name,s.phone from ");

        sql.append(" restaurant r left join restaurant_staff s on r.id=s.restaurant_id where  1=1 ");

        if(StringUtils.isNotEmpty(merchantId)){
            sql.append(" AND r.merchant_id = '"+merchantId+"' ");
        }
        totalSql.append(sql.toString());
        sqlEle.append(sql.toString());
        Integer num= jdbcTemplate.queryForObject(totalSql.toString(), Integer.class);
        MyPage<RestaurantVo> page=new MyPage<RestaurantVo>();
        page.setTotalNum(num);
        sqlEle.append(" ORDER BY r.id ");
        List<RestaurantVo> list= jdbcTemplate.query(sqlEle.toString(), new ObjectMapper(RestaurantVo.class));
        page.setList(list);
        return page;
    }


    public MyPage<PresentVo> findPresentData(Integer curPage, Integer pageSize, String restaurantName,Integer merchantId) {
        MyPage<PresentVo> page=new MyPage<PresentVo>();
        StringBuilder totalSql = new StringBuilder();
        StringBuilder sql = new StringBuilder();
        totalSql.append("SELECT COUNT(*) FROM `restaurant` t LEFT JOIN `merchant` m ON m.id = t.merchant_id where  1=1 ");
        sql.append("SELECT t.`name` AS restaurant_name,m.`name` AS merchant_name,to_days(t.expried_date) - to_days(now()) AS day,t.id \n" +
                "FROM `restaurant` t LEFT JOIN `merchant` m ON m.id = t.merchant_id where  1=1 ");
        Integer num= jdbcTemplate.queryForObject(totalSql.toString(), Integer.class);
        page.setTotalNum(num);

        if(StringUtils.isNotEmpty(restaurantName)){
            sql.append(" AND t.`name` like '%"+restaurantName+"%' ");
        }
        if(merchantId != null){
            sql.append(" AND m.id = '"+merchantId+"' ");
        }
        sql.append(" ORDER BY m.id DESC LIMIT ?,?");
        int pageStart=(curPage-1)*pageSize;
        List<PresentVo> list= jdbcTemplate.query(sql.toString(),  new Object[]{pageStart, pageSize}, new ObjectMapper(PresentVo.class));
        page.setList(list);
        return page;
    }

    public void updateExpriedDate(String id, Integer dateNum) {
        String sql = "UPDATE restaurant SET expried_date = date_add(IF(expried_date < NOW(), \n" +
                "DATE_FORMAT(NOW(),'%Y-%m-%d'), expried_date), interval ? day) WHERE id = ?";
        jdbcTemplate.update(sql, dateNum, id);
    }

    public void savePresendDate(String id, Integer dateNum, String remark, String userName) {
        String sql = "INSERT INTO restaurant_present_log (restaurant_id, day, status, remark, operate, create_at, update_at)\n" +
                "VALUES (?,?,'0',?,?, now(), now())";
        jdbcTemplate.update(sql,id,dateNum,remark,userName);
    }

    public List<RestaurantPresentLogVo> findDetail(String id) {
        String sql = "SELECT t.`day`,IF(t.`status`=0,'成功','失败') AS `status`,t.remark,DATE_FORMAT(t.create_at,'%Y-%m-%d %H:%i:%s') AS create_at," +
                "t.operate FROM `restaurant_present_log` t WHERE t.restaurant_id = '"+id+"' ORDER BY t.create_at DESC";
        List<RestaurantPresentLogVo> list = jdbcTemplate.query(sql.toString(), new ObjectMapper(RestaurantPresentLogVo.class));
        return list;
    }

    public List<MerchantVo> getMerchat(String merchantName) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT t.id, t.simple_name FROM `merchant` t WHERE 1 = 1 ");
        if (StringUtils.isNotEmpty(merchantName)) {
            sql.append(" AND t.simple_name like '%" + merchantName + "%' ");
        }
        List<MerchantVo> list = jdbcTemplate.query(sql.toString(), new ObjectMapper(MerchantVo.class));
        return list;
    }

}
