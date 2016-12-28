package com.qiyu.data.repository;


import com.qiyu.data.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kk on 2016/6/1.
 */
@Repository
public interface RestaurantRepository extends PagingAndSortingRepository<Restaurant, Long>,JpaSpecificationExecutor<Restaurant> {
    List<Restaurant> findByMerchantId(Long merchantId);
    int countByPinyin(String pinyin);
}
