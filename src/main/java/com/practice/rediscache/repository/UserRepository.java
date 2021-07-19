package com.practice.rediscache.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.rediscache.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
