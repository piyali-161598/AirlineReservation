package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.User;

@Repository
public class UserRepoImpl implements UserRepo {

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public int addAUser(User user) {
		User u = em.merge(user);
		return u.getUserId();
	}

	@Override
	public List<User> viewAllUser() {
		return em.createNamedQuery("fetch-all", User.class).getResultList();
	}

	@Override
	public int findUserByEmail(String userEmail, String password) {
		return (Integer) em.createQuery("select u.userId from User u where u.userEmail = :em and u.password = :pw")
				.setParameter("em", userEmail).setParameter("pw", password).getSingleResult();
	}

	@Override
	public User findUserById(int userId) {
		return em.find(User.class, userId);
	}

	@Override
	public boolean isUserPresent(String userEmail) {
		return (Long) em.createQuery("select count(u.userId) from User u where u.userEmail = :em")
				.setParameter("em", userEmail).getSingleResult() == 1 ? true : false;
	}

	@Override
	public int resetUserPassword(String userEmail) {
		// TODO Auto-generated method stub
		return (Integer) em.createQuery("select u.userId from User u where u.userEmail = :em ")
				.setParameter("em", userEmail).getSingleResult();

	}

}
