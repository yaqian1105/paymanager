package com.qiyu.paymanager.service;



import com.qiyu.data.entity.SystemUser;
import com.qiyu.data.repository.AgentRepo;
import com.qiyu.data.repository.RestaurantStaffRepository;
import com.qiyu.data.repository.SysConfigRepository;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Dean on 2016/4/10.
 */
@Service
public class BaseService {
    @Autowired
    protected AgentRepo agentRepo;

    @Autowired
    protected RestaurantStaffRepository restaurantStaffRepository;
    /**
     * 取出Shiro中的当前用户LoginName.
     */
    public SystemUser getCurrentUser() {
        SystemUser user = (SystemUser) SecurityUtils.getSubject().getPrincipal();
        return user;
    }

}
