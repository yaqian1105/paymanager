package com.qiyu.data.dao;


import com.qiyu.common.data.ObjectMapper;
import com.qiyu.data.entity.PayInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PayInformationDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查询是否有申请的记录
     * @return
     */
    public PayInformation getPayInformation(Long restaurantId,Integer restaurantSignType,String paymentChannel) {
        StringBuilder sql = new StringBuilder();
        sql.append("select pi.* from pay_information pi where 1=1  and pi.restaurant_id= ? and pi.restaurant_sign_type = ? and pi.payment_channel = ? ");
        List<PayInformation> list = jdbcTemplate.query(sql.toString(), new Object[]{restaurantId,restaurantSignType,paymentChannel}, new ObjectMapper(PayInformation.class));
        PayInformation payInformation = null;
        if (null != list && list.size()>0){
            for (PayInformation p : list) {
                payInformation = p;
            }
        }
        return payInformation;
    }

}
