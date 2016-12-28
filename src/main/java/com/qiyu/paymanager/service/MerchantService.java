package com.qiyu.paymanager.service;


import com.qiyu.data.dao.MerchantDao;
import com.qiyu.data.repository.RestaurantStaffRepository;
import com.qiyu.data.vo.*;
import com.qiyu.sms.SmsSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by KK on 2016/6/1.
 */
@Service
@Transactional
public class MerchantService {
    private Logger logger = LoggerFactory.getLogger(MerchantService.class);

 /*   @Autowired
    private SmsSender smsSender;

    @Value("${sms.merchantRegisterSuffix}")
    private String merchantRegisterSuffix;

    @Value("${sms.merchantRegisterPrefix}")
    private String merchantRegisterPrefix;
    @Autowired
    private RestaurantStaffRepository restaurantStaffRepo;
*/
    @Autowired
    private MerchantDao merchantDao;


    /**
     * 商家列表
     * @param merchantName
     * @param curPage
     * @param pageSize
     * @return
     */
    public MyPage<MerchantVo> findMerchant(String merchantName, int curPage, int pageSize) {
        return merchantDao.findMerchant(merchantName,curPage,pageSize);
    }

    /**
     * 门店统计
     * @param merchantId
     * @param restaurantName
     * @param curPage
     * @param pageSize
     * @return
     */
    public MyPage<RestaurantVo> findRestaurants(Long merchantId, String restaurantName, int curPage, int pageSize) {
        return merchantDao.findRestaurants(merchantId,restaurantName,curPage,pageSize);
    }

    /**
     * 商家信息
     * @param id
     * @return
     */
    public MerchantVo findMerchantById(Long id){
        return merchantDao.findMerchantById(id);
    }

    /**
     * 获取下拉列表值
     *
     * @return
     */
    public List<RegistermerVo> findAllMerName(String name, Integer status) {
        return merchantDao.findAllMerName(name, status);
    }
}