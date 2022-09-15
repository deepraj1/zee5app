package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.InvalidEmainException;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.UNableToGenerateIdException;
import com.zee.zee5app.exceptions.UsernameExistsExecption;
//import com.zee.zee5app.repo.UserRepo;
//import com.zee.zee5app.repo.UserRepoImpl;
import com.zee.zee5app.repo.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repo;
	
	@Override
	public User insertUser(User user) throws UsernameExistsExecption, InvalidEmainException {
		// TODO Auto-generated method stub
//		return null;
		if(repo.existsByuserName(user.getUserName())) {
			throw new UsernameExistsExecption("username already exists");
		}
		if(repo.existsByEmail(user.getEmail())) {
			throw new InvalidEmainException("email is already exists");
		}
		return repo.save(user);
	}

	@Override
	public Optional<User> updateUser( User user) {
		// TODO Auto-generated method stub
//		return null;
//		return repo.get;
		return Optional.ofNullable(repo.save(user));
	}

	@Override
	public String deleteUser(String userId) throws NoDataFoundException {
		// TODO Auto-generated method stub
//		return null;
		try {
			boolean result = repo.existsById(userId);
			if(result) {
				repo.deleteById(userId);
				return "success";
			}else {
				throw new NoDataFoundException("no data find");
			}
		}catch(NoDataFoundException e){
			e.printStackTrace();
			throw e;
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "fail";
	
	}

	@Override
	public Optional<List<User>> getAllUsers() {
		return Optional.ofNullable(repo.findAll());
	}

	@Override
	public Optional<User> getUserById(String userId) {
		// TODO Auto-generated method stub
//		return Optional.empty();
//		repo.findby
		return repo.findById(userId);
	}

	@Override
	public Optional<User> deleteUserById(String userId) {
		// TODO Auto-generated method stub
		return repo.findById(userId);
	}

}
