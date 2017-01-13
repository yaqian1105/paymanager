package com.qiyu.paymanager.service;

import com.qiyu.data.BeanMapper;
import com.qiyu.data.Msg;
import com.qiyu.data.dao.SetupDao;
import com.qiyu.data.entity.GlobalConstant;
import com.qiyu.data.entity.Merchant;
import com.qiyu.data.repository.GlobalConstantRepo;
import com.qiyu.data.repository.MerchantRepo;
import com.qiyu.data.vo.GlobalConstantVo;
import com.qiyu.data.vo.MerchantVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by zyq on 2017/1/10.
 */
@Service
public class SetupService {
    @Autowired
    private GlobalConstantRepo globalConstantRepo;
    @Autowired
    private SetupDao setupDao;
    @Autowired
    private MerchantRepo merchantRepo;
    /**
     * 查询代理商佣金结算日
     * @return
     */
    public GlobalConstant findByConstantName (String accountDay){
        return globalConstantRepo.findByConstantName(accountDay);
    }

    /**
     * 查询商家信息
     * @param simpleName
     * @return
     */
    public List<MerchantVo> findMerchant(String type, String simpleName) {
        return setupDao.findMerchant(type,simpleName);
    }

    /**
     * POS应用设置
     * @param merchantIds
     * @param isPosApplication
     * @return
     */
    public Msg updatePosApplication (List<Long> merchantIds, int isPosApplication){
        Date now = new Date();
        int msg = 0;
        int errorMsg = 0;
        if(merchantIds!=null && !merchantIds.equals("")){
            for(Long id : merchantIds){
                Merchant merchant = merchantRepo.findOne(id);
                merchant.setIsPosApplication(isPosApplication);
                merchant.setUpdateAt(now);
                try {
                    merchantRepo.save(merchant);
                    msg++;
                }catch (Exception e){
                    e.printStackTrace();
                    errorMsg++;
                }
            }
        }
        return Msg.createSucMsg("共设置："+merchantIds.size()+"个，成功：" + msg + "，失败：" + errorMsg);
    }



    /**
     * 编辑全局常量
     * @param vo
     * @return
     */
    public Msg updateAccountDay(GlobalConstantVo vo){
        Date now = new Date();
        GlobalConstant globalConstant = null;
        //更新该通道信息
        if(vo.getId()!=null && !vo.getId().equals("")) {
            globalConstant = globalConstantRepo.findOne(vo.getId());
            globalConstant.setConstantValue(vo.getConstantValue());
            globalConstant.setUpdateAt(now);
        }else{
            globalConstant  = BeanMapper.getMapperFacade().map(vo, GlobalConstant.class);
            globalConstant.setCreateAt(now);
        }
        globalConstantRepo.save(globalConstant);
        return Msg.createSucMsg(globalConstant.getConstantValue());
    }

}
