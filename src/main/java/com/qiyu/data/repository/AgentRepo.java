package com.qiyu.data.repository;


import com.qiyu.data.entity.Agent;
import com.qiyu.data.entity.Agent;
import com.qiyu.data.vo.AgentVo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by KK on 2016/5/26.
 */
public interface AgentRepo extends PagingAndSortingRepository<Agent, Long>,JpaSpecificationExecutor<Agent> {
     List<Agent> findAll();
}
