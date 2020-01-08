package com.hucs.user;

import org.springframework.stereotype.Component;

import com.hucs.security.entity.User;

import java.util.List;

@Component
public interface UserService {

	User findByEmail(String email);
	
	User createOrUpdate(User user);
	
	User findById(Long id);
	
	void delete(Long id);
	
	List<User> findAll();
}
