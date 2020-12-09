package com.cldiaz.fetchrewards.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cldiaz.fetchrewards.domain.User;
import com.cldiaz.fetchrewards.domain.UserApiRequest;
import com.cldiaz.fetchrewards.repository.UserBalanceRepository;

@Service
public class UserService {

	@Autowired
	private UserBalanceRepository userBalanceRepository;
	
	public void addToBalance(UserApiRequest request) {
		User existingUser = getUserByName(request.getName());
		
		if(existingUser != null) {
			User updatUser = new User();
			updatUser.setName(request.getName());
			updatUser.setBalance(existingUser.getBalance() + request.getPoints());
			userBalanceRepository.save(updatUser);
		} else {
			User newUser = new User();
			newUser.setName(request.getName());
			newUser.setBalance(request.getPoints());
			userBalanceRepository.save(newUser);
		}
	}
	
	public User getUserByName(String name) {
		return userBalanceRepository.findUserByName(name);
	}
	
	public User deductBalance(UserApiRequest request) {
		User existingUser = getUserByName(request.getName());
		User updatedUser = new User();
		int newBal = existingUser.getBalance() - request.getPoints();
		
		if(newBal < 0) {
			newBal = 0;
		}
		
		updatedUser.setName(existingUser.getName());
		updatedUser.setBalance(newBal);
		
		userBalanceRepository.save(updatedUser);
		
		return updatedUser;
	}
	
	
}
