package com.portfolio.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")

@JsonIgnoreProperties(value = { "person" })
@Entity
@Getter
@Setter
public class Education implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	@Column
	private String status;
	@Column
	private String img;
	@ManyToOne(fetch = FetchType.LAZY)
	private Person person;
	
	public Education() {
		super();
	}

	public Education(Long id, String name, String status, String img, Person person) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.img = img;
		this.person = person;
	}

	

}
