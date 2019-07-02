package com.example.service;

import org.springframework.stereotype.Component;

import com.example.security.entity.User;

import java.util.List;

@Component
public interface UserService {

	User findByEmail(String email);
	
	User createOrUpdate(User user);
	
	User findById(Long id);
	
	void delete(Long id);
	
	List<User> findAll();
}
