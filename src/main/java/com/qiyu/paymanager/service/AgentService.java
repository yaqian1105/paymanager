package com.qiyu.paymanager.service;


import com.qiyu.data.Msg;
import com.qiyu.data.dao.AgentDao;
import com.qiyu.data.entity.Agent;
import com.qiyu.data.repository.AgentRepo;
import com.qiyu.data.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by KK on 2016/5/27.
 */
@Service
@Transactional
public class AgentService {

    @Autowired
    private AgentDao agentDao;

    @Autowired
    private AgentRepo agentRepo;

    /**
     * 代理商列表
     * @param agentName
     * @param curPage
     * @param pageSize
     * @return
     */
    public MyPage<AgentVo> findAgent(String agentName, int curPage, int pageSize) {
        return agentDao.findAgent(agentName,curPage,pageSize);
    }

    /**
     * 客户列表
     * @param agentid
     * @param curPage
     * @param pageSize
     * @return
     */
    public MyPage<MerchantVo> findMerchants(Long agentid, int curPage, int pageSize) {
        return agentDao.findMerchants(agentid,curPage,pageSize);
    }

    /**
     * 代理商详情
     * @param id
     * @return
     */
     public Agent findAgentById(Long id){
         return agentRepo.findOne(id);
     }

    public Agent findAgentByRestaurantId(Long restaurantId){
        return agentDao.findAgentByRestaurantId(restaurantId);
    }

    /**
     * 修改返佣信息
     * @param vo
     * @return
     */
    @Transactional
    public Msg updateReturnPer(AgentVo vo) {
        Date now = new Date();
        //更新返佣比例
        Agent agent = agentRepo.findOne(vo.getId());

        agent.setReturnPercentage(vo.getReturnPercentage());
        agent.setUpdateAt(now);
        agentRepo.save(agent);
        return Msg.createSucMsg();
    }
}
