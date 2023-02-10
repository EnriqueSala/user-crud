package com.curso.crudUser.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserErrorResponse {
	private int status;
	private String message;
	private long timestamp;

	public UserErrorResponse(String message)
    {
        super();
        this.message = message;
    }
}