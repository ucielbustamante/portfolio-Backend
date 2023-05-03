package com.portfolio.demo.security.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.portfolio.demo.security.enums.RolName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Rol {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private RolName rolName;
	
	public Rol() {
		super();
	}

	public Rol(Long id, RolName rolName) {
		super();
		this.id = id;
		this.rolName = rolName;
	}
	
}
