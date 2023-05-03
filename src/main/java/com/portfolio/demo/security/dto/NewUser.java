package com.portfolio.demo.security.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewUser {
	private String username;
	private String password;
	private String email;
	private Set<String> roles = new HashSet<>();
}
