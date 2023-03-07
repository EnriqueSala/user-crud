package com.curso.crudUser.dao;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.curso.crudUser.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public UserDAOImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	@Override
	public List<User> findAll() {
		
		//get the hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//Create a query
		Query<User> theQuery = 
				currentSession.createQuery("from User", User.class);
		
		//Execute the query to get the list of users
		List<User> users = theQuery.getResultList();
		
		return users;
		
	}

	@Override
	public User findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		User theUser = 
				currentSession.get(User.class, theId);
		return theUser;
	}
	@Override
	public User findByFirstName(String theFirstName) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		User theUser = 
				currentSession.get(User.class, theFirstName);
		return theUser;
	}

	@Override
	public void save(User theUser) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theUser);
		
	}

	@Override
	public void deleteById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);

		Query theQuery = 
				currentSession.createQuery(
						"delete from User where id=:userId");
		theQuery.setParameter("userId", theId);
		
		theQuery.executeUpdate();
	}
}
