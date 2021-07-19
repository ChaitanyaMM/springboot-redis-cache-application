package com.practice.rediscache.service;

import java.util.Optional;

import com.practice.rediscache.entity.User;

public interface UserService {

	User save(User user);

	User update(User user,Long userId);

	Optional<User> findById(Long userId);

	void delete(Long userId);

}
