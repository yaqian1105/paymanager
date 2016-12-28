package com.qiyu.data.dao;


import com.qiyu.common.data.ObjectMapper;
import com.qiyu.data.entity.PayConfig;
import com.qiyu.data.vo.*;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class PayConfigDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 获取渠道信息
     * @param platform
     * @return
     */
    public List<PayConfigInformationVo> getChannelInformation(String platform) {
        StringBuilder sql = new StringBuilder();
        StringBuilder sqlEle = new StringBuilder();
        sqlEle.append("select pi.* from pay_channel_information pi ");
        sql.append("  where  1=1 ");
        if(!StringUtils.isBlank(platform)){
            sql.append(" and  pi.platform ='" + platform + "' ");
        }
        sqlEle.append(sql.toString());
        sqlEle.append("  order by pi.config_no desc");
        List<PayConfigInformationVo>list= jdbcTemplate.query(sqlEle.toString(), new ObjectMapper(PayConfigInformationVo.class));
        return list;
    }

    /**
     * 查询使用中的通道
     * @return
     */
    public PayConfig changeUsePayConfig(Long restaurantId,String platform){
        StringBuilder sql = new StringBuilder();
        sql.append("select pc.* from pay_config pc where 1=1 and pc.restaurant_id= ? and pc.platform = ? and pc.used_type = 1 ");
        List<PayConfig> list = jdbcTemplate.query(sql.toString(), new Object[]{restaurantId,platform}, new ObjectMapper(PayConfig.class));
        PayConfig payConfig = null;
        if (null != list && list.size()>0){
            for (PayConfig p : list) {
                payConfig = p;
            }
        }
        return payConfig;
    }

    /**
     * 查询配置的信息
     * @return
     */
    public PayConfig getPayConfig(Long restaurantId,String platform, String paymentChannel) {
        StringBuilder sql = new StringBuilder();
        sql.append("select pc.* from pay_config pc where 1=1   and pc.restaurant_id= ? and pc.platform = ? and pc.payment_channel = ?");
        List<PayConfig> list = jdbcTemplate.query(sql.toString(), new Object[]{restaurantId, platform, paymentChannel}, new ObjectMapper(PayConfig.class));
        PayConfig payConfig = null;
        if (null != list && list.size()>0){
            for (PayConfig p : list) {
                payConfig = p;
            }
        }
        return payConfig;
    }
    /**
     * 查询已配置的银行通道信息
     * @return
     */
    private  List<SetConfigVo> getChannel(Long restaurantId,String platform, int curPage, int pageSize) {
        StringBuilder sql = new StringBuilder();
        StringBuilder totalSql = new StringBuilder();
        totalSql.append("select count(1) from (");
        sql.append("select pc.id, pc.restaurant_id, pc.platform, pci.channel_name as payment_channel, pc.rate, pc.settlement_type from pay_config pc LEFT JOIN pay_channel_information pci on pci.config_no = pc.payment_channel where 1=1   and pc.restaurant_id= ? and pc.payment_channel>100 and pc.platform = ? order by pc.platform desc");
        totalSql.append(sql.toString() +" )t");
        List<SetConfigVo> list = jdbcTemplate.query(sql.toString(), new Object[]{restaurantId,platform}, new ObjectMapper(SetConfigVo.class));
        return list;
    }

    public  List<List<SetConfigVo>> getChannels(Long restaurantId, int curPage, int pageSize) {
        List<List<SetConfigVo>> map = new ArrayList<>();
        String platform ="ali";
        map.add(getChannel(restaurantId,platform,curPage,pageSize));
        platform = "weixin";
        map.add(getChannel(restaurantId,platform,curPage,pageSize));
        return map;
    }
}
