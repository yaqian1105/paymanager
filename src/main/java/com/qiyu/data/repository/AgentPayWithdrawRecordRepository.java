package com.qiyu.data.repository;


import com.qiyu.data.entity.AgentPayWithdrawRecord;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * Created by lizeyu on 2016/5/3.
 */
public interface AgentPayWithdrawRecordRepository extends PagingAndSortingRepository<AgentPayWithdrawRecord, Long>, JpaSpecificationExecutor<AgentPayWithdrawRecord>{

}
