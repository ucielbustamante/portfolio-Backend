package com.portfolio.demo.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.portfolio.demo.security.entity.MainUser;
import com.portfolio.demo.security.entity.User;

@Service
public class UserDetailsImpls implements UserDetailsService{

	@Autowired
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.getByUsername(username).get();
		return MainUser.build(user);
	}

}
