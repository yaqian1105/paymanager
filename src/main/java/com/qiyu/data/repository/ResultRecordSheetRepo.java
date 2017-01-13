package com.qiyu.data.repository;

import com.qiyu.data.entity.ResultRecordSheet;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ResultRecordSheetRepo extends PagingAndSortingRepository<ResultRecordSheet, Long>,JpaSpecificationExecutor<ResultRecordSheet> {
}
