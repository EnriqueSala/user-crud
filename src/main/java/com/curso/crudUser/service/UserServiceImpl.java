package com.curso.crudUser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.crudUser.dao.UserDAO;
import com.curso.crudUser.entity.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	@Autowired
	public UserServiceImpl(UserDAO theUserDAO) {
		userDAO = theUserDAO;
	}
	@Override
	@Transactional
	public List<User> findAll() {
		return userDAO.findAll();
	}

	@Override
	public User findById(int theId) {
		return userDAO.findById(theId);
	}

	@Override
	public void save(User theUser) {
		userDAO.save(theUser);
		
	}

	@Override
	public void deleteById(int theId) {
		userDAO.deleteById(theId);
		
	}

}
