package com.cldiaz.fetchrewards.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cldiaz.fetchrewards.domain.User;
import com.cldiaz.fetchrewards.domain.UserApiRequest;
import com.cldiaz.fetchrewards.repository.UserBalanceRepository;

@Service
public class UserServiceH2Impl implements UserService {

	@Autowired
	private UserBalanceRepository userBalanceRepository;
	
	@Override
	public void addToBalance(UserApiRequest req) {
		User existingUser = getUserByName(req.getName());

		if(existingUser != null) {
			User updatUser = new User();
			updatUser.setName(req.getName());
			updatUser.setBalance(existingUser.getBalance() + req.getPoints());
			userBalanceRepository.save(updatUser);
		} else {
			User newUser = new User();
			newUser.setName(req.getName());
			newUser.setBalance(req.getPoints());
			userBalanceRepository.save(newUser);
		}

	}

	@Override
	public User deductBalance(UserApiRequest req) {
		User existingUser = getUserByName(req.getName());
		User updatedUser = new User();
		int newBal = existingUser.getBalance() - req.getPoints();

		if(newBal < 0) {
			newBal = 0;
		}

		updatedUser.setName(existingUser.getName());
		updatedUser.setBalance(newBal);

		userBalanceRepository.save(updatedUser);

		return updatedUser;
	}

	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return userBalanceRepository.findUserByName(name);
	}

}
