package com.qiyu.data.repository;


import com.qiyu.data.entity.SystemUser;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Dean on 2016/3/9.
 */
@Repository
public interface SystemUserRepository extends PagingAndSortingRepository<SystemUser, Long>,
        JpaSpecificationExecutor<SystemUser> {


    SystemUser findByUserNameAndIsExpired(String loginName, boolean b);
}
