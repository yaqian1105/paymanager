package com.qiyu.paymanager.shiro;



import com.qiyu.common.utils.Encodes;
import com.qiyu.data.entity.SystemUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ShiroDbRealm extends AuthorizingRealm {

	@Autowired
	protected AccountService accountService;

	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
//		RestaurantStaff user = accountService.findByPhone(token.getUsername());
		SystemUser user = accountService.findByUserName(token.getUsername());
		//只有  系统管理员  管理员  财务才能登陆
		if(!user.getRoleList().contains("admin")&&!user.getRoleList().contains("manager")
				&&!user.getRoleList().contains("accountant")){
			user=null;
		}
		if (user != null) {
			byte[] salt = Encodes.decodeHex(user.getSalt());
			return new SimpleAuthenticationInfo(user,user.getPassword(), ByteSource.Util.bytes(salt), getName());
		} else {
			return null;
		}
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		RestaurantStaff shiroUser = (RestaurantStaff) principals.getPrimaryPrincipal();
//		RestaurantStaff user = accountService.findByPhone(shiroUser.getPhone());
		SystemUser shiroUser = (SystemUser) principals.getPrimaryPrincipal();
		SystemUser user = accountService.findByUserName(shiroUser.getUserName());
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRoles(user.getRoleList());
		return info;
	}

	/**
	 * 设定Password校验的Hash算法与迭代次数.
	 */
	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(AccountService.HASH_ALGORITHM);
		matcher.setHashIterations(AccountService.HASH_INTERATIONS);

		setCredentialsMatcher(matcher);
	}



}
