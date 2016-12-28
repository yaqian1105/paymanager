package com.qiyu.paymanager.shiro;


import com.qiyu.common.exception.ServiceException;
import com.qiyu.common.utils.Digests;
import com.qiyu.common.utils.Encodes;
import com.qiyu.data.entity.RestaurantStaff;
import com.qiyu.data.entity.SystemUser;
import com.qiyu.data.repository.RestaurantStaffRepository;
import com.qiyu.data.repository.SystemUserRepository;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 用户管理类.
 * 
 * @author calvin
 */
// Spring Service Bean的标识.
@Component
@Transactional(readOnly = true)
public class AccountService {

	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;

	private static Logger logger = LoggerFactory.getLogger(AccountService.class);

	@Autowired
	private RestaurantStaffRepository restaurantStaffRepository;
	@Autowired
	private SystemUserRepository systemUserRepository;

	public List<RestaurantStaff> getAllUser() {
		return (List<RestaurantStaff>) restaurantStaffRepository.findAll();
	}

	public RestaurantStaff getUser(Long id) {
		return restaurantStaffRepository.findOne(id);
	}

	public RestaurantStaff findByPhone(String loginName) {
		return restaurantStaffRepository.findByPhoneAndIsExpired(loginName,false);
	}

	public SystemUser findByUserName(String loginName){
		return systemUserRepository.findByUserNameAndIsExpired(loginName,false);
	}

	@Transactional(readOnly = false)
	public void registerUser(RestaurantStaff user) {
		entryptPassword(user);
		user.setRole("shopkeeper");
		user.setCreateAt(new Date());
		restaurantStaffRepository.save(user);
	}

	@Transactional(readOnly = false)
	public void updateUser(RestaurantStaff user) {
		if (StringUtils.isNotBlank(user.getPassword())) {
			entryptPassword(user);
		}
		restaurantStaffRepository.save(user);
	}

	@Transactional(readOnly = false)
	public void deleteUser(Long id) {
		if (isSupervisor(id)) {
			logger.warn("操作员{}尝试删除超级管理员用户", getCurrentUserName());
			throw new ServiceException(1);
		}
		restaurantStaffRepository.delete(id);

	}

	/**
	 * 判断是否超级管理员.
	 */
	private boolean isSupervisor(Long id) {
		return id == 1;

	}

	/**
	 * 取出Shiro中的当前用户LoginName.
	 */
	private String getCurrentUserName() {
		RestaurantStaff user = (RestaurantStaff) SecurityUtils.getSubject().getPrincipal();
		return user.getPhone();
	}

	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(RestaurantStaff user) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(user.getPassword().getBytes(), salt, HASH_INTERATIONS);
		user.setPassword(Encodes.encodeHex(hashPassword));
	}

}
