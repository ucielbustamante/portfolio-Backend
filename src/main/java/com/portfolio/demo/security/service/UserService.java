package com.portfolio.demo.security.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.demo.security.entity.User;
import com.portfolio.demo.security.repository.iUserRepository;

@Transactional
@Service
public class UserService {
	
	@Autowired
	iUserRepository iUserRepository;
	
	public Optional<User> getByUsername(String username){
		return iUserRepository.findByUsername(username);
	}
	
	public Optional<User> getByEmail(String email){
		return iUserRepository.findByEmail(email);
	}
	
	public boolean existsByEmail(String email) {
		return iUserRepository.existsByEmail(email);
	}
	
	public boolean existsByUsername(String username) {
		return iUserRepository.existsByUsername(username);
	}
	
	public void save(User user) {
		iUserRepository.save(user);
	}
	
}
