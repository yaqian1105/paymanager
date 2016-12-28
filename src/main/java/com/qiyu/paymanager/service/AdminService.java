package com.qiyu.paymanager.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qiyu.common.exception.RestResult;
import com.qiyu.common.exception.ServiceException;
import com.qiyu.common.utils.JsonUtil;
import com.qiyu.data.RetCode;
import com.qiyu.data.entity.RestaurantStaff;
import com.qiyu.data.entity.SysConfig;
import com.qiyu.data.repository.SysConfigRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dean on 2016/3/9.
 */
@Service
public class AdminService extends BaseService{
    private static Logger logger= LoggerFactory.getLogger(AdminService.class);
    @Autowired
    protected SysConfigRepository sysConfigRepository;
    public Map<String,Object> getAppPrice(){
        List<String> roles=getCurrentUser().getRoleList();
        if(!roles.contains(RestaurantStaff.ROLE_ADMIN)){
            throw new ServiceException(RetCode.SYS_ERROR_CODE);
        }
        SysConfig sysConfig=sysConfigRepository.findByType(SysConfig.TYPE_APP_PRICAE);
        if(null==sysConfig){
            throw new ServiceException(RetCode.SYS_ERROR_CODE);
        }
        Map<String,Object> data=new HashMap<>();
        SimpleDateFormat sft=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        data.put("createAt",sft.format(sysConfig.getCreateAt()));
        data.put("updateAt",sft.format(sysConfig.getUpdateAt()));
        data.put("updater",sysConfig.getUpdater());

        JSONObject jsonObject=JSON.parseObject(sysConfig.getContent());
        double appPrice=jsonObject.getDouble("appPrice");
        data.put("appPrice",appPrice);
        return RestResult.restSuccess(data);
    }

    public Map<String,Object> saveAppPrice(double appPrice) {
        List<String> roles=getCurrentUser().getRoleList();
        if(!roles.contains(RestaurantStaff.ROLE_ADMIN)){
            throw new ServiceException(RetCode.SYS_ERROR_CODE);
        }
        SysConfig sysConfig=sysConfigRepository.findByType(SysConfig.TYPE_APP_PRICAE);
        if(null==sysConfig){
            throw new ServiceException(RetCode.SYS_ERROR_CODE);
        }
        sysConfig.setUpdateAt(new Date());
        sysConfig.setUpdaterId(getCurrentUser().getId());
        sysConfig.setUpdater(getCurrentUser().getUserName());
        Map<String,Object> contentMap=new HashMap<>();
        contentMap.put("appPrice",appPrice);
        String countent= JsonUtil.toJson(contentMap);
        sysConfig.setContent(countent);
        sysConfigRepository.save(sysConfig);
        return RestResult.restSuccess(null);
    }
}
