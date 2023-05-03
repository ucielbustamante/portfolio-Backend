package com.portfolio.demo.security.entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainUser implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8964977805816552879L;
	private String username;
	private String email;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	
	public MainUser(String username, String email, String password, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}
	
	public static MainUser build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(rol -> new SimpleGrantedAuthority(rol.getRolName()
						.name())).collect(Collectors.toList());
		return new MainUser(user.getUsername(), user.getEmail(), user.getPassword(), authorities);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}
	
	public String getEmail() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	

}
