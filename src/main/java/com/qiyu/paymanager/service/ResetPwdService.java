package com.qiyu.paymanager.service;


import com.qiyu.data.dao.RestaurantDao;
import com.qiyu.data.entity.SystemUser;
import com.qiyu.data.vo.MerchantVo;
import com.qiyu.data.vo.MyPage;
import com.qiyu.data.vo.PresentVo;
import com.qiyu.data.vo.RestaurantPresentLogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by liuhui on 2016/7/19.
 */
@Service
@Transactional
public class ResetPwdService {

    @Autowired
    private RestaurantDao restaurantDao;


    public MyPage<PresentVo> findPresentData(Integer curPage, Integer pageSize, String restaurantName, Integer merchantId) {
        return restaurantDao.findPresentData(curPage, pageSize, restaurantName, merchantId);
    }

    public void saveDate(String id, Integer dateNum, String remark,SystemUser cur_user) {
        restaurantDao.updateExpriedDate(id, dateNum);
        restaurantDao.savePresendDate(id ,dateNum, remark, cur_user.getUserName());
    }

    public List<RestaurantPresentLogVo> findDetail(String id) {
        return restaurantDao.findDetail(id);
    }

    public List<MerchantVo> getMerchant(String merchantName) {
        return restaurantDao.getMerchat(merchantName);
    }
}
