package com.curso.crudUser.rest;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserNotFoundException extends RuntimeException {
	private String message;
	public UserNotFoundException(String message)
	{
		super(message);
		this.message=message;
	}

}