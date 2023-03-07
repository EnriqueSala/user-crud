package com.curso.crudUser.rest;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.crudUser.entity.User;
import com.curso.crudUser.service.UserService;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService theUserService) {
		userService = theUserService;
	}
	
	@GetMapping("/users")
	public List<User> findAll(){
		return userService.findAll();
	}
	@GetMapping("/users/{userId}")
	public User findById(@PathVariable int userId) {
		User user = userService.findById(userId);
		if (user == null) {
			throw new UserNotFoundException("User id not found - " + userId);
		}
		return user;
	}
	@RequestMapping(value = "/users/{firstName}",method = RequestMethod.GET)
	public User findByFirstName(@RequestParam("firstName") String firstName) {
		User user = userService.findByFirstName(firstName);
		if (user == null) {
			throw new UserNotFoundException("Name not found - " + firstName);
		}
		return user;
	}
	
	@PostMapping("/users")
	public User postUser(@RequestBody User theUser) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theUser.setId(0);
		
		userService.save(theUser);
		
		return theUser;
	}
	
	@PutMapping("/users")
	@Transactional
	public User updateUser(@RequestBody User theUser) {
		
		userService.save(theUser);
		
		return theUser;
	}
	
	@DeleteMapping("/users/{userId}")
	@Transactional
	public String deleteUser(@PathVariable int userId) {
		User tempUser = userService.findById(userId);
		
		if(tempUser == null) {
			throw new UserNotFoundException("User id not fount: "+ userId);
		}
		userService.deleteById(userId);
		return "deleted user with id: " + userId;
	}
}
