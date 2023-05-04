package com.portfolio.demo.security.controller;


import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.demo.security.dto.JwtDto;
import com.portfolio.demo.security.dto.NewUser;
import com.portfolio.demo.security.dto.UserLogin;
import com.portfolio.demo.security.entity.Rol;
import com.portfolio.demo.security.entity.User;
import com.portfolio.demo.security.enums.RolName;
import com.portfolio.demo.security.jwt.JwtProvider;
import com.portfolio.demo.security.service.RolService;
import com.portfolio.demo.security.service.UserService;

@CrossOrigin(origins = "https://portfolio-frontend-5a014.web.app/")
@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UserService userService;
	@Autowired
	RolService rolService;
	@Autowired
	JwtProvider jwtProvider;
	
	@PostMapping("/new")
	public ResponseEntity<?> nuevo(@Valid @RequestBody NewUser newUser, BindingResult bindingResult){
		
		if(bindingResult.hasErrors())
			return new ResponseEntity<Message>(new Message("Fields missplaced or invalid email"),HttpStatus.BAD_REQUEST);
		
		if (userService.existsByUsername(newUser.getUsername()))
			return new ResponseEntity<Message>(new Message("This username already exists"),HttpStatus.BAD_REQUEST);
		
		if (userService.existsByEmail(newUser.getEmail()))
			return new ResponseEntity<Message>(new Message("This email already exists"),HttpStatus.BAD_REQUEST);
		
		User user = new User(newUser.getUsername(), newUser.getEmail(), passwordEncoder.encode(newUser.getPassword()));
		
		Set<Rol> roles = new HashSet<>();
		roles.add(rolService.getRolByName(RolName.ROLE_USER).get());
		
		if(newUser.getRoles().contains("admin"))
			roles.add(rolService.getRolByName(RolName.ROLE_ADMIN).get());
		
		user.setRoles(roles);
		userService.save(user);
		
		return new ResponseEntity<Message>(new Message("User saved"), HttpStatus.CREATED);
	}	
		
	@PostMapping("/login")
	public ResponseEntity<JwtDto> login(@Valid @RequestBody UserLogin userLogin, BindingResult bindingResult){
		
		if(bindingResult.hasErrors())
			return new ResponseEntity(new Message("Fields missplaced"), HttpStatus.BAD_REQUEST);
		
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				userLogin.getUsername(), userLogin.getPassword())); 
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = jwtProvider.generateToken(authentication);
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
		return new ResponseEntity<JwtDto>(jwtDto, HttpStatus.OK);
	}
	
}