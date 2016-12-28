package com.qiyu.data.repository;


import com.qiyu.data.entity.SysConfig;
import com.qiyu.data.entity.SysConfig;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Dean on 2016/3/9.
 */
public interface SysConfigRepository extends PagingAndSortingRepository<SysConfig, Long>, JpaSpecificationExecutor<SysConfig> {

    SysConfig findByType(String type);
}
