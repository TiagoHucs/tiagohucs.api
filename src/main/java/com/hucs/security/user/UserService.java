package com.hucs.security.user;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {

	User findByEmail(String email);
	
	User createOrUpdate(User user);
	
	User findById(Long id);
	
	void delete(Long id);
	
	List<User> findAll();

	User getCurrentUser();

	void setCurrentUser(User user);
}
