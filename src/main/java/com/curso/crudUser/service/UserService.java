package com.curso.crudUser.service;

import java.util.List;

import com.curso.crudUser.entity.User;

public interface UserService {
	
	public List<User> findAll();
	
	public User findById(int theId);

	public User findByFirstName(String theFirstName);
	
	public void save(User theUser);
	
	public void deleteById(int theId);
}
