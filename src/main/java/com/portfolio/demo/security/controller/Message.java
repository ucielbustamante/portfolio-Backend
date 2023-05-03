package com.portfolio.demo.security.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
	private String message;

	public Message() {
		super();
	}

	public Message(String message) {
		super();
		this.message = message;
	}
	
	
}
