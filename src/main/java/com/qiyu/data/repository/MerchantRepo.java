package com.qiyu.data.repository;


import com.qiyu.data.entity.Merchant;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by kk on 2016/6/1.
 */
public interface MerchantRepo  extends PagingAndSortingRepository<Merchant, Long>,JpaSpecificationExecutor<Merchant> {
    List<Merchant> findByAgentId(Long agentId);
}
