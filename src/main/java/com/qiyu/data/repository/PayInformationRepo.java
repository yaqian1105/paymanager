package com.qiyu.data.repository;

import com.qiyu.data.entity.PayConfig;
import com.qiyu.data.entity.PayInformation;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PayInformationRepo extends PagingAndSortingRepository<PayInformation, Long>,JpaSpecificationExecutor<PayInformation> {
}
