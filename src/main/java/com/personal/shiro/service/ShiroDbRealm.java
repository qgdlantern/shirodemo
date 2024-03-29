/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.personal.shiro.service;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.personal.shiro.entity.User;

public class ShiroDbRealm extends AuthorizingRealm {

	protected AccountService accountService;

	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
//		User user = accountService.findUserByLoginName(token.getUsername());
		System.out.println("@@@@@@@@@@@@@@@" + token.getUsername());
//		if (user != null) {
//			return new SimpleAuthenticationInfo(user.getLoginName(), user.getPassword(), getName());
//		} else {
//			return null;
//		}
		return new SimpleAuthenticationInfo(token.getUsername(), token.getPassword(), getName());
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.fromRealm(getName()).iterator().next();

//		if (username != null) {
//			// 查询用户授权信息
//			Collection<String> pers = businessManager
//					.queryPermissions(username);
//			if (pers != null && !pers.isEmpty()) {
//				SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//				for (String each : pers)
//					info.addStringPermissions(each);
//
//				return info;
//			}
//		}

		return null;
	}

	@Autowired
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
}
