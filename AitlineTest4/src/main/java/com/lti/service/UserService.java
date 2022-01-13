package com.lti.service;

import com.lti.entity.User;

public interface UserService {

	void register(User user);

	User login(String userEmail, String password);

	User get(int userId);

	void update(User user);
	void resetUserPassword(String userEmail);
}
