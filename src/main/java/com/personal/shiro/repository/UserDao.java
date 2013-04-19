package com.personal.shiro.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.personal.shiro.entity.User;

public interface UserDao extends PagingAndSortingRepository<User, Long> {
	User findByLoginName(String loginName);
}
