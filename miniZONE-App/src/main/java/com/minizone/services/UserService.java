package com.minizone.services;

import java.util.List;

import com.minizone.entities.User;
import com.minizone.exceptions.UserException;

public interface UserService {

	public String addUser(User user) throws UserException;
	
	public String updateUser(User user, Long userID) throws UserException;
	
	public String deleteUserById(Long userID) throws UserException;
	
	public User getUserById(Long userID) throws UserException;
	
	public List<User> getAllUsers() throws UserException;
	
}
