package com.lti.repository;

import java.util.List;

import com.lti.entity.User;

public interface UserRepo {

	public int addAUser(User user);

	public List<User> viewAllUser();

	public int findUserByEmail(String userEmail, String password);

	public User findUserById(int userId);

	public boolean isUserPresent(String userEmail);
	
	public int resetUserPassword(String userEmail);
}
