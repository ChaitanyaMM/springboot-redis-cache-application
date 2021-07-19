package com.practice.rediscache.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.practice.rediscache.entity.User;
import com.practice.rediscache.repository.UserRepository;
import com.practice.rediscache.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@CachePut(value = "user", key = "#user.id")
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	@CachePut(value = "user", key = "#user.id")
	public User update(User user, Long userId) {
		User updateUser = user;
		updateUser.setId(userId);
		return userRepository.save(user);
	}

	@Override
	@Cacheable(value = "user", key = "#id")
	public Optional<User> findById(Long userId) {
		return userRepository.findById(userId);

	}

	@Override
	@CacheEvict(value = "user", key = "#user.id")
	public void delete(Long userId) {
		userRepository.deleteById(userId);

	}

}
