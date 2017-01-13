package com.qiyu.data.repository;

import com.qiyu.data.entity.GlobalConstant;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GlobalConstantRepo extends PagingAndSortingRepository<GlobalConstant, Long>,JpaSpecificationExecutor<GlobalConstant> {
    GlobalConstant findByConstantName (String constantName);
}
