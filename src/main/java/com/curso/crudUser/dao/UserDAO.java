package com.curso.crudUser.dao;

import java.util.List;

import com.curso.crudUser.entity.User;

public interface UserDAO {
	
	public List<User> findAll();
	
	public User findById(int theId);

	public List<User> findByFirstName(String theFirstName);
	
	public void save(User theUser);
	
	public void deleteById(int theId);
}
