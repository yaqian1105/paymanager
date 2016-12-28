package com.qiyu.data.repository;


import com.qiyu.data.entity.Agent;
import com.qiyu.data.entity.TransactionInfo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TransactionInfoRepo extends PagingAndSortingRepository<TransactionInfo, Long>,JpaSpecificationExecutor<TransactionInfo> {
}
