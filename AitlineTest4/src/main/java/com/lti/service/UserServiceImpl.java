package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.User;
import com.lti.exception.UserServiceException;
import com.lti.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private EmailService emailService;

	@Override
	public void register(User user) {
		if (!userRepo.isUserPresent(user.getUserEmail())) {
			int userId = userRepo.addAUser(user);
			String text = "Successfully registered. Your user Id is " + userId;
			String subject = "Welcome to TRAP airlines";
			emailService.sendEmailForNewRegistration(user.getUserEmail(), text, subject);
		} else {
			throw new UserServiceException("Email already registered");
		}

	}

	@Override
	public User login(String userEmail, String password) {
		try {
			if (!userRepo.isUserPresent(userEmail))
				throw new UserServiceException("User not registered");
			int id = userRepo.findUserByEmail(userEmail, password);
			User user = userRepo.findUserById(id);
			return user;

		} catch (EmptyResultDataAccessException e) {
			throw new UserServiceException("Incorrect email/password");
		}
	}

	@Override
	public User get(int userId) {
		return userRepo.findUserById(userId);
	}

	@Override
	public void update(User user) {
		userRepo.addAUser(user);
	}

	@Override
	public void resetUserPassword(String userEmail) {
		// TODO Auto-generated method stub
		  if (!userRepo.isUserPresent(userEmail)) 
			  throw new UserServiceException("User not registered");
	            int userId = userRepo.resetUserPassword(userEmail);
	            User user = userRepo.findUserById(userId);
	            String text = "Your password is " + user.getPassword();
	            String subject = "Reset password";
	            emailService.sendEmailForNewRegistration(userEmail, text, subject);
	        
		 /* else {
	            throw new UserServiceException("Email already registered");
	        }*/
		
	}

}
