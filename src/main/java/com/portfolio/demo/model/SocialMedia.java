package com.portfolio.demo.model;

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


@Getter
@Setter

@JsonIgnoreProperties(value = { "person" })
@Entity
public class SocialMedia {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="link")
	private String link;
	@Column(name="img")
	private String img;
	@ManyToOne(fetch = FetchType.LAZY)
	private Person person;
	
	public SocialMedia() {
		super();
	}

	public SocialMedia(Long id, String name, String link, String img, Person person) {
		super();
		this.id = id;
		this.name = name;
		this.link = link;
		this.img = img;
		this.person = person;
	}
	
	
}