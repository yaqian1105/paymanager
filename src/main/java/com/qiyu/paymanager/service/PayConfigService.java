package com.qiyu.paymanager.service;

import com.qiyu.data.BeanMapper;
import com.qiyu.data.Msg;
import com.qiyu.data.dao.PayConfigDao;
import com.qiyu.data.entity.PayConfig;
import com.qiyu.data.repository.PayConfigRepo;
import com.qiyu.data.vo.MyPage;
import com.qiyu.data.vo.PayConfigInformationVo;
import com.qiyu.data.vo.PayConfigVo;
import com.qiyu.data.vo.SetConfigVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PayConfigService {
    @Autowired
    private PayConfigDao payConfigDao;
    @Autowired
    private PayConfigRepo payConfigRepo;

    /**
     * 获取渠道信息
     * @param platform
     * @return
     */
    public List<PayConfigInformationVo> getChannelInformation(String platform) {
        return payConfigDao.getChannelInformation(platform);
    }

    /**
     * 获取配置信息
     * @param restaurantId
     * @param platform
     * @param paymentChannel
     * @return
     */
    public PayConfig getPayConfig(Long restaurantId, String platform, String paymentChannel){
        return payConfigDao.getPayConfig(restaurantId,platform,paymentChannel);
    }
    /**
     * 保存或更新门店支付信息
     */
    public Msg updatePayConfig(PayConfigVo vo) {
        Date now = new Date();
        //当用户已使用某平台的某通道，及先关闭通道，再更新通道
        PayConfig userPayConfig = payConfigDao.changeUsePayConfig(vo.getRestaurantId(),vo.getPlatform());
        if(userPayConfig!=null){
            userPayConfig.setUpdateAt(now);
            userPayConfig.setUsedType(0);
            payConfigRepo.save(userPayConfig);
        }
        //查询是否开通此数据
        PayConfig payConfig = payConfigDao.getPayConfig(vo.getRestaurantId(),vo.getPlatform(),vo.getPaymentChannel());
        if (payConfig!=null){

            if(vo.getPaymentChannel().equals("21")) {
                payConfig.setPayMerchantId(vo.getPayMerchantId());
                payConfig.setPayKey(vo.getPayKey());
                payConfig.setAppid(vo.getAppid());
                payConfig.setAppSecret(vo.getAppSecret());
                payConfig.setApiclientCert(vo.getApiclientCert());
                payConfig.setApiclientKey(vo.getApiclientKey());
            }else if(vo.getPaymentChannel().equals("22")) {
                payConfig.setPayMerchantId(vo.getPayMerchantId());
                payConfig.setPayKey(vo.getPayKey());
                payConfig.setAppid(vo.getAppid());
                payConfig.setAppSecret(vo.getAppSecret());
                payConfig.setApiclientCert(vo.getApiclientCert());
                payConfig.setApiclientKey(vo.getApiclientKey());
                payConfig.setSubMerchantId(vo.getSubMerchantId());
            }else if(vo.getPaymentChannel().equals("23")) {
                payConfig.setSubMerchantId(vo.getSubMerchantId());
            }else if(vo.getPaymentChannel().equals("11")) {
                payConfig.setEmail(vo.getEmail());
                payConfig.setAliStoreId(vo.getAliStoreId());
                payConfig.setAliPid(vo.getAliPid());
                payConfig.setPayAccount(vo.getPayAccount());
            }else if(vo.getPaymentChannel().equals("12")) {
                payConfig.setSaftKey(vo.getSaftKey());
                payConfig.setAppid(vo.getAppid());
                payConfig.setPid(vo.getPid());
                payConfig.setPayAccount(vo.getPayAccount());
                payConfig.setPrivateKey(vo.getPrivateKey());
                payConfig.setPublicKey(vo.getPublicKey());
            }else{
                payConfig.setChannelMerchantKey(vo.getChannelMerchantKey());
                payConfig.setChannelMerchantId(vo.getChannelMerchantId());
                payConfig.setSettlementType(vo.getSettlementType());
            }
            payConfig.setUsedType(vo.getUsedType());
            payConfig.setRate(vo.getRate());
            payConfig.setUpdateAt(now);

        }else {
            payConfig = BeanMapper.getMapperFacade().map(vo, PayConfig.class);
            payConfig.setCreateAt(now);
        }
        payConfigRepo.save(payConfig);
        return Msg.createSucMsg();
    }

    /**
     *获取已配置的银行通道信息
     * @param restaurantId
     * @return
     */
    /*public List<PayConfigVo> getChannel(Long restaurantId, int curPage, int pageSize){
        return payConfigDao.getChannel(restaurantId,curPage,pageSize);
    }*/
    public List<List<SetConfigVo>> getChannels(Long restaurantId, int curPage, int pageSize){
        return payConfigDao.getChannels(restaurantId,curPage,pageSize);
    }

    /**
     * 更改设置状态
     * @param vo
     * @return
     */
    @Transactional
    public Msg updateChannel(PayConfigVo vo) {
        Date now = new Date();
        //更新该通道信息
        PayConfig payConfig = payConfigRepo.findOne(vo.getId());

        payConfig.setRate(vo.getRate());
        payConfig.setSettlementType(vo.getSettlementType());
        payConfig.setUpdateAt(now);

        payConfigRepo.save(payConfig);
        return Msg.createSucMsg();
    }
}