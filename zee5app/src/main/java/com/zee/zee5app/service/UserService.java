package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.InvalidEmainException;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.UNableToGenerateIdException;
import com.zee.zee5app.exceptions.UsernameExistsExecption;
@Service
public interface UserService {
	public User insertUser(User user) throws UNableToGenerateIdException, UsernameExistsExecption, InvalidEmainException;
	public Optional<User> updateUser(String userId, User user);
//	public String deleteUser(int userId) throws NoDataFoundException;
	public Optional<List<User>> getAllUsers();
//	public Optional<User> getUserById(int userId);
//	public Optional<User> deleteUserById(int userId);
	Optional<User> getUserById(String userId);
	Optional<User> deleteUserById(String userId);
	String deleteUser(String userId) throws NoDataFoundException;
		
	

}
