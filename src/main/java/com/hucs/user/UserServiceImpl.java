package com.hucs.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hucs.security.entity.User;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public User findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}

	public User createOrUpdate(User user) {
		return this.userRepository.save(user);
	}

	public User findById(Long id) {
		return this.userRepository.findById(id).get();
	}

	public void delete(Long id) {
		this.userRepository.deleteById(id);
	}

	public List<User> findAll() {
		return this.userRepository.findAll();
	}
}
