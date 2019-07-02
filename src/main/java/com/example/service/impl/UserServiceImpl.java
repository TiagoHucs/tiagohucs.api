package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.example.repository.UserRepository;
import com.example.security.entity.User;
import com.example.service.UserService;

import java.util.List;
import java.util.Optional;

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
