package com.qiyu.data.repository;

import com.qiyu.data.entity.PayConfig;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PayConfigRepo extends PagingAndSortingRepository<PayConfig, Long>,JpaSpecificationExecutor<PayConfig> {
}
