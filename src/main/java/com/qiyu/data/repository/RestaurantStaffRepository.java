package com.qiyu.data.repository;

import com.qiyu.data.entity.RestaurantStaff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dean on 2016/3/9.
 */
@Repository
public interface RestaurantStaffRepository extends PagingAndSortingRepository<RestaurantStaff, Long>,
        JpaSpecificationExecutor<RestaurantStaff> {

    RestaurantStaff findByRestaurantIdAndUserName(long restaurantId, String userName);

    RestaurantStaff findByRestaurantIdAndStaffNo(long restaurantId, String staffNo);

    RestaurantStaff findByRestaurantIdAndId(long restaurantId, long id);

    RestaurantStaff findByPhone(String phone);

    RestaurantStaff findByRestaurantIdAndRoleLike(long restaurantId, String role);

    RestaurantStaff findByPhoneAndIsExpired(String phone, boolean isExpired);

    List<RestaurantStaff> findByIdIn(List<Long> ids);

    Page<RestaurantStaff> findByRestaurantIdAndPhoneLike(long restaurantId, String phone, Pageable pageable);

    Page<RestaurantStaff> findByRestaurantIdAndIsExpiredAndPhoneLike(long restaurantId, boolean isExpired, String phone, Pageable pageable);

    Page<RestaurantStaff> findByRestaurantId(long restaurantId, Pageable pageable);

    Page<RestaurantStaff> findByRestaurantIdAndIsExpired(long restaurantId, boolean isExpired, Pageable pageable);

}
