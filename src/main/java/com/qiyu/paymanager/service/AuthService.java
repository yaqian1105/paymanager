package com.qiyu.paymanager.service;


import com.qiyu.common.utils.AuthUtil;
import com.qiyu.data.entity.Agent;
import com.qiyu.data.entity.RestaurantStaff;
import com.yunjiangzhe.service.sms.LanzWangwangSmsSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by Dean on 2016/3/9.
 */
@Service
public class AuthService extends BaseService{


//    public Map<String,Object> register(long restaurantId, String userName, String staffNo, String password){
//        Map<String,Object> result=new HashMap<>();
//        //isRightRestaurant(restaurantId);
//        AuthUtil.PwdEntity pwdEntity=AuthUtil.decodePassword(password,RestaurantStaff.HASH_INTERATIONS);
//
//        RestaurantStaff restaurantStaff=restaurantStaffRepository.findByRestaurantIdAndUserName(restaurantId,userName);
//        if(null!=restaurantStaff){
//            throw new ServiceException(RetCode.USER_NAME_HAS_EXIST);
//        }
//
//        restaurantStaff=restaurantStaffRepository.findByRestaurantIdAndStaffNo(restaurantId,staffNo);
//        if(null!=restaurantStaff){
//            throw new ServiceException(RetCode.USER_HAS_NO_EXIST);
//        }
//        RestaurantStaff staff=new RestaurantStaff();
//        staff.setRestaurantId(restaurantId);
//        staff.setPassword(pwdEntity.getPwd());
//        staff.setSalt(pwdEntity.getSalt());
//        staff.setStaffNo(staffNo);
//        staff.setUserName(userName);
//        Date now =new Date();
//        staff.setCreateAt(now);
//        staff.setUpdateAt(now);
//        saveStaff(staff);
//
//        result.put(RetCode.CODE,RetCode.SUCCESS_CODE);
//        result.put(RetCode.MSG,"注册成功");
//        return result;
//    }

    @Transactional
    public void  saveStaff(RestaurantStaff restaurantStaff){
        restaurantStaffRepository.save(restaurantStaff);
    }


    public void login(String userName, String password, boolean reme, HttpServletRequest request,HttpServletResponse response){

    }


    public void resertMerchantPwd(String merchantId, String phone) {
        RestaurantStaff restaurantStaff = restaurantStaffRepository.findByPhone(phone);

        if(restaurantStaff != null){
            AuthUtil.PwdEntity pwdEntity= AuthUtil.decodePassword("123456",RestaurantStaff.HASH_INTERATIONS);
            restaurantStaff.setPassword(pwdEntity.getPwd());
            restaurantStaff.setSalt(pwdEntity.getSalt());
            restaurantStaff.setUpdateAt(new Date());
            restaurantStaffRepository.save(restaurantStaff);
            LanzWangwangSmsSender lanzWangwangSmsSender = new LanzWangwangSmsSender();
            lanzWangwangSmsSender.sendSms(phone,"恭喜您密码重置成功,初始密码为123456");
        }
    }

    public void resertAgentPwd(String id, String phone) {
        Agent agent = agentRepo.findOne(Long.valueOf(id));
        if(agent != null){
            agent.setPassword("123456");
            agent.setUpdateAt(new Date());
            agentRepo.save(agent);
            LanzWangwangSmsSender lanzWangwangSmsSender = new LanzWangwangSmsSender();
            lanzWangwangSmsSender.sendSms(phone,"恭喜您密码重置成功,初始密码为123456");
        }
    }
}
